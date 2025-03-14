class MyThreadDemo 
{
    public static void main(String args[]) 
    {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread is: " + t);

        // Changing the thread name
        t.setName("Demo Thread");
        System.out.println("After changing the name, thread is: " + t);

        try 
        {
            for (int n = 100; n > 0; n--) 
            {
                System.out.println(n);
                Thread.sleep(1); // Pause for 6 seconds
            }
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Thread interrupted");
        }
    }
}
