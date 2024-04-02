class BadFour
{
    public static void main(String[] a)
    {
        System.out.println(new Internal().Run(0));
    }
}

class Internal
{
    public int Run(int x)
    {
        int y;
        y = x * 4 - 3;
        
        if (y > 9)
            System.out.println(true);
        else
            System.out.println(false);
        return y * x;
    }
}
