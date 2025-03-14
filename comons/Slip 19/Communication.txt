
public class Communication {
	public static void main(String args[])
	{
		Producer p = new Producer();
		Consumer c = new Consumer(p);
		c.start();
		p.start();
	}
}



class Producer extends Thread
{
	StringBuffer sb;
	
	Producer()
	{
		sb = new StringBuffer();
	}
	public void run()
	{
		synchronized(sb)
		{
			for(int i=0;i<=10;i++)
			{
				try
				{
					sb.append(i+":");
					Thread.sleep(100);
					System.out.println("Appending:"+i);
				}
				catch(InterruptedException e)
				{
						System.out.println(e);
				}
			}
			sb.notify();
		}
	}
}

class Consumer extends Thread
{
	Producer prod;
	Consumer(Producer prod)
	{
		this.prod = prod;
	}
	public void run()
	{
		synchronized(prod.sb)
		{
			try
			{
				prod.sb.wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			System.out.println(prod.sb);
		}
	}
}