package main;

import java.io.*;
import java.net.URL;

public class ErickWendelChallenge {
    private ErickWendelChallenge() {
    }

    public static String problemOne() {
        var data = readFile();
        return ProblemSolver.getPalindromicPrimeWithLength(9, data);
    }

    public static String problemTwo() {
        var numberOfDigits = 1000;
        var max = 10_000_000_000L;
        var numberOfDigitsToCheck = 9;
        var found = 0;
        StringBuilder data = new StringBuilder("");
        StringBuilder lastDigitsToReverifie = new StringBuilder("");
        int[] foundPrime = {0,0};
        var actualPoint = 0L;
        try {
            var url = "https://archive.org/download/pi_dec_1t/pi_dec_1t_01.zip/pi_dec_1t_01.txt";
            URL oracle = new URL(url);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()))) {
                //read char by char and put on data
                char c;
                var count = 0;
                while (actualPoint < max) {
                    c = (char) in.read();
                    actualPoint++;
                    data.append(c);
                    count++;
                    if (count >= numberOfDigits-numberOfDigitsToCheck){
                        lastDigitsToReverifie.append(c);
                    }
                    if (count == numberOfDigits) {
                        found = verifyPrimeExists(numberOfDigitsToCheck, data, foundPrime);
                        if (found != 0) {
                            break;
                        }
                        data = new StringBuilder(lastDigitsToReverifie);
                        lastDigitsToReverifie = new StringBuilder();
                        count = 0;
                    }
                    actualPoint++;
                    if (actualPoint == max) {
                        System.out.println("Max reached");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Found Prime at "+ actualPoint);
        return String.valueOf(found);
    }

    private static int verifyPrimeExists(int numberOfDigitsToCheck, StringBuilder data, int[] foundPrime) {
        var parameters = new Data(numberOfDigitsToCheck, data.toString());
        var myFirstThread = new ProblemSolver(parameters, foundPrime);
        new Thread(myFirstThread).start();

        return foundPrime[1];
    }


    public static String readFile() {
        var result = "";
        var absolutePath = new File("").getAbsolutePath();
        var file = new File(absolutePath + "/src/java/resources/oneMillionPiDigits.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}