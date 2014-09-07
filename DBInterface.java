import java.util.ArrayList;

public interface DBInterface {

	public boolean insertData(int chestNo);

	/*
	 * Chest Number of each participant is accepted and inserted into the first
	 * table
	 */

	public boolean insertData(int chestNo, String firstName, String lastName);

	/*
	 * Chest Number, First Name and Last Name of each participant is accepted
	 * and inserted into the first table
	 */

	public boolean insertData(int chestNo, String firstName, String lastName,
			String imagePath);

	/*
	 * Chest Number, First Name, Last Name and the Image Path of each
	 * participant is accepted and inserted into the first table
	 */

	public boolean insertTimings1(int chestNo, ArrayList<Float> lapTimings);

	/*
	 * The Lap Timings related to category 1 of each Participant or the chest number is
	 * inserted into the second table. The Lap Timings is accepted as an Array
	 * List
	 */

	public boolean insertTimings2(int chestNo, ArrayList<Float> lapTimings);

	/*
	 * The Lap Timings related to category 2 of each Participant or the chest number is
	 * inserted into the second table. The Lap Timings is accepted as an Array
	 * List
	 */

	public boolean insertTimings3(int chestNo, ArrayList<Float> lapTimings);

	/*
	 * The Lap Timings related to category 3 each Participant or the chest number is
	 * inserted into the second table. The Lap Timings is accepted as an Array
	 * List
	 */

	public ArrayList<Float> getResult3();

	/*
	 * Returns the sorted list of the participants based on the lap timings for
	 * 3 KM race.
	 */

	public ArrayList<Float> getResult5();

	/*
	 * Returns the sorted list of the participants based on the lap timings for
	 * 5 KM race.
	 */

	public ArrayList<Float> getResult10();

	/*
	 * Returns the sorted list of the participants based on the lap timings for
	 * 10 KM race.
	 */

}
