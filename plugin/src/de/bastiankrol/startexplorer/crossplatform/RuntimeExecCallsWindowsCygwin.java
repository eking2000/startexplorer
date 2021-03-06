package de.bastiankrol.startexplorer.crossplatform;

import java.io.File;

/**
 * Runtime exec calls for Windows with Cygwin.
 * 
 * @author Bastian Krol
 */
class RuntimeExecCallsWindowsCygwin extends AbstractRuntimeExecCallsWindows
{

  /**
   * Creates a new instance and initializes the {@link RuntimeExecDelegate}.
   */
  RuntimeExecCallsWindowsCygwin()
  {
    super();
  }

  /**
   * Creates a new instance with the given {@link RuntimeExecDelegate}.
   * 
   * @param delegate the RuntimeExecDelegate to use
   */
  RuntimeExecCallsWindowsCygwin(RuntimeExecDelegate delegate)
  {
    super(delegate);
  }

   @Override
  String[] getCommandForStartShell(File file)
  {
    return new String[] { "cmd.exe /c start /d " + getPath(file) + " bash.exe" };
  }
}
