import java.io.*;
import java.io.InputStreamReader;

/**
 * Math Expression Scanner driver program
 * Name: Dr. Tom Way
 * Date: 1/25/23
 *
 */
public class MathExprScanner implements ParserTokens
{
	public MathExprScanner() throws IOException
	{
		scan();
	}

	public void scan() throws IOException
	{
		// Create the scanner object
		InputStreamReader in = new InputStreamReader(System.in);
		Yylex lexer = new Yylex(in);

		String expr = ""; // gather complete scanned expression
		
		// Flags to report error or more tokens available
		boolean hasError = false;
		boolean hasToken = true;

		while (hasToken)
		{
			// Get next token
			int token = lexer.yylex();
			hasToken = token != Yylex.YYEOF; // was end of file reached?
					
			// Gather up the current expression from each token
			expr += lexer.yytext() + " ";

			// ADD MORE BELOW to display all of the tokens your scanner recognizes
			switch (token)
			{
			case NUMBER:
				System.out.println(lexer.yytext() + " NUMBER " + lexer.value);
				break;
			case ADDOP:
				System.out.println(lexer.yytext() + " ADDOP " + "");
				break;
			case error:
				hasError = true;
				System.out.println("ERROR");
				break;
			case NEWLINE:
			case ENDINPUT:
			default:
				System.out.println("hasError:" + hasError);
				System.out.println("--------------------------");
				expr = "";
				hasError = false;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		new MathExprScanner();
	}
}
