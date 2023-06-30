package com.sfiso.collegeediary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CollegeDiaryTable {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public CollegeDiaryTable(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void openDB()
    {
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }

    public void insertRecord(String strTitle, int intSemesterNo, String strEDescription, String strFtasks, String eDate)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_Entry_Title, strTitle);
        contentValues.put(DBHelper.strColumn_Semester, intSemesterNo);
        contentValues.put(DBHelper.strColumn_Entry_Description, strEDescription);
        contentValues.put(DBHelper.strColumn_future_tasks, strFtasks);
        contentValues.put(DBHelper.strColumn_Date, eDate);
        sqLiteDatabase.insert(DBHelper.strTable_DName, null, contentValues);
    }

    public Cursor getAllRecords()
    {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DBHelper.strTable_DName, null);
    }

    public void updateRecord(String strDiaryID, String strEntry, int intSemesterNo, String strDiaryDate, String strFutureTasks)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_Entry_Title, strEntry);
        contentValues.put(DBHelper.strColumn_Semester, intSemesterNo);
        contentValues.put(DBHelper.strColumn_Entry_Description, strDiaryDate);
        contentValues.put(DBHelper.strColumn_future_tasks, strFutureTasks);
        sqLiteDatabase.update(dbHelper.strTable_DName, contentValues, strDiaryID + "=" +dbHelper.strColumn_DiaryId, null);
    }
}
