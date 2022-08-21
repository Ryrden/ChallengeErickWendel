package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var data = readFile();
        for (int i = 0; i < data.length() - 9; i++) {
            var sub = data.substring(i, i + 9);
            if (sub.equals(new StringBuilder(sub).reverse().toString())) {
                if (isPrime(Long.parseLong(sub))) {
                    System.out.printf("%s\n", sub);
                    return;
                }
            }
        }
        System.out.println("No palindrome found");
    }

    public static String readFile() throws IOException {
        var absolutePath = new File("").getAbsolutePath();
        var file = new File( absolutePath + "/src/java/main/oneMillionPiDigits.txt");

        var bufferedReader = new BufferedReader(new FileReader(file));
        var result = bufferedReader.readLine();
        bufferedReader.close();
        return result;
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
}