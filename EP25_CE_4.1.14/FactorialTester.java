/*************************************************************
* This program takes the N integer from the command line and
* prints a table of execution time for both algorithms
* from 0 to 2eN.
*
* Execution example:
* java FactorialTester 19
*************************************************************/


import java.math.*; 
public class FactorialTester{
	public static void main(String[] args){
		Stopwatch time = new Stopwatch();
		double iLasttime = 0;
		System.out.println("N     FastAlg.   ObviousAlg.");
		for(int i = 0; i < Integer.parseInt(args[0]); i++){
			System.out.print("2e" + i + " ");
			iLasttime = time.elapsedTime();
			BigFactorial.bigDivideAndFactorial(BigInteger.ONE, new BigInteger(Integer.toString((int)Math.pow(2, i))));
			System.out.printf("%8.2f", (time.elapsedTime() - iLasttime));
			System.out.print(" ");
			iLasttime = time.elapsedTime();
			BigFactorial.bigRegularFactorial(new BigInteger(Integer.toString((int)Math.pow(2, i))));
			System.out.printf("%8.2f", (time.elapsedTime() - iLasttime));
			System.out.println();
		}
	}
}