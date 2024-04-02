class BadNine
{
    public static void main(String[] a)
    {
        System.out.println(new ThisClass().ThisMethod(0));
    }
}

class ThisClass extends ThatOtherClass
{
    int value;
    boolean truth;
    
    public int ThisMethod(int value)
    {
        value = this.NonExistentMethod(value);
        if (value < 0)
            truth = true;
        else
        {
            value = 0;
            truth = false;
        }
    }
}


