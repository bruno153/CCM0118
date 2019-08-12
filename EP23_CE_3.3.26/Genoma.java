/******************************************************************************
  *  Compilacao  javac Genoma.java
  *  Ha tres opcoes de execucao:
  *  1. % java Genoma 1 gene1 gene2 iGram
  *     Devolve a similaridade entre duas sequencias genomicas com 
  *     k-gramas de tamanho i-Gram
  * 
  *  2. % java Genoma 2 gene
  *     Devolve um inteiro correspondente à codificacao da sequencia genomica 
  *     em base-4
  * 
  *  3. % java Genoma 3 gene(int)
  *     Devolve a sequencia genomica de um inteiro codificado
  *
  *  Obs: todas as entradas devem ser em formato txt ou similar
  ******************************************************************************/
public class Genoma{
    private final String id;
    private Vector iProfile;
    
    public Genoma(String sName, int iGram){ // similar to Document.java
        id = sName;
        In in = new In(sName);
        String sNucleotide = in.readAll();
        int N = sNucleotide.length();
        iProfile = generateProfile(sNucleotide, iGram, N);}
    
    public static int hash(String sCodon){
        char[] cCodon = sCodon.toCharArray();
        int iCodon = 0;
        int tmp;
        //convert the char array into a base-4 number
        for(int i = 0; i < cCodon.length; i++){
            if(cCodon[i] == 'C' || cCodon[i] == 'c')
                iCodon += Math.pow(10, cCodon.length - i - 1);
            if(cCodon[i] == 'G' || cCodon[i] == 'g')
                iCodon += 2 * Math.pow(10, cCodon.length - i - 1);
            if(cCodon[i] == 'T' || cCodon[i] == 't')
                iCodon += 3 * Math.pow(10, cCodon.length - i - 1);}
        //convert the base-4 number into a base-10 number
        tmp = iCodon;
        iCodon = 0;
        for(int i = 0; tmp != 0; i++, tmp /= 10){
            iCodon += (tmp%10) * Math.pow(4, i);}
        
        return iCodon;}
    
    public static String unhash(int nCodon){
		if(nCodon == 0){ //if the hash number is 0, returns A
			return "A";
		}
		String sCodon = "";
        // convert the base-10 number into a base-4 number
        for(; nCodon > 0; nCodon /= 4){
			int tmp = nCodon%4;
			if(tmp == 0)
				sCodon = sCodon.concat("A");
			if(tmp == 1)
				sCodon = sCodon.concat("C");
			if(tmp == 2)
				sCodon = sCodon.concat("G");
			if(tmp == 3)
				sCodon = sCodon.concat("T");
		}
		return sCodon;
	}
    
    public static Vector generateProfile(String sNucleotide, int iGram, int N){
        int len = N;
        double[] iProfile = new double[(int)Math.pow(4, iGram)];
        for(int i = 0; i <= len-iGram; i++){
            int tmp = hash(sNucleotide.substring(i, i + iGram));
            iProfile[tmp] += 1;}
        return new Vector(iProfile).direction();}
    
    public double compare(Genoma gene){
        return iProfile.dot(gene.iProfile);}
    
    public String name(){
        return id;}
    
    public static void main (String[] args){
        int opcao = Integer.parseInt(args[0]); // opcao: profile (1), hash (2) ou unhash (3)
        if (opcao == 1 || args.length > 2){
            String name1 = args[1]; // gene 1
            String name2 = args[2]; // gene 2
            int i = Integer.parseInt(args[3]); // i-gram
            Genoma gene1 = new Genoma (name1, i);
            Genoma gene2 = new Genoma (name2, i);
            StdOut.println("Similarity = " + gene1.compare(gene2));}
        
        else if (opcao == 2){
            String name = args[1]; // gene
            In in = new In(name);
            String sCodon = in.readAll();
            int hashCodon = hash(sCodon);
            StdOut.println("Hashed Codon = " + hashCodon);}
        
        else if (opcao == 3){
            StdOut.println("Unhashed Codon = " + unhash(Integer.parseInt(args[1])));
		}
	}
}