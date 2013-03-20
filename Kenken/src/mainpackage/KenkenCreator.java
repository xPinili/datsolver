package mainpackage;

//import java.util.ArrayList;
import java.util.Random;


public class KenkenCreator {
	public static int difficulty;
	public static Random rand = new Random();
	
	public static void main(String[] args){
		difficulty = 6;
		int[][] kenken = new int[difficulty][difficulty];
		String[][] cages = new String[difficulty][difficulty];
		
		
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
		
		kenken = createPuzzle(kenken); //creates a new puzzle
		
		
		
		//displays solution in console
		for (int i = 0; i < difficulty; i++) {
			for (int j = 0; j < difficulty; j++) {
				System.out.print(kenken[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
		
		cages = createCages(kenken, 4); //creates the random cages for the puzzle

		System.out.println();
		for (int i = 0; i < difficulty; i++) {
			for (int j = 0; j < difficulty; j++) {
				System.out.print(cages[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	//----------------------------------------------------------------------------
	/* Algorithm for creating a (unique) random solution for a Kenken puzzle
	 * Step 1: Create a unique row which has unique numbers already in place
	 * Step 2: Check if the current row is conflicting with another row in the puzzle
	 * Step 3: If the current row is being conflicted, use a new unique row
	 */
	public static int[][] createPuzzle(int[][] curPuzzle) {
		boolean conflictRow = false;
		int temp[]; //creates a temporary row
		
		for(int i = 0; i < difficulty; i++) {
			do {
				conflictRow = false;
				temp = createRow();
				for(int j = 0; j < i; j++) {
					for (int checkX = 0; checkX < difficulty; checkX++) {
						//Step 2 - Check if the current row is conflicting
						if (curPuzzle[j][checkX] == temp[checkX])
							//Step 3 (if needed) - Use a new unique row
							conflictRow = true;
					}
				}
			} while(conflictRow == true);
			curPuzzle[i] = temp;
		}
		return curPuzzle;
	}
	
	//Step 1 - Create a unique row with unique numbers
	public static int[] createRow() {
		int[] newUniqueRow = new int[difficulty];
		boolean conflict = false; //checks if there is a conflicting number
		int temp; //creates a temporary number
		
		for(int j = 0; j < difficulty; j++) {
			do { //creates a new number if there is a conflicting number
				conflict = false;
				temp = 1 + rand.nextInt(difficulty); //generates a random number
				for (int chkRow = 0; chkRow < j; chkRow++) {
					if (newUniqueRow[chkRow] == temp)  //checks if any number is conflicting with the temp number
						conflict = true;
				}
			} while (conflict == true); //loops if there is a conflicting number
			newUniqueRow[j] = temp;
		}
		return newUniqueRow;
	}
	//----------------------------------------------------------------------------
	
	
	
	
	//----------------------------------------------------------------------------
	/* Algorithm for creating random cages
	 * Step 1: Generate the shape of the cages
	 * Step 2: Use a random operator for each cage (make sure division is ONLY used when it produces an integer and use it for only 2x1 cages)
	 * Step 3: Get the number produced from the operator
	 * Step 4: Place the String Code for all currCages
	 */
	public static String[][] createCages(int[][] curPuzzle, int numOfOper) {
		String[][] currCages = new String[difficulty][difficulty]; //Keeps track of the type of cage for each cell
		int[][] connCells = new int[difficulty][difficulty]; //Keeps track of what cells are connected to represent a cage
		
		int currCageNum = 0;
		//int numOfCages = (int)(((difficulty * difficulty) / 2) - ((Math.random() * difficulty) - (int)(difficulty / 2))); //Creates a random number of cages corresponding to the difficulty
		//System.out.println(numOfCages);
		
		
		/* String Code for the cages double array:
		 * 
		 * Sample: L+12
		 * 
		 * 12 - Number that should be produced by the operator with all numbers in cage
		 * + - operator to be applied to all numbers in a cage
		 * L - shape of the cage (All types of shapes: HBox, VBox, BBox, 1Box, LN (Normal L), LB (Backwards L), LNF (Normal L, Flipped), LBF (Backwards L, Flipped)
		 */
		
		
		
		
		//Step 1 - Generating a random shapes for the specified coordinate
		for (int i = 0; i < difficulty; i++) {
			for (int j = 0; j < difficulty; j++) {
		
				//for (int intCage = 1; intCage <= numOfCages; intCage++) { //the cage it is currently shaping
				
					/* index for the type of shape:
					 * 0 - VBox (2 Boxes)
					 * 1 - HBox (2 Boxes)
					 * 2 - BBox (4 Boxes)
					 * 3 - LN (Normal L)				 (3 Boxes)
					 * 4 - LB (Backwards L)				 (3 Boxes)
					 * 5 - LNF (Normal L, Flipped)		 (3 Boxes)
					 * 6 - LBF (Backwards L, Flipped)	 (3 Boxes)
					 * 7* - 1Box (NOTE: to be generated last when there is no space for any other shape) 
					 */
				
					if (connCells[i][j] == 0) { //checks if entering a shape in the specified coordinate is possible
						
						//integers retrieved from the shape and produce a number corresponding to the operator (used later in Step 3)
						int a = 0, b[] = new int[7], c[] = new int[4], d = 0, z = 0; 
						a = curPuzzle[i][j]; //a is the current coordinate number from the solution
						String oper = "+"; //operator stored in a string (used later in Step 3)
						
						
						//Step 1 - Generates a random shape (if possible, otherwise 1Box) to the specified coordinate
						//checks if its possible to enter a shape there, otherwise the shape will be skipped
						boolean possShapes[] = new boolean[7];
						currCageNum++; //increments the current cage it is working on
						if(i + 1 < difficulty) {
							if(connCells[i+1][j] == 0) { //VBox
								possShapes[0] = true;
								b[0] = curPuzzle[i+1][j];
							}
						}
						if (j + 1 < difficulty) {
							if(connCells[i][j+1] == 0) { //HBox
								possShapes[1] = true;
								b[1] = curPuzzle[i][j+1];
							}
						}
						if ((i + 1) < difficulty && (j + 1) < difficulty) {
							if(connCells[i][j+1] == 0 && connCells[i+1][j] == 0 && connCells[i+1][j+1] == 0) { //BBox
								possShapes[2] = true;
								b[2] = curPuzzle[i][j+1];
								c[0] = curPuzzle[i+1][j];
								d = curPuzzle[i+1][j+1];
								System.err.println("I DID IT " + i + " " + j);
							} else if(connCells[i+1][j+1] == 0 && connCells[i+1][j] == 0) { //LN (L)
								possShapes[3] = true;
								b[3] = curPuzzle[i][j+1];
								c[1] = curPuzzle[i+1][j];
								
								
							} else if(connCells[i+1][j] == 0 && connCells[i][j+1] == 0) { //LNF (T)
								possShapes[5] = true;
								b[5] = curPuzzle[i+1][j];
								c[3] = curPuzzle[i][j+1];
							} else if(connCells[i][j+1] == 0 && connCells[i+1][j+1] == 0) { //LBF (7)
								possShapes[6] = true;
								b[6] = curPuzzle[i][j+1];
								c[4] = curPuzzle[i+1][j+1];
							}
						}
						if ((i + 1) < difficulty && (j - 1) >= 0) {
							if(connCells[i+1][j] == 0 && connCells[i+1][j-1] == 0) { //LB (J)
								possShapes[4] = true;
								b[4] = curPuzzle[i+1][j];
								c[2] = curPuzzle[i+1][j-1];
							}
						}
						
						//checks if there is any shape that is possible in that coordinate, otherwise do a 1Box
						boolean anyPossShape = false;
						for(boolean possShape : possShapes) {
							if (possShape == true)
								anyPossShape = true;
						}

						int genShape = 0;
						if (anyPossShape == true) {
							do {
								genShape = rand.nextInt(7); //picks a random shape to do
							} while (possShapes[genShape] == false); //only if that shape is possible
						//System.err.println(genShape);
						} else {
							genShape = 7; //do a 1Box
						}
						
						
						
						//Step 2 - Picks an operation for the shape
						int intOper;
						
						if ((genShape == 0 || genShape == 1) && numOfOper >= 3) { //currCages is a 2x1 box and the numOfOper = 4 and x / y = an integer
							//Does a random operation from add, multiply, and subtract, ONLY if division (if numOfOper = 4) does NOT produce an integer
							intOper = rand.nextInt(3);
							
							//Checks if an integer is produced when divided
							if (numOfOper == 4) {
								double x = 0, y;
								if (genShape == 0) //VBox
									x = curPuzzle[i+1][j];
								else if (genShape == 1) //HBox
									x = curPuzzle[i][j+1];
								y = curPuzzle[i][j];


								if(x%y==0) //it is an integer
									intOper = rand.nextInt(numOfOper); //gets a random operator from one of the 4 operators (+ * - /)
							}
						} else {
							intOper = rand.nextInt(2); //this excludes division and subtraction from being used for the cage
						}
						
						if (intOper == 0)
							oper = "+";
						else if (intOper == 1)
							oper = "*";
						else if (intOper == 2)
							oper = "-";
						else if (intOper == 3)
							oper = "/";
						

						
						//Step 3 - Get the number produced from the operator
						connCells[i][j] = currCageNum; //makes the current cage, from the coordinates, the current cage number
						
						if (genShape == 0) { //VBox
							if (intOper == 0) { //add
								z = a + b[0];
							} else if(intOper == 1) { //multiply
								z = a * b[0];
							} else if(intOper == 2) { //subtract
								z = a - b[0];
								if (z < 0)
									z = z * -1;
							} else if(intOper == 3) { //divide
								if (a > b[0])
									z = a / b[0];
								else
									z = b[0] / a;
							}
							currCages[i][j] = "VBox" + oper + "" + z;
							currCages[i+1][j] = "VBox" + oper + "" + z;
							connCells[i+1][j] = currCageNum;
						} else if(genShape == 1) { //HBox
							if (intOper == 0) { //add
								z = a + b[1];
							} else if(intOper == 1) { //multiply
								z = a * b[1];
							} else if(intOper == 2) { //subtract
								z = a - b[1];
								if (z < 0)
									z = z * -1;
							} else if(intOper == 3) { //divide
								if (a > b[1])
									z = a / b[1];
								else
									z = b[1] / a;
							}
							currCages[i][j] = "HBox" + oper + "" + z;
							currCages[i][j+1] = "HBox" + oper + "" + z;
							connCells[i][j+1] = currCageNum;
						} else if(genShape == 2) { //BBox
							if (intOper == 0) { //add
								z = a + b[2] + c[0] + d;
							} else if(intOper == 1) { //multiply
								z = a * b[2] * c[0] * d;
							}
							currCages[i][j] = "BBox" + oper + "" + z;
							currCages[i+1][j] = "BBox" + oper + "" + z;;
							currCages[i][j+1] = "BBox" + oper + "" + z;;
							currCages[i+1][j+1] = "BBox" + oper + "" + z;
							connCells[i][j+1] = currCageNum;
							connCells[i+1][j] = currCageNum;
							connCells[i+1][j+1] = currCageNum;
						} else if(genShape == 3) { //LN
							if (intOper == 0) { //add
								z = a + b[3] + c[1];
							} else if(intOper == 1) { //multiply
								z = a * b[3] * c[1];
							}
							currCages[i][j] = "LN" + oper + "" + z;
							currCages[i+1][j] = "LN" + oper + "" + z;
							currCages[i+1][j+1] = "LN" + oper + "" + z;
							connCells[i+1][j] = currCageNum;
							connCells[i+1][j+1] = currCageNum;
						} else if(genShape == 4) { //LB
							if (intOper == 0) { //add
								z = a + b[4] + c[2];
							} else if(intOper == 1) { //multiply
								z = a * b[4] * c[2];
							}
							currCages[i][j] = "LB" + oper + "" + z;
							currCages[i+1][j] = "LB" + oper + "" + z;
							currCages[i+1][j-1] = "LB" + oper + "" + z;
							connCells[i+1][j] = currCageNum;
							connCells[i+1][j-1] = currCageNum;
						} else if(genShape == 5) { //LNF
							if (intOper == 0) { //add
								z = a + b[5] + c[3];
							} else if(intOper == 1) { //multiply
								z = a * b[5] * c[3];
							}
							currCages[i][j] = "LNF" + oper + "" + z;
							currCages[i][j+1] = "LNF" + oper + "" + z;
							currCages[i+1][j] = "LNF" + oper + "" + z;
							connCells[i][j+1] = currCageNum;
							connCells[i+1][j] = currCageNum;
						} else if(genShape == 6) { //LBF
							if (intOper == 0) { //add
								z = a + b[6] + c[4];
							} else if(intOper == 1) { //multiply
								z = a * b[6] * c[4];
							}
							currCages[i][j] = "LBF" + oper + "" + z;
							currCages[i][j+1] = "LBF" + oper + "" + z;
							currCages[i+1][j+1] = "LBF" + oper + "" + z;
							connCells[i][j+1] = currCageNum;
							connCells[i+1][j+1] = currCageNum;
						} else if(genShape == 7) { //1Box
							z = a;
							currCages[i][j] = "1Box" + z;
						}
					}
				//}
			}
		}
		return currCages;
	}
	
	
	
}