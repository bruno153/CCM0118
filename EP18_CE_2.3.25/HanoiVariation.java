/********************************************
This program is able to solve the towers of
Hanoi variation, in which odd numbered discs
are placed on the leftmost pin, while the even
numbered discs are placed on the rightmost
pin.

Note that this program does not have the most
efficient solution. As it follows the method:
It first transforms the presented problem by
reducing it to a known problem, the traditional
tower of Hanoi. It is possible by using the
recursive function transform().
After the problem is now simplified, it
uses the function hanoi() to solve it.
It finally transforms the solved tower of
Hanoi by tranforming it back with the
transform() function.

% java HanoiVariation 2
********************************************/


public class HanoiVariation{
  //solves the tradition towers of Hanoi
  public static void hanoi(int n, boolean left){
    if(n == 0)
      return;
    hanoi(n-1, !left);
    if(left)
      StdOut.println(n + " LEFT");
    else
      StdOut.println(n + " RIGHT");
    hanoi(n-1, !left);
  }
  //transforms the variation problem to a known one
  public static void transform(int n, boolean left){
    if(n == 0)
      return;
    transform(n-1, !left);
    hanoi(n, left); //suprisingly, the hanoi function can be used to this end
  }
  //converts the tradition towers of hanoi to the variation back
  public static void untransform(int n, boolean left){
    if(n == 0)
      return;
    hanoi(n, !left);
    untransform(n-1, !left);
  }
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    transform(2*n-1, true);
    hanoi(2*n, false);
    untransform(2*n-1, false);
  }
}
