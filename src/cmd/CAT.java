package cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CAT implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		try
		{
			if (cmd.length == 2)
			{
				FileReader fr = new FileReader(new File(wd, cmd[1]));
				BufferedReader br = new BufferedReader(fr);
				while(true)
				{
					String line = br.readLine();
					if (line == null)
						break;
					System.out.println(line);
				}
				br.close();
			}
			else
			{
				throw new IOException();
			}
		}
		catch (IOException e)
		{
			System.err.print("Not enough or too many parameters.");
			e.printStackTrace();
		}
		
		return null;
	}

}
