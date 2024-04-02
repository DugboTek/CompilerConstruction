/* Scanner specification file for mini java syntax checker. */
/* Author: sola dugbo */
/* Date: 3/08/22 */

%%

%unicode
%line
%column
%standalone
%implements ParserTokens

/* uncomment %debug to see verbose scanner output */
%debug

%{
	// Store a reference to the parser object. Needed to reference yylval.
	private Parser yyparser;

	// constructor taking an additional parser
	public Yylex(java.io.Reader r, Parser yyparser)
	{
		this(r);	
		this.yyparser = yyparser;
	}
	
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
%}

digit = [0-9]
letter = [A-Za-z]

// integer is either 0 or any number
// of digits starting with 1-9
integer = "0"|[1-9]{digit}*

// identifier sequence of letters, digits, 
// and underscores, starting with a letter
identifier = ({letter})({letter}|{digit}|"_")*

hex = ("0x"| "0X")([0-9a-fA-F])+
binary = ("0b"|"0B")("0"|"1")+
octal = "0"([0-7])+

whitespace = [\s]+


// Single-line comments
LineComment = "//".*

// Multi-line comments
MultiLineComment = "/*"~"*/"

%%

"class"				{ return CLASS; }

"public"			{ return PUBLIC; }

"static"			{ return STATIC; }

"void"				{ return VOID; }

"main"				{ return MAIN; }
"String"			{ return STRING; }
"int"				{ return INT; }
"boolean"			{ return BOOLEAN; }
"extends"			{ return EXTENDS; }
"return"			{ return RETURN; }
"if"				{ return IF;}
"else"				{ return ELSE;}
"while"				{ return WHILE;}
"System.out.println" { return PRINT;}
"true"				{ return TRUE;}
"false"				{ return FALSE;}
"this"				{ return THIS;}
"new"				{ return NEW;}
"length"			{ return LENGTH;}
"&&" 				{ return AND; }
"<"					{ return LT; }
"-"					{ return MINUS; }
"+"					{ return PLUS; }
"!"					{ return NOT;}
","					{ return COMMA;}
"."					{ return DOT;}
";" 				{ return SEMICOLON;}
"*"					{ return TIMES;}


"="					{ return EQUALS; }

"{"					{ return LBRACE; }
"}"					{ return RBRACE; }
"("					{ return LPAREN; }
")"					{ return RPAREN; }
"["					{ return LBRACKET; }
"]"					{ return RBRACKET; }
";"					{ return SEMICOLON; }



{identifier}		{ return IDENTIFIER; }

{integer}			{ return INTEGER_LITERAL; }
{hex}				{ return INTEGER_LITERAL; }
{binary}			{ return INTEGER_LITERAL; }
{octal}				{ return INTEGER_LITERAL; }

{whitespace}		{/* ignore */}
{LineComment} {/* ignore */}
{MultiLineComment} {/* ignore */}


<<EOF>>				{ return ENDINPUT; }
.					{ return UNKNOWN; }
