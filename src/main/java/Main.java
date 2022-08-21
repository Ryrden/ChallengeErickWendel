import main.java.Problem;

public class Main {
    public static void main(String[] args) {
        Problem.solve();
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
