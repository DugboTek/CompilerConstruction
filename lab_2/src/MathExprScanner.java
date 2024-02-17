import java.io.*;
import java.util.Stack;

/**
 * Math Expression Scanner driver program
 * Name: Sola Dugbo
 * Date: 1/25/23
 */
public class MathExprScanner implements ParserTokens {

    public MathExprScanner() throws IOException {
        scan();
    }

    public void scan() throws IOException {
        // Create the scanner object
        InputStreamReader in = new InputStreamReader(System.in);
        Yylex lexer = new Yylex(in);

        String expr = ""; // gather complete scanned expression
        Stack<Character> parenStack = new Stack<>(); // for tracking parentheses
        int numOps = 0;
        

        // Flags to report error or more tokens available
        boolean hasError = false;
        boolean hasToken = true;
        
        int lastToken;

        while (hasToken) {
            // Get next token
            int token = lexer.yylex();
            hasToken = token != Yylex.YYEOF; // was end of file reached?

            // Gather up the current expression from each token
            expr += lexer.yytext() + " ";

            switch (token) {
            case NUMBER:
            	numOps = 0;
                System.out.println(lexer.yytext() + " NUMBER " + lexer.value);
                break;
            case ADDOP:
                System.out.println(lexer.yytext() + " ADDOP ");
                numOps++;
                if(numOps>1) {
                	hasError= true;
                	System.out.println("Invalid operator placment");
                }
                break;
            case MULOP:
                System.out.println(lexer.yytext() + " MULOP ");
                numOps++;
                if(numOps>1) {
                	hasError= true;
                	System.out.println("Invalid operator placment");
                }
                break;
            case DIVOP:
                System.out.println(lexer.yytext() + " DIVOP ");
                numOps++;
                if(numOps>1) {
                	hasError= true;
                	System.out.println("Invalid operator placment");
                }
                break;
            case LPAREN:
                System.out.println(lexer.yytext() + " LPAREN ");
                parenStack.push('(');
                
                break;
            case RPAREN:
                System.out.println(lexer.yytext() + " RPAREN ");
                if (parenStack.isEmpty()) {  // Check for empty stack first
                	hasError= true;
                	System.out.println("Mismatched parentheses: Extra closing parenthesis");
                } else {
                    char lastParen = parenStack.pop();
                    if (lastParen != '(') {
                    	System.out.println("Mismatched parentheses");
                    }
                }
                break;
            case NEWLINE:
            case ENDINPUT:
            default:
            	numOps = 0;
                System.out.println(hasError ? "Rejected": "Accepted");
                System.out.println("--------------------------");
                expr = "";
                hasError = false;
                parenStack.clear(); // reset parens for next expression
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new MathExprScanner();
    }
}
