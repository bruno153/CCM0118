/****************************************
*
* Generates sequence of integers
* from 1 to N, with a repeated integer
* and a missing integer defined by the
* user. It is also shuffled ranomly
*
* Example: 
* java ArraysweeperTester 10 3 2
* 
*****************************************/

public class ArraySweeperTester{
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int gone = Integer.parseInt(args[1]);
		int twice = Integer.parseInt(args[2]);
		int[] array = new int[n];
		
		for(int i = 0; i < n; i++){
			if(i+1 != gone)
				array[i] = i+1;
			else
				array[i] = twice;
		}
		StdRandom.shuffle(array);
		StdArrayIO.print(array);
	}
}