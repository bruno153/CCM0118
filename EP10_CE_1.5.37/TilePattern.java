public class TilePattern { 
    public static void main(String[] args) {
		/***********************************************************************************
		* Tres tipos diferentes de padroes (0-2)                                           *
		* Tres cores diferentes: 0 - Tons de cinza, 1 - Tons de azul, 2 - Tons de vermelho *
		************************************************************************************/
		int size = Integer.parseInt(args[0]);
		int patt = Integer.parseInt(args[1]);
		int colr = Integer.parseInt(args[2]);
		
		if(patt==0){
			if(colr==1)
				StdDraw.setPenColor(StdDraw.BLUE);
			if(colr==2)
				StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledSquare(0.5, 0.5, 0.5);
			StdDraw.setXscale(0, size);
			StdDraw.setYscale(0, size);
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.filledPolygon(new double[]{0.25+i, 1+i, 0.75+i, 0+i}, new double[]{0+j, 0.75+j, 1+j, 0.25+j});
					StdDraw.filledPolygon(new double[]{0.75+i, 1+i, 0.25+i, 0+i}, new double[]{0+j, 0.25+j, 1+j, 0.75+j});
					
					if(colr==0)
						StdDraw.setPenColor(StdDraw.GRAY);
					if(colr==1)
						StdDraw.setPenColor(StdDraw.CYAN);
					if(colr==2)
						StdDraw.setPenColor(StdDraw.PINK);
					StdDraw.filledPolygon(new double[]{(double)1/2+i, 1+i, 0.5+i, 0+i}, new double[]{0+j, 0.5+j, 1+j, 0.5+j});
					
					StdDraw.filledPolygon(new double[]{0+i, 0.25+i, 0.25+i, 0+i}, new double[]{0+j, 0+j, 0.25+j, 0.25+j});
					StdDraw.filledPolygon(new double[]{0.75+i, 1+i, 1+i, 0.75+i}, new double[]{0+j, 0+j, 0.25+j, 0.25+j});
					StdDraw.filledPolygon(new double[]{0.75+i, 1+i, 1+i, 0.75+i}, new double[]{0.75+j, 0.75+j, 1+j, 1+j});
					StdDraw.filledPolygon(new double[]{0+i, 0.25+i, 0.25+i, 0+i}, new double[]{0.75+j, 0.75+j, 1+j, 1+j});
				}
			}
		}
		
		if(patt==1){ //pattern 2
			if(colr==1)
				StdDraw.setPenColor(StdDraw.BLUE);
			if(colr==2)
				StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledSquare(0.5, 0.5, 0.5);
			StdDraw.setXscale(0, size);
			StdDraw.setYscale(0, size);
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					if(j%2==0 && i%2==0 || j%2==1 && i%2==1){ //only prints the pattern if both i and j have the same parity
						
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledPolygon(new double[]{0.25+i, 1+i, 0.75+i, 0+i}, new double[]{0+j, 0.75+j, 1+j, 0.25+j});
						StdDraw.filledPolygon(new double[]{0.75+i, 1+i, 0.25+i, 0+i}, new double[]{0+j, 0.25+j, 1+j, 0.75+j});
						if(colr==0)
							StdDraw.setPenColor(StdDraw.GRAY);
						if(colr==1)
							StdDraw.setPenColor(StdDraw.CYAN);
						if(colr==2)
							StdDraw.setPenColor(StdDraw.PINK);
						
						StdDraw.filledPolygon(new double[]{(double)1/2+i, 1+i, 0.5+i, 0+i}, new double[]{0+j, 0.5+j, 1+j, 0.5+j});
					}
				}
			}
		}
		
		if(patt==2){ //pattern 4
			if(colr==1)
				StdDraw.setPenColor(StdDraw.BLUE);
			if(colr==2)
				StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledSquare(0.5, 0.5, 0.5);
			StdDraw.setXscale(0, size);
			StdDraw.setYscale(0, size);
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					if(j%2==0 && i%2==0 || j%2==1 && i%2==1){ //only prints the pattern if both i and j have the same parity
						
						if(colr==0)
							StdDraw.setPenColor(StdDraw.GRAY);
						if(colr==1)
							StdDraw.setPenColor(StdDraw.CYAN);
						if(colr==2)
							StdDraw.setPenColor(StdDraw.PINK);
						StdDraw.filledPolygon(new double[]{0.5+i, 1+i, 0.5+i, 0+i}, new double[]{0+j, 0.5+j, 1+j, 0.5+j});
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledPolygon(new double[]{0.25+i, 0.25+i, 0+i}, new double[]{0+j, 0.25+j, 0.25+j});
						StdDraw.filledPolygon(new double[]{0.75+i, 0.75+i, 1+i}, new double[]{0+j, 0.25+j, 0.25+j});
						StdDraw.filledPolygon(new double[]{0.75+i, 0.75+i, 1+i}, new double[]{0.75+j, 1+j, 0.75+j});
						StdDraw.filledPolygon(new double[]{0+i, 0.25+i, 0.25+i}, new double[]{0.75+j, 0.75+j, 1+j});
					}
					else{
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.filledPolygon(new double[]{0.5+i, 1+i, 0.5+i, 0+i}, new double[]{0+j, 0.5+j, 1+j, 0.5+j});
						if(colr==0)
							StdDraw.setPenColor(StdDraw.GRAY);
						if(colr==1)
							StdDraw.setPenColor(StdDraw.CYAN);
						if(colr==2)
							StdDraw.setPenColor(StdDraw.PINK);
						StdDraw.filledPolygon(new double[]{0.25+i, 0.25+i, 0+i}, new double[]{0+j, 0.25+j, 0.25+j});
						StdDraw.filledPolygon(new double[]{0.75+i, 0.75+i, 1+i}, new double[]{0+j, 0.25+j, 0.25+j});
						StdDraw.filledPolygon(new double[]{0.75+i, 0.75+i, 1+i}, new double[]{0.75+j, 1+j, 0.75+j});
						StdDraw.filledPolygon(new double[]{0+i, 0.25+i, 0.25+i}, new double[]{0.75+j, 0.75+j, 1+j});
					}
				}
			}
		}
    }
}