package com.challenge;

public class Main {
    public static void main(String[] args) {
        var start = System.nanoTime();
        var result = ErickWendelChallenge.problemOne();
        var end = System.nanoTime();

        // convert time to seconds
        var time = (end - start) / 1000000000.0;
        System.out.println("Time: " + time + " seconds");
        System.out.println("Result: " + result);
        // ErickWendelChallenge.problemTwo();
    }
}
