package ie.gmit.sw;

public class Runner
{
	public static void main(String[] args)
	{
		//Runner class to run a new window
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new AppWindow();
			}
		});
	}
}
