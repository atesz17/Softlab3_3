package cmd;

import java.io.File;

public class Exit implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		System.exit(0);
		return null;
	}

}
