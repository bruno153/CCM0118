
public class FirstMinima {
    public static void main(String[] args) {
      int size;
      int number = Integer.parseInt(args[0]);
      int tmp = 0;
      int minima = 1;

      //find the vector size
      for(size = 0; Math.pow(10, size) <= number; size++){

      }

      //vectorize the input
      int[] vector = new int[size];
      int[] permutation = new int[size];
      for(int i = 0; i < size; i++){
        vector[i] = number % 10;
        number /= 10;
      }

      //permute the vector
      for(int i = 0; i < size; i++){
        int rnd = (int) (Math.random()*(i+1));
        tmp = vector[i];
        vector[i] = vector[rnd];
        vector[rnd] = tmp;
      }

      //prints the vector
      System.out.print("Permutation = ");
      for(int i = 0; i < size; i++){
        System.out.print(vector[i]);
      }
      System.out.println();

      //calculates the minima
      tmp = vector[0];
      for(int i = 1 ; i<size; i++){
        if(tmp > vector[i]){
          tmp = vector[i];
          minima++;
        }
      }
      //print minima
      System.out.println("Minima = " + minima);

    }
}
