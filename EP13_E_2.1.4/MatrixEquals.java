public class MatrixEquals{
	public static boolean eq(int[] a, int[] b){
		if(a.length != b.length)
			return false;
		for(int i = 0; i < a.length; i++){
			if(a[i] != b[i])
				return false;
		}
		return true;
	}
	public static boolean eqM(int[][] m, int[][] n){
		if(m.length != n.length){ //different amount of lines returns false
			return false;
		}
		for(int i = 0; i < m.length; i++){
			if(!eq(m[i], n[i]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int[][] a = {{0, 0, 0, 0}, {0, 0, 0}};
		int[][] b = {{0, 0, 0, 0}, {0, 0, 0}};
		int[][] c = {{1, 0, 0, 0}, {1, 0, 0}};
		int[][] d = {{0, 0, 0, 0}, {0, 0}};
		int[][] e = {{0, 0, 0, 0}, {0, 0, 0}, {0, 0, 0, 0}};
		StdOut.println("Same matrix = " + eqM(a, b));
		StdOut.println("Same size, different elements = " + eqM(a, c));
		StdOut.println("Same elements, different columm amount = " + eqM(a, d));
		StdOut.println("Same elements, different line amount = " + eqM(a, e));
	}
}