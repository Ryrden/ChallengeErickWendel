package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ErickWendelChallenge {
    private ErickWendelChallenge() {
    }

    public static String problemOne() {
        var data = readFile();
        return ProblemSolver.getPalindromicPrimeWithLength(9, data);
    }

    public static String problemTwo() {
        var start = 1L;
        var numberOfDigits = 1000;
        var max = 100_000_000_000L;
        var numberOfDigitsToCheck = 21;
        String found = null;
        var data = "";
        //TODO use Threads to speed up the process
        boolean[] foundPrime = {false};
        while (start < max) {
            data = HandlerPiApi.getDataFromApi(start, numberOfDigits);
            var parameters = new Data(numberOfDigitsToCheck,data);
            var myFirstThread = new ProblemSolver(parameters,foundPrime);
            new Thread(myFirstThread).start();
            System.out.println("Actual point: " + start);
            if (foundPrime[0])
                break;
            start += numberOfDigits - numberOfDigitsToCheck + 1;
        }
        if (start >= max) {
            System.out.println("Palindromic Prime Not found");
        } else {
            System.out.println("Palindromic Prime found at " + start);
        }
        return found;
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