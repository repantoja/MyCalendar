package com.example.admin.mycalendar.db;

/**
 * Created by admin on 9/24/2017.
 */

public class Tag {

    int id;
    String tag_name;

    //constructor
    public Tag()
    {

    }

    public Tag(String tag_name)
    {
       super();
       this.tag_name = tag_name;
    }

    public Tag(int id, String tag_name)
    {
        this.id = id;
        this.tag_name = tag_name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTag_name(String tag_name)
    {
        this.tag_name = tag_name;
    }

    public int getId(int id)
    {
        return id;
    }

    public String getTag_name(String tag_name)
    {
        return tag_name;
    }

}
