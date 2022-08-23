package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ErickWendelChallenge {
    private ErickWendelChallenge() {
    }

    public static void problemOne() {
        var data = readFile();
        var found = getPalindromicPrimeWithLength(9, data);
        System.out.println(found);
    }

    public static void problemTwo() {
        //get request from https://api.pi.delivery/v1/pi?start=0&numberOfDigits=100
        var start = 1L;
        var numberOfDigits = 1000;
        var max = 100_000_000_000L;
        var numberOfDigitsToCheck = 9;
        //TODO use Threads to speed up the process
        while (start < max) {
            var data = HandlerPiApi.getDataFromApi(start, numberOfDigits);
            var found = getPalindromicPrimeWithLength(numberOfDigitsToCheck, data);
            if (found != null) {
                System.out.println(found);
                break;
            }
            start += numberOfDigits - numberOfDigitsToCheck + 1;
        }
        if (start >= max) {
            System.out.println("Palindromic Prime Not found");
        } else {
            System.out.println("Palindromic Prime found at " + start);
        }
    }


    public static String getPalindromicPrimeWithLength(int length, String data) {
        //TODO use Sliding Window Technique
        for (int i = 0; i < data.length() - length; i++) {
            var sub = data.substring(i, i + length);
            if (isPalindromic(sub) && (isPrime(sub))) {
                return sub;
            }
        }
        return null;
    }

    private static boolean isPalindromic(String sub) {
        return sub.equals(new StringBuilder(sub).reverse().toString());
    }

    public static boolean isPrime(String num) {
        var n = Long.parseLong(num);
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
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
