/**
 * MiniJavaSyntaxChecker - driver program for mini java parser.
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MiniJavaSyntaxChecker implements ParserTokens
{
	public MiniJavaSyntaxChecker(String[] args) throws IOException
	{
		scan(args);
	}

	public void scan(String[] args) throws IOException
	{
		int count = 0;
		int success = 0;
		int failure = 0;
		
		if (args.length == 0)
		{
			BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
			String program = lineReader.readLine();
			Parser parser = new Parser("string", program);
			boolean result = parser.parse();
			System.out.println("Parse " + (result ? "successful" : "errors"));
			System.out.println("------------------------------------------------");
			count++;
			success += result ? 1 : 0;
			failure += result ? 0 : 1;
		}
		else
		{
			for (String arg : args)
			{
				Path filePath = Path.of(arg);
				String name = filePath.toFile().getName();
				String program = Files.readString(filePath);
				Parser parser = new Parser(name, program);
				boolean result = parser.parse();
				System.out.println("Parse " + (result ? "successful" : "errors"));
				System.out.println("------------------------------------------------");
				count++;
				success += result ? 1 : 0;
				failure += result ? 0 : 1;
			}
		}
		
		System.out.println("total: " + count + ", successes: " + success + ", failures: " + failure);
	}

	public static void main(String[] args) throws IOException
	{
		new MiniJavaSyntaxChecker(args);
	}
}
