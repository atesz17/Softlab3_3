package cmd;

import java.io.File;

public interface Command {
	File execute(File wd, String[] cmd);
}
