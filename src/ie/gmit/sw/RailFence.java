package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RailFence
{
	//***** Encrypt a String called cypherText using an integer key *****
	public String encrypt(String cypherText, int key)
	{
		//Declare a 2D array of key rows and text length columns
		char[][] matrix = new char[key][cypherText.length()]; //The array is filled with chars with initial values of zero, i.e. '0'.

		//Fill the array
		int row = 0; //Used to keep track of rows
		boolean down = true; //Used to zigzag
		for (int i = 0; i < cypherText.length(); i++)
		{ //Loop over the plaintext
			matrix[row][i] = cypherText.charAt(i); //Add the next character in the plaintext to the array

			if (down){ //If we are moving down the array
				row++;
				if (row == matrix.length)
				{ //Reached the bottom
					row = matrix.length - 2; //Move to the row above
					down = false; //Switch to moving up
				}
			}
			else
			{ //We are moving up the array
				row--;

				if (row == -1){ //Reached the top
					row = 1; //Move to the first row
					down = true; //Switch to moving down
				}
			}
		}

		printMatrix(matrix); //Output the matrix

		//Extract the cypher text
		StringBuffer sb = new StringBuffer(); //A string buffer allows a string to be built efficiently
		for (row = 0; row < matrix.length; row++)
		{ //Loop over each row in the matrix
			for (int col = 0; col < matrix[row].length; col++)
			{ //Loop over each column in the matrix
				if (matrix[row][col] > '0') sb.append(matrix[row][col]); //Extract the character at the row/col position if it's not 0.
			}
		}

		return sb.toString(); //Convert the StringBuffer into a String and return it
	}

	//***** Decrypt a String cypherText using an integer key *****
	public String decrypt(String cypherText, int key)
	{
		//Declare a 2D array of key rows and text length columns
		char[][] matrix = new char[key][cypherText.length()]; //The array is filled with chars with initial values of zero, i.e. '0'.

		//Fill the array
		int targetRow = 0;
		int index = 0;
		do{
			int row = 0; //Used to keep track of rows
			boolean down = true; //Used to zigzag
			for (int i = 0; i < cypherText.length(); i++)
			{ //Loop over the plaintext
				if (row == targetRow){
					matrix[row][i] = cypherText.charAt(index); //Add the next character in the plaintext to the array
					index++;
			}

				if (down)
				{ //If we are moving down the array
					row++;
					if (row == matrix.length){ //Reached the bottom
						row = matrix.length - 2; //Move to the row above
						down = false; //Switch to moving up
				}
				}
				else
				{ //We are moving up the array
					row--;

					if (row == -1)
					{ //Reached the top
						row = 1; //Move to the first row
						down = true; //Switch to moving down
					}
				}
			}

			targetRow++;
		}
		while (targetRow < matrix.length);

		printMatrix(matrix); //Output the matrix

		//Extract the cypher text
		StringBuffer sb = new StringBuffer(); //A string buffer allows a string to be built efficiently
		int row = 0;
		boolean down = true; //Used to zigzag
		for (int col = 0; col < matrix[row].length; col++)
		{ //Loop over each column in the matrix
			sb.append(matrix[row][col]); //Extract the character at the row/col position if it's not 0.

			if (down)
			{ //If we are moving down the array
				row++;
				if (row == matrix.length)
				{ //Reached the bottom
					row = matrix.length - 2; //Move to the row above
					down = false; //Switch to moving up
			    }
			}
			else
			{ //We are moving up the array
				row--;

				if (row == -1)
				{ //Reached the top
					row = 1; //Move to the first row
					down = true; //Switch to moving down
				}
			}

		}

		return sb.toString(); //Convert the StringBuffer into a String and return it
	}

	//***** Output the 2D array in CSV format *****
	private void printMatrix(char[][] matrix)
	{
		for (int row = 0; row < matrix.length; row++){ //Loop over each row in the matrix
			for (int col = 0; col < matrix[row].length; col++)
			{ //Loop over each column in the matrix
				System.out.print(matrix[row][col]); //Output the value at row/column index
				if (col < matrix[row].length - 1) System.out.print(",");
			}
			System.out.println();
		}
	}

	//Now I read the contents of a file and output it
	public static void main(String[] args) throws Exception
	{



		try
		{
			Scanner user_input1 = new Scanner( System.in );
			String choice;
			System.out.println("Enter a choice: \n 1. For user input "
													+ "\n 2. To enter a file name"
													+ "\n 3. To read from 4grams.txt");
			choice = user_input1.next();

			if(choice.equals("1"))
			{
				Scanner enterText = new Scanner(System.in);

				RapidEncryption user = new RapidEncryption();
				System.out.print("Type a message to encode: ");
				String msg = enterText.nextLine();
				user.dumpGrid();
				System.out.println("Message you wanted to Encode: " + msg);
				String inputText = new RailFence(). encrypt(msg, 5);
				System.out.println("   Coded: " + inputText);
				String inputText1 = new RailFence(). decrypt(inputText, 5);
				System.out.println(" Decoded: " + inputText1);
			}
			else if(choice.equals("2"))
			{
			File cypherfile = new File("ShieldsAndSwords.txt"); // creates the file object
			Scanner user_input2 = new Scanner( System.in );
			String file_name;
			System.out.println("Enter a File name (Case Sensitive) ");
			file_name = user_input2.next();

			if(file_name.equals("ShieldsAndSwords.txt"))
			{
				System.out.println("File Name is " + file_name);

			//Applies Railfence
			Scanner scanFile = new Scanner(cypherfile);
			while (scanFile.hasNextLine())
			{
				String cypherText = scanFile.nextLine();

				String RailFence = new RailFence(). decrypt(cypherText, 5);
				System.out.println(RailFence);
		    }
			scanFile.close();
		}
			else
			{
				System.out.println("File Name is incorrect, Enter a correct one ");
			}
		}


		else if(choice.equals("3"))
				{
				String s = new RailFence().decrypt("TTFOHATGRNREEANOETYRCIMHHAKT", 5);
				System.out.println(">" + s);
				}
		else{
			System.out.println("Incorrect Command! Please try again!");
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		}
}
