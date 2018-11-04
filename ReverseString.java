package newGoogleJam;

import java.io.*;

public class ReverseString {

	public static void main(String args[]) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("B-large-practice.in"));
			int caseNum = 0;
			String input = reader.readLine();
			while (input != null) {
				String output = reverseWords(input);
				System.out.println("Case #" + caseNum + ": " + output);
				input = reader.readLine();
				caseNum++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String reverseWords(String input) {
		String[] inputArray = input.split(" ");
		StringBuilder output = new StringBuilder();
		for (int i = inputArray.length - 1; i >= 0; i--) {
			output.append(inputArray[i] + " ");
		}
		String outputString = output.toString();
		return outputString;
	}
}
