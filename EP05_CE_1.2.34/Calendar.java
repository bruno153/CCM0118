public class Calendar { 
    public static void main(String[] args) { 
        
      int y = Integer.parseInt(args[1]);
      int m = Integer.parseInt(args[0]);
      boolean isLeapYear;
      int Leap = 0;//isLeapYear em int
      String[] mLib = {"ERROR", "  January", " February", "    March", "    April", "      May", 
        "     June", "     July", "   August", "September", "  October", " November", " December"};
      String[] wLib = {"Su", " M", "Tu", " W", "Th", " F", "Sa"};
      int d;
      int w = 0;

      isLeapYear = (y % 4 == 0); //verifies if it's leap year
      isLeapYear = isLeapYear && (y % 100 != 0);
      isLeapYear = isLeapYear || (y % 400 == 0);
      if(isLeapYear)
        Leap = 1;
      
      if(m == 2) //calculates the amount of days
        d = 28 + Leap;
      else
        d = 31 - (m - 1) % 7 % 2;
      
      int y0 = y - (14 - m) / 12; //calculates the day of the week of the first day
      int x = y0 + y0/4 - y0/100 + y0/400;
      int m0 = m + 12 * ((14 - m) / 12) - 2;
      int d0 = (1 + x + (31*m0)/12) % 7;
      
      System.out.println("   " + mLib[m] + " " + y); //starts the header
      System.out.println("Su  M Tu  W Th  F Sa");
      for(; w < d0; w++) //adds the correct spacing
        System.out.print("   ");
      
      for(int i = 1; i <= d; i++)
      {
        if(i<10)
          System.out.print(" " + i + " ");
        else
          System.out.print(i + " ");
        d0 = d0 + 1;
        if(d0 == 7){
          System.out.println();
          d0=0;
        }
      }
      
    }
}