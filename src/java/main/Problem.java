package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem {

    public Problem() {
        super();
    }

    public static void solve() throws IOException {
        System.out.printf("%s\n", readFile());
    }

    public static String readFile() throws IOException {
        var absolutePath = new File("").getAbsolutePath();
        var file = new File( absolutePath + "/src/java/resources/oneThousandPiDigits.txt");

        var bufferedReader = new BufferedReader(new FileReader(file));
        var result = bufferedReader.readLine();
        bufferedReader.close();
        return result;
    }

    public boolean isPrime(long n) {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
