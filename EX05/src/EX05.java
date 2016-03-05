import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

/**
 * The Class EX05.
 */
public class EX05 {

  /** The Constant INPUTFile. */
  public static final String INPUTFILE = "Movies.txt";

  /** The Constant OUTPUTFile. */
  public static final String OUTPUTFILE = "OutputMovies.txt";

  /** The MOVIES list. */
  public static String MOVIESLIST = "";

  /**
   * Convert.
   *
   * @param inputFile the input file
   * @param outputFile the output file
   * @return the int
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static int convert(String inputFile, String outputFile) throws IOException {
    String ret = "";
    int countFilms = 1;
    Path path = Paths.get(inputFile);
    Scanner scanner = new Scanner(path);

    while (scanner.hasNextLine()) {

      // "\n" -> newline
      ret += scanner.nextLine() + "\n";
      countFilms++;
    }

    scanner.close();
    MOVIESLIST += ret;

    FileWriter writer2 = new FileWriter(outputFile);

    writer2.write("" + getNicelyFormattedMovie(MOVIESLIST));
    writer2.close();

    return countFilms;
  }

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(String[] args) throws IOException {
    System.out.println(getNicelyFormattedMovie("tere|")); // null
    convert(INPUTFILE, OUTPUTFILE);
    System.out.println(getNicelyFormattedMovie("2016-02-24|Movie1|description|8.0"));
    System.out.println(getNicelyFormattedMovie(MOVIESLIST));

    /*
     * Movie1 Release date: 24/02/2016 Description: description Average rating: 8.0 <- no new line
     * in the end
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
    int minLength = 3;
    int  newLine = 4;
    movieLine = movieLine.replaceAll("\n", "|");

    String[] retAll = movieLine.split("\\|");

    if (retAll.length < minLength) {
      return null;
    }

    for (int j = 0; j < retAll.length; j += newLine) {
      String saveLine;

      saveLine = retAll[j];
      retAll[j] = retAll[j + 1];
      retAll[j + 1] = saveLine;
    }

    int name = 1;
    int data = 0;
    int desc = 2;
    int rat = 3;

    for (int i = 0; i < retAll.length; i++) {
      if (i == name) {
        ret += "Release Date: " + retAll[i] + "\n";
        name += newLine;
      }

      if (i == data) {
        ret += retAll[i] + "\n";
        data += newLine;
      }

      if (i == desc) {
        ret += "Description: " + retAll[i] + "\n";
        desc += newLine;
      }

      if (i == rat) {
        ret += "Average Rating: " + retAll[i] + "\n\n";
        rat += newLine;
      }
    }

    return ret;
  }
}

