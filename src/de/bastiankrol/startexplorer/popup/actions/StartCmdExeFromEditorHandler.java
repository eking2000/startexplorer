package de.bastiankrol.startexplorer.popup.actions;

import java.io.File;

import de.bastiankrol.startexplorer.ResourceType;

/**
 * Examines the selected region in a text file, tries to interpret it as a
 * Windows filesystem path and tries to start cmd.exe for the directory
 * described by that path.
 * 
 * @author Bastian Krol
 */
public class StartCmdExeFromEditorHandler extends
    AbstractStartFromEditorHandler
{
  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromEditorHandler#getResourceType()
   */
  protected ResourceType getResourceType()
  {
    return ResourceType.DIRECTORY;
  }

  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromEditorHandler#doActionForFile(java.io.File)
   */
  protected void doActionForFile(File file)
  {
    this.getRuntimeExecCalls().startShellForFile(file);
  }

  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromEditorHandler#getAppropriateStartFromResourceHandler()
   */
  @Override
  protected AbstractStartFromResourceHandler getAppropriateStartFromResourceHandler()
  {
    return new StartCmdExeFromResourceHandler();

  }
}
