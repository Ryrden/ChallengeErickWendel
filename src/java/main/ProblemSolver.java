package main;

public class ProblemSolver extends Thread{
    private ProblemSolver() {
    }

    @Override
    public void run(){

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
}
