/**
 * Home assignment 01.
 */
public class EX01 {
    /**
     * Entry-point of the program.
     * This is here so you can test out your code
     * with running this program.  
     * @param args Arguments from command-line.   
     */
    public static void main(String[] args) {
        System.out.println(getCustomerGreeting("Alice")); // => Hello Alice, nice to see you!
        System.out.println(getPriceOfCandies(5, 4.5)); // => 22.5
    }
 
    /**
     * Function that greets a customer by it's name
     * @param customerName The customer's name to greet
     * @return Greeting to the customer like Hello {customerName}, nice to see you!
     */
    public static String getCustomerGreeting(String customerName) {
       String greeting = "Hello " + customerName + ", nice to see you!";//Add your code here
        return greeting;
    }
 
    /**
     * Function that returns the total cost of candies
     * @param amount Amount of candies to buy
     * @param price Price of one candy
     * @return Total cost of the candies
     */
    public static double getPriceOfCandies(int amount, double price) {
       
        return amount*price;
    }
}