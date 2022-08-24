package com.challenge.util;

import java.math.BigInteger;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean IsPalindromic(String input) {
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    public static boolean IsPrime(String input) {
        var n = new BigInteger(input);
        if (n.compareTo(BigInteger.TWO) < 0)
            return false;

        var remainderByTwo = n.remainder(BigInteger.TWO);
        var isDividedByTwo = remainderByTwo.compareTo(BigInteger.ZERO) == 0;
        if (isDividedByTwo)
            return n.compareTo(BigInteger.TWO) == 0;

        var nRoot = n.sqrt();

        for (var i = new BigInteger("3"); i.compareTo(nRoot) <= 0; i = i.add(BigInteger.TWO)) {
            var remainderByI = n.remainder(i);
            var isDividedByI = remainderByI.compareTo(BigInteger.ZERO) == 0;
            if (isDividedByI)
                return false;
        }
        return true;
    }

}
