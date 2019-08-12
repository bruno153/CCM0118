/**************************************************************************
* Bruno Daiki Yamada
* Tibor Zequini Boglar
* 
* This program takes a namefile and encripts it by using a binary 
* key from the commandline and a tap integer number.
* 
* Usage: 
* java PhotoMagic filename key tap
* Example:
* java PhotoMagic what.png 100101001 4
**************************************************************************/
import java.awt.Color;
public class PhotoMagic{
	public static Picture magic(String sInput, String sSeed, String sTap){ //the actual encription function
		Picture inPhoto = new Picture(sInput);
		Picture outPhoto = new Picture(inPhoto);
		LFSR random = new LFSR(sSeed, Integer.parseInt(sTap));
		for(int i = 0; i < inPhoto.width(); i++){ //sweeps the whole picture, pixel by pixel
			for(int j = 0; j < inPhoto.height(); j++){
				Color pixel = inPhoto.get(i, j);
				//generates the random number and the encripts by XORing the RGB values
				pixel = new Color(pixel.getRed() ^ random.generate(8), pixel.getGreen() ^ random.generate(8), pixel.getBlue() ^ random.generate(8)); 
				outPhoto.set(i, j, pixel);
			}
		}
		return outPhoto;
	}
	public static Picture breakMagic(String sInput, String sSeed, String sTap){
		Picture inPhoto = new Picture(sInput);
		Picture outPhoto = new Picture(1, inPhoto.height());
		LFSR random = new LFSR(sSeed, Integer.parseInt(sTap));
		for(int i = 0; i < 1; i++){ //sweeps the first line, pixel by pixel
			for(int j = 0; j < inPhoto.height(); j++){
				Color pixel = inPhoto.get(i, j);
				//generates the random number and the encripts by XORing the RGB values
				pixel = new Color(pixel.getRed() ^ random.generate(8), pixel.getGreen() ^ random.generate(8), pixel.getBlue() ^ random.generate(8)); 
				outPhoto.set(i, j, pixel);
			}
		}
		return outPhoto;
	}
	public static void main(String[] args){
		Picture photo = magic(args[0], args[1], args[2]);
		photo.save("X".concat(args[0])); //saves the result in a different file
		photo.show();
	}
}