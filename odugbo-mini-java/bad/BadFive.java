class BadFive
{
    public static void main(String[] a)
    {
        System.out.println(new Internal().Run(0));
    }
}

class Internal
{
    public void Run(int x)
    {
        return x;
    }
}
