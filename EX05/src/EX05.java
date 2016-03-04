import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class EX05.
 */
public class EX05 {
    
    /** The Constant INPUTFile. */
    public static final String INPUTFile  = "Movies.txt";
    
    /** The Constant OUTPUTFile. */
    public static final String OUTPUTFile = "OutputMovies.txt";
    
    /** The MOVIES list. */
    public static String       MOVIESList = "";

    /**
     * Convert.
     *
     * @param inputFile the input file
     * @param outputFile the output file
     * @return the int
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static int convert(String inputFile, String outputFile) throws IOException {
        String  ret     = "";
        int     c       = 0;
        Path    path    = Paths.get(inputFile);
        Scanner scanner = new Scanner(path);

        while (scanner.hasNextLine()) {

            // "\n" -> newline
            ret += scanner.nextLine() + "\n";
            c++;
        }

        scanner.close();
        MOVIESList += ret;

        FileWriter writer2 = new FileWriter(outputFile);

        writer2.write("" + getNicelyFormattedMovie(MOVIESList));
        writer2.close();

        return c;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        System.out.println(getNicelyFormattedMovie("tere|"));    // null
        convert(INPUTFile, OUTPUTFile);
        System.out.println(getNicelyFormattedMovie("2016-02-24|Movie1|description|8.0"));
        System.out.println(getNicelyFormattedMovie(MOVIESList));

        /*
         * Movie1
         * Release date: 24/02/2016
         * Description: description
         * Average rating: 8.0    <- no new line in the end
         */
    }

    /**
     * Gets the nicely formatted movie.
     *
     * @param movieLine the movie line
     * @return the nicely formatted movie
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String getNicelyFormattedMovie(String movieLine) throws IOException {
        String ret = "";

        movieLine = movieLine.replaceAll("\n", "|");

        String[] retAll = movieLine.split("\\|");

        if (retAll.length < 3) {
            return null;
        }

        for (int j = 0; j < retAll.length; j += 4) {
            String saveLine;

            saveLine      = retAll[j];
            retAll[j]     = retAll[j + 1];
            retAll[j + 1] = saveLine;
        }

        int name = 1,
            data = 0,
            desc = 2,
            rat  = 3;

        for (int i = 0; i < retAll.length; i++) {
            if (i == name) {
                ret  += "Release Date: " + retAll[i] + "\n";
                name += 4;
            }

            if (i == data) {
                ret  += retAll[i] + "\n";
                data += 4;
            }

            if (i == desc) {
                ret  += "Description: " + retAll[i] + "\n";
                desc += 4;
            }

            if (i == rat) {
                ret += "Average Rating: " + retAll[i] + "\n\n";
                rat += 4;
            }
        }

        return ret;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
