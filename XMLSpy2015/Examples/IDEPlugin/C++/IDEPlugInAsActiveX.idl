// IDEPlugInAsActiveX.idl : IDL source for IDEPlugInAsActiveX.dll
//

// This file will be processed by the MIDL tool to
// produce the type library (IDEPlugInAsActiveX.tlb) and marshalling code.

import "oaidl.idl";
import "ocidl.idl";
#include "olectl.h"
	

	[
		object,
		uuid(D4711F68-57BD-44D3-B4D3-A511795D4FB1),
		dual,
		helpstring("IIDESampleActiveX Interface"),
		pointer_default(unique)
	]
	interface IIDESampleActiveX : IDispatch
	{
	};

[
#ifdef BUILDAUTHENTIC
	uuid(C75AA551-A30A-4cd2-A77F-8C2CECAD94AE),
#else
	uuid(B5F1719A-61E5-4EFF-8918-DE66F1B320D4),
#endif
	version(1.0),
	helpstring("IDEPlugInAsActiveX 1.0 Type Library")
]
library IDEPLUGINASACTIVEXLib
{
	importlib("stdole32.tlb");
	importlib("stdole2.tlb");

	importlib("IXMLSpyPlugIn.tlb");

	[
#ifdef BUILDAUTHENTIC
		uuid(7626553A-0277-4c8c-97EE-1D3AFF0602B7),
#else
		uuid(6581F0C2-C80F-40c8-A003-3E93ADA140DA),
#endif
		helpstring("IDESampleActiveX Class")
	]
	coclass IDESampleActiveX
	{
		[default] interface IIDESampleActiveX;
		interface IXMLSpyPlugIn;
	};
};
