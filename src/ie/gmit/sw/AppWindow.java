package ie.gmit.sw;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import sun.tools.jar.resources.jar;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class AppWindow
{

	private JFrame frame;

	public AppWindow()
	{
		//Create a window for the application
		frame = new JFrame();
		frame.setTitle("B.Sc. in Software Development - GMIT");
		frame.setSize(550, 500);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());

        //The file panel will contain the file chooser
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING));
        top.setBorder(new javax.swing.border.TitledBorder("Select File to Encode"));
        top.setPreferredSize(new java.awt.Dimension(500, 100));
        top.setMaximumSize(new java.awt.Dimension(500, 100));
        top.setMinimumSize(new java.awt.Dimension(500, 100));

        final JTextField txtFileName =  new JTextField(20);
		txtFileName.setPreferredSize(new java.awt.Dimension(100, 30));
		txtFileName.setMaximumSize(new java.awt.Dimension(100, 30));
		txtFileName.setMargin(new java.awt.Insets(2, 2, 2, 2));
		txtFileName.setMinimumSize(new java.awt.Dimension(100, 30));

		JButton btnChooseFile = new JButton("Browse...");
		btnChooseFile.setToolTipText("Select File to Encode");
        btnChooseFile.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMaximumSize(new java.awt.Dimension(90, 30));
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.setMinimumSize(new java.awt.Dimension(90, 30));
		btnChooseFile.addActionListener(new java.awt.event.ActionListener()
		{
            public void actionPerformed(ActionEvent evt)
            {
        		JFileChooser fc = new JFileChooser("./");
        		int returnVal = fc.showOpenDialog(frame);
            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                	File file = fc.getSelectedFile().getAbsoluteFile();
                	String name = file.getAbsolutePath();
                	txtFileName.setText(name);
                	System.out.println("You selected the following file: " + name);
            	}
			}
        });

		JButton btnJARInfo = new JButton("JAR Info");
		btnJARInfo.setToolTipText("JAR Info");
		btnJARInfo.setPreferredSize(new java.awt.Dimension(150, 30));
		btnJARInfo.setMaximumSize(new java.awt.Dimension(150, 30));
		btnJARInfo.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnJARInfo.setMinimumSize(new java.awt.Dimension(150, 30));
		btnJARInfo.addActionListener(new java.awt.event.ActionListener()
		{

            public void actionPerformed(ActionEvent evt)
            {
            	// check if their is something entered in the filepath
            	if(txtFileName.getText().length() > 1)
            	{
                    CalculationsImpl calcs = new CalculationsImpl(txtFileName.getText());
                    AppSummary as =  new AppSummary(frame, true);
                    TypeSummaryTableModel tm = as.getTableModel();
                    tm.setTableData(calcs.getInfoAboutMetric());
                    as.setVisible(true);
                }
            	else
            	{
                    System.out.println("No jar selected, Default one used instead");

                    /*Asking user to choose a number from 1-9 to display info about the 9 classes
        				within the JAR */
                    	Scanner user_input1 = new Scanner( System.in );
                    	//represents the number the user will enter
        				String classNumber;
        				System.out.println("There are 9 classes in the jar"
        									+ "\n" +
        									"Choose a number from 1-9 to see details of these classes"
        									+ "\n" +
        									"Classes are in Alphabetical Order");
        				classNumber = user_input1.next();


        				if(classNumber.equals("1"))
        				{
        					//Referencing ReflectionReferenceCodeDecryptor method from
        					//within CodeDecryptor
        		       	     try
        		       	     {
        						ReflectionCodeDecrypter.ReflectionReferenceCodeDecryptor();
        		 /*Opens a new window to begin the options again once the user has already picked,
        			  reduces nuisance of having to begin the console again after each choice */
        						javax.swing.SwingUtilities.invokeLater(new Runnable()
        						{
        							public void run()
        							{
        								new AppWindow();
        							}
        						});
        					 }
        		       	     catch (FileNotFoundException e)
        		       	     {
        						e.printStackTrace();
        					 }
        		       	     catch (ClassNotFoundException e)
        		       	     {
        						e.printStackTrace();
        				   	 }
        		       	     catch (IOException e)
        		       	     {
        						e.printStackTrace();
        					 }
        				}
        				else if(classNumber.equals("2"))
        				{
        					//Referencing ReflectionReferenceCypherBreaker method from
        					//within CypherBreaker
        		    		 try
        		    		 {
        		    			ReflectionCypherBreaker.ReflectionReferenceCypherBreaker();
        		    			javax.swing.SwingUtilities.invokeLater(new Runnable()
        						{
        							public void run()
        							{
        								new AppWindow();
        							}
        						});
        		    		 }
        		    		 catch (FileNotFoundException e)
        		    		 {
        		    			e.printStackTrace();
        		    		 }
        		    		 catch (ClassNotFoundException e)
        		    		 {
        		    			e.printStackTrace();
        		    		 }
        		    		 catch (IOException e)
        		    		 {
        		    			e.printStackTrace();
        		    		 }
            		    }


            		else if(classNumber.equals("3"))
        			{
            			//Referencing ReflectionReferenceParseFile method from
        				//within ParseFile
        		   		 try
        		   		 {
        		   			ReflectionParseFile.ReflectionReferenceParseFile();
        		   			javax.swing.SwingUtilities.invokeLater(new Runnable()
        					{
        						public void run()
        						{
        							new AppWindow();
        						}
        					});
        		   		 }
        		   		 catch (FileNotFoundException e)
        		   		 {
        		   			e.printStackTrace();
        		   		 }
        		   		 catch (ClassNotFoundException e)
        		   		 {
        		   			e.printStackTrace();
        		   		 }
        		   		 catch (IOException e)
        		   		 {
        		   			e.printStackTrace();
        		   		 }
        			 }

            		else if(classNumber.equals("4"))
        			{
            			//Referencing ReflectionReferenceQuadGramMap method from
        				//within QuadGramMap
               		 try
               		 {
               			ReflectionQuadGramMap.ReflectionReferenceQuadGramMap();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }

        			}

            		else if(classNumber.equals("5"))
        			{
            			//Referencing ReflectionReferenceRailFence method from
        				//within RailFence
               		 try
               		 {
               			ReflectionRailFence.ReflectionReferenceRailFence();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }
        			}

            		else if(classNumber.equals("6"))
        			{
            			//Referencing ReflectionReferencRapidEncryption method from
        				//within RapidEncryption
               		 try
               		 {
               			ReflectionRapidEncryption.ReflectionReferenceRapidEncryption();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }

        			}

            		else if(classNumber.equals("7"))
        			{
            			//Referencing ReflectionReferenceResult method from
        				//within Result
               		 try
               		 {
               			ReflectionResult.ReflectionReferenceResult();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }
        			}

            		else if(classNumber.equals("8"))
        			{
            			//Referencing ReflectionReferenceResultable method from
        				//within Resultable
               		 try
               		 {
               			ReflectionResultable.ReflectionReferenceResultable();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }
        			}

            		else if(classNumber.equals("9"))
        			{
            			//Referencing ReflectionReferenceTextScorer method from
        				//within TextScorer
               		 try
               		 {
               			ReflectionTextScorer.ReflectionReferenceTextScorer();
               			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
               		 }
               		 catch (FileNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (ClassNotFoundException e)
               		 {
               			e.printStackTrace();
               		 }
               		 catch (IOException e)
               		 {
               			e.printStackTrace();
               		 }

        			}
            		else
            		{
            			//If anything not in the range 1-9 is entered by the user print
            			// this error message
            			System.out.println("Invalid Entry!");
            			System.out.println("Please Enter a number in the range 1-9");

            			javax.swing.SwingUtilities.invokeLater(new Runnable()
        				{
        					public void run()
        					{
        						new AppWindow();
        					}
        				});
            		}

                }

            }
          }
);



        top.add(txtFileName);
        top.add(btnChooseFile);
        top.add(btnJARInfo);
        frame.getContentPane().add(top); //Add the panel to the window


        //A separate panel for the programme output
        JPanel mid = new JPanel(new FlowLayout(FlowLayout.LEADING));
        mid.setBorder(new BevelBorder(BevelBorder.RAISED));
        mid.setPreferredSize(new java.awt.Dimension(500, 300));
        mid.setMaximumSize(new java.awt.Dimension(500, 300));
        mid.setMinimumSize(new java.awt.Dimension(500, 300));

        CustomControl cc = new CustomControl(new java.awt.Dimension(500, 300));
        cc.setBackground(Color.WHITE);
        cc.setPreferredSize(new java.awt.Dimension(300, 300));
        cc.setMaximumSize(new java.awt.Dimension(300, 300));
        cc.setMinimumSize(new java.awt.Dimension(300, 300));
        mid.add(cc);
		frame.getContentPane().add(mid);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setPreferredSize(new java.awt.Dimension(500, 50));
        bottom.setMaximumSize(new java.awt.Dimension(500, 50));
        bottom.setMinimumSize(new java.awt.Dimension(500, 50));

        JButton btnDialog = new JButton("Show Dialog"); //Create Quit button
        btnDialog.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
            	AppSummary as =  new AppSummary(frame, true);
            	as.show();
			}
        });

        JButton btnQuit = new JButton("Quit"); //Create Quit button
        btnQuit.addActionListener(new java.awt.event.ActionListener()
        {
        public void actionPerformed(ActionEvent evt)
        {
        	System.exit(0);
        }
    });
        bottom.add(btnDialog);
        bottom.add(btnQuit);

        frame.getContentPane().add(bottom);
		frame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AppWindow();
	}
}