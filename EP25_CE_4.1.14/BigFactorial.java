/********************************************************************************
* This program has three different methods to calculate
* the factorial of a integer.
* 
* divideAndFactorial - uses the divide and conquer method
* with regular int to calculate factorial of N. Example:
* BigFactorial.divideAndFactorial(0, 5);
*
* bigDivideAndFactorial - same as divideAndFactorial, but
* with BigInteger java class. Example:
* BigFactorial.bigDivideAndFactorial(BigInteger.ONE, new BigInteger("100000"));
*
* bigRegularFactorial - calculates the factorial of a 
* BigInteger with the obvious method. Example:
* BigFactorial.bigRegularFactorial(new BigInteger("100000"));
*
*********************************************************************************/

import java.math.*; 
public class BigFactorial{
	public static int divideAndFactorial(int iStart, int iEnd){ //uses divide and conquer method to solve factorial using Int
		if(iEnd - iStart == 1) //end of recursion
			return iEnd*iStart;
		if(iEnd == iStart)
			return iStart;
		return divideAndFactorial(iStart, (iEnd+iStart-1)/2) * divideAndFactorial(((iEnd+iStart-1)/2) + 1, iEnd);
	}
	public static BigInteger bigDivideAndFactorial(BigInteger iStart, BigInteger iEnd){
		if(iEnd.subtract(iStart).equals(new BigInteger("1")))
			return iEnd.multiply(iStart);
		if(iEnd.equals(iStart))
			return iStart;
		return bigDivideAndFactorial(iStart, (iEnd.add(iStart).subtract(BigInteger.ONE).divide(new BigInteger("2")))).multiply(
		bigDivideAndFactorial((iEnd.add(iStart).subtract(BigInteger.ONE).divide(new BigInteger("2"))).add(BigInteger.ONE), iEnd));
	}
	public static BigInteger bigRegularFactorial(BigInteger bInt){
		BigInteger bFactorial = BigInteger.ONE;
		for(int i = 1; i <= bInt.intValue(); i++){
			bFactorial = bFactorial.multiply(new BigInteger(Integer.toString(i)));
		}
		return bFactorial;
	}
	
	public static void main(String[] args){
		int iN = Integer.parseInt(args[0]);
		StdOut.println(bigDivideAndFactorial(BigInteger.ONE, new BigInteger(args[0])));
		//StdOut.println(bigRegularFactorial(new BigInteger(args[0])));
	}
}