package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem {

    private Problem() {
    }

    public static void solve() {
        System.out.printf("%s\n", readFile());
    }

    public static String readFile() {
        var file = new File("../resources/oneThousandPiDigits");
        var bufferedReader = new BufferedReader(new FileReader(file));
        var result = bufferedReader.readLine();
        bufferedReader.close();
        return result;
    }

}
