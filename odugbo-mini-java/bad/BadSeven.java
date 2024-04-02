class BadSeven
{
    public static void main(String[] a)
    {
        System.out.println(new One().Run(0));
    }
}

class One
{
    public int Run(int x)
    {
        return x;
    }
}

class Two
{
    
}

class Three
{
    
}

class Four{}

class Five{
}

class Six{
    public int MyMethod(int x)
    {
        if (x < 9) {
            if (x < 5) {
                if (x < 0) {
                    x = 0;
                } else {
                    x=999;
                }
            } else {
                y = 2;
                if (y < 9)
                    y = 3;
                else
                    if(true)
                        x = 9;
                    else
                        x = 10;
                }
            } else { y = x / 4; }
    }
}
