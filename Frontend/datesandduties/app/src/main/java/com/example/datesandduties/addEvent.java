package com.example.datesandduties;

import androidx.appcompat.app.AppCompatActivity;
import com.example.datesandduties.dates;
import com.example.datesandduties.net_utils.Const;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class addEvent extends Activity implements View.OnClickListener{

    private EditText inputDate, inputTitle, inputTime, inputDesc;
    private Button addEvent;
    private TextView outError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        inputDate = (EditText) findViewById(R.id.inputDate);
        inputDate.setText(dates.displayDate());
        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputTime= (EditText) findViewById(R.id.inputTime);
        inputDesc = (EditText) findViewById(R.id.inputDescription);

        addEvent = (Button) findViewById(R.id.sendEvent);

        outError = (TextView) findViewById(R.id.errorOut);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sendEvent:
                checkInputs();
                break;

        }
    }



    public void checkInputs(){

        String title, description, date, time;


        title = inputTitle.getText().toString();
        description = inputDesc.getText().toString();
        date = inputDate.getText().toString();
        time = inputTime.getText().toString();

        if(title.isEmpty()){
            outError.setText("Please insert a valid title");
        }
        else if(description.isEmpty()){
            outError.setText("Please enter a description");
        }
        else if(date.isEmpty()){
            outError.setText("Please enter a date");
        }
        else if(time.isEmpty()) {
            outError.setText("please enter time of event.");
        }

        //other stuff that checks if date and time are valid based on inputs to backend;
        else{
            outError.setText("Valid inputs Event will be created" + date);

            String suffix = "?owner=" + sign_in_page.getUsername()
                    +"&title=" + title
                    +"&description=" + description
                    +"&date=" + date
                    +"&time=" + time;
            suffix = Const.ADD_EVENT + suffix; //request out for adding event





        }


    }


}