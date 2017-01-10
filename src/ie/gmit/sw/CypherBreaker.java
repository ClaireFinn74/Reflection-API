package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker
{

	private static final int MAX_QUEUE_SIZE = 150;
	//can not close a blocking queue unless you poison it
	private BlockingQueue<Resultable> myQueue;
	private String EncodedText;

	//Starting a new blocking queue, waits for space to become available in the queue
	public CypherBreaker()
	{
		myQueue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.EncodedText = EncodedText;
		init();
	}

	public void init()
	{
		for (int i = 2; i < EncodedText.length()/2; i++)
		{
			new Thread(new CodeDecrypter(myQueue, EncodedText)).start();

		}

		new Thread(new Runnable()
		{
			 //if queue is not empty, take from it
			public void run()
			{
				while(!myQueue.isEmpty())
				{
					try
					{
						Resultable resultable = myQueue.take();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		});


	}


}
