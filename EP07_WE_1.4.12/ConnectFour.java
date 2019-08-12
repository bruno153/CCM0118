public class ConnectFour { 
    public static void main(String[] args) { 
String[][] board = new String[][]{
{"X", "O", "X", "O", "X", "X", " ", " ", "X", "X"},
{"O", "X", " ", "X", " ", "X", "X", " ", "O", "X"},
{"X", "O", " ", "X", "X", " ", " ", "X", "X", " "},
{"O", "O", "O", "X", "O", "X", " ", "X", " ", "X"},
{"O", "O", "O", "O", " ", "X", "O", "O", "X", " "},
{"X", " ", " ", "O", " ", " ", "X", "X", "X", "O"},
{"O", " ", " ", "O", " ", "O", "X", "O", " ", "O"},
{"O", "O", " ", "X", "X", "X", "X", "O", "X", "O"},
{" ", "O", "X", " ", "X", "O", "O", "O", "X", "X"},
{"O", "O", "X", "X", " ", " ", "X", "X", " ", "X"}
};
   int max = 0;
   int tmpmax = 0;
   int n = Integer.parseInt(args[0]);
   //checks for lines
   for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
     if(board[i][j].equals(new String("X"))){
      tmpmax++;
     }
     else{
      if(tmpmax > max){
      max = tmpmax;
      }
      tmpmax = 0;
     }
    }
    if(tmpmax > max){
   max = tmpmax;
    }
    tmpmax = 0;
   }
   //checks for collums
   for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
     if(board[j][i].equals(new String("X"))){
      tmpmax++;
     }
     else{
      if(tmpmax > max){
      max = tmpmax;
      }
      tmpmax = 0;
     }
    }
    if(tmpmax > max){
   max = tmpmax;
    }
    tmpmax = 0;
   }
   //checks for NW-SE diagonals
   for(int i = n-1; i >= 0; i--){
    for(int j = 0; i + j < n; j++){
     if(board[j][i+j].equals(new String("X"))){
      tmpmax++;
     }
     else{
      if(tmpmax > max){
       max = tmpmax;
      }
      tmpmax = 0;
     }
    }
    if(tmpmax > max){
     max = tmpmax;
    }
    tmpmax = 0;
   }
   for(int i = 1; i < n; i++){
    for(int j = 0; i + j < n; j++){
     if(board[i+j][j].equals(new String("X")))
      tmpmax++;
     else{
      if(tmpmax > max)
       max = tmpmax;
      tmpmax = 0;
     }
    }
    if(tmpmax > max)
     max = tmpmax;
    tmpmax = 0;
   }
   //checks for NE-SW diagonals IT DOESNT WORK
   for(int i = 0; i < n; i++){
    for(int j = 0; j <= i; j++){
     if(board[j][i-j].equals(new String("X"))){
      tmpmax++;
     }
     else{
      if(tmpmax > max){
       max = tmpmax;
      }
      tmpmax = 0;
     }
    }
    if(tmpmax > max){
     max = tmpmax;
    }
    tmpmax = 0;
   }
   for(int i = 1; i < n; i++){
    for(int j = 0; i+j < n; j++){
     if(board[i+j][n-1+-j].equals(new String("X")))
      tmpmax++;
     else{
      if(tmpmax > max)
       max = tmpmax;
      tmpmax = 0;
     }
    }
    if(tmpmax > max)
     max = tmpmax;
    tmpmax = 0;
   }
  
   System.out.println(max);
    }
}