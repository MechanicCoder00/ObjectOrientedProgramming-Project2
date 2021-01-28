//****Project 2****
//
//Author: Scott Tabaka
//Instructor: Steve Riegerix
//Class: CMPSCI 2700(Fall 2018)
//Due Date: September 23, 2018

package connect4game;

import java.util.Scanner;

public class Connect4 
{
	static Scanner userInput = new Scanner(System.in);
	
	public static void clearScreen()
	{  
		for (int i = 0; i < 50; ++i) 
		{	
			System.out.println();
		}
	}  

	public static void displayBoard(char[][] ar1)
	{
		clearScreen();
		
		System.out.println("|0|1|2|3|4|5|6|");
		System.out.print("---------------");
		
		for(int row=0; row<ar1.length;row++)
		{
			System.out.println();
			for(int column=0;column<ar1[row].length;column++)
			{
				System.out.print("|");
				System.out.print(ar1[row][column]);
					if(column == (ar1[row].length - 1))
					{
						System.out.print("|");
					}
			}
		}
		System.out.print("\n---------------\n\n");
	}
	
	public static void clearGameBoard(char[][] ar1,int[] discTrackerArray)
	{
		for(int i=0;i<7;i++)
		{
		discTrackerArray[i] = 5;
		}
		
		for(int row=0; row<ar1.length;row++)
		{
			for(int column=0;column<ar1[row].length;column++)
			{
				ar1[row][column] = ' ';
			}
		}
	}
	
	public static void PlayerRedInput(char[][] gameBoardArray,int[] discTrackerArray)
	{
		int choice = 0;
		boolean repeatloop = true;
		
		while(repeatloop == true)
		{
			repeatloop = false;
					
			System.out.print("Drop a Red disk at column (0-6): ");
			choice = userInput.nextInt();			
	
			if (choice >= 0 && choice <= 6)
			{
				if(discTrackerArray[choice] >= 0)
				{
				gameBoardArray[discTrackerArray[choice]][choice] = 'R';
				discTrackerArray[choice] -= 1;
				displayBoard(gameBoardArray);
				}
				else
				{
					displayBoard(gameBoardArray);
					System.out.print("That column is full, please select an empty column.\n\n");
					repeatloop = true;
				}
			}
			else
			{
				repeatloop = true;
				displayBoard(gameBoardArray);
				System.out.print("Please try again.  ");
			}
		}
	}
	
	public static void PlayerYellowInput(char[][] gameBoardArray,int[] discTrackerArray)
	{
		int choice = 0;
		boolean repeatloop = true;

		while(repeatloop == true)
		{
			repeatloop = false;	
			System.out.print("Drop a Yellow disk at column (0-6): ");
			choice = userInput.nextInt();			
	
			if (choice >= 0 && choice <= 6)
			{
				if(discTrackerArray[choice] >= 0)
				{
				gameBoardArray[discTrackerArray[choice]][choice] = 'Y';
				discTrackerArray[choice] -= 1;
				displayBoard(gameBoardArray);
				}
				else
				{
					displayBoard(gameBoardArray);
					System.out.print("That column is full, please select an empty column.\n\n");
					repeatloop = true;
				}
			}
			else
			{
				repeatloop = true;
				displayBoard(gameBoardArray);
				System.out.print("Please try again.  ");
			}	
		}
	}

	public static boolean winCheckRed(char[][] gameBoardArrayRedCheck)
	{
		boolean breakOut = false;
		
		for(int i = 0; i < 4;i++)
		{
			for(int j = 0; j < 6;j++)
				if(gameBoardArrayRedCheck[j][i] == 'R' && gameBoardArrayRedCheck[j][i+1] == 'R' && gameBoardArrayRedCheck[j][i+2] == 'R' && gameBoardArrayRedCheck[j][i+3] == 'R')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 7;i++)
		{
			for(int j = 0; j < 3;j++)
				if(gameBoardArrayRedCheck[j][i] == 'R' && gameBoardArrayRedCheck[j+1][i] == 'R' && gameBoardArrayRedCheck[j+2][i] == 'R' && gameBoardArrayRedCheck[j+3][i] == 'R')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 4;i++)
		{
			for(int j = 0; j < 3;j++)
				if(gameBoardArrayRedCheck[j][i] == 'R' && gameBoardArrayRedCheck[j+1][i+1] == 'R' && gameBoardArrayRedCheck[j+2][i+2] == 'R' && gameBoardArrayRedCheck[j+3][i+3] == 'R')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 4;i++)
		{
			for(int j = 3; j < 6;j++)
				if(gameBoardArrayRedCheck[j][i] == 'R' && gameBoardArrayRedCheck[j-1][i+1] == 'R' && gameBoardArrayRedCheck[j-2][i+2] == 'R' && gameBoardArrayRedCheck[j-3][i+3] == 'R')
				{
				breakOut = true;
				}
		}
		return breakOut;
	}
	
	public static boolean winCheckYellow(char[][] gameBoardArrayYellowCheck)
	{
		boolean breakOut = false;
		
		for(int i = 0; i < 4;i++)
		{
			for(int j = 0; j < 6;j++)
				if(gameBoardArrayYellowCheck[j][i] == 'Y' && gameBoardArrayYellowCheck[j][i+1] == 'Y' && gameBoardArrayYellowCheck[j][i+2] == 'Y' && gameBoardArrayYellowCheck[j][i+3] == 'Y')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 7;i++)
		{
			for(int j = 0; j < 3;j++)
				if(gameBoardArrayYellowCheck[j][i] == 'Y' && gameBoardArrayYellowCheck[j+1][i] == 'Y' && gameBoardArrayYellowCheck[j+2][i] == 'Y' && gameBoardArrayYellowCheck[j+3][i] == 'Y')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 4;i++)
		{
			for(int j = 0; j < 3;j++)
				if(gameBoardArrayYellowCheck[j][i] == 'Y' && gameBoardArrayYellowCheck[j+1][i+1] == 'Y' && gameBoardArrayYellowCheck[j+2][i+2] == 'Y' && gameBoardArrayYellowCheck[j+3][i+3] == 'Y')
				{
				breakOut = true;
				}
		}
		for(int i = 0; i < 4;i++)
		{
			for(int j = 3; j < 6;j++)
				if(gameBoardArrayYellowCheck[j][i] == 'Y' && gameBoardArrayYellowCheck[j-1][i+1] == 'Y' && gameBoardArrayYellowCheck[j-2][i+2] == 'Y' && gameBoardArrayYellowCheck[j-3][i+3] == 'Y')
				{
				breakOut = true;
				}
		}
		return breakOut;
	}
	
	public static boolean keepPlaying()
	{
		char choice = 0;
		boolean repeatloop = true;
		boolean playercontinuechoice = false;
		
		while(repeatloop == true)
		{
			repeatloop = false;
			
			System.out.print("\n\nWould you like to play again?(y/n)");
			choice = userInput.next().charAt(0);
			
			if (choice == 'y' || choice == 'Y')
			{
				playercontinuechoice = true;
			}
			else if (choice == 'n' || choice == 'N')
			{
				playercontinuechoice = false;
			}
			else
			{
				repeatloop = true;
			}
		}
		return playercontinuechoice;
	}
	
	
	public static void main(String[] args) 
	{
		
		Boolean keepPlaying = true;
		Boolean breakOutOfGameLoop = false;
		int[] columnCountArray = {5,5,5,5,5,5,5};
		char[][] gameBoardArray = 
			{
				{' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' '},
				{' ',' ',' ',' ',' ',' ',' '}
			};
		
		while(keepPlaying == true)
		{
			clearGameBoard(gameBoardArray,columnCountArray);
			displayBoard(gameBoardArray);
			breakOutOfGameLoop = false;
			
			for(int i = 0;i < 21;i++)
			{
				
				PlayerRedInput(gameBoardArray,columnCountArray);
				breakOutOfGameLoop = winCheckRed(gameBoardArray);
				
				if(breakOutOfGameLoop)
				{
					System.out.print("\nRed Wins.");
					break;
				}
				
				PlayerYellowInput(gameBoardArray,columnCountArray);	
				breakOutOfGameLoop = winCheckYellow(gameBoardArray);
				
				if(breakOutOfGameLoop)
				{
					System.out.print("\nYellow Wins.");
					break;
				}
				
				if(i == 20)
				{
					System.out.print("\nThe match is a draw.");
				}
			}
			keepPlaying = keepPlaying();
		}	
		
		System.out.print("\nThanks for playing!");
		userInput.close();
	}
}
