package cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WC implements Command {

	@Override
	public File execute(File wd, String[] cmd) {
		// TODO Auto-generated method stub
		try
		{
			FileReader fr = new FileReader(new File(wd, cmd[1]));
			BufferedReader br = new BufferedReader(fr);
			int rowCount = 0;
			int wordCount = 0;
			int charCount = 0;
			while(true)
			{
				String line = br.readLine();
				if (line == null)
					break;
				rowCount++;
				StringTokenizer str = new StringTokenizer(line);
				while (str.hasMoreTokens())
				{
					wordCount++;
					charCount += str.nextToken().length();
				}
			}
			br.close();
			System.out.println("- Rows in file: " + rowCount);
			System.out.println("- Words in file: " + wordCount);
			System.out.println("- Character count in file: " + charCount);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
		return null;
	}

}
