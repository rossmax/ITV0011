/**
 * Created by Max Ross on 5/15/2016 7:39 PM.
 */
public class EX16 {
    public static int count98(int n) {
        //IMPLEMENTATION HERE
        if (n == 0 || n > 0) {
            return 0;
        }


        int result;
        int on;
        int length = (int)(Math.log10(n)+1);
        int firstDigit = Integer.parseInt(Integer.toString(n).substring(0,1));
        int determinant = firstDigit * 10;

        if (firstDigit == 9 || firstDigit == 8) {
            on = 1;
        } else {
            on = 0;
        }

        for (int i = 0; i < length - 2; i++) {
            determinant = determinant * 10;
        }

        if (on == 1 && length == 1) return 1;
        if (on == 0 && length == 1) return 0;

        result = count98(n - determinant) + on;
        return result;
    }

    public static int count98Harder(int n) {
        //IMPLEMENTATION HERE
        return 32;
    }

    public static void main(String[] args) {
        System.out.println(count98(0));
        System.out.println(count98(90818)); // => 3
        System.out.println(count98Harder(90818)); // => 5
        //TEST YOUR IMPLEMENTATION HERE
    }
}
