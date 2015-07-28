<%@ Language=VBScript %><%
option explicit
dim sRoot, sDir, sParent, objFSO, objFolder, objFile, objSubFolder, sSize
%>
<META content="Microsoft Visual Studio 6.0" name=GENERATOR><!-- Author: Adrian Forbes --><%
' This is the root directory that the explorer will browse.  Make sure there is no backslash ()
' at the end.  Also make sure that show.asp has an identical sRoot variable.
sRoot = "c:webfiles"

' Get the directory relative to the root directory
sDir = Request("Dir")

' Add a backslash
sDir = sDir & "\"

Response.Write "<h1>" & sDir & "</h1>" & vbCRLF

' Create a copy of FileSystemObject
Set objFSO = CreateObject("Scripting.FileSystemObject")
on error resume next
' Get a handle on the folder
Set objFolder = objFSO.GetFolder(sRoot & sDir)
if err.number <> 0 then
    Response.Write "Could not open folder"
    Response.End
end if
on error goto 0

' We want a link to the parent folder also
' Get the full path of the parent folder
sParent = objFSO.GetParentFolderName(objFolder.Path)

' Remove the contents of sRoot from the front.  This gives us the parent
' path relative to the root folder
' eg. if parent folder is "c:webfilessubfolder1subfolder2" then we just want "subfolder1subfolder2"
sParent = mid(sParent, len(sRoot) + 1)

Response.Write "<table border=""1"">"

' Give a link to the parent folder.  This is just a link to this page only pssing in
' the new folder as a parameter
Response.Write "<tr><td colspan=3><a href=""browse.asp?dir=" & Server.URLEncode(sParent) & """>Parent folder</a></td></tr>" & vbCRLF

' Now we want to loop through the subfolders in this folder
For Each objSubFolder In objFolder.SubFolders
    ' And provide a link to them
    Response.Write "<tr><td colspan=3><a href=""browse.asp?dir=" & Server.URLEncode(sDir & objSubFolder.Name) & """>" & objSubFolder.Name & "</a></td></tr>" & vbCRLF
Next

' Now we want to loop through the files in this folder
For Each objFile In objFolder.Files
    if Clng(objFile.Size) < 1024 then
        sSize = objFile.Size & " bytes"
    else
        sSize = Clng(objFile.Size / 1024) & " KB"
    end if
    ' And provide a link to view them.  This is a link to show.asp passing in the directory and the file
    ' as parameters
    Response.Write "<tr><td><a href=""show.asp?file=" & server.URLEncode(objFile.Name) & "&dir=" & server.URLEncode (sDir) & """>" & objFile.Name & "</a></td><td>" & sSize & "</td><td>" & objFile.Type & "</td></tr>" & vbCRLF
Next

Response.Write "</table>"
%>

[bold]show.asp[/bold]

 
<%@ Language=VBScript %><%
option explicit
dim sFile, sRoot, sDir, sExt, objShell, objFSO, sMIME, objStream

' Author: Adrian Forbes -->

' Make sure this is the same sRoot variable that is defined in browse.asp
sRoot = "c:webfiles"

' Get the directory relative to the root folder
sDir = Request("dir")

' Get the file we're going to show
sFile = Request("file")

' We need to know the MIME type for the file we are about to view.  In
' order to get this we need to know the file's extension.
' We could use string functions to get the file extension but we've going
' to be lazy and use FileSystemObject
set objFSO = server.CreateObject("Scripting.FileSystemObject")
sExt = objFSO.GetExtensionName (sFile)
set objFSO = nothing

' Now we have the extension, the file's MIME type is held in the registry at
' HKEY_CLASSES_ROOT.<ext>Content Type
' Create an instance of Wscript.Shell to let us read the registry
Set objShell = Server.CreateObject("Wscript.Shell")
On Error Resume Next
' Get the MIME type
sMIME = objShell.RegRead("HKEY_CLASSES_ROOT." & sExt & "Content Type")
On Error GoTo 0
if len(sMIME) = 0 then
    ' If there is no registered type then return octetstream.  This will prompt
    ' the user with the "Open or Save to disk" dialogue.
    sMIME = "application/octetstream"
end if
set objShell = nothing

' Tell the browse the content type
Response.ContentType = sMIME

' And the name of the file
Response.AddHeader "Content-Disposition", "filename=" & sFile & ";"

' Now we need to pipe the file to the browser, to do this we
' will use the ADODB.Stream
Set objStream = Server.CreateObject("ADODB.Stream")
objStream.Open
' Set the type as Binary
objStream.Type = 1
' Load our file
objStream.LoadFromFile sRoot & sDir & sFile

' And send it to the browser
Response.BinaryWrite objStream.Read

objStream.Close
Set objStream = Nothing
%>