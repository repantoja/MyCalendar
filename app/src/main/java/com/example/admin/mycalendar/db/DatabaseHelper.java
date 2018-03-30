package com.example.admin.mycalendar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 6/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "taskdb";
    private static final int DATABASE_VERSION = 3;
    private static final String tag = "DatabaseHelper";

    //tasks table name
    private static final String TABLE_NAME = "tasks";

    //tasks table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TASKNAME = "taskName";
    private static final String KEY_STATUS = "status";
    private static final String KEY_DATE = "date";
    private static final String[] COLUMNS = {KEY_TASKNAME,KEY_STATUS,KEY_DATE,KEY_ID};

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(tag, "created");

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String Create_query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_TASKNAME + " TEXT, "
                + KEY_STATUS + " INTEGER, "
                + KEY_DATE + " TEXT );";
        db.execSQL(Create_query);
        Log.d("table1", "created table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV)
    {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create tables again
        onCreate(db);
    }

    //Add a new row to the database
    public boolean addTask(TaskContract task)
    {
        ContentValues values = new ContentValues();

        values.put(KEY_TASKNAME, task.getTaskName());
        values.put(KEY_STATUS, task.getStatus());
        values.put(KEY_DATE, task.getDate());
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }


    }

    //Delete a task from db
    public void deleteTask(String taskName)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, KEY_TASKNAME +"='"+taskName+"'",null);
    }

    // get all tasks
    public List<TaskContract> getAllTasks()
    {

        List<TaskContract> taskList = new ArrayList<TaskContract>();
        // 1. build the query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        // 2. get reference to writable db.
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // 3. go over each row, build task.

        if (cursor.moveToFirst())
        {
            do {
                TaskContract task = new TaskContract();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setTaskName(cursor.getString(1));
                task.setStatus(cursor.getInt(2));
                task.setDate(cursor.getString(3));


                //add to task
                taskList.add(task);
            }

            //add data to list

            while (cursor.moveToNext());
        }

        Log.d("getAllTask()", taskList.toString());
        //return the list
        return taskList;
    }

    //update task status

    public void updateTask(TaskContract task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TASKNAME, task.getTaskName());
        values.put(KEY_STATUS, task.getStatus());
        db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]
                {
                        String.valueOf(task.getId())
                });
    }

    public void updateStatus(TaskContract task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("status", task.getStatus());
        String whereClause = "taskName=?";
        String WhereArgs[] ={task.getTaskName().toString()};

        db.update(TABLE_NAME, value, whereClause, WhereArgs);


    }

    // get task by day

    public List<TaskContract> getTask(String date)
    {

        List<TaskContract> taskList = new ArrayList<TaskContract>();
        // 1. reference to database
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query

        Cursor cursor =
                db.query(TABLE_NAME, // a. table
                        COLUMNS, // b. column names
                        KEY_DATE // c. selections
                        + " = '"+date+"'", // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if there is result get first
        if (cursor.moveToFirst())
        {
            do {
                TaskContract task = new TaskContract();
                task.setTaskName(cursor.getString(0));
                task.setStatus(cursor.getInt(1));
                task.setDate(cursor.getString(2));
                task.setId(cursor.getInt(3));


                //add to task
                taskList.add(task);
            }

            //add data to list

            while (cursor.moveToNext());
        }


               // 4. build object

        return taskList;
    }



}
