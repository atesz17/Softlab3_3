package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

	private String line;
	
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
			exit(cmd);
		else if(cmd[0].equals("pwd"))
			pwd(cmd);
		else if(cmd[0].equals("cd"))
			cd(cmd);
		else if(cmd[0].equals("ls"))
			ls(cmd);
		else if(cmd[0].equals("mv"))
			mv(cmd);
		else if(cmd[0].equals("cat"))
			cat(cmd);
		else if(cmd[0].equals("wc"))
			wc(cmd);
	}
	
	protected void exit(String[] cmd)
	{
		System.exit(0);
	}
	
	protected void pwd(String[] cmd)
	{
		
	}
	
	protected void cd(String[] cmd)
	{
		
	}
	
	protected void ls(String[] cmd)
	{
		
	}
	
	protected void mv(String[] cmd)
	{
		
	}
	
	protected void cat(String[] cmd)
	{
		
	}
	
	protected void wc(String[] cmd)
	{
		
	}
}
