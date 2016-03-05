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
  public static String moviesLIST = "";

  /** The minimum length of array. */
  public static final int MINLENGHT = 3;

  /** The new line begins after 4 array elements. */
  public static final int NEWLINE = 4;

  /** The Constant name index of array. */
  public static int nameINDEX = 1;

  /** The Constant data index of array. */
  public static int dataINDEX = 0;

  /** The Constant description index of array. */
  public static int descINDEX = 2;

  /** The Constant rating index of array. */
  public static int ratIndex = 3;

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
    moviesLIST += ret;

    FileWriter writer2 = new FileWriter(outputFile);

    writer2.write("" + getNicelyFormattedMovie(moviesLIST));
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
    System.out.println(getNicelyFormattedMovie(moviesLIST));

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
    movieLine = movieLine.replaceAll("\n", "|");

    String[] retAll = movieLine.split("\\|");

    if (retAll.length < MINLENGHT) {
      return null;
    }

    for (int j = 0; j < retAll.length; j += NEWLINE) {
      String saveLine;

      saveLine = retAll[j];
      retAll[j] = retAll[j + 1];
      retAll[j + 1] = saveLine;
    }

    for (int i = 0; i < retAll.length; i++) {
      if (i == nameINDEX) {
        ret += "Release Date: " + retAll[i] + "\n";
        nameINDEX += NEWLINE;
      }

      if (i == dataINDEX) {
        ret += retAll[i] + "\n";
        dataINDEX += NEWLINE;
      }

      if (i == descINDEX) {
        ret += "Description: " + retAll[i] + "\n";
        descINDEX += NEWLINE;
      }

      if (i == ratIndex) {
        ret += "Average Rating: " + retAll[i] + "\n\n";
        ratIndex += NEWLINE;
      }
    }

    return ret;
  }
}

