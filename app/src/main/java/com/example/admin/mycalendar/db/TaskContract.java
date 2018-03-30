package com.example.admin.mycalendar.db;

import android.provider.BaseColumns;

/**
 * Created by admin on 6/10/2017.
 */

public class TaskContract {

    private String taskName;
    private int status;
    private int id;
    private String date;
    private String created_at;

    //constructors

    public TaskContract()
    {
        this.taskName = null;
        this.status = 0;
    }

    public TaskContract(String taskName, int status)
    {
        super();
        this.taskName = taskName;
        this.status = status;
    }

    public TaskContract(int id, String taskName, int status)
    {
        this.id = id;
        this.taskName = taskName;
        this.status = status;
    }

    public int  getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDate(){return date;}

    public void setDate(String date){this.date = date;}

    public String getCreatedAt()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }
}
