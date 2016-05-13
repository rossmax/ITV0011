import java.util.Arrays;

/**
 * Created by Max Ross on 5/11/2016 10:51 AM.
 */
public class EX19 {

        public static void main(String[] args) {
            String test = "Koeratoit toidukoeratäpp toidukoor kalamaja TäpikKoer koe";
            int[] result = testDog(test);
            System.out.println(Arrays.toString(testDog(test)));
            System.out.println(Arrays.toString(testDog("koerkoerkoer")));
            System.out.println(reverse("tere"));
            System.out.println(reverse("a  b"));
            System.out.println(reverse("Tere"));
            System.out.println(reverse("Tere!"));


        }
        public static int[] testDog(String text) {
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
        public static String reverse(String text){
            String res = "";
            String result = "";
            char charArray[];

            for (String part : text.split(" ")) {
                res = new StringBuilder(part).reverse().toString();
                charArray = res.toCharArray();
                if(res.length() > 0) {
                    if (Character.isUpperCase(charArray[res.length() - 1]) && charArray[0] != '!') {
                        res = lowerCaseFirst(res);
                        res = upperCaseFirst(res);
                    }
                }
                result += res + " ";
            }

            return result;

        }
        public static String lowerCaseFirst(String value) {
            char[] array = value.toCharArray();
            array[value.length()-1] = Character.toLowerCase(array[value.length()-1]);
            return new String(array);
        }
            public static String upperCaseFirst(String value) {
            char[] array = value.toCharArray();
            array[0] = Character.toUpperCase(array[0]);
        return new String(array);
        }
}