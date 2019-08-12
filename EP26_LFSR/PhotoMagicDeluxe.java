/**************************************************************************
* Bruno Daiki Yamada
* Tibor Zequini Boglar
* 
* This program takes a namefile and encripts it by using a alphanumeric
* key from the commandline and a tap integer number.
*
* Usage: 
* java PhotoMagicDeluxe filename key tap
* Example:
* java PhotoMagicDeluxe pipe.png turma25 10
**************************************************************************/
import java.awt.*;
public class PhotoMagicDeluxe{
	public static int toInt(String sSub){ //executes the 64-bit encoding
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(sSub);
	}
	public static String leadingZero(String sCode){ //adds the leading zeroes
		for(int i = sCode.length(); i < 6; i++)
			sCode = "0".concat(sCode);
		return sCode;
	}
	public static void main(String[] args){
		String sKey = "";
		for(int i = 0; i < args[1].length(); i++) //keybuilder
			sKey = leadingZero(Integer.toBinaryString(toInt(args[1].substring(i, i+1)))).concat(sKey);
		Picture photo = PhotoMagic.magic(args[0], sKey, args[2]); //calls PhotoMagic
		photo.save("X".concat(args[0])); 
		photo.show();
	}
}