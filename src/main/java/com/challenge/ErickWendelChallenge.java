package com.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.challenge.util.PiApi;

public class ErickWendelChallenge {
    private ErickWendelChallenge() {
    }

    public static String problemOne() {
        var data = readFile();
        return getPalindromicPrimeWithLength(9, data);
    }

    public static String problemTwo() {
        var start = 1L;
        var numberOfDigits = 1000;
        var max = 100_000_000_000L;
        var numberOfDigitsToCheck = 9;
        String found = null;
        var data = "";
        // TODO use Threads to speed up the process
        while (start < max) {
            data = PiApi.getDataFromApi(start, numberOfDigits);
            found = getPalindromicPrimeWithLength(numberOfDigitsToCheck, data);
            if (found != null)
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

    public static String getPalindromicPrimeWithLength(int length, String data) {
        var windowSubstring = data.substring(0, length);
        for (int i = length; i < data.length() - length; i++) {
            if (isPalindromic(windowSubstring) && (isPrime(windowSubstring))) {
                return windowSubstring;
            } else {
                windowSubstring = windowSubstring.substring(1);
                windowSubstring += data.charAt(i);
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