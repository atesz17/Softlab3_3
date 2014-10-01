package cmd;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		Reader r = new Reader();
		System.out.println("Ready for reading input...");
		while(true)
		{
			r.processInput();
		}
	}
}
