/**************************************************************************
* Bruno Daki Yamada
* Tibor Zequini Boglar
*
* This java program is able to break the encryption by PhotoMagic.
* 
* Usage:
* java BreakPhotoMagic filename numberOfBits
* Example:
* java BreakPhotoMagic Xwhat.png 9
**************************************************************************/

import java.awt.*;
public class BreakPhotoMagic{
	public static String leadingZero(String sCode, int iPad){ //adds the leading zeroes
		for(int i = sCode.length(); i < iPad; i++)
			sCode = "0".concat(sCode);
		return sCode;
	}

	public static String[] findKey(String sInput, int iBit){
		String sBestKey = "";
		int iBestTap = 0;
		double iBestDif = 0;
		Picture pTmp = new Picture (sInput); 
		for(int j = 0; j < Math.pow(2, iBit); j++){ //test all taps
			for(int i = 0; i < iBit - 1; i++){ //test all keys
				double iRFreq = 0;
				double iGFreq = 0;
				double iBFreq = 0;
				int p = 1;
				LFSR random = new LFSR(leadingZero(Integer.toBinaryString(j), iBit), i);
				for(int k = 0; k < p; k++){
					for(int w = 0; w < pTmp.height(); w++){
						Color pixel = pTmp.get(k, w);
						iRFreq += pixel.getRed() ^ random.generate(8);
						iGFreq += pixel.getGreen() ^ random.generate(8);
						iBFreq += pixel.getBlue() ^ random.generate(8);
					}
				}
				iRFreq = (double)iRFreq/(pTmp.height()*p);
				iGFreq = (double)iGFreq/(pTmp.height()*p);
				iBFreq = (double)iBFreq/(pTmp.height()*p);
				if(Math.abs(((double)(iRFreq+iGFreq+iBFreq)/3) - 128) > iBestDif){
					iBestDif = Math.abs(((double)(iRFreq+iGFreq+iBFreq)/3) - 128);
					sBestKey = leadingZero(Integer.toBinaryString(j), iBit);
					iBestTap = i;
				}
			}
		}
		String[] foo = {sBestKey, Integer.toString(iBestTap)};
		return foo;
	}
	
	public static void main(String[] args){
		String[] sAnswer = findKey(args[0], Integer.parseInt(args[1]));
		StdOut.println("The image has been broken: ");
		StdOut.println("The key is " + leadingZero(sAnswer[0], Integer.parseInt(args[1])));
		StdOut.println("The tap is " + sAnswer[1]);
		PhotoMagic.magic(args[0], leadingZero(sAnswer[0], Integer.parseInt(args[1])), sAnswer[1]).show();
	}
}