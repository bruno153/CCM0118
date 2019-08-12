public class Locker {

    public static void main(String[] args) { 
        boolean locker[] = new boolean[100];
        int i, j;
        for(i = 2; i <= 100; i++){
          for(j = 0; j < 100; j++){
            if((j+1)%i ==  0)
              locker[j] = !locker[j];
          }
        }
        for(j = 0; j < 10; j++){
          for(i = 0; i < 10; i++){
            System.out.print(" ");
            if(j * 10 + i + 1 < 100)
              System.out.print(" ");
            if(j * 10 + i + 1 <10)
              System.out.print(" ");
            System.out.print(j * 10 + i + 1);
          }
          System.out.println();
          for(i = 0; i < 10; i++){
            System.out.print("  ");
            if(locker[j * 10 + i])
              System.out.print("O");
            else
              System.out.print("X");
            System.out.print(" ");
          }
          System.out.println();
        }
        System.out.println("\n Em geral numeros tem um numero de divisores par, no caso somente quadrados perfeitos tem um numero impar de divisores, ja que tem um fator repetido.");
    }
}