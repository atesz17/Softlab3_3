package cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

	private String line;
	public static File wd = new File(System.getProperty("user.dir"));
	
	public void processInput() throws IOException // br.readLine-hoz kell
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		switchCommand(line.split("\\s"));
		/*
		command = line.split("\\s")[0];
		paramCount = line.split("\\s").length - 1;
		parameters = new String[paramCount];
		for (int i = 0; i < paramCount; i++)
			parameters[i] = line.split("\\s")[i+1];
			*/
	}
	
	private void switchCommand(String[] cmd)
	{
		if (cmd[0].equals("exit"))
		{
			Exit e = new Exit();
			e.execute(wd, cmd);
		}
		else if(cmd[0].equals("pwd"))
		{
			PWD pwd = new PWD();
			pwd.execute(wd, cmd);
		}
		else if(cmd[0].equals("cd"))
		{
			CD cd = new CD();
			wd = cd.execute(wd, cmd);
		}
		else if(cmd[0].equals("ls"))
		{
			LS ls = new LS();
			ls.execute(wd, cmd);
		}
		else if(cmd[0].equals("mv"))
		{
			MV mv = new MV();
			mv.execute(wd, cmd);
		}
		else if(cmd[0].equals("cat"))
		{
			CAT cat = new CAT();
			cat.execute(wd, cmd);
		}
		else if(cmd[0].equals("wc"))
		{
			WC wc = new WC();
			wc.execute(wd, cmd);
		}
		else
			System.out.println("Invalid input, try again!");
	}
}
