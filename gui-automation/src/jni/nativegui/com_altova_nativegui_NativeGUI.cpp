#include <stdio.h>
#include <iostream>
#include <tchar.h>

//#include "strsafe.h"

#include "com_altova_nativegui_NativeGUI.h"
#include "windows.h"
#include "WindowList.h"




const int MAX_WINDOWS = 1000;
HWND ahWnd [MAX_WINDOWS];
int window_counter = 0;

/*
 * Fill the ahWnd array with the handles of the open window in the Application list
 */
BOOL FillList()
{
	//clear the counter and window list
	window_counter = 0;
	for(int i = 0; i < MAX_WINDOWS; i++) {
		ahWnd[i] = 0;
	}

	//printf("filllist");
  // enumerate top-level windows, and put their titles in the list
  if (EnumWindows(ListWindows, 0) == FALSE)
  {
    //printf("Error getting window handles\n");
    return FALSE;
  }
  return TRUE;
}

/*
 * Callback method to get window info
 */
BOOL CALLBACK ListWindows(HWND hwnd, LPARAM lparam)
{
	if ((GetParent(hwnd) == NULL) && 
		(GetWindowTextLength(hwnd) > 0) && 
		IsWindowVisible(hwnd) && 
		!(GetWindowLong(hwnd, GWL_EXSTYLE) & WS_EX_TOOLWINDOW)) {
				ahWnd[window_counter] = hwnd;
				window_counter++;
	}
	return TRUE;
  
}

/*
 * Construct a Java String[] containing info about the given window handle
 */
jobjectArray ExtractWindowInfo(JNIEnv *env, HWND hWnd ) {
	RECT rect;
	char className[1000];
	char windowsText[1000];

	GetWindowRect (hWnd, &rect);
	GetClassNameA (hWnd, className, sizeof (className) - 1);
	GetWindowTextA (hWnd, windowsText, sizeof (windowsText) - 1);

	jobjectArray ans = (jobjectArray) (env)->NewObjectArray(7,env->FindClass("java/lang/String"),env->NewStringUTF(""));
	env->SetObjectArrayElement(ans, 0 , (jstring) env->NewStringUTF( windowsText ) );
	env->SetObjectArrayElement(ans, 1 , (jstring) env->NewStringUTF( className ) );

	char str[62];
	size_t size = 62;
	_itoa_s( rect.left,  str, 10);
	env->SetObjectArrayElement(ans, 2 , (jstring) env->NewStringUTF( str ) );

	_itoa_s( rect.top,  str, 10);
	env->SetObjectArrayElement(ans, 3 , (jstring) env->NewStringUTF( str ) );

	_itoa_s( rect.right,  str, 10);
	env->SetObjectArrayElement(ans, 4 , (jstring) env->NewStringUTF( str ) );

	_itoa_s( rect.bottom,  str, 10);
	env->SetObjectArrayElement(ans, 5 , (jstring) env->NewStringUTF( str ) );

	//WARNING: THIS METHOD WILL CAUSE A BUFFER OVERFLOW in .Net 2005 (works fine in 2003, though...)
	//If Microsoft had been so kind to mentioned at compile time that the method is depricated,
	//this wouldn't have wasted so many hours....
	//sprintf(str, "%I64u", (unsigned __int64)hWnd);


	 //bunch of tests - all rubbish. :(
	 /*
	 int a = 1;
	 sprintf(str, "%d", a);
    StringCchPrintfA(str, size, "%d", a);

	//check how big a string we really need first
	unsigned __int64 h = (unsigned __int64)hWnd;
	jlong j = (unsigned __int64)hWnd;
	
	int size = _scprintf("%Ulu", j);
	itoa( size,  str, 10);
	char *str2 = new char[size];
	_snprintf(str2, size, "%I64d", (unsigned __int64)hWnd);
	*/

	//casting from I64 to long here, this might not be a good idea...
	_ltoa_s((long)hWnd, str, 10);
	env->SetObjectArrayElement(ans, 6 , (jstring) env->NewStringUTF( str ) );

	return ans;
}

/*
 * Construct a Java String[][] of all open windows (the Application List
 * 
 */
jobjectArray ExtractWindowInfoArray(JNIEnv *env, HWND hWnd[], int size) {
	jobjectArray resultSet, oneRecord;
	jclass stringCls,objCls;
	
	stringCls = env->FindClass("java/lang/String");
	if(stringCls == NULL) {return NULL;}
	oneRecord = (env)->NewObjectArray(size, stringCls, NULL);
	if(oneRecord == NULL) {return NULL;}
	objCls = (env)->GetObjectClass(oneRecord);
	if(objCls == NULL) {return NULL;}
	resultSet = (jobjectArray) (env)->NewObjectArray(size, objCls, NULL);
	if(resultSet == NULL) {return NULL;}

	for(int i=0; i<size; i++) {
		
			oneRecord = ExtractWindowInfo(env, hWnd [i]);
			if(oneRecord == NULL) {return NULL;}
			env->SetObjectArrayElement(resultSet, i, oneRecord);
		
	}
	if(resultSet == NULL) {return NULL;}
	return resultSet;
}

/*
 * Get info about the window or object at the given location
 * Native Java method.
 */
JNIEXPORT jobjectArray JNICALL Java_com_altova_nativegui_NativeGUI_getWindowRect
(JNIEnv *env, jclass obj, jint x, jint y) {
	POINT		screenpoint;
	HWND		hwndFoundWindow = NULL;

	screenpoint.x = x;
	screenpoint.y = y;
	hwndFoundWindow = WindowFromPoint (screenpoint);

	return ExtractWindowInfo(env, hwndFoundWindow);
}

/*
 * Get the forground window info
 * Native Java method.
 */
JNIEXPORT jobjectArray JNICALL Java_com_altova_nativegui_NativeGUI_getForegroundWindow
(JNIEnv *env, jclass obj) {
	return ExtractWindowInfo(env, GetForegroundWindow () );
}

/*
 * Get the current postion of the mouse pointer.
 * Native Java method.
 */
JNIEXPORT jobjectArray JNICALL Java_com_altova_nativegui_NativeGUI_getCursorPos
(JNIEnv *env, jclass obj) {
	POINT		screenpoint;
	GetCursorPos( &screenpoint );

	jobjectArray ans = (jobjectArray) (env)->NewObjectArray(2,env->FindClass("java/lang/String"),env->NewStringUTF(""));

	char str[10];
	_itoa_s( screenpoint.x,  str, 10);
	env->SetObjectArrayElement(ans, 0 , (jstring) env->NewStringUTF( str ) );

	_itoa_s( screenpoint.y,  str, 10);
	env->SetObjectArrayElement(ans, 1 , (jstring) env->NewStringUTF( str ) );

	return ans;
}

/*
 * Get the version of the DLL
 * Native Java method.
 */
JNIEXPORT jint JNICALL Java_com_altova_nativegui_NativeGUI_getVersion
  (JNIEnv *env, jclass obj) {
	return com_altova_nativegui_NativeGUI_CURRENT_VERSION;
}

/*
 * Get the Application List of open windows
 * Native Java method.
 */
JNIEXPORT jobjectArray JNICALL Java_com_altova_nativegui_NativeGUI_getWindowInfo
  (JNIEnv *env, jclass obj) {
	if(FillList() && window_counter > 0) {
			return ExtractWindowInfoArray(env, ahWnd, window_counter);
	}
	return NULL;
}

/*
 * Show a specific window
 * Native Java method.
 */
JNIEXPORT void JNICALL Java_com_altova_nativegui_NativeGUI_showWindow
(JNIEnv *env, jclass obj, jlong hWnd) {
	ShowWindow((HWND)hWnd, SW_SHOW);
	SetForegroundWindow((HWND)hWnd);
}


/*
 * Only for testing
 */

int _tmain(int argc, _TCHAR* argv[])
{
	if(FillList() && (window_counter != 0)){
		for(int i=0; i<window_counter; i++) {
			printf("test");
			//printf("\n%d" , ahWnd[i]);
			//OpenWindow(ahWnd[i]);
		}
	}
	return NULL;
}

