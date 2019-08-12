/******************************************************************************
 *  Compilation:  javac CompareAllGenome.java
 *  Execution:    java CompareAllGenome 5 < genomes.txt
 *
 ******************************************************************************/

 public class CompareAllGenome{

    private static String filename(String f) {
	int s = f.lastIndexOf('/');
	String filename = f.substring(s + 1);
	return filename;
    }
    
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int N = StdIn.readInt();
        Genoma[] a = new Genoma[N];

        // read in documents
        for (int i = 0; i < N; i++) {
            a[i] = new Genoma(StdIn.readString(), k);
        }

        // print header
        System.out.print("    ");
        for (int j = 0; j < N; j++) 
            System.out.printf("    %.4s", filename(a[j].name()));

        System.out.println();

        // print N-by-N table
        for (int i = 0; i < N; i++) {
            System.out.printf("%.4s", filename(a[i].name()));
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.2f", a[i].compare(a[j]));
            }
            System.out.println();
        }
    }
}