import java.util.Scanner;
 
/**
 * EX04.
 */
public class EX04 {
    /** Guess parameter array index for guess ROW value*/
    public static final int FIELD_ROW = 0;
    /** Guess parameter array index for guess COL value*/
    public static final int FIELD_COL = 1;
    /** Settings parameter array index for matrix height value*/
    public static final int FIELD_MATRIX_HEIGHT = 0;
    /** Settings parameter array index for matrix width value */
    public static final int FIELD_MATRIX_WIDTH = 1;
    /** Settings parameter array index for matrix target row value */
    public static final int FIELD_TARGET_ROW = 2;
    /** Settings parameter array index for matrix target col value*/
    public static final int FIELD_TARGET_COL = 3;
    /** The count of settings parameters */
    public static final int INITIAL_PARAMETER_ARRAY_LENGTH = 4;
    /** The count of guess parameters */
    public static final int GUESS_ARRAY_LENGTH = 2;
    /** Maximum matrix dimension value */
    public static final int MAX_DIMENSION = 10;
    /** Precision for double checking */
    public static final double ERROR_BOUND = 0.001;
    public static int INPUTGUESS_ROW;
    public static  int INPUTGUESS_COL;
    
 
    /**
     * Entry point.
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixParameters = readInitialMatrixParameters(scanner);
        char[][] matrix = createMatrix(
                matrixParameters[FIELD_MATRIX_HEIGHT],
                matrixParameters[FIELD_MATRIX_WIDTH],
                matrixParameters[FIELD_TARGET_ROW],
                matrixParameters[FIELD_TARGET_COL]
        );
 
        int[] guessInput;
        int totalGuesses = 0;
        while (true) {
            System.out.println(getAsciiMatrix(matrix));
            guessInput = readGuessInput(scanner, matrixParameters);
            totalGuesses++;
            System.out.println("Katseid : " + totalGuesses);
            double distance = guess(matrix, guessInput[FIELD_ROW], guessInput[FIELD_COL]);
            if (distance < ERROR_BOUND) {
                System.out.println("Lahendus leitud " + totalGuesses + " katsega!");
                break;
            } else {
                System.out.printf("Kaugus mõeldud punktist %.2f\n", distance);
            }
        }

    }
 
    public static char[][] createMatrix(int n, int m, int row, int col) {
		
		char[][] createMatrix = new char[n][m];
		char dot = '.';
		char moeldudRuut = 'x';
		for(int i = 0; i < n; i++){
		   for(int j = 0; j < m; j++){
			  createMatrix[i][j] = dot;
		   }	   
	   }
		createMatrix[row][col] = moeldudRuut;
		INPUTGUESS_ROW = row;
		INPUTGUESS_COL = col;
		
	    return createMatrix;
	}
 
    public static double guess(char[][] matrix, int row, int col) {
        
    	char star = '*';
    	matrix[row][col] = star;
    	System.out.println(getAsciiMatrix(matrix));
 
        return Math.sqrt(Math.pow((row - INPUTGUESS_ROW), 2) + Math.pow((col - INPUTGUESS_COL), 2));
    }
 
    public static String getAsciiMatrix(char[][] matrix) {
    	
    	String matrixTekstikujul = "";
    	String str;
    	String lineChange = "\n";
    	
    	for(int i = 0; i < matrix.length; i++){
    		for(int j = 0; j < matrix[0].length; j++){
    			str = String.valueOf(matrix[i][j]);
    			matrixTekstikujul += str;
	
    		}
    		matrixTekstikujul += lineChange;
    	}
    	matrixTekstikujul = matrixTekstikujul.replaceAll("x", ".");
        return matrixTekstikujul;
    }
 
    /**
     * Read user guess input from scanner.
     * Returned array structure:
     * row index, column index
     * Index 0 - row, Index 1 - col
     *
     * @param scanner          Input scanner
     * @param matrixParameters Array of user guess information
     * @return int[] array of guess input parameters
     */
    public static int[] readGuessInput(Scanner scanner, int[] matrixParameters) {
        int[] parameters;
        do {
            System.out.print("Sisestage mõeldav ruut (näiteks 0,0):");
            String parameterInput = scanner.nextLine();
            parameters = splitInputStructureToIntArray(parameterInput);
        } while (!validateGuessInput(parameters, matrixParameters));
        return parameters;
    }
 
    /**
     * Validate whether the guess input parameters are ok.
     * 1) guess input length must be 2 (row and col indices)
     * 2) row and col must be inside matrix that is specified by the matirxParameters
     *
     * @param guessInput       user guess input, consists of [0] - row [1] - col indices
     * @param matrixParameters game matrix parameters (look readInitialMatrixParameters for structure information)
     * @return whether the guess input is ok.
     */
    public static boolean validateGuessInput(int[] guessInput, int[] matrixParameters) {
        if (guessInput.length != GUESS_ARRAY_LENGTH) {
            return false;
        }
        for (int guessValue : guessInput) {
            if (guessValue < 0) {
                return false;
            }
        }
        return guessInput[FIELD_ROW] < matrixParameters[FIELD_MATRIX_HEIGHT]
                && guessInput[FIELD_COL] < matrixParameters[FIELD_MATRIX_WIDTH];
    }
 
    /**
     * Read matrix parameters from scanner.
     * returned array structure
     * N - Matrix height, M - matrix width
     * ROW - row index of target square,
     * COL - column index of target square
     * index 0 - N value, index 1 - M value
     * index 2 - ROW value, index 3 - COL value
     *
     * @param scanner Input scanner
     * @return int[] - Array of user input parameters
     */
    public static int[] readInitialMatrixParameters(Scanner scanner) {
        int[] parameters;
        do {
            System.out.print("Sisestage N,M,ROW,COL (näiteks: 2,2,0,0):");
            String parameterInput = scanner.nextLine();
            parameters = splitInputStructureToIntArray(parameterInput);
        } while (!validateInitialParameters(parameters));
 
        return parameters;
    }
 
    /**
     * Converts input that is separated by commas to integer array.
     * If value is not convertable to int -1 is used.
     *
     * @param input input string to be parsed
     * @return int[] array of int values.
     */
    public static int[] splitInputStructureToIntArray(String input) {
 
        String[] splitParts = input.replaceAll(" ", "").split(",");
        int[] parameters = new int[splitParts.length];
        for (int i = 0; i < splitParts.length; i++) {
            try {
                parameters[i] = Integer.parseInt(splitParts[i]);
            } catch (NumberFormatException e) {
                parameters[i] = -1;
            }
        }

        return parameters;
    }
 
    /**
     * Check whether the input input parameters are ok.
     * We consider a parameter ok when its value is between 1 and 10(exclusive) and
     * ROW, COL are inside the matrix
     *
     * @param parameters Array of user matrix parameters.
     * @return boolean - whether the input parameters are ok.
     */
    public static boolean validateInitialParameters(int[] parameters) {
        if (parameters.length != INITIAL_PARAMETER_ARRAY_LENGTH) {
            return false;
        }
        for (int parameter : parameters) {
            if (parameter < 0 || parameter > MAX_DIMENSION) {
                return false;
            }
        }
        return parameters[FIELD_MATRIX_HEIGHT] > parameters[FIELD_TARGET_ROW]
                && parameters[FIELD_MATRIX_WIDTH] > parameters[FIELD_TARGET_COL];
    }
}