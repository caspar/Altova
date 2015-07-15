package com.altova.umodel.regression.functional;

/*
 * 
 * usage: UModelBatch.exe [project] [options]

/? or /help ... display this help information

project     ... project file (*.ump)
/new[=file] ... create new project
/set        ... set options permanent
/gui        ... display UModel user interface

commands (executed in given order):
/chk        ... check project syntax
/isd=path   ... import source directory
/isp=file   ... import source project file
                (*.project,*.xml,*.jpx,*.csproj,*.csdproj,*.sln,*.bdsproj)
/ibt=list   ... import binary types (specify binary[typenames] list)
                (';'=separator, '*'=all types, '#' before assembly names)
/ixs=file   ... import XML schema file (*.xsd)
/m2c        ... update program code from model (export/forward engineer)
/c2m        ... update model from program code (import/reverse engineer)
/ixf=file   ... import XMI file
/exf=file   ... export to XMI file
/inc=file   ... include file
/doc=file   ... write documentation to specified file
/lue[=cpri] ... list all elements not used on any diagram (i.e. unused)
/ldg        ... list all diagrams
/lcl        ... list all classes
/lsp        ... list all shared packages
/lip        ... list all included packages

options for import commands:
/iclg=lang  ... code language (Java1.4 | Java5.0 | C#2.0)
/ipsd[=0|1] ... process sub directories (recursive)
/ijdc[=0|1] ... JavaDocs as Java comments
/icdc[=0|1] ... DocComments as C# comments
/icds[=lst] ... C# defined symbols
/imrg[=0|1] ... synchronize merged
/iudf[=0|1] ... use directory filter
/iflt[=lst] ... directory filter (presets /iudf)

options for import binary types (after /iclg):
/ibrt=vers  ... runtime version
/ibpv=path  ... override of PATH variable for searching native code libraries
/ibro[=0|1] ... use reflection context only
/ibua[=0|1] ... use add referenced types with package filter
/ibar[=flt] ... add referenced types package filter (presets /ibua)
/ibot[=0|1] ... import only types
/ibuv[=0|1] ... use minimum visibility filter
/ibmv[=key] ... keyword of required minimum visibility (presets /ibuv)
/ibsa[=0|1] ... suppress attribute sections / annotation modifiers
/iboa[=0|1] ... create only one attribute per attribute section
/ibss[=0|1] ... suppress 'Attribute' suffix on attribute type names

options for diagram generation:
/dgen[=0|1] ... generate diagrams
/dopn[=0|1] ... open generated diagrams
/dsac[=0|1] ... show attributes compartment
/dsoc[=0|1] ... show operations compartment
/dscc[=0|1] ... show nested classifiers compartment
/dstv[=0|1] ... show tagged values

options for export commands:
/ejdc[=0|1] ... Java comments as JavaDocs
/ecdc[=0|1] ... C# comments as DocComments
/espl[=0|1] ... use user defined SPL templates
/ecod[=0|1] ... comment out deleted
/emrg[=0|1] ... synchronize merged
/egfn[=0|1] ... generate missing file names
/eusc[=0|1] ... use syntax check

options for XMI export
/exid[=0|1] ... export UUIDs
/exex[=0|1] ... export UModel specific extensions
/exuv[=ver] ... UML version (UML2.0 | UML2.1.1)

options for documentation generation
/doof[=fmt] ... output format (HTML | RTF | MSWORD )
---

 */
public class UModelBatchTest {

}
