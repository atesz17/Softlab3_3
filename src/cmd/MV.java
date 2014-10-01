package cmd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MV implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		try
		{
			if (cmd.length == 3)
			{
				File f1 = new File(wd, cmd[1]);
				if (!f1.exists())
					throw new FileNotFoundException();
				File f2 = new File(wd, cmd[2]);
				if (f2.exists())
					throw new IOException();
				
				boolean success = f1.renameTo(f2);
				if (!success)
					throw new RuntimeException();
			}
			else
			{
				System.err.println("Not enoguh parameters.");
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.print("First parameter doesnt exist.");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.err.print("Cannot rename beacuse a file with that name already exist.");
			e.printStackTrace();
		}
		catch(RuntimeException e)
		{
			System.err.print("Something went wrong while renaming the file.");
			e.printStackTrace();
		}
		
		return null;
	}

}
