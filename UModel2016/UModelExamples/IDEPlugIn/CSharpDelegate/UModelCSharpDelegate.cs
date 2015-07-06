using System;
using System.Collections.Generic;
using System.Text;
using UModelLib;
using UModelPlugInLib;

/* 
 * CSharp delegate sample
 * add a new CSharp delegate on the top/left corner of the active class diagram if possible 
 * (i.e. when diagram is inside a C# root namespace)
 */

namespace CSharpDelegate
{
    public class UModelCSharpDelegate : UModelPlugInLib.IUModelPlugIn
    {
        #region helpers

        protected string GetPlugInPath()
        {
            string sDLLPath = System.Reflection.Assembly.GetExecutingAssembly().Location;
            return System.IO.Path.GetDirectoryName(sDLLPath);
        }

        #endregion

        #region IUModelPlugIn Members

        public string GetDescription()
        {
            return "CSharpDelegate sample Plug-in for UModel;This Plug-in demonstrates how to create a new CSharp delegate on a class diagram.";
        }

        public string GetUIModifications()
        {
            try
            {
                string sPath = GetPlugInPath();

                System.IO.StreamReader myFile = new System.IO.StreamReader(sPath + "\\config.xml");
                string sRet = myFile.ReadToEnd();
                myFile.Close();

                // this replaces the token "**path**" from the XML file with
                // the actual installation path of the plug-in to get the image file
                return sRet.Replace("**path**", sPath);
            }
            catch (System.Exception ex)
            {
                System.Windows.Forms.MessageBox.Show("Error in GetUIModifications:" + ex.Message);
                throw ex;
            }
        }


        public void OnInitialize(object pUModel)
        {
            // before processing DDE or batch commands
        }

        public void OnRunning(object pUModel)
        {
            // DDE or batch commands are processed; application is fully initialized
        }

        public void OnShutdown(object pUModel)
        {
            // application will shutdown; release all unused objects
            GC.Collect();
        }

        public UModelUpdateAction OnUpdateCommand(int nID, object pUModel)
        {
            UModelUpdateAction action = UModelUpdateAction.UModelUpdateAction_Disable;

            // check if we can add a new CSharpDelegate on the active diagram
            if (nID == 3 || nID == 4)
                action = OnUpdateAddNewCSharpDelegate((IApplication)pUModel);

            // release unused objects
            GC.Collect();

            return action;
        }

        public void OnCommand(int nID, object pUModel)
        {
            // add a new CSharpDelegate on the active diagram
            if (nID == 3 || nID == 4)
                OnAddNewCSharpDelegate((IApplication)pUModel);

            // release unused objects
            GC.Collect();
        }

        #endregion

        #region AddNewCSharpDelegate // add new CSharp delegate on active diagram
        
        UModelUpdateAction OnUpdateAddNewCSharpDelegate(IApplication pUModel)
        {
            if (pUModel == null)
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // get the active document of the application
            IDocument iDoc = pUModel.ActiveDocument;
            if (iDoc == null)
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // get the active diagram window
            IDiagramWindow iActiveDiagram = iDoc.ActiveDiagramWindow;
            if ( iActiveDiagram == null )
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // get the UML diagram of the diagram window
            IUMLGuiDiagram iUMLDiagram = iActiveDiagram.Diagram;

            // check if it is a class diagram
            if ( !( iUMLDiagram is IUMLGuiClassDiagram) )
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // verify if the diagram may be modified
            if ( !iUMLDiagram.IsEditable )
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // get the UML element, which "owns" the class diagram
            IUMLElement iDiagramOwner = iUMLDiagram.LinkedOwner;
            if (iDiagramOwner == null)
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // verify if we are inside a CSharp namespace root (otherwise adding a CSharp delegate makes no sense)
            IUMLElement iFindNamespaceRoot = iDiagramOwner;
            while( iFindNamespaceRoot != null)
            {
                if ( iFindNamespaceRoot is IUMLPackage)
                {
                    IUMLPackage iPackage = (IUMLPackage) iFindNamespaceRoot;
                    if ( iPackage.IsCodeLangNamespaceRoot( ENUMCodeLang.eCodeLang_CSharp ) )
                        return UModelUpdateAction.UModelUpdateAction_Enable;
                }

                iFindNamespaceRoot = iFindNamespaceRoot.Owner;
            }

            // nothing found => disable command
            return UModelUpdateAction.UModelUpdateAction_Disable;
        }

        public void OnAddNewCSharpDelegate(IApplication pUModel)
        {
            if (pUModel == null)
                return;

            // get the active document of the application
            IDocument iDoc = pUModel.ActiveDocument;
            if (iDoc == null)
                return;

            // get the active diagram window
            IDiagramWindow iActiveDiagram = iDoc.ActiveDiagramWindow;
            if (iActiveDiagram == null)
                return;

            // get the UML diagram of the diagram window
            IUMLGuiDiagram iUMLDiagram = iActiveDiagram.Diagram;

            // get the CSharp profile
            IUMLProfile iCSharpProfile = (IUMLProfile) iDoc.RootPackage.FindPredefinedOwnedElement(ENUMUMLPredefinedElement.ePredefined_CSharp_Profile, false);
            if ( iCSharpProfile == null)
                return;

            try
            {
                // make all modifications within one UndoStep; start modification here
                if (!iDoc.BeginModification())
                    return;

                // get top left corner of the visible diagram area
                int nInsertPosX = iActiveDiagram.ScrollPosX;
                int nInsertPosY = iActiveDiagram.ScrollPosY;

                // add new class on diagram
                IUMLGuiNodeLink iClassNode = iUMLDiagram.AddUMLElement("Class", nInsertPosX + 100, nInsertPosY + 100);

                IUMLClass iClass = (IUMLClass) iClassNode.Element;
                // use SetName (instead of Name) that UModel automatically generates a valid, unique name starting with "NewDelegate"
                iClass.SetName("NewDelegate");

                // set the CSharp 'delegate' stereotype
                iClass.ApplyPredefinedStereotype( ENUMUMLPredefinedElement.ePredefined_CSharp_delegateStereotypeOfClass );

                // set attribute-section "STAThread"
                IUMLStereotypeApplication iStereotypeApp = iClass.ApplyPredefinedStereotype(ENUMUMLPredefinedElement.ePredefined_CSharp_attributesStereotypeOfClass);
                IUMLEnumerationLiteral iSTAThread = (IUMLEnumerationLiteral)iCSharpProfile.FindPredefinedOwnedElement(ENUMUMLPredefinedElement.ePredefined_CSharp_AttributePresetsEnumeration_STAThreadEnumerationLiteral, true);
                iStereotypeApp.SetPredefinedTaggedValueAt(-1, ENUMUMLPredefinedElement.ePredefined_CSharp_attributesStereotypeOfClass_sectionsProperty, iSTAThread.Name);

                // add delegate operation:
                IUMLOperation iOperation = iClass.InsertOwnedOperationAt(-1);
                iOperation.SetName( "delegate");

                // per default set operation-return type "void"
                IUMLPrimitiveType iTypeVoid = (IUMLPrimitiveType)iCSharpProfile.FindPredefinedOwnedElement(ENUMUMLPredefinedElement.ePredefined_CSharp_voidPrimitiveType, true);
                iOperation.Type = iTypeVoid;

                // do not forget to end modification and finish UndoStep
                iDoc.EndModification();

                // at last focus newly inserted delegate on the diagram:
                iActiveDiagram.SelectGuiElement(iClassNode, true);
            }
            catch( System.Exception )
            {
                // rollback made changes
                iDoc.AbortModification();

                // add error handling
            }
        }

        #endregion 
    }
}
