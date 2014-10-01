package cmd;

import java.io.File;
import java.io.IOException;

public class PWD implements Command {
	
	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		try {
			System.out.println(wd.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
