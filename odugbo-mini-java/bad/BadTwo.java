class BadTwo
{
    public static void main(String[] a)
    {
        System.out.println(new Internal().Run(0));
    }
}

public class Internal
{
    public int Run(int x)
    {
        System.out.println(x + 77);
        return x;
    }
}
