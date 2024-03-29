import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper implements DBInterface {

	private static final String DATABASE_NAME = "Lapometer.db";
	private static final int DATABASE_VERSION = 1;

	public DBClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		// @Override
		db.execSQL("CREATE TABLE IF NOT EXISTS participant(chestNo int primary key, firstName String, lastName String, imagePath String, categoryNo int)");
		db.execSQL("CREATE TABLE IF NOT EXISTS category1(chestNo int, float lap1, float lap2,float lap3, FOREIGN KEY(chestNo) REFERENCES participant(chestNo),)");
		db.execSQL("CREATE TABLE IF NOT EXISTS category2(chestNo int, float lap1, float lap2,float lap3, float lap4, float lap5, FOREIGN KEY(chestNo) REFERENCES participant(chestNo))");
		db.execSQL("CREATE TABLE IF NOT EXISTS category3(chestNo int, float lap1, float lap2,float lap3, float lap4, float lap5, float lap6, float lap7, float lap8, float lap9, float lap10, FOREIGN KEY(chestNo) REFERENCES participant(chestNo))");

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// no body
	}

	public boolean insertData(int chestNo) {
		// TODO Auto-generated method stub

		// Chest Number of each participant is accepted and inserted into the
		// first table

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);

		db.insert("participant", null, contentValues);
		return true;

	}

	@Override
	public boolean insertData(int chestNo, String firstName, String lastName) {
		// TODO Auto-generated method stub

		// Chest Number, First Name, Last Name and the Image Path of each
		// participant is accepted and inserted into the first table

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);
		contentValues.put("firstName", firstName);
		contentValues.put("lastName", lastName);

		db.insert("participant", null, contentValues);
		return true;

	}

	@Override
	public boolean insertData(int chestNo, String firstName, String lastName,
			String imagePath) {
		// TODO Auto-generated method stub

		// The Lap Timings related to each Participant or the chest number is
		// inserted into the second table. The Lap Timings is accepted as an
		// Array List

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);
		contentValues.put("firstName", firstName);
		contentValues.put("lastName", lastName);
		contentValues.put("imagePath", imagePath);

		db.insert("participant", null, contentValues);
		return true;

	}

	@Override
	public boolean insertTimings1(int chestNo, ArrayList<Float> lapTimings) {
		// TODO Auto-generated method stub

		// The Lap Timings related to category 1 of each Participant or the
		// chest number is inserted into the second table. The Lap Timings is
		// accepted as an Array List

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);
		contentValues.put("lap1", lapTimings.get(0));
		contentValues.put("lap2", lapTimings.get(1));
		contentValues.put("lap3", lapTimings.get(2));

		db.insert("category1", null, contentValues);

		String strSQL = "UPDATE participant SET categoryNo = 3 WHERE chestNo = "
				+ chestNo;

		db.execSQL(strSQL);
		return true;

	}

	@Override
	public boolean insertTimings2(int chestNo, ArrayList<Float> lapTimings) {
		// TODO Auto-generated method stub

		// The Lap Timings related to category 2 of each Participant or the
		// chest number is inserted into the second table. The Lap Timings is
		// accepted as an Array List

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);
		contentValues.put("lap1", lapTimings.get(0));
		contentValues.put("lap2", lapTimings.get(1));
		contentValues.put("lap3", lapTimings.get(2));
		contentValues.put("lap4", lapTimings.get(3));
		contentValues.put("lap5", lapTimings.get(4));

		db.insert("category2", null, contentValues);

		String strSQL = "UPDATE participant SET categoryNo = 5 WHERE chestNo = "
				+ chestNo;

		db.execSQL(strSQL);

		return true;

	}

	@Override
	public boolean insertTimings3(int chestNo, ArrayList<Float> lapTimings) {
		// TODO Auto-generated method stub

		// The Lap Timings related to category 3 of each Participant or the
		// chest number is inserted into the second table. The Lap Timings is
		// accepted as an Array List

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put("chestNo", chestNo);
		contentValues.put("lap1", lapTimings.get(0));
		contentValues.put("lap2", lapTimings.get(1));
		contentValues.put("lap3", lapTimings.get(2));
		contentValues.put("lap4", lapTimings.get(3));
		contentValues.put("lap5", lapTimings.get(4));
		contentValues.put("lap6", lapTimings.get(5));
		contentValues.put("lap7", lapTimings.get(6));
		contentValues.put("lap8", lapTimings.get(7));
		contentValues.put("lap9", lapTimings.get(8));
		contentValues.put("lap10", lapTimings.get(9));

		db.insert("category3", null, contentValues);

		String strSQL = "UPDATE participant SET categoryNo = 10 WHERE chestNo = "
				+ chestNo;

		db.execSQL(strSQL);

		return true;

	}

	@Override
	public ArrayList<Float> individualResult(int chestNo) {

		ArrayList<Float> individual_lap_timings = new ArrayList<Float>();
		try {
			Cursor c = null;
			SQLiteDatabase db = this.getReadableDatabase();
			c = db.rawQuery(
					"SELECT categoryNo from participant where chestNo = "
							+ chestNo, null);
			c.moveToFirst();
			// int catNo = c.getInt(c.getColumnIndex(categoryNo),null);
			int catNo = c.getInt(1);

			c = null;
			if (catNo == 3) {
				c = db.rawQuery(
						"SELCT lap1,lap2,lap3 from category3 where chestNo = "
								+ chestNo, null);
				c.moveToFirst();

				// individual_lap_timings.add(c.getInt((i+1)));
				individual_lap_timings.add(c.getFloat(1));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(2));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(3));
				// c.moveToNext();

			} else if (catNo == 5) {

				c = db.rawQuery(
						"SELCT lap1,lap2,lap3 from category2 where chestNo = "
								+ chestNo, null);
				c.moveToFirst();

				// individual_lap_timings.add(c.getInt((i+1)));
				individual_lap_timings.add(c.getFloat(1));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(2));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(3));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(4));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(5));

			} else if (catNo == 10) {
				c = db.rawQuery(
						"SELCT lap1,lap2,lap3 from category3 where chestNo = "
								+ chestNo, null);
				c.moveToFirst();

				// individual_lap_timings.add(c.getInt((i+1)));
				individual_lap_timings.add(c.getFloat(1));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(2));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(3));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(4));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(5));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(6));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(7));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(8));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(9));
				c.moveToNext();
				individual_lap_timings.add(c.getFloat(10));
			}

		}

		catch (Exception e) {
			// body
		}

		return individual_lap_timings;

	}

	@Override
	public ArrayList<Float> getResult3() {
		// TODO Auto-generated method stub

		// Returns the sorted list of the participants based on the lap timings
		// for 3 KM race.

		ArrayList<Float> result3 = new ArrayList<Float>();
		try {
			Cursor c = null;
			SQLiteDatabase db = this.getReadableDatabase();
			c = db.rawQuery("SELECT * from category1", null);
			c.moveToFirst();

			while (c.moveToNext()) {
				result3.add(c.getFloat(0));
			}
			c.close();
		}

		catch (Exception e) {
			// body
		}

		return result3;
	}

	@Override
	public ArrayList<Float> getResult5() {
		// TODO Auto-generated method stub

		// Returns the sorted list of the participants based on the lap timings
		// for 5 KM race.

		ArrayList<Float> result5 = new ArrayList<Float>();
		try {
			Cursor c = null;
			SQLiteDatabase db = this.getReadableDatabase();
			c = db.rawQuery("SELECT * from category2", null);
			c.moveToFirst();

			while (c.moveToNext()) {
				result5.add(c.getFloat(0));
			}
			c.close();
		}

		catch (Exception e) {
			// body
		}

		return result5;

	}

	@Override
	public ArrayList<Float> getResult10() {
		// TODO Auto-generated method stub

		// Returns the sorted list of the participants based on the lap timings
		// for 10 KM race.

		ArrayList<Float> result10 = new ArrayList<Float>();
		try {
			Cursor c = null;
			SQLiteDatabase db = this.getReadableDatabase();
			c = db.rawQuery("SELECT * from category3", null);
			c.moveToFirst();

			while (c.moveToNext()) {
				result10.add(c.getFloat(0));
			}
			c.close();
		}

		catch (Exception e) {
			// body
		}

		return result10;

	
	}

}
