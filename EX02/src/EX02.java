public class EX02 {
	
	/**
	 * Constant.
	 * Every 3   days, feed worms.
	 */
	public static final int WORM_FEEDING_DAY = 3;

 
	/**
	 * Constant.
	 * Every 5 days, bathe in sand.
	 */
	public static final int BATHING_DAY = 5;
 
	/**
	 * Constant.
	 * Total number of days for which instructions are needed.
	 */
	public static final int NUMBER_OF_DAYS = 30;
 
	/**
	 * Entry point of the program.
	 * @param args Arguments from command line.
	 */
	public static void main(String[] args) {
			for(int i = 1; i <= NUMBER_OF_DAYS; i++)
			{	
				System.out.println(getInstructionForCurrentDay(i));
			}
	
	}
	/**
	 * Return instruction for given day.
	 * @param currentDay number of day to print instructions for.
	 */
	public static String getInstructionForCurrentDay(int currentDay) {
		String m = "";
		if( currentDay % WORM_FEEDING_DAY == 0 ) m = "feed worms";
		if( currentDay % BATHING_DAY == 0 ) m = "bathe in sand";
		if( currentDay % WORM_FEEDING_DAY == 0 && currentDay % BATHING_DAY == 0 ) m = "glide in wind";
		if( currentDay % WORM_FEEDING_DAY != 0 && currentDay % BATHING_DAY != 0 ) m = "give fruit and water";
		if( currentDay < 1 ) m = "Can't fly back in time";
		
		m = "Day " + currentDay + ": " + m;
		
		return m;
	}
}