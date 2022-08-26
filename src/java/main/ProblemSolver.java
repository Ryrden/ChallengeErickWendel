package main;

public class ProblemSolver implements Runnable {
    Data parameter;
    int[] foundPrime;
    public ProblemSolver(Data parameter,int[] foundPrime) {
        this.parameter = parameter;
        this.foundPrime = foundPrime;
    }

    @Override
    public void run(){
        var length = parameter.length();
        var data = parameter.data();
        var found = getPalindromicPrimeWithLength(length,data);
        if (found != null) {
            foundPrime[0] = 1;
            foundPrime[1] = Integer.parseInt(found);
        }
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
        //TODO treat number to 21 digits
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
