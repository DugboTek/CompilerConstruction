class OneToTen
{
    public static void main(String[] a)
    {
        System.out.println(new Count().Run(10));
    }
}

class Count
{
    public int Run(int high)
    {
        int n;
        n = 1;
        while (n < high)
        {
            System.out.println(n);
            n = n + 1;
        }
        return n;
    }
}
