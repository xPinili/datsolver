package mainpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Scanner;


public class Main {
	public static boolean visPuzzle;
	
	public static void main(String[] args) {
		
		
		
		
		//An example of a puzzle in a 3 by 3 format
		/*        0 1 2
		 * 
		 *  0     3 2 1
		 *  1     2 1 3
		 *  2     1 3 2
		 *  
		 *  NOTE: the first integer (i) for the 2D array is the row number,
		 *  the second integer (j) is for the specified number in the row
		 */

		NewJFrame frame = new NewJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(916, 727));
		//frame.setContentPane(new Main());
		
		frame.setVisible(true);
	}
	
	
	/*
	public static String[][] inputProblem(){
		Scanner input = new Scanner(System.in);
		String[][] newCages = new String[difficulty][difficulty];
		
		System.out.println("Enter the difficulty of the puzzle you are about to input: ");
		difficulty = input.nextInt();
		
		System.out.println("How our puzzles are inputted:");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Code for input: [shape][operator][overall value of cell] \n");
		System.out.println("Acceptable Shapes:");
		System.out.println("VBox = Vertical Box (2 Boxes going down)");
		System.out.println("HBox = Horizonal Box (2 Boxes going across)");
		System.out.println("LN = L shape, that is orientated regularly (takes up 3 boxes)");
		System.out.println("LB = L shape, that is orientated backwards (takes up 3 boxes)");
		System.out.println("LNF = L shape, that is orientated regularly and flipped (takes up 3 boxes)");
		System.out.println("LBF = L shape, that is orientated backwards and flipped (takes up 3 boxes)");
		System.out.println("1Box = 1 box\n");
		System.out.println("Acceptable Operators:");
		System.out.println("+ (Addition)");
		System.out.println("- (Subtraction)");
		System.out.println("/ (Division)");
		System.out.println("* (Multiplication)\n");
		System.out.println("Accepted Overall Values:");
		System.out.println("-Has to be the value when all numbers in that cage are calculated with that cages' operator.\n");
		System.out.println("Sample Input: For a 3 by 3 Puzzle:");
		System.out.println("VBox-1 -> VBox+3 -> VBox/3 -> VBox-1 -> VBox+3 -> VBox/3 -> HBox+4 -> HBox+4  -> 1Box2 ");
		System.out.println("--------------------------------------------------------------------------------------------");
		
		for(int i=0; i<(difficulty); i++){
			for(int j=0; j<(difficulty); j++){
				System.out.println("Enter a value for position (" + (i+1) + ", " + (j+1) + "): ");
				newCages[i][j] = input.nextLine();
			}
		}
		input.close();
		
		return newCages;
	}
	*/
	
	
}

	