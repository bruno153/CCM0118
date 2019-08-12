/**************************************************************
* Counts the greatest number of 9 in a row on a txt file
*
* Example:
* java NumberCounter 1000000.txt
**************************************************************/

public class NumberCounter{
	public static int numSeeker(String sNumber){
		int iCounter = 0;
		int iReturn = 0;
		for(int i = 0; i < sNumber.length(); i++){
			if(sNumber.substring(i, i+1).equals("9")){
				iCounter++;
			}
			else{
				if(iCounter > iReturn)
					iReturn = iCounter;
				iCounter = 0;
			}
		}
		if(iCounter > iReturn)
			iReturn = iCounter;
		return iReturn;
	}
	public static void main(String[] args){
		In in = new In(args[0]);
		String sNumber = in.readAll();
		StdOut.println(numSeeker(sNumber));
	}
}