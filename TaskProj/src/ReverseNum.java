
public class ReverseNum {

	public static void main(String arg[]) {
		int num = -2123456781;
		System.out.println(reverseNum(num));
		num = 1234;
		System.out.println(reverseNum(num));
		//num = Integer.MIN_VALUE;//Illegal argument
		System.out.println(reverseNum(num));
		//num = -2123456789;//Illegal argument
		System.out.println(reverseNum(num));
	}

	private static int reverseNum(int num) throws IllegalArgumentException {
		boolean sign = false;
		long result = 0;
		int resultInInt = 0;
		if(num < 0) {
			sign = true;
			num = - num;
		}
		while(num != 0) {
			result = result * 10;
			result = result + num % 10;
			num = num / 10;
		}
		if(sign) {
			result = - result;
		} 
		if(result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
			resultInInt = (int)result;
		} else {
			throw new IllegalArgumentException();
		}
		return resultInInt;
	}
}
