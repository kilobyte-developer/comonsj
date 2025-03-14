import java.util.*;

class Randomno extends Thread
{
	public void run()
	{
		Random rs = new Random();
		
		for(int i=0;i<10;i++)
		{
			int randint = rs.nextInt(100);
			System.out.println("Random No Generated:"+randint);
			if((randint%2)==0)
			{
				System.out.println("Generated no is Even");
				SquareThread sthread = new SquareThread(randint);
				sthread.start();
			}
			else {

				System.out.println("Generated no is Odd");
				CubeThread rthread = new CubeThread(randint);
				rthread.start();
			}
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
	}
	
}

class SquareThread extends Thread
{
	int randint;
	
	SquareThread(int randint)
	{
		this.randint = randint;
	}
	
	public void run()
	{
		System.out.println("Square of Number:"+randint*randint);
	}
}

class CubeThread extends Thread
{
	int randint;
	
	CubeThread(int randint)
	{
		this.randint = randint;
	}
	
	public void run()
	{
		System.out.println("Cube of Number:"+randint*randint*randint);
	}
}

public class MultiThread {
	public static void main(String args[])
	{
		Randomno r = new Randomno();
		r.start();
	}	
}
