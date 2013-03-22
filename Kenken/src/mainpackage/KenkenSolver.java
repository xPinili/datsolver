package mainpackage;

/* Algorithm to solve Kenken puzzles
 * Step 1:	Get the input from the player and make sure the input is legit 
 * 			If the input from the player is not legit, have an error msg explain why
 * 			(ex. division can only be used with 2x1 cages)
 * Step 2:	Sort it in a 2d array and list all of the possible numbers using the
 * 			difficulty level in a 2d array string
 * Step 3:	Fill in the 1Box cages (if it exists) since the numbers are given,
 * 			eliminate possible values in vertical and horizontal rows
 * Step 4:  Find VBoxes and HBoxes, 
 */

/*
public class KenkenSolver {
	
	public int[][] solvePuzzle(String[][] currCages, int difficulty) {
		//Step 1 is during the process of solving the puzzle
		
		String[][] possNumbers = new String[difficulty][difficulty];
		int[][] solPuzzle = new int[difficulty][difficulty];
		
		//Step 2 - Create a 2D array with possible numbers
		for (int i = 0; i < difficulty; i++) {
			for (int j = 0; j < difficulty; j++) {
				for (int k = 0; k < difficulty; k++) {
					possNumbers[i][j] = "";
				}
			}
		}

		boolean solved, cannotSolve;
		String lastPossNumbers[][] = new String[difficulty][difficulty];
		int samePuzzle;
		do {
			
			
			
		} while (solved == false && cannotSolve == false);
		
		
		
		
		return solPuzzle;
	}
	
	public static int[][] rem1BoxNum(int[][] possNumbers, int difficulty) {
		
		for (int i = 0; i < difficulty; i++) {
			
		}
		return possNumbers;
	}
	
	
	
	
}
*/