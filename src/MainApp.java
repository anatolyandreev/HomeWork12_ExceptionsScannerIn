import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

	static String type;
	
	public static String askForTypeOfOperation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter type of operation");
		type = sc.next();
		validateOperationType(type);
		return type;
	}
	
	public static void validateOperationType(String type) {
		if (type.length() > 1) {
			System.out.println("type of operation should consist of 1 character");
			askForTypeOfOperation();
		} else if (!type.equals("+") && !type.equals("-") && !type.equals("/") && !type.equals("*")) {
			System.out.println("type of operation should be one of '+, -, / or *'");
			askForTypeOfOperation();
		}

	}
	
	public static void concatStrings(String s1, String s2, String type) {
		System.out.println("concat value1 & value2 = " + s1 + " " + type + " " + s2);
	}

	public static double executeOperation(String s1, String s2, String type) {
		double n1 = Double.parseDouble(s1);
		double n2 = Double.parseDouble(s2);
		double result = 0;
			switch (type) {
			case "+":
				result = n1 + n2;
				break;
			case "-":
				result = n1 - n2;
				break;
			case "/":
				result = n1 / n2;
				break;
			case "*":
				result = n1 * n2;
				break;
			default:
				break;
			}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter value1");
		String input1 = sc.next();
		System.out.println("enter value2");
		String input2 = sc.next();
		String type = askForTypeOfOperation();

		try {
			Integer.parseInt(input1);
			System.out.println("value1 is integer");
			try {
				Integer.parseInt(input2);
				System.out.println("value2 is integer");
				int tempInt = (int) executeOperation(input1, input2, type); // просто
																			// извращаюсь
																			// переводя
																			// дабл
																			// в
																			// инт
				System.out.println("value1 " + type + " value2 = " + tempInt);
			} catch (NumberFormatException e1) {
				System.out.println("value2 not an integer");
				try {
					Double.parseDouble(input2);
					System.out.println("value2 is double");
					double tempDouble = executeOperation(input1, input2, type);
					System.out.println("value1 " + type + " value2 = " + tempDouble);
				} catch (NumberFormatException e2) {
					System.out.println("value2 is not a double");
					System.out.println("==========");
					concatStrings(input1, input2, type);
				}
			}
		} catch (NumberFormatException e3) {
			System.out.println("value1 not an integer");
			try {
				Double.parseDouble(input1);
				System.out.println("value1 is double");
				try {
					Integer.parseInt(input2);
					System.out.println("value2 is integer");
					double tempDouble = executeOperation(input1, input2, type);
					System.out.println("value1 " + type + " value2 = " + tempDouble);
				} catch (NumberFormatException e1) {
					System.out.println("value2 not an integer");
					try {
						Double.parseDouble(input2);
						System.out.println("value2 is double");
						double tempDouble = executeOperation(input1, input2, type);
						System.out.println("value1 " + type + " value2 = " + tempDouble);
					} catch (NumberFormatException e2) {
						System.out.println("value2 is not a double");
						System.out.println("==========");
						concatStrings(input1, input2, type);
					}
				}
			} catch (NumberFormatException e4) {
				System.out.println("value1 not a double");
				System.out.println("==========");
				concatStrings(input1, input2, type);
			}
		}
	}

}
