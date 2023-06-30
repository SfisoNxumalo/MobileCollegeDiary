package com.sfiso.collegeediary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String strDB_Name = "CollegeDiaryDB";
    private static final int intDB_Version = 1;

    public static final String strTable_DName = "collegeDiary";
    public static final String strColumn_DiaryId ="ID";
    public static final String strColumn_Entry_Title = "title";
    public static final String strColumn_Semester = "semesterNo";
    public static final String strColumn_future_tasks = "futureTasks";
    public static final String strColumn_Entry_Description = "description";
    public static final String strColumn_Date = "dateOfEntry";

    String strCreate_TableCMD = "Create table" + " " + strTable_DName + "(" + strColumn_DiaryId + " " + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + strColumn_Entry_Title + " " + "text," + strColumn_Semester + " " + "INTEGER," + strColumn_Entry_Description + " "
            + "text," + strColumn_future_tasks + " " + "text," + strColumn_Date + " " + "text)";

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase)
    {
        sqliteDatabase.execSQL(strCreate_TableCMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }

    public DBHelper (Context context)
    {
        super(context, strDB_Name, null, intDB_Version);
    }
}
