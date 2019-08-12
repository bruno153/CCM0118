/********************************************************
* Reads a 1D array from StdIn, which is a sequence
* from 1 to N, with a missing number and a repeated one.
* Using ArraySweeperTester.java is recommended.
*
* Example:
* java ArraySweeperTester 100 42 30 | java ArraySweeper
**********************************************************/

public class ArraySweeper2{
	public static void main(String[] args){
		int[] iArray = StdArrayIO.readInt1D();
		for(int i = 0; i < iArray.length; i++){
			if(iArray[Math.abs(iArray[i]) - 1] > 0){ //sees if the number has already been read
				iArray[Math.abs(iArray[i]) - 1] = -iArray[Math.abs(iArray[i]) - 1]; //marks the index with a negative number
			}
			else{
				StdOut.println("The repeated number is " + (Math.abs(iArray[i]))); //if the number has already been seen, it's repeated
			}
		}
		for(int i = 0; i < iArray.length; i++){ //a index with a positive integer indicates that the number is missing
			if(iArray[i] > 0)
				StdOut.println("The missing number is " + (i+1));
		}
	}
}