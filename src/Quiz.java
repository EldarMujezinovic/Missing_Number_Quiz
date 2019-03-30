import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {
	static Scanner input = new Scanner(System.in);
	static ArrayList<String> correctAnswers = new ArrayList<>();
	static ArrayList<String> incorrectAnswers = new ArrayList<>();
	static int numberOfPointsOnLevel = 0;
	static int numberOfPoints = 0;
	static String userInput = null;
	static int userChoose;
	static boolean easyExecuted = false;
	static boolean mediumExecuted = false;
	static boolean hardExecuted = false;
	static boolean isValid = true;
	static String nickname = null;

	public static void main(String[] args) {
		createNewUser();
		menu();

	}

	public static void menu() throws InputMismatchException {
		System.out.println("******************************************\n");
		System.out.println("\t   WELCOME TO MY QUIZ\n");
		System.out.println("******************************************\n");
		System.out.println("Choose the difficulty level:\n" + "1. Easy\n" + "2. Medium\n" + "3. Hard\n"
				+ "******************************************\n\nMORE OPTIONS\n\n4. Create new user\n"
				+ "5. Print all users\n6. User details");
		System.out.println("0. EXIT");
		int i = -1;
		do {
			try {
				userChoose = input.nextInt();
				if (userChoose != 1 && userChoose != 2 && userChoose != 3 && userChoose != 4 && userChoose != 5
						&& userChoose != 6 && userChoose != 0) {
					throw new InputMismatchException();
				} else {
					i = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Wrong input, try again!");
			}
			input.nextLine();
		} while (i != 0);

		switch (userChoose) {

		case 0:
			System.exit(0);
			break;
		case 1:
			if (!easyExecuted)
				easy();
			else
				System.out.println("You have already played on this level!");
			break;

		case 2:
			if (!mediumExecuted)
				medium();
			else
				System.out.print("You have already played on this level!");
			break;

		case 4:
			createNewUser();
			menu();

			break;
		case 5:
			printAllUsers();
			break;

		case 6:
			userDetails(numberOfPoints);
			break;
		}

	}

	public static void userDetails(int score) {
		User user = new User();
		System.out.println("Please choose one of these: ");
		user.printAllUsers();
		String nick = input.next();
		if (user.userIsValid(nick)) {
			user.printUserDetails(nick);
		}
		menu();
	}

	public static void printAllUsers() {
		User user = new User();
		user.printAllUsers();
		menu();
	}

	public static void createNewUser() {
		boolean valid = true;
		easyExecuted = false;
		mediumExecuted = false;
		numberOfPoints = 0;
		System.out.println("Please enter your nickname: ");
		nickname = input.next();
		while (valid) {
			if (!User.userIsValid(nickname)) {
				User user = new User(nickname, numberOfPoints);
				valid = false;
			} else {
				System.out.println("Try another nickname: ");
				nickname = input.next();
			}
		}

	}

	public static void easy() {
		User user = new User();
		correctAnswers.clear();
		incorrectAnswers.clear();
		numberOfPointsOnLevel = 0;
		System.out.println("\n******************************************\n");
		System.out.println("You have choosed Easy level!");
		System.out.println("1. Find the missing number: \n" + "[26] [28] [31] [35] [?]\n" + "A. 39\n" + "B. 40\n"
				+ "C. 41\n" + "D. 42\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		char answer = ' ';
		char correctAnswer = 'B';
		int i = -1;
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("1. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;

			} else {
				incorrectAnswers.add("1. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("2. Find the missing number:\n" + "[3] [5] [8] [13] [?]\n" + "A. 16\n" + "B. 21\n"
				+ "C. 25\n" + "D. 26\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("2. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;

			} else {
				incorrectAnswers.add("2. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("3. Find the missing number:\n");
		char[][] charArray = { { '7', '3', '6', '2' }, { '2', '8', '5', '4' }, { '1', '1', '2', '4' },
				{ '4', '2', '1', '?' } };

		for (i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray.length; j++) {
				System.out.print("[" + charArray[i][j] + "]" + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("A. 1\n" + "B. 5\n" + "C. 4\n" + "D. 7\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;

		correctAnswer = 'C';
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("3. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("3. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("4. Find the missing number:\n" + "[2] [7] [14] [23] [?] [47]\n" + "A. 28\n" + "B. 31\n"
				+ "C. 34\n" + "D. 38\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == 'C') {
				correctAnswers.add("4. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;

			} else {
				incorrectAnswers.add("4. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("5. Find the missing number:\n" + "[4] [6] [12] [14] [28] [30] [?]\n" + "A. 32\n" + "B. 64\n"
				+ "C. 62\n" + "D. 60\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;
		correctAnswer = 'D';
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("5. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("5. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}
		switch (correctAnswers.size()) {

		case 0:
			numberOfPointsOnLevel = 0;
			break;
		case 1:
			numberOfPointsOnLevel = 10;
			break;
		case 2:
			numberOfPointsOnLevel = 20;
			break;
		case 3:
			numberOfPointsOnLevel = 30;
			break;
		case 4:
			numberOfPointsOnLevel = 40;
			break;
		case 5:
			numberOfPointsOnLevel = 50;
			break;

		default:
			System.out.println("Erorr.");

		}

		System.out.println("**** You got it to the end! ****");
		System.out.println("You got " + correctAnswers.size() + " correct answers and " + incorrectAnswers.size()
				+ " incorrect answers.");
		System.out.println("POINTS ON THIS LEVEL: " + numberOfPointsOnLevel);
		user.printScore(numberOfPoints);
		System.out.println("CORRECT ANSWERS: ");
		for (i = 0; i < correctAnswers.size(); i++) {
			System.out.println(correctAnswers.get(i));
		}
		System.out.println("INCORRECT ANSWERS: ");
		for (i = 0; i < incorrectAnswers.size(); i++) {
			System.out.println(incorrectAnswers.get(i));
		}
		System.out.println("\n******************************************");
		easyExecuted = true;
		User.increaseUserScore(nickname, numberOfPointsOnLevel);
		menu();
		input.close();
	}

	public static void medium() {
		User user = new User();
		correctAnswers.clear();
		incorrectAnswers.clear();
		numberOfPointsOnLevel = 0;
		System.out.println("\n******************************************\n");
		System.out.println("You have choosed Medium level!");
		char answer = ' ';
		char correctAnswer = ' ';
		int i = -1;
		System.out.println("1. Find the missing number:\n");
		String[][] intArray = { { "6", "8", "7" }, { "36", "64", "49" }, { "24", "48", "35" }, { "12", "24", "?" } };

		for (i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray.length - 1; j++) {
				if (intArray[i][j] == intArray[0][1] || intArray[i][j] == intArray[0][2]) {
					System.out.print(" ");
				}
				System.out.print("[" + intArray[i][j] + "]" + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("A. 17.5\n" + "B. 17\n" + "C. 18\n" + "D. 21\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;

		correctAnswer = 'A';
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("1. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("1. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("2. Find the missing number:\n");
		int red = 4;
		int num = 1;
		int brojac = 1;
		for (i = 1; i <= red; i++) {
			for (int j = 1; j <= i; j++) {
				brojac++;
				if (i == 4) {
					System.out.print("[" + num + "]" + " [?]");
					break;
				}
				System.out.print("[" + num + "]" + " ");
				num = (int) Math.pow(brojac, 2);
			}
			System.out.println();
		}
		System.out.println("A. 64\n" + "B. 81\n" + "C. 57\n" + "D. 100\n");
		System.out.println("Enter your answer(A, B, C, D): ");

		userInput = input.next();
		i = -1;
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("2. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("2. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("3. Find the missing number:\n");
		char[][] charArray = { { '2', '8', '9' }, { '3', '2', '4' }, { '3', '6', '?' } };

		for (i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray.length; j++) {
				System.out.print("[" + charArray[i][j] + "]" + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("A. 11\n" + "B. 5\n" + "C. 1\n" + "D. 8\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;

		correctAnswer = 'C';
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("3. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("3. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("4. Find the missing number:\n" + "[195] [383] [575] [763] [955] [?]\n" + "A. 936\n"
				+ "B. 1078\n" + "C. 1143\n" + "D. 1245\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == 'C') {
				correctAnswers.add("4. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("4. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		System.out.println("5. Find the missing number:");

		char[][] charArray2 = { { '1', '2', '3' }, { '2', '1', '6' }, { '3', '4', '?' } };

		for (i = 0; i < charArray2.length; i++) {
			for (int j = 0; j < charArray2.length; j++) {
				System.out.print("[" + charArray2[i][j] + "]" + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("A. 4\n" + "B. 5\n" + "C. 3\n" + "D. 6\n");
		System.out.println("Enter your answer(A, B, C, D): ");
		userInput = input.next();
		i = -1;

		correctAnswer = 'C';
		while (i != 0) {
			answer = userInput.charAt(0);
			if (userInput.length() > 1) {
				System.out.println("Please enter only one character(A, B, C or D)");
				userInput = input.next();
			} else if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
				System.out.println("Please enter one of the offered answers(A, B, C, D)");
				userInput = input.next();
			} else if (answer == correctAnswer) {
				correctAnswers.add("3. " + correctAnswer);
				numberOfPoints += 10;
				i = 0;
			} else {
				incorrectAnswers.add("5. " + correctAnswer + " (correct answer) - You answered: " + answer);
				i = 0;
			}
		}

		switch (correctAnswers.size()) {

		case 0:
			numberOfPointsOnLevel = 0;
			break;
		case 1:
			numberOfPointsOnLevel = 10;
			break;
		case 2:
			numberOfPointsOnLevel = 20;
			break;
		case 3:
			numberOfPointsOnLevel = 30;
			break;
		case 4:
			numberOfPointsOnLevel = 40;
			break;
		case 5:
			numberOfPointsOnLevel = 50;
			break;

		default:
			System.out.println("Erorr.");

		}

		System.out.println("**** You got it to the end! ****");
		System.out.println("You got " + correctAnswers.size() + " correct answers and " + incorrectAnswers.size()
				+ " incorrect answers. ");
		System.out.println("POINTS ON THIS LEVEL: " + numberOfPointsOnLevel);
		user.printScore(numberOfPoints);
		System.out.println("CORRECT ANSWERS: ");
		for (i = 0; i < correctAnswers.size(); i++) {
			System.out.println(correctAnswers.get(i));
		}
		System.out.println("INCORRECT ANSWERS: ");
		for (i = 0; i < incorrectAnswers.size(); i++) {
			System.out.println(incorrectAnswers.get(i));
		}

		System.out.println("\n******************************************");
		mediumExecuted = true;
		User.increaseUserScore(nickname, numberOfPointsOnLevel);
		menu();
		input.close();
	}
}
