
public class FinalMinima {
    public static void main(String[] args) {
      int permutation = Integer.parseInt(args[0]);
      int size = Integer.parseInt(args [1]);
      int number = Integer.parseInt(args[0]);
      int[] vector = new int[size];
      int tmp = 0;
      int minima = 1;
      double mean = 0;

      //create the vector
      for(int i = 0; i < size; i++){
        vector[i] = i;
      }

      //begins the testing
      for(int i = 0; i < permutation; i++){
        //permute the vector
        for(int j = 0; j < size; j++){
          int rnd = (int) (Math.random()*(j+1));
          tmp = vector[j];
          vector[j] = vector[rnd];
          vector[rnd] = tmp;
        }
        //find minima
        tmp = vector[0];
        for(int j = 1 ; j<size; j++){
          if(tmp > vector[j]){
            tmp = vector[j];
            minima++;
          }
        }
        mean += minima;
        minima = 1;
      }
      //calculates the mean
      mean /= permutation;

      //print mean
      System.out.println("Media das minimas = " + mean);

    }
}
//Como podemos perceber, para valores pequenos (1~4), a media da minima das sequencias sobe rapidamente
//e passa a crescer menos para valores maiores, uma caracteristica comum em funcoes logaritmicas.
//Uma analise mais cuidadosa com ferramentas graficas presume que a expressao do valor da media
//das minimas em funcao do N seria: f(N) = 0.87 * ln(N) + 0.91.
