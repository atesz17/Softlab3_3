package cmd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CD implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		File cr = wd;
		try
		{
			if (cmd.length==1)
			{
				throw new IOException();
			}
			else if (cmd[1].equals(".."))
			{
				wd = wd.getParentFile();
			}
			else
			{
				String fileWithSpcaes = new String();
				for (int i = 1; i<cmd.length; i++)
				{
					fileWithSpcaes += new String((cmd[i] + " "));
				}
				fileWithSpcaes = fileWithSpcaes.substring(0, fileWithSpcaes.length() - 1);
				
				wd = new File(wd, cmd[1]);
				if(!wd.exists() || !wd.isDirectory())
					throw new FileNotFoundException();
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Directory doesnt exist.");
		}
		catch(IOException e)
		{
			System.out.println("Too many, or too few parameters. Check code at:");
			e.printStackTrace();
		}
		if (wd.exists() && wd.isDirectory())
			return wd;
		else
			return cr;
	}

}
