package game;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
private	List<Integer> digits;

	public Coordinate(int num){
		digits = new ArrayList<Integer>();
		while (num > 0) {
			digits.add(num % 10);
			num /= 10;

		     }
		 }

	public Integer getX(){
		String numStr = concatDigits(digits.get(3), digits.get(2));
		return Integer.parseInt(numStr);
	}

	public Integer getY(){
		String numStr = concatDigits(digits.get(1), digits.get(0));
		return Integer.parseInt(numStr);
	}


	public static String concatDigits(int... digit) {
		   StringBuilder sb = new StringBuilder(digit.length);
		   for (int dig : digit) {
		     sb.append(dig);
		   }
		   return sb.toString();
		}
}

