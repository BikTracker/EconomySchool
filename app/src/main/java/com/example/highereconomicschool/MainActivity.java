package com.example.highereconomicschool;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String from = "Russia";
    String in = "USA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button from_Button = findViewById(R.id.From_Flags_Button);
        final Button to_button = findViewById(R.id.To_Flags_Button);
        final Button solve = findViewById(R.id.button3);
        final EditText from_EditText = findViewById(R.id.From_EditText);
        from_EditText.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        final TextView to_tv = findViewById(R.id.To_TextView);

        from_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from.equals("Russia")){
                    from_Button.setBackgroundResource(R.drawable.ic_flag_of_the_united_states);
                    to_button.setBackgroundResource(R.drawable.ic_flag_of_russia);
                    from = "USA";
                    in = "Russia";
                }
                else{
                    from_Button.setBackgroundResource(R.drawable.ic_flag_of_russia);
                    to_button.setBackgroundResource(R.drawable.ic_flag_of_the_united_states);
                    from = "Russia";
                    in = "USA";
                }
            }
        });

        to_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in.equals("Russia")){
                    from_Button.setBackgroundResource(R.drawable.ic_flag_of_the_united_states);
                    to_button.setBackgroundResource(R.drawable.ic_flag_of_russia);
                    in = "USA";
                    from = "Russia";
                }
                else{
                    from_Button.setBackgroundResource(R.drawable.ic_flag_of_russia);
                    to_button.setBackgroundResource(R.drawable.ic_flag_of_the_united_states);
                    in = "Russia";
                    from = "Russia";
                }
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double from_double = 0;
                try {
                    from_double = Double.parseDouble(from_EditText.getText().toString());
                }
                catch (NumberFormatException e){
                    to_tv.setText("0.00");
                    from_EditText.setText("0.00");
                }
                if(from.equals("USA")) to_tv.setText(Double.toString(from_double * 74));
                else to_tv.setText(Double.toString(from_double / 74));
            }
        });

    }

}
