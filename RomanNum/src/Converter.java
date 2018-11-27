import java.util.Scanner;
public class Converter {
	public static int convertRequest(String str) {
		char[] userIn = str.toUpperCase().toCharArray(); //taking string and turning it into roman symbols
		int decimal = 0; // what we will be returning at the end
		int lastNum = 0; // to keep track of the last number checked
		for (int i = userIn.length - 1; i >= 0; i--) {
			switch(userIn[i]) {
			case 'M':
				decimal = decimalProc(1000, lastNum, decimal);
				lastNum = 1000;
				break;
			case 'D':
				decimal = decimalProc(500, lastNum, decimal);
				lastNum = 500;
				break;
			case 'C':
				decimal = decimalProc(100, lastNum, decimal);
				lastNum = 100;
				break;
			case 'L':
				decimal = decimalProc(50, lastNum, decimal);
				lastNum = 50;
				break;
			case 'X':
				decimal = decimalProc(10, lastNum, decimal);
				lastNum = 10;
				break;
			case 'V':
				decimal = decimalProc(5, lastNum, decimal);
				lastNum = 5;
				break;
			case 'I':
				decimal = decimalProc(1, lastNum, decimal);
				lastNum = 1;
				break;
			}
		}
		return decimal;
	}
	public static int decimalProc(int decimal, int lastNum, int lastDecimal) {
		if (lastNum > decimal) {
			return lastDecimal - decimal;
		}
		else {
			return lastDecimal + decimal;
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your Roman Numerials");
		String userIn = kb.nextLine();
		System.out.println(Converter.convertRequest(userIn));
		kb.close();
	}
}