/**
 * Created by Max Ross on 5/15/2016 7:39 PM.
 */
public class EX16 {
    /**
     * The constant N.
     */
    public static final int N = 9;
    /**
     * The constant E.
     */
    public static final int E = 8;
    /**
     * The constant T.
     */
    public static final int T = 10;

    /**
     * Count 98 int.
     *
     * @param n the n
     * @return the int
     */
    public static int count98(int n) {

        //IMPLEMENTATION HERE
        if (n == 0 || n < 0) {
            return 0;
        }

        int result;
        int on;
        int length = (int)(Math.log10(n) + 1);
        int firstDigit = Integer.parseInt(Integer.toString(n).substring(0, 1));
        int determinant = firstDigit * T;

        if (firstDigit == N || firstDigit == E) {
            on = 1;
        } else {
            on = 0;
        }

        for (int i = 0; i < length - 2; i++) {
            determinant = determinant * T;
        }

        if (on == 1 && length == 1) return 1;
        if (on == 0 && length == 1) return 0;

        result = count98(n - determinant) + on;
        return result;
    }

    /**
     * Count 98 harder int.
     *
     * @param n the n
     * @return the int
     */
    public static int count98Harder(int n) {
        //IMPLEMENTAAATION HERE
        if (n == 0 || n < 0) {
            return 0;
        }

        int result;
        int on;
        int length = (int) (Math.log10 (n) + 1);
        int digit = Integer.parseInt(Integer.toString(n).substring(0,1));
        int determinant = digit * 10;

        if (digit == N || digit == E) {
            on = 1;
            if (length >= 3) {
                int firstDigit = Integer.parseInt(Integer.toString(n).substring(0, 1));
                int secondDigit = Integer.parseInt(Integer.toString(n).substring(1, 2));
                if (firstDigit + secondDigit == N || firstDigit + secondDigit == E) {
                    on = 2;
                }
            }
        } else {
            on = 0;
        }

        for (int i = 0; i < length - 2; i++) {
            determinant = determinant * T;
        }

        if (on == 1 && length == 1) return 1;
        if (on == 0 && length == 1) return 0;

        result = count98(n - determinant) + on;
        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //TEST YOUR IMPLEMENTATION HERE
    }
}
