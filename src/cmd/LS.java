package cmd;

import java.io.File;
import java.io.IOException;

public class LS implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		File[] list = wd.listFiles();
		
		if (cmd.length == 2)
		{
			if (cmd[1].equals("-l"))
			{
				advancedLS(list);
			}
			else
			{
				try {
					throw new IOException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Wrong parameter.");
					e.printStackTrace();
				}
			}
		}
		else
		{
			for (File l : list)
				System.out.println(l.getName());
		}
		
		return wd;
	}
	
	private long folderSize(File directory) {
	    long length = 0;
	    for (File file : directory.listFiles()) {
	        if (file.isFile())
	            length += file.length();
	        else
	            length += folderSize(file);
	    }
	    return length;
	}
	
	private void advancedLS(File[] list)
	{
		int maxCharSize = 0;
		long maxFolderFileSize = 0;
		
		// Formazasi kovetelmenyek
		
		for (File l : list)
			maxCharSize = l.getName().length() > maxCharSize ? l.getName().length() : maxCharSize;
		for (File l : list)
		{
			if (l.isDirectory())
				maxFolderFileSize = folderSize(l) > maxFolderFileSize ? folderSize(l) : maxFolderFileSize;
			else
				maxFolderFileSize = l.length() > maxFolderFileSize ? l.length() : maxFolderFileSize;
			if (maxFolderFileSize > Integer.MAX_VALUE)
				System.err.println("NEM PONTOS A MERET (Int vs Long OVERFLOW) ennel az elemnel: " + l.getName());
			
		}
		maxFolderFileSize = (new Integer((int)maxFolderFileSize)).toString().length();
		
		// END
		for (File l : list)
		{
			System.out.print(l.getName());
			for(int i = 0; i < maxCharSize - l.getName().length(); i++)
				System.out.print(" ");
			System.out.print("\t");
			int size = 0;
			if (l.isDirectory())
				System.out.print((size = (int) folderSize(l)));
			else
				System.out.print((size = (int) l.length()));
			for (int i = 0; i < maxFolderFileSize - new Integer(size).toString().length(); i++)
				System.out.print(" ");
			System.out.print("\t");
			if (l.isDirectory())
				System.out.println("d");
			else
				System.out.println("f");
		}
	}

}
