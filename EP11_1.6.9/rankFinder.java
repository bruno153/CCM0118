public class rankFinder{
	public static void main(String[] args){
		//receives number of pages and number of the page to find the position
		int pages = Integer.parseInt(args[0]);
		int find = Integer.parseInt(args[1]);
		int rank = 0;
		double[] m = new double[pages];
		for(int i = 0; i < pages; i++){
			m[i] = StdIn.readDouble();
		}
		for(; pages>0; pages --){
			if(m[pages-1]>=m[find]){
				rank++;
			}
		}
		StdOut.print("O ranking da pagina " + find + " e' " + rank);
	}
}
