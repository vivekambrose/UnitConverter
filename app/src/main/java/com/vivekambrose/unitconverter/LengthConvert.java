package com.vivekambrose.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class LengthConvert extends AppCompatActivity {
    NumberPicker lengthFrom;
    NumberPicker lengthTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convert);
        String[] units = {
                "meter",
                "cm",
                "in",
                "feet"

        };
        lengthFrom = (NumberPicker) findViewById(R.id.numberPicker_LengthFrom);
        lengthFrom.setDisplayedValues(units);
        lengthFrom.setMinValue(0);
        lengthFrom.setMaxValue(units.length - 1);

        lengthTo = (NumberPicker) findViewById(R.id.numberPicker_LengthTo);
        lengthTo.setDisplayedValues(units);
        lengthTo.setMinValue(0);
        lengthTo.setMaxValue(units.length - 1);



    }

    public void convert(View view) {
        TextView result = (TextView) findViewById(R.id.textView_LengthResult);
        EditText input_mass = (EditText) findViewById(R.id.editText_inputLength);
        double value;

        try {
            value = Double.parseDouble(input_mass.getText().toString());
        }
        catch (Exception e){
            value = 0;
        }
        double output;
        DecimalFormat formatVal = new DecimalFormat("##.####");

        int from = lengthFrom.getValue();
        int to = lengthTo.getValue();
        if (value == 0){
            Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_SHORT).show();
        }
        else{
            if (from == 0) {
                if (to == 0) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 100;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 39.37;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 3.28084;
                    result.setText(formatVal.format(output));
                }

            }
            else if (from == 1) {
                if (to == 0) {
                    output = value / 100;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 0.393701;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 0.032808;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 2) {
                if (to == 0) {
                    output = value / 39.37;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value / 0.393701;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value / 12;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 3) {
                if (to == 0) {
                    output = value / 3.28084;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value / 0.032808;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 12;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value;
                    result.setText(formatVal.format(output));
                }
            }
        }

    }
}