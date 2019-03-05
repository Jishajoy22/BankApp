
class Demo implements Runnable 
{
public void run()
{
	try
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
			Thread.sleep(3000);
		}
	synchronized(this)
	{
		for(int j=65;j<=70;j++)
		{
			System.out.println((char)j);
			Thread.sleep(5000);
		}
	}
	}
	catch(Exception e)
	{
		System.out.println("Some problem occurred");

	}
}
}
class Launch
{
	public static void main(String[] args) {
		Demo d=new Demo();
		Thread t1=new Thread();
	    Thread t2=new Thread();
		t1.start();
		t2.start();
		
	}
}
