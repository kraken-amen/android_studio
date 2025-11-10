package com.example.project2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.CheckBox;
import android.widget.CompoundButton ;
import android.widget.ToggleButton ;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup1);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linear);
        final EditText Login;
        final Button b1;
        Login = (EditText) findViewById(R.id.editTextText);
        b1 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast msg = Toast.makeText(getBaseContext(), Login.getText().toString(), Toast.LENGTH_LONG);
                msg.show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final ToggleButton tb;
        tb = (ToggleButton) findViewById(R.id.toggleButton1);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast msg = Toast.makeText(getBaseContext(), "Toggle Button is checked", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(this);
        }
    public void Traitementcheckbox (View v)
    {
        CheckBox cb, cb1 ;
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb1 = (CheckBox) findViewById(R.id.checkBox2);
        if (cb.isChecked())
        {
            Toast msg = Toast.makeText(getBaseContext(),"la case windows est cochée", Toast.LENGTH_SHORT);
            msg.show();
        }
        if (cb1.isChecked())
        {
            Toast msg = Toast.makeText(getBaseContext(),"la case Linux est cochée", Toast.LENGTH_SHORT);
            msg.show();
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radio0) {
            Toast.makeText(getBaseContext(), "Radio Button rouge is checked", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.radio1) {
            Toast.makeText(getBaseContext(), "Radio Button vert is checked", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.radio2) {
            Toast.makeText(getBaseContext(), "Radio Button bleu is checked", Toast.LENGTH_SHORT).show();
        }
    }
}