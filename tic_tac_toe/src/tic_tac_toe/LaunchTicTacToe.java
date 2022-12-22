package tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	public static void displayBoard(char board[][]) {
		for (char y[]:board) {
			for (char c:y) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void insertPosition(char board[][], int position, String playerType) {
		char ch;  
		
		if (playerType.equals("player")) {
			ch = 'X';
		} else {
			ch = 'O';
		}
		
		if (ch == 'X') {
			LaunchTicTacToe.pChoices.add(position);
		} else {
			LaunchTicTacToe.cpuChoices.add(position);
		}
		
		switch(position) {
		case 1:board[0][0] = ch;
		break;
		case 2:board[0][2] = ch;
		break;
		case 3:board[0][4] = ch;
		break;
		case 4:board[2][0] = ch;
		break;
		case 5:board[2][2] = ch;
		break;
		case 6:board[2][4] = ch;
		break;
		case 7:board[4][0] = ch;
		break;
		case 8:board[4][2] = ch;
		break;
		case 9:board[4][4] = ch;
		break;
		
		default:
			System.out.println("Invalid input. Please re-enter the position between 1 - 9.");
		}
	}
	
	static void checkWinner() {
		List<Integer> rule1 = Arrays.asList(1,2,3); 
		List<Integer> rule2 = Arrays.asList(4,5,6); 
		List<Integer> rule3 = Arrays.asList(7,8,9); 
		List<Integer> rule4 = Arrays.asList(1,4,7); 
		List<Integer> rule5 = Arrays.asList(2,5,8); 
		List<Integer> rule6 = Arrays.asList(3,6,9); 
		List<Integer> rule7 = Arrays.asList(1,5,9); 
		List<Integer> rule8 = Arrays.asList(3,5,7); 
		
		if (LaunchTicTacToe.pChoices.containsAll(rule1) || 
			LaunchTicTacToe.pChoices.containsAll(rule2) ||
			LaunchTicTacToe.pChoices.containsAll(rule3) ||
			LaunchTicTacToe.pChoices.containsAll(rule4) ||
			LaunchTicTacToe.pChoices.containsAll(rule5) ||
			LaunchTicTacToe.pChoices.containsAll(rule6) ||
			LaunchTicTacToe.pChoices.containsAll(rule7) ||
			LaunchTicTacToe.pChoices.containsAll(rule8)) {
			System.out.println("User is the Winner!");
			System.exit(0);
		} else if (LaunchTicTacToe.cpuChoices.containsAll(rule1) || 
				LaunchTicTacToe.cpuChoices.containsAll(rule2) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule3) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule4) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule5) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule6) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule7) ||
				LaunchTicTacToe.cpuChoices.containsAll(rule8)) {
				System.out.println("CPU is the Winner!"); 
				System.exit(0);
			} else if (LaunchTicTacToe.pChoices.size() + LaunchTicTacToe.cpuChoices.size() == 9) {
				System.out.println("It's a draw!");
				System.exit(0);
			}
	}
}

public class LaunchTicTacToe {

	static ArrayList<Integer> pChoices = new ArrayList<Integer>();
	static ArrayList<Integer> cpuChoices = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int playerChoice, cpuChoice;
		boolean winner = false; 
		
		
		char board[][] = {
						  {' ', '|', ' ', '|', ' '},
						  {'-', '+', '-', '+', '-'},
						  {' ', '|', ' ', '|', ' '},
						  {'-', '+', '-', '+', '-'},
						  {' ', '|', ' ', '|', ' '},
						};
		
//		char board2[][] = {
//				  {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
//				  {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-','-'},
//				  {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
//				  {'-', '-', '-', '+', '-', '-', '-', '+', '-', '-','-'},
//				  {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
//				};

		while (!winner) {
			TicTacToe.displayBoard(board);
			
			Scanner s = new Scanner(System.in);
			System.out.println("Player, please enter desired position (1 - 9)");
			playerChoice = s.nextInt();
			
			while (pChoices.contains(playerChoice) || cpuChoices.contains(playerChoice)) {
				if (playerChoice > 0 || playerChoice < 10) {
					System.out.println("Position is already taken. Please re-enter your choice:");
					playerChoice = s.nextInt();	
				}
			}
			
			
			TicTacToe.insertPosition(board, playerChoice, "player");
			TicTacToe.displayBoard(board);
			TicTacToe.checkWinner();			
			
			Random rand = new Random();
			
			cpuChoice = rand.nextInt(1,10);
			System.out.println("Cpu has selected position " + cpuChoice);
			
			while (pChoices.contains(cpuChoice) || cpuChoices.contains(cpuChoice)) {
				System.out.println("Position is already taken. Cpu will re-enter their choice: ");
				cpuChoice = rand.nextInt(1,10);
				System.out.println("Cpu has selected position " + cpuChoice);
			}
			
			TicTacToe.insertPosition(board, cpuChoice, "cpu");
			TicTacToe.displayBoard(board);
			TicTacToe.checkWinner();
		}
	}
}


	
