using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using UModelLib;
using UModelPlugInLib;

/* 
 * Styles sample
 * set following styles for selected diagram elements
 *      Fill Color
 *      Header Gradient Begin Color
 *      Header Gradient End Color 
 * if style is available and not already set
 */

namespace Styles
{
    public class UModelStyles : UModelPlugInLib.IUModelPlugIn
    {
        bool m_bPlugInVersionOK = true; // verify if UModel-API has been changed in a way that a recompile of this plug-in is recommended

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
            return "Styles sample Plug-in for UModel;This Plug-in demonstrates how to change several styles of the selected diagram elements.";
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
                MessageBox.Show("Error in GetUIModifications:" + ex.Message);
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

            // verify if UModel-API has been changed in a way that a recompile of this plug-in is recommended:
            IApplication iApp = (IApplication)pUModel;
            if (iApp == null || iApp.APIMajorVersion != 5) // this plug-in was compiled for API major version '5'!
            {
                MessageBox.Show("'Styles': This Plug-in has been made with a previous version of the UModel-API and should be recompiled.\nDisabled Plug-in commands in the meantime.");
                m_bPlugInVersionOK = false;
            }
        }

        public void OnShutdown(object pUModel)
        {
            // application will shutdown; release all unused objects
            GC.Collect();
        }

        public UModelUpdateAction OnUpdateCommand(int nID, object pUModel)
        {
            UModelUpdateAction action = UModelUpdateAction.UModelUpdateAction_Disable;
            if (!m_bPlugInVersionOK)
                return action;

            // check for "fill red"
            if (nID == 3 || nID == 6)
                action = OnUpdateSetStyles((IApplication)pUModel);

            // check for "fill green"
            if (nID == 4 || nID == 7)
                action = OnUpdateSetStyles((IApplication)pUModel);

            // release unused objects
            GC.Collect();

            return action;
        }

        public void OnCommand(int nID, object pUModel)
        {
            if (!m_bPlugInVersionOK)
                return;

            // fill red
            if (nID == 3 || nID == 6)
                OnSetStyles((IApplication)pUModel, "red");

            // fill green
            if (nID == 4 || nID == 7)
                OnSetStyles((IApplication)pUModel, "green");

            // release unused objects
            GC.Collect();
        }

        #endregion

        #region SetStyles // set styles of selected diagram elements
        
        UModelUpdateAction OnUpdateSetStyles(IApplication pUModel)
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

            // get the selected elements on the active diagram
            IUMLDataList iSelection = iActiveDiagram.SelectedGuiElements;
            if ( iSelection == null )
                return UModelUpdateAction.UModelUpdateAction_Disable;

            // search all selected elements, if at least one has one of the styles to change
            foreach ( IUMLGuiElement iSelGuiElement in iSelection )
            {
                // verify if it is a GuiVisibleElement (with Styles) and if it may be modified
                if ( iSelGuiElement is IUMLGuiVisibleElement && iSelGuiElement.IsEditable )
                {
                    IUMLGuiVisibleElement iVisGuiElement = (IUMLGuiVisibleElement)iSelGuiElement;

                    if ( iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_FillColor) != null ||
                         iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_HeaderGradientBeginColor) != null ||
                         iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_HeaderGradientEndColor) != null )
                    {
                        return UModelUpdateAction.UModelUpdateAction_Enable;
                    }
                }
            }

            // nothing found => disable command
            return UModelUpdateAction.UModelUpdateAction_Disable;
        }

        public void OnSetStyles(IApplication pUModel, string sColor)
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

            // get the selected elements on the active diagram
            IUMLDataList iSelection = iActiveDiagram.SelectedGuiElements;
            if (iSelection == null)
                return;

            try
            {
                // make all modifications within one UndoStep; start modification here
                if (!iDoc.BeginModification())
                    return;

                // search all selected elements, and change the style if the wanted value is not already used (directly applied or through style-chain)
                foreach (IUMLGuiElement iSelGuiElement in iSelection)
                {
                    // verify if it is a GuiVisibleElement (with Styles) and if it may be modified
                     if (iSelGuiElement is IUMLGuiVisibleElement && iSelGuiElement.IsEditable )
                    {
                        IUMLGuiVisibleElement iVisGuiElement = (IUMLGuiVisibleElement)iSelGuiElement;

                        // set Fill Color if possible and not already set
                        IUMLGuiStyle iStyle = iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_FillColor);
                        if (iStyle != null && iStyle.UsedValue != sColor)
                            iStyle.Value = sColor;

                        // set Header Gradient Begin Color if possible and not already set
                        iStyle = iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_HeaderGradientBeginColor);
                        if (iStyle != null && iStyle.UsedValue != sColor)
                            iStyle.Value = sColor;

                        // set Header Gradient End Color if possible and not already set
                        iStyle = iVisGuiElement.Styles.GetStyle(ENUMUMLGuiStyleKind.eUMLGuiStyle_HeaderGradientEndColor);
                        if (iStyle != null && iStyle.UsedValue != sColor)
                            iStyle.Value = sColor;
                    }
                }

                // do not forget to end modification and finish UndoStep
                iDoc.EndModification();
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
