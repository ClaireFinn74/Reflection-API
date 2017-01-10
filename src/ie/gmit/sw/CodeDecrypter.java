package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class CodeDecrypter implements Runnable //Has one method called run
{

	//variables
	private BlockingQueue<Resultable> myqueue;
	private String cypherText;
	private int IdentifierKey;

	public CodeDecrypter(BlockingQueue<Resultable> queue, String cypherText)
	{
		super();
		this.myqueue = queue;
		this.cypherText = cypherText;
	}

	//run method
	public void run()
	{
		//makes a railfence
		RailFence railFence = new RailFence();
		//Decrypts cyphertext to readable plaintext
		String plainText = railFence.decrypt(cypherText, IdentifierKey);

		//catches any exceptions
		Resultable resultable = null;
		try
		{
			myqueue.put(resultable);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}