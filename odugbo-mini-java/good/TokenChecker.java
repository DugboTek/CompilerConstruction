/*
 * This program checks for various tokens 
 * to verify that just about everything is 
 * checked and can be successfully 
 * scanned and parsed.
 */
class TokenChecker
{
    public static void main(String[] a)
    {
        System.out.println(new Tokens().Check(32, 0x20, 0b100000));
    }
}

class Tokens extends GenericChecker
{
    public int Check(int x, int y, int z)
    {
        boolean positive;
        positive = true;
        
        // Add various kinds of values
        x = 0xffff; // hex
        x = y + 0X9ABC; // HEX
        x = z + 0764; // octal
        x = x + 0b0010010101; // binary
        x = x * 54321; // decimal
        
        positive = false;
        if (!(x < 0 && 87654 < x))
            positive = false;
        
        if (positive) {
            x = x * y - z;
        } else {
            x = 0 - x + y * z;
        }
        
        // Return the result
        return x;
    }
}


