import java.util.Random;
import java.util.Scanner;

/**
 * Template for HW01: Treasurehunt. More information:
 * https://courses.cs.ttu.ee/pages/ITI0011:Aardejaht
 */
public class HW01 {
    /**
     * Value to return in makeMove in case the cell was empty.
     */
    public static final int CELL_EMPTY = 0;

    /**
     * Value to return in makeMove in case the cell contained treasure.
     */
    public static final int CELL_TREASURE = 1;

    /**
     * Value to return in makeMove in case the cell does not exist.
     */
    public static final int CELL_ERROR = -1;

    /**
     * The Constant CELL_DIG.
     */
    public static final int CELL_DIG = 2;

    /**
     * The Matrix value.
     */
    public static int[][] matrixValue;

    /**
     * The Matrix symbols.
     */
    public static char[][] matrixSymbols;

    /**
     * The constant invalidValue.
     */
    public static final int invalidValue = -123;

    /**
     * Main entry.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // game logic here
        boolean startGame = true;
        while (startGame) {
            int height = 1;
            int width = 1;
            int treasures = 1;
            int row = 0;
            int col = 0;
            int kaevamisiSum = 0;
            while (height > 0 && treasures > 0 && width > 0) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Sisesta M (ridade arv), N (veergude arv), X (aarete arv): ");
                String parameterInput = sc.nextLine();
                String[] parArray = parameterInput.split(",");
                height = Integer.parseInt(parArray[0]);
                width = Integer.parseInt(parArray[1]);
                treasures = Integer.parseInt(parArray[2]);
                if (height > 0 || width > 0) {
                    createMap(height, width, treasures);
                    System.out.println("Edukat kaevamist!\n");
                    System.out.println(getMatrix(matrixSymbols));
                    while (aardeidSum(matrixValue) != 0) {
                        System.out.println(
                                "kaevamisi: " + kaevamisiSum + ", aardeid jäänud: " + aardeidSum(matrixValue));
                        kaevamisiSum++;
                        System.out.print("Mida kaevame (rida, veerg): ");
                        String moeldnudAarde = sc.nextLine();
                        System.out.print("\n");
                        String[] ardArray = moeldnudAarde.split(",");
                        row = Integer.parseInt(ardArray[0]);
                        col = Integer.parseInt(ardArray[1]);
                        makeMove(row, col);
                    }
                    if (aardeidSum(matrixValue) == 0) {
                        System.out.println(
                                "kaevamisi: " + kaevamisiSum + ", aardeid jäänud: " + aardeidSum(matrixValue));
                        System.out.println("Mäng läbi! Kokku tehti " + kaevamisiSum + " kaevamist.");
                        System.out.print("Kas soovid veel mängida?(jah,ei): ");
                        if (sc.nextLine() == "jah") {
                            startGame = true;
                            break;
                        } else {
                            startGame = false;
                            break;
                        }
                    }
                } else {
                    System.out.println("Vale parametrid!\n");
                }
            }
        }
    }

    /**
     * Makes move to cell in certain row and column and returns the contents of the cell. Use CELL_*
     * constants in return.
     *
     * @param row Row to make move to.
     * @param col Column to make move to.
     * @return Contents of the cell.
     */
    public static int makeMove(int row, int col) {
        if (getCell(row, col)) {
            matrixSymbols[row][col] = '+';
            matrixValue[row][col] = CELL_DIG;
            System.out.print(getMatrix(matrixSymbols));
            System.out.println("AARE!\n");
        }
        if (!getCell(row, col)) {
            matrixSymbols[row][col] = ' ';
            System.out.println(getMatrix(matrixSymbols));
        }
        if (row == -1) {
            return CELL_ERROR;
        }
        return CELL_EMPTY;
    }

    /**
     * Creates a map with certain measures and treasures. As this is a static method which doesn't
     * return anything (void), you should store the created map internally. This means you can choose
     * your own implementation of how to store the map. The treasures should be put on the map
     * randomly using setCell method.
     *
     * @param height    Height of the map.
     * @param width     Width of the map.
     * @param treasures The number of treasures on the map.
     * @return Whether map was created.
     */
    public static boolean createMap(int height, int width, int treasures) {
        // initialize map (for example 2D-array)
        // - set all cells empty (is this needed?)
        // do some random for every treasure and add them to map:
        matrixSymbols = new char[height][width];
        matrixValue = new int[height][width];
        int count = 0;
        char dot = '.';
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrixValue[i][j] == CELL_EMPTY) {
                    matrixValue[i][j] = CELL_EMPTY;
                }
                matrixSymbols[i][j] = dot;
                if (count < treasures) {
                    Random n = new Random();
                    Random m = new Random();
                    int nn = n.nextInt(height);
                    int mm = m.nextInt(width);
                    if (matrixValue[nn][mm] == CELL_TREASURE) {
                        count--;
                    }
                    setCell(nn, mm, CELL_TREASURE);
                    count++;

                }
            }
        }
        return false;
    }

    /**
     * Sets the cell value for the active map (created earlier using createMap method). This method is
     * required to test certain maps
     *
     * @param row Row index.
     * @param col Column index.
     * @return Whether the getCell value was set.
     */
    public static boolean getCell(int row, int col) {

        if (matrixValue[row][col] == CELL_EMPTY || matrixValue[row][col] == CELL_ERROR) {
            return false;
        }
        if (matrixValue[row][col] == CELL_TREASURE || matrixValue[row][col] == CELL_DIG) {
            return true;
        }
        return row != invalidValue;
    }

    /**
     * Sets cell.
     *
     * @param row          the row
     * @param col          the col
     * @param cellContents the cell contents
     * @return the cell
     */
    public static boolean setCell(int row, int col, int cellContents) {

        if (matrixValue[row][col] == CELL_EMPTY) {
            matrixValue[row][col] = CELL_TREASURE;
            return true;
        }
        return row != invalidValue;
    }


    /**
     * Gets the matrix.
     *
     * @param createMatricSymbols the create matric symbols
     * @return the matrix
     */
    public static String getMatrix(char[][] createMatricSymbols) {
        String matrixTekstikujul = "";
        String str;
        String lineChange = "\n";

        for (int i = 0; i < createMatricSymbols.length; i++) {
            for (int j = 0; j < createMatricSymbols[0].length; j++) {
                str = String.valueOf(createMatricSymbols[i][j]);
                matrixTekstikujul += str;

            }
            matrixTekstikujul += lineChange;
        }

        return matrixTekstikujul;
    }

    /**
     * Aardeid sum.
     *
     * @param maatrixValue the matrix value
     * @return the int
     */
    public static int aardeidSum(int[][] maatrixValue) {

        int aardeid = 0;
        for (int i = 0; i < maatrixValue.length; i++) {
            for (int j = 0; j < maatrixValue[0].length; j++) {
                if (matrixValue[i][j] == CELL_TREASURE) {
                    aardeid++;
                }
            }
        }
        return aardeid;
    }
}
