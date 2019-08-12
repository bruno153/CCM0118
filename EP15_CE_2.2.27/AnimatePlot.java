/**********************************************
/ This program animates the plot of a function
/ using bargraph.
/ Receives a integer on the command-line, which
/ is the number of data to be read.
/ The second integer defines the mode:
/ 0 - for bargraph
/ 1 - for linegraph
/ Recommended use:
/ java SquareFourier 0.5 1000 | java AnimatePlot 1000 1
**********************************************/ 
public class AnimatePlot{
	public static double[] shiftArray(double[] dArray, double dAdd, int iOrder, int iSize){
		//this function left-shifts the position of the first iOrder elements from left to right, 
		//and also adds the double value on the leftmost position 
		for(; iOrder > 0; iOrder--){ //shifts the elements
			dArray[iSize - 1 - iOrder] = dArray[iSize - iOrder];
		}
		dArray[iSize-1] = dAdd; //add the double value
		return dArray;
	}
	public static void main(String[] args){
		//data aquisition
		int iM = Integer.parseInt(args[0]);
		int iMode = Integer.parseInt(args[1]);
		double[] dData = new double[iM];
		
		for(int i = 0; i < iM; i++){
			dData = shiftArray(dData, StdIn.readDouble(), i, iM); //shifts the array and add the value
			if(iMode ==0)
				StdStats.plotBars(dData);                         //plot the graph with bars
			else
				StdStats.plotLines(dData);                        //plot the graph with line
			StdDraw.show(1);
			StdDraw.clear();
		}
		
	}
}