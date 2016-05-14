import java.util.Arrays;

/**
 * Created by Max Ross on 5/13/2016 1:15 PM.
 */
public class KT3 {

    public static void main(String[] args) {
            int[] a = new int[] {1,1,3,4444,1,2,3};
        System.out.println(maxDiffSub(a));
    }
    public static int maxDiffSub(int[] a) {
        if(a == null) {
            return 0;
        }
        int maxSubArray[] = null;
        int subarray[] = new int[a.length];

            for (int j = 0; j < a.length-1; j++) {
                if (a[j] == a[j + 1] - 1) {
                    subarray[j] = a[j];
                    subarray[j + 1] = a[j + 1];
                } else {

                    if(maxSubArray == null || maxSubArray.length < j + 2) {
                        maxSubArray = new int[j + 1];
                        for (int k = 0; k <= j; ++k) {
                            maxSubArray[k] = subarray[k];
                    }
                        a = Arrays.copyOfRange(a, j + 1, a.length);
                        subarray = new int[a.length];
                        j = -1;
                }
                }
        }
        if(maxSubArray == null ||maxSubArray[0] == 0) {
            return a[a.length-1];
        }
        if(subarray.length > maxSubArray.length) {
            return subarray[subarray.length-1];
        }

        return maxSubArray[maxSubArray.length-1];
    }
}
