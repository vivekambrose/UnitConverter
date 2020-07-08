package com.vivekambrose.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Class type_choice = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup_unitType = (RadioGroup) findViewById(R.id.radioGroup_units);

        radioGroup_unitType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radioButton_length:{
                        type_choice = LengthConvert.class;
                        break;
                    }
                    case R.id.radioButton_mass:{
                        type_choice = MassConvert.class;
                        break;
                    }
                    case R.id.radioButton_area:{
                        type_choice = AreaConvert.class;
                        break;
                    }
                    case R.id.radioButton_volume:{
                        type_choice = VolumeConvert.class;
                        break;
                    }

                }

            }

        });



    }

    public void go(View v) {
     if (type_choice == null){
         Toast.makeText(getApplicationContext(), "Select an option", Toast.LENGTH_SHORT).show();
     }
     else{
         Intent goToType = new Intent();
         goToType.setClass(this, type_choice);
         startActivity(goToType);
     }
    }
}