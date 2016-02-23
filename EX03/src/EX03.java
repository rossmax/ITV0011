public class EX03 {
 
    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humanoids
     *                  with relative ease.
     * @param rotation
     * @return encrypted text
     */
	public static String encrypt(String plainText, int rotation) {
		
		if(plainText == null) return null;
		plainText = plainText.toLowerCase();
    	char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    	char [] myCharArray = plainText.toCharArray ();  	
    	
    	for(int i = 0; i <= myCharArray.length - 1; i++){
    		for(int j = 0; j <= letters.length - 1; j++){
    			if(myCharArray [i] == letters [j]){
    				if(j + rotation >= letters.length){
    					if(rotation > letters.length){
    						rotation = rotation % letters.length;
    					}
    		    		myCharArray [i] = letters [j + rotation-letters.length];
    		    		break;
    				}
    					myCharArray [i] = letters [j+rotation];
    					break;
    			}
    			if(myCharArray [i] == ' '|| myCharArray [i] == '?' ){
    			myCharArray [i] = myCharArray [i];
    			break;
        		}
    		}
    	}
    	plainText = String.valueOf(myCharArray);
		plainText = plainText.replaceAll(findMostFrequentlyOccurringLetter(plainText), "");
		if (plainText.equals("")) return "";
        else return plainText;
    }

    /**
     * Finds the most frequently occurring letter in text.
     * @param text either plain or encrypted text.
     * @return the most frequently occurring letter in text.
     */
    public static String findMostFrequentlyOccurringLetter(String text) {
    
    	
    	if(text == null) return null;
    	String occurringLetter = "";
    	int m = 0,n = 0,k = 0;

    	text = text.toLowerCase();
    	char [] myCharArray = text.toCharArray ();
    	for(int i = 0; i <= myCharArray.length - 1; i++, n = 0){
    		for(int j = 0; j <= myCharArray.length - 1; j++, m = 0){
    			if(myCharArray [i] == myCharArray [j]){
    			m++;
    			n += m;
    			}
    		
    		if(n > k){
    			k += n;
    			occurringLetter = String.valueOf(myCharArray[i]);	
    		}
    		}
    	}
    	
    	if(occurringLetter.equals("")) return "";
        else return occurringLetter;
    }
 
    /**
     * Removes the most prevalent letter from text.
     * @param text either plain or encrypted text.
     * @return text in which the most prevalent letter has been removed.
     */
    public static String minimizeText(String text) {
    	
    	if(text == null) return null;
    	String occurringLetter = "";
    	int m = 0,n = 0,k = 0;

    	text = text.toLowerCase();
    	char [] myCharArray = text.toCharArray ();
    	for(int i = 0; i <= myCharArray.length - 1; i++, n = 0){
    		for(int j = 0; j <= myCharArray.length - 1; j++, m = 0){
    			if(myCharArray [i] == myCharArray [j]){
    			m++;
    			n += m;
    			}
    		
    		if(n >= k){
    			k += n;
    			occurringLetter = String.valueOf(myCharArray[i]);	
    		}
    		}
    	}
    	text = text.replaceAll(occurringLetter, "");
		
    	
    	if(occurringLetter.equals("")) return "";
        else return text;
       
    }
 
    /**
     * Given the initial rotation and the encrypted text, this method
     * decrypts said text.
     * @param cryptoText Encrypted text.   
     * @param rotation How many letters to the right the alphabet was
     *                 shifted in order to encrypt text.
     * @return Decrypted text.
     */
    public static String decrypt(String cryptoText, int rotation) {
    	
    	if(cryptoText == null) return null;
    	char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    	cryptoText = cryptoText.toLowerCase();
    	char [] myCharArray = cryptoText.toCharArray ();

    	for(int i = 0; i <= myCharArray.length - 1; i++){
    		for(int j = 0; j <= letters.length - 1; j++){
    			if(myCharArray [i] == letters [j]){
    				if(j - rotation <= -1){
    	    			myCharArray [i] = letters [j - rotation + letters.length];
    	    			break;
    	    			}
    					myCharArray [i] = letters [j - rotation];
    	    			break;
    			}
    			
    			if(myCharArray [i] == ' '|| myCharArray [i] == '?' ){
    			myCharArray [i] = myCharArray [i];
    			break;
    			}	
    		}
    	}
    	cryptoText = String.valueOf(myCharArray);
        
    	
        if(cryptoText.equals("")) return "";
        else return cryptoText;
    }
    

 
    /**
     * The main method, which is the entry point of the program.
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        System.out.println(encrypt("you too Brutus?", 26)); // => zv u csvuvt? 
        // (both u and o appear 3 times, o comes earlier in alphabet)
        System.out.println(decrypt("zpv upp csvuvt?", 1)); // => you too brutus?
        System.out.println(findMostFrequentlyOccurringLetter("you too Brutus?")); // => o
        System.out.println(minimizeText("you too Brutus?")); // yu t brutus?
    }
}