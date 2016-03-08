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
  public static final String INPUTFILE = "Test.txt";

  /** The Constant OUTPUTFile. */
  public static final String OUTPUTFILE = "OutputMovies.txt";

  /** The MOVIES list. */
  public static String moviesLIST = "";

  /** The minimum length of array. */
  public static final int MINLENGHT = 3;

  /** The new line begins after 4 array elements. */
  public static final int NEWLINE = 4;

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void main(String[] args) throws IOException {
    
    System.out.println(getNicelyFormattedMovie("tere|")); // null

    System.out.println(getNicelyFormattedMovie("2016-02-24|Movie1|description|8.0"));


    convert(INPUTFILE, OUTPUTFILE);
    
    //System.out.println(moviesLIST);

    // System.out.println(convert(INPUTFILE, OUTPUTFILE));
    // System.out.println(getNicelyFormattedMovie(moviesLIST));

    /*
     * Movie1 Release date: 24/02/2016 
     * Description: description 
     * Average rating: 8.0 <- no new line
     * in the end
     */
  }

  /**
   * Convert.
   *
   * @param inputFile the input file
   * @param outputFile the output file
   * @return the int
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static int convert(String inputFile, String outputFile) throws IOException {

    if (inputFile == null || inputFile == "") {
      return 0;
    }


    int countFilms = 0;
    Path path = Paths.get(inputFile);
    Scanner scanner = new Scanner(path);
    FileWriter writer2 = new FileWriter(outputFile);

    while (scanner.hasNextLine()) {

      writer2.write("" + getNicelyFormattedMovie(scanner.nextLine()) + "\n\n");
      
      countFilms++;
    }
    
    writer2.close();

    scanner.close();


    return countFilms;
  }

  /**
   * Gets the nicely formatted movie.
   *
   * @param movieLine the movie line
   * @return the nicely formatted movie
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static String getNicelyFormattedMovie(String movieLine) throws IOException {
    
    if (movieLine == null) {
      return null;
    }
    if (movieLine == "") {
      return null;
    }
    
    String[] retAll = movieLine.split("\\|");
    
    if (retAll.length < MINLENGHT) {
      return null;
    }

    int nameIndex = 1;
    int dataIndex = 0;
    int descIndex = 2;
    int ratIndex = 3;

    String ret = "";

    String saveLine;
    saveLine = retAll[0];
    retAll[0] = retAll[1];
    retAll[1] = saveLine;

    for (int i = 0; i < retAll.length; i++) {
      if (i == nameIndex) {
        ret += "Release Date: " + retAll[i] + "\n";
      }

      if (i == dataIndex) {
        ret += retAll[i] + "\n";
      }

      if (i == descIndex) {
        ret += "Description: " + retAll[i] + "\n";
      }

      if (i == ratIndex) {
        ret += "Average Rating: " + retAll[i];
      }
    }
    return ret;
  }
}

