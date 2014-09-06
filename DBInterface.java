public interface DBInterface{

	public void insertData (int chestNo)
	{
	/*Chest Number of each participant is accepted and inserted into the first table*/
	}
	
	public void insertData (int chestNo, char firstName, char lastName)
	{
	/*Chest Number, First Name and Last Name of each participant is accepted and inserted into the first table*/
	}
	
	public void insertData (int chestNo, char firstName, char lastName, char imagePath)
	{
	/*Chest Number, First Name, Last Name and the Image Path of each participant is accepted and inserted into the first table*/
	}
	
	public void insertTimings (int chestNo, ArrayList <lapTimings>)
	{
	/*The Lap Timings related to each Participant or the chest number is inserted into the second table. The Lap Timings is accepted as an Array List*/
	}
	
	}
	{
	public ArrayList getResult3()
	{
	/*Returns the sorted list of the participants based on the lap timings for 3 KM race.*/

	public ArrayList getResult5()
	{
	/*Returns the sorted list of the participants based on the lap timings for 5 KM race. */
	}
	
	public ArrayList getResult10()
	{
	/*Returns the sorted list of the participants based on the lap timings for 10 KM race. */
	}
	
}
