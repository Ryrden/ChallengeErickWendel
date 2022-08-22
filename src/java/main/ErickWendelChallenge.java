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
        System.out.println(getPrimePalindromicWithLength(9, data));
    }

    public static void problemTwo() {
        var result = "no palindromic prime found";
        //get request from https://api.pi.delivery/v1/pi?start=0&numberOfDigits=100
        var data = getDataFromApi();
        result = getPrimePalindromicWithLength(21, data);
        System.out.println(result);
    }

    private static String getDataFromApi() {
        // TODO GET Request from API https://api.pi.delivery/v1/pi?start=0&numberOfDigits=100
        return null;
    }

    public static String getPrimePalindromicWithLength(int length, String data) {
        for (int i = 0; i < data.length() - length; i++) {
            var sub = data.substring(i, i + length);
            if (sub.equals(new StringBuilder(sub).reverse().toString())) {
                if (isPrime(Long.parseLong(sub))) {
                    return sub;
                }
            }
        }
        return "No palindromic prime found";
    }

    public static boolean isPrime(long n) {
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
        var file = new File(absolutePath + "/src/java/main/oneMillionPiDigits.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
