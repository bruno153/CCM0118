public class RandomFour {
    public static void main(String[] args) {
      if(args.length==0){
        System.out.println("Insira o tamanho da matriz como entrada do console.");
        //System.exit(0);
      }
      int n = Integer.parseInt(args[0]);
      System.out.println("String[][] board = new String[][]{");
      for(int i = 0; i<n; i++){
        System.out.print("{");
        for(int j = 0; j<n; j++){
          double random = Math.random()*3;
          if(random<1){
            System.out.print("\"O\"");
          }
          else
            if(random<2){
            System.out.print("\"X\"");
          }
          else {
           System.out.print("\" \"");
          }
          if(j==n-1){
            System.out.print("}");
          }
          else{
            System.out.print(", ");
          }
        }
        if(!(i==n-1)){
          System.out.print(",");
        }
        System.out.println();
      }
      System.out.println("};");
    }
}