public class BenfordGenerator{
  public static int randomInt(int x){ //generates a random integer number [0,x[
    return (int)(Math.random()*x);
  }
  public static int leadingDigit(int x){
    while(x >= 10){
      x /= 10;
    }
    return x;
  }
  public static void main(String[] args){
    int iAmount = Integer.parseInt(args[0]);
    int iTmp;
    int iBnfrd = 0;
    double fRnd;
    double[] dProb = new double[9];

    //aquires the probabilities from BenfordProb.java
    for(int i = 0; i < 9; i++)
      dProb[i] = StdIn.readDouble()/100;
    //adjust the probablities to use on the else if conditionals
    for(int i = 0; i < 8; i++){
      dProb[i+1] += dProb[i];
    }
    //start printing the random values
    for(int i = 0; i < iAmount; i++){
      fRnd = Math.random(); //raffles the leading number
      if(fRnd < dProb[0])
        iBnfrd = 1;
      else if(fRnd < dProb[1])
        iBnfrd = 2;
      else if(fRnd < dProb[2])
        iBnfrd = 3;
      else if(fRnd < dProb[3])
        iBnfrd = 4;
      else if(fRnd < dProb[4])
        iBnfrd = 5;
      else if(fRnd < dProb[5])
        iBnfrd = 6;
      else if(fRnd < dProb[6])
        iBnfrd = 7;
      else if(fRnd < dProb[7])
        iBnfrd = 8;
      else if(fRnd < 1)
        iBnfrd = 9;

      //raffles a random number
      iTmp = randomInt(1001);
      //reroll if the random number is not adequate
      while(leadingDigit(iTmp) != iBnfrd)
        iTmp = randomInt(1001);
      StdOut.println(iTmp);
    }
  }
}
