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

  /** The Constant DATAINDEX. */
  public static final int DATAINDEX = 1;

  /** The Constant NAMEINDEX. */
  public static final int NAMEINDEX = 0;

  /** The Constant DESCINDEX. */
  public static final int DESCINDEX = 2;

  /** The Constant RATINDEX. */
  public static final int RATINDEX = 3;

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

    while  (scanner.hasNextLine())  {
      writer2.write("" + getNicelyFormattedMovie(scanner.nextLine()));
      if (scanner.hasNext() == true) {
        writer2.write("\n\n");
      }
      countFilms++;
    }

    writer2.close();
    scanner.close();

    return countFilms;
  }

  /**
   * Gets the nicely formatted movie.
   *
   * @param  movieLine  the  movie line
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

    String ret = "";

    String saveLine;
    saveLine = retAll[0];
    retAll[0] = retAll[1];
    retAll[1] = saveLine;

    for (int i = 0; i < retAll.length; i++) {
      if  (i == DATAINDEX)  {
        String[] newDataForm;
        String saveData;
        retAll[i] = retAll[i].replaceAll("-", "/");
        newDataForm = retAll[i].split("/");
        saveData = newDataForm[0];
        newDataForm[0] = newDataForm[2];
        newDataForm[2] = saveData;

        ret += "Release date: " + newDataForm[0] + "/";
        ret += newDataForm[1]  + "/" + newDataForm[2] + "\n";
      }

      if (i == NAMEINDEX)  {
        ret += retAll[i] + "\n";
      }

      if (i == DESCINDEX) {
        ret += "Description: " + retAll[i] + "\n";
      }

      if (i == RATINDEX) {
        ret += "Average rating: " + retAll[i];
      }
    }
    return ret;
  }
}

