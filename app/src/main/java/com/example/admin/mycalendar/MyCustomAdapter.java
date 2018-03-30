package com.example.admin.mycalendar;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.admin.mycalendar.db.TaskContract;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 7/1/2017.
 */

public class MyCustomAdapter extends ArrayAdapter<TaskContract>
{
    Context context;
    int layoutintResource;
    ArrayList<TaskContract> taskList = null;

    public MyCustomAdapter(Context context, int resource, ArrayList<TaskContract> taskObjects)
    {
        super(context, resource, taskObjects);
        this.context = context;
        this.layoutintResource = resource;
        this.taskList = taskObjects;
    }


    public View getView(int position, View convertView, ViewGroup parent)
    {
        TaskContract current = taskList.get(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_inner_view, parent,false);
        }

        TextView task = (TextView)convertView.findViewById(R.id.taskText);
        CheckBox chkbStatus = (CheckBox)convertView.findViewById(R.id.status);
        ImageButton delete = (ImageButton)convertView.findViewById(R.id.deleteTask);

        task.setText(current.getTaskName());
        chkbStatus.setChecked(current.getStatus() == 1 ? true : false);



        return convertView;
    }
}
