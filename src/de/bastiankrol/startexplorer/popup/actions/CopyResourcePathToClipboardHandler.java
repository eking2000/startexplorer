package de.bastiankrol.startexplorer.popup.actions;

import java.io.File;
import java.util.List;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import de.bastiankrol.startexplorer.preferences.PreferenceUtil;
import de.bastiankrol.startexplorer.util.PathChecker;

/**
 * Handler for the command copy resource path to clipboard
 * 
 * @author Bastian Krol
 * @version $Revision:$ $Date:$
 */
public class CopyResourcePathToClipboardHandler extends
    AbstractStartFromResourceHandler
{
  private PreferenceUtil preferenceUtil = new PreferenceUtil();

  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromStringHandler#getResourceType()
   */
  protected PathChecker.ResourceType getResourceType()
  {
    return PathChecker.ResourceType.BOTH;
  }

  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromResourceHandler#doActionForFileList(java.util.List)
   */
  @Override
  protected void doActionForFileList(List<File> fileList)
  {
    if (fileList.isEmpty())
    {
      return;
    }
    StringBuffer clipboardContentBuffer = new StringBuffer();
    String copyResourcePathSeparator =
        this.preferenceUtil.getCopyResourcePathSeparatorStringFromPreferences();
    for (File file : fileList)
    {
      clipboardContentBuffer.append(file.getAbsolutePath());
      clipboardContentBuffer.append(copyResourcePathSeparator);
    }

    // clip last separator
    String clipboardContent =
        clipboardContentBuffer.substring(0, clipboardContentBuffer.length()
            - copyResourcePathSeparator.length());

    Display display = Display.getDefault();
    Clipboard clipboard = new Clipboard(display);
    TextTransfer textTransfer = TextTransfer.getInstance();
    clipboard.setContents(new Object[] { clipboardContent },
        new Transfer[] { textTransfer });
    clipboard.dispose();
  }

  /**
   * {@inheritDoc}
   * 
   * @see de.bastiankrol.startexplorer.popup.actions.AbstractStartFromResourceHandler#getAppropriateStartFromStringHandler()
   */
  @Override
  protected AbstractStartFromStringHandler getAppropriateStartFromStringHandler()
  {
    // there is no appropriate text selection based handler for this action
    return null;
  }
}