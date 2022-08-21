package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem {

    public static void solve() {
        System.out.printf("%s\n", readFile());
    }

    public static String readFile() {
        var absolutePath = new File("").getAbsolutePath();
        var file = new File(absolutePath + "/resources/oneThousandPiDigits.txt");
        return "dasd";
    }

}
