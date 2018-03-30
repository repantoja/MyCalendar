package com.example.admin.mycalendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mycalendar.db.DatabaseHelper;
import com.example.admin.mycalendar.db.TaskContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 6/8/2017.
 */


public class TodoActivity extends Activity
{
   // ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private TextView theDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);
        theDate = (TextView)findViewById(R.id.date);
        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);
        /*generateListView(date);
        addTask(date); */



    }
}



/*public class TodoActivity extends AppCompatActivity{
    private TextView theDate;
    private String taskItem;
    private static final String TAG = "TodoActivity";
    private DatabaseHelper dbHelper;
    ImageButton addButton;
    EditText textItem;
    MyAdapter adapt;
    List<TaskContract> list;



    public void generateListView(String date)
    {
        dbHelper = new DatabaseHelper(this);
        list = dbHelper.getTask(date);
       // list = dbHelper.getAllTasks();
        //adapt = new MyAdapter(this,list, R.layout.list_inner_view);
        //ListView listTask = (ListView)findViewById(R.id.TaskView);
        //listTask.setAdapter(adapt);
    }

    //this method gets date and execute onclick listener to enter the task
    public void addTask(final String date)
    {
        addButton = (ImageButton)findViewById(R.id.btnAddItem);
        textItem = (EditText)findViewById(R.id.newTask);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                taskItem = textItem.getText().toString();
                if (taskItem.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter a Task", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Log.d(TAG, taskItem);
                    Log.d(TAG, date);
                    textItem.setText("");
                    addToDB(taskItem, date);
                    generateListView(date);
                }
            }

        });
    }


    //Add task to database
    public void addToDB(String taskName, String date)
    {
        TaskContract task = new TaskContract();
        task.setTaskName(taskName);
        task.setDate(date);
       boolean addData = dbHelper.addTask(task);

        if (addData == true)
        {
            Toast.makeText(TodoActivity.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(TodoActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }

    //Array adapter to populate list view
  /*  private class MyAdapter extends ArrayAdapter<TaskContract> {

        Context context;
        List<TaskContract> taskList = new ArrayList<TaskContract>();
        int layoutResourceId;

        public MyAdapter(Context context, List<TaskContract> objects,
                         int layoutResourceId) {
            super(context, layoutResourceId, objects);
            this.layoutResourceId = layoutResourceId;
            this.taskList = objects;
            this.context = context;
        }


        //Method define the view inside the list view
        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            /*
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.list_inner_view, parent, false);
            final CheckBox chk = (CheckBox)rowView.findViewById(R.id.status);
            final TextView taskText = (TextView)rowView.findViewById(R.id.taskText);
            ImageButton delete = (ImageButton)rowView.findViewById(R.id.deleteTask);
            final TaskContract current = taskList.get(position);
            taskText.setText(current.getTaskName());
            chk.setChecked(current.getStatus() == 1 ? true : false);
            delete.setTag(position);

            //handle check button
            chk.setOnClickListener(new  View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                    String textValue = String.valueOf(taskText.getText());
                    int newStatus = 0;
                    TaskContract task = new TaskContract(textValue, newStatus);
                    if (chk.isChecked())                    {

                        newStatus = 1;
                        task.setStatus(newStatus);
                        task.setTaskName(textValue);
                        view.setBackgroundColor(Color.GREEN);
                        dbHelper.updateStatus(task);
                        Toast.makeText(TodoActivity.this, "Item Completed", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        newStatus = 0;
                        task.setStatus(newStatus);
                        task.setTaskName(textValue);
                        view.setBackgroundColor(Color.TRANSPARENT);
                        dbHelper.updateStatus(task);
                        Toast.makeText(TodoActivity.this, "Item Not Completed", Toast.LENGTH_SHORT).show();
                    }


                }
            });


            //handle delete button actions
            delete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Integer index = (Integer) view.getTag();
                    View parent = (View)view.getParent();
                    TextView task = (TextView)parent.findViewById(R.id.taskText);
                    String taskName = String.valueOf(task.getText());

                    dbHelper.deleteTask(taskName);
                    taskList.remove(position);
                    adapt.notifyDataSetChanged();
                    Toast.makeText(TodoActivity.this, "Item Deleted!", Toast.LENGTH_SHORT).show();
                }
            });

            return rowView;
        }
    }






}*/


