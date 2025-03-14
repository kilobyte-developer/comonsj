import java.util.*;

class MyThread extends Thread
{
	String message="";
	int n;
	MyThread(String message,int n)
	{
		this.message = message;
		this.n = n;
	}
	public void run()
	{
		try
		{
			for(int i=0;i<n;i++)
			{
				System.out.println(message+" "+i+"Times ");
	
			}
		}
		catch(Exception e) 
		{
			
		}
	}
}
public class Covid_SETA 
{
	public static void main(String args[])
	{
		int n= 10;
		MyThread t1 = new MyThread("Covid10",n);
		System.out.println(t1);
		t1.start();
		MyThread t2 = new MyThread("LOCKDOWN20",n+10);
		System.out.println(t2);
		t2.start();
		MyThread t3 = new MyThread("Vaccinated20",n+20);
		System.out.println(t3);
		t3.start();
	}
}
