import java.util.Arrays;

/**
 * Created by Max Ross on 5/11/2016 10:51 AM.
 */
public class EX19 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
            String test = "Koeratoit toidukoeratäpp toidukoor kalamaja TäpikKoer koe";
            int[] result = testDog(test);
            System.out.println(Arrays.toString(testDog(test)));
            System.out.println(Arrays.toString(testDog("koerkoerkoerkoer")));
            System.out.println(Arrays.toString(testDog("koerKoerkoerkoer")));
            System.out.println(Arrays.toString(testDog("")));
            System.out.println(Arrays.toString(testDog(null)));
            System.out.println(Arrays.toString(testDog("0")));
            System.out.println(reverse("tere"));
            System.out.println(reverse("a b"));
            System.out.println(reverse("Tere"));
            System.out.println(reverse("tEre"));
            System.out.println(reverse("Tere!"));
            System.out.println(reverse("tere!"));


        }

    /**
     * Test dog int [ ].
     *
     * @param text the text
     * @return the int [ ]
     */
    public static int[] testDog(String text) {

        if (text == null) {
            return new int[]{0,0};
        }
        if (text.isEmpty()) {
            return new int[]{0,0};
        } /*
        if (text.equals("")) {
            return new int[]{0};
        }*/

            int elusKoer = 0;
            int surnudKoer = 0;
            int[] count = new int[2];

            String[] koerad = text.split(" ");

            for (int i = 0; i < koerad.length; i++) {
                if (koerad[i].contains("Koer")) {
                    elusKoer++;
                }
                if (koerad[i].contains("koer")) {
                    surnudKoer++;
                }
            }
            count[0] = elusKoer;
            count[1] = surnudKoer;
            return count;

        }

    /**
     * Reverse string.
     *
     * @param text the text
     * @return the string
     */
    public static String reverse(String text) {

        if (text == null) {
            return null;
        }
        if (text.equals("")) {
            return "";
        }

        String res = "";
        String result = "";
        char[] charArray;

            for (String part : text.split(" ")) {
                res = new StringBuilder(part).reverse().toString();
                charArray = res.toCharArray();
                if (res.length() > 0) {
                    if (Character.isUpperCase(charArray[res.length() - 1]) || charArray[0] != '!') {
                        char[] array = res.toCharArray();
                        /*for(int i = 1; i < array.length; i++) {
                            if(array[0] == '!') {
                                break;
                            }
                            if(Character.isUpperCase(charArray[res.length() - 1])) {
                                array[res.length() - 1] = Character.toLowerCase(array[res.length() - 1]);
                                array[0] = Character.toUpperCase(array[0]);
                            }

                            array[i] = Character.toLowerCase(array[i]);
                        }*/

                        res = new String(array);

                    }
                }
                result += res + " ";
            }
        charArray = result.toCharArray();
        char[] array2 = Arrays.copyOfRange(charArray, 0, charArray.length - 1);
        String s = new String(array2);
        return s;

        }

}
