import java.util.*;

class thread implements Runnable
{
	Thread t;
	int i,no=0,sum;
	int a[] = new int[1000];
	
	thread(String s,int n)
	{
		Random rs = new Random();
		t = new Thread(this,s);
		
		no = n;
		int j=0;
		
		for(i=1;i<=1000;i++)
		{
			a[j] = rs.nextInt(100)%100;
			j++;
		}
		t.start();
	}
	
	public void run()
	{
		for(i=0;i<100;i++)
		{
			sum = sum+a[no];
			no++;
		}
		System.out.println("Sum="+sum);
		System.out.println("Avg="+sum/100);
	}
}

public class sum_array
{
	public static void main(String args[]) throws InterruptedException
	{
		thread t1=new thread("g",1);
		t1.t.join();
		thread t2=new thread("r",100);
		t2.t.join();
		thread t3=new thread("s",200);
		t3.t.join();
		thread t4=new thread("t",300);
		t4.t.join();
		thread t5=new thread("p",400);
		t5.t.join();
		thread t6=new thread("p",500);
		t6.t.join();
		thread t7=new thread("p",600);
		t7.t.join();
		thread t8=new thread("p",700);
		t8.t.join();
		thread t9=new thread("p",800);
		t9.t.join();
		thread t10=new thread("p",900);
		t10.t.join();
	}
}