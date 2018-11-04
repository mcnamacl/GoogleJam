import java.io.*;

public class SolutionProblemA {

    public static void main(String args[]){
        BufferedReader reader;
        int caseNum = 1;
        int lineNum = 0;
        int amount = 0;
        int lastAmountNum = -2;
        int lastIntArrayNum = 0;
        int[] prices = null;
        try {
        	reader = new BufferedReader(new FileReader("A-large-practice.in"));
        	String line = reader.readLine();
        	while (line != null) {
        		lineNum++;
        		if (lineNum == lastAmountNum + 3) {
        			amount = Integer.valueOf(reader.readLine());
        			lastAmountNum = lineNum;
        		}
        		else if (lineNum == lastIntArrayNum + 3) {
        			String pricesString = reader.readLine();
        			String[] pricesArray = pricesString.split(" ");
        			prices = new int[pricesArray.length];
        			for (int i = 0; i < pricesArray.length; i++) {
        				prices[i] = Integer.valueOf(pricesArray[i]);
        			}
        			lastIntArrayNum = lineNum;
        		}
        		else {
        			reader.readLine();
        		}
        		if (amount != 0 && prices != null) {
        			System.out.println("Case #" + caseNum + ": " + storeCredit(amount, prices)[0] + " " + storeCredit(amount,prices)[1]);
        			caseNum++;
        			amount = 0;
        			prices = null;
        		}
        	}
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    }

    public static int[] storeCredit(int amount, int[] prices){
        int indexOne = -1;
        int indexTwo = -1;
        int[] indexOfPrices = new int[2];
        boolean found = false;
        for (indexOne = 0; indexOne < prices.length && !found; indexOne++){
            int numToFind = amount - prices[indexOne];
            if (numToFind > 0){
                for (indexTwo = indexOne+1; indexTwo < prices.length && !found; indexTwo++){
                    if (prices[indexTwo] == numToFind){
                        found = true;
                    }
                }
            }
        }
        if (indexOne < indexTwo){
            indexOfPrices[0] = indexOne-1;
            indexOfPrices[1] = indexTwo-1;
        } else {
            indexOfPrices[0] = indexTwo-1;
            indexOfPrices[1] = indexOne-1;
        }
        return indexOfPrices;
    }
}
