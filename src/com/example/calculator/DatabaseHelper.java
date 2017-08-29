package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	public static final String  DATABASE_NAME="calculator.db";
	public static final String  TABLE_NAME="calculator_table";
	public static final String  COL_1="ID";
	public static final String  COL_2="VALUE1";
	public static final String  COL_3="CHAR";
	public static final String  COL_4="VALUE2";
	public static final String  COL_5="RESULT";
	
	

	public DatabaseHelper(Context context) {
		super(context,DATABASE_NAME , null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table  " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,VALUE1 REAL,CHAR TEXT,VALUE2 REAL,RESULT REAL)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
		onCreate(db);
		
	}
	
	public boolean insertData(String value1 ,String symbol,String value2,String result){
		SQLiteDatabase db= this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();
		contentValues.put(COL_2, value1);
		contentValues.put(COL_3, symbol);
		contentValues.put(COL_4, value2);
		contentValues.put(COL_5, result);
		long resultn=db.insert(TABLE_NAME, null, contentValues);
		if(resultn == -1){
			return false;
		}
		else 
			return true;
	}
	public Cursor getAllData(){
		SQLiteDatabase db= this.getWritableDatabase();
		Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
//		res.moveToLast();
		return res;
	}
	
	public Integer deleteData(String id){
		SQLiteDatabase db= this.getWritableDatabase();
		return db.delete(TABLE_NAME,"ID = ?" , new String [] {id});
		
	}
	/*
	public boolean updateData(String id,String value1,String symbol,String value2,String result){
		SQLiteDatabase db= this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();
		contentValues.put(COL_1, id);
		contentValues.put(COL_2, value1);
		contentValues.put(COL_3, symbol);
		contentValues.put(COL_4, value2);
		contentValues.put(COL_5, result);
		db.update(TABLE_NAME,contentValues, "ID = ?" , new String [] {id});
		return true;
		
		
	}*/

}
