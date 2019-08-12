/******************************************************
* MazeGenerator is a java program designed to generate
* a grid based perfect maze with recursive function.
* It receives the size of grid on the command line and
* draws the maze with StdDraw.
*
* The following example generates a 100x100 grid based 
* maze.
*
* %java Mazegenerator 30 50
*
* Bruno Daiki Yamada e Henrique D'Ambrosio Retti
*
******************************************************/
import java.awt.Dimension;
import java.awt.Toolkit;

public class MazeGenerator{
	public static void Generate(int iMinX, int iMinY, int iMaxX, int iMaxY){
		//stopping point
		if(iMaxX-iMinX==1 || iMaxY-iMinY==1)
			return;
		//chooses the random coordinate and draws the perpendicular lines
		int iRndX = StdRandom.uniform(iMinX+1, iMaxX);
		int iRndY = StdRandom.uniform(iMinY+1, iMaxY);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(iMinX, iRndY, iMaxX, iRndY);
		StdDraw.line(iRndX, iMinY, iRndX, iMaxY);
		//starts making holes
		StdDraw.setPenColor(StdDraw.WHITE);
		//chooses which wall will be intact
		int iRnd = StdRandom.uniform(0, 4);
		if(iRnd != 0){
			int iTmp = StdRandom.uniform(iMinX, iRndX);
			StdDraw.line(iTmp+0.1, iRndY, iTmp+1-0.1, iRndY);
		}
		if(iRnd != 1){
			int iTmp = StdRandom.uniform(iRndX, iMaxX);
			StdDraw.line(iTmp+0.1, iRndY, iTmp+1-0.1, iRndY);
		}
		if(iRnd != 2){
			int iTmp = StdRandom.uniform(iMinY, iRndY);
			StdDraw.line(iRndX, iTmp+0.1, iRndX, iTmp+1-0.1);
		}
		if(iRnd != 3){
			int iTmp = StdRandom.uniform(iRndY, iMaxY);
			StdDraw.line(iRndX, iTmp+0.1, iRndX, iTmp+1-0.1);
		}
		//recursive calls
		Generate(iMinX, iMinY, iRndX, iRndY);
		Generate(iMinX, iRndY, iRndX, iMaxY);
		Generate(iRndX, iMinY, iMaxX, iRndY);
		Generate(iRndX, iRndY, iMaxX, iMaxY);
	}
	public static void main(String[] args){
		//data aquisition
		int iSizeX = Integer.parseInt(args[0]);
		int iSizeY = Integer.parseInt(args[1]);

		//scales the window
		StdDraw.setCanvasSize(15*iSizeX, 15*iSizeY);
		StdDraw.setXscale(0, iSizeX);
		StdDraw.setYscale(0, iSizeY);
		StdOut.println(iSizeX*15 + " " + iSizeY*15);
		//draw maze
		StdDraw.polygon(new double[]{2*StdDraw.getPenRadius(), iSizeX-2*StdDraw.getPenRadius(), iSizeX-2*StdDraw.getPenRadius(), 2*StdDraw.getPenRadius()}, new double[]{2*StdDraw.getPenRadius(), 2*StdDraw.getPenRadius(), iSizeY-2*StdDraw.getPenRadius(), iSizeY-2*StdDraw.getPenRadius()});
		Generate(0, 0, iSizeX, iSizeY);
	}
}