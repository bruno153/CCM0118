/*********************************************************************************
/ Receives two arguments in command-line: 
/ -first is the limit in x axis in PI
/ -second is the sample amount
/ This program uses the fourth order fourier series for square wave function
*********************************************************************************/
public class SquareFourier{
	public static void main(String[] args){
		double fMax = Math.PI * Double.parseDouble(args[0]);
		int iSample = Integer.parseInt(args[1]);
		double f = 1;
		for(int i = 0; i < iSample; i++){
			double x = ((4/Math.PI) * (Math.sin(2 * Math.PI * f * fMax/iSample * i) + Math.sin(6 * Math.PI * f * fMax/iSample * i)/3 + Math.sin(10 * Math.PI * f * fMax/iSample * i)/5 + Math.sin(14 * Math.PI * fMax/iSample * i)/7) * 0.4) + 0.5;
			StdOut.println(x);
		}
	}
}