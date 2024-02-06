/* Scanner specification file for simple math expressions. */
/* Name: Dr. Tom Way */
/* Date: 1/10/23 */
%%

%unicode
%line
%column
%standalone

%{

	// Returns current line number
	public int getLine()
	{
		return yyline;
	}

	// Returns current column number
	public int getCol()
	{
		return yycolumn;
	}
	
	// Holds value of current token
	public int value;

%}


letter = [A-Za-z]
digit = [0-9]

%%

{digit}+			{ value = Integer.parseInt(yytext());
					  return ParserTokens.NUMBER; }
"+"					{ return ParserTokens.ADDOP; }
[\r\n]+				{ return ParserTokens.NEWLINE; }
[ \t]+				{/* do nothing-skip whitespace */}
<<EOF>>				{ return ParserTokens.ENDINPUT; }
.					{ return ParserTokens.error; }
