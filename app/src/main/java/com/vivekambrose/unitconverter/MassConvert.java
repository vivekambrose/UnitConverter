package com.vivekambrose.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MassConvert extends AppCompatActivity {
    NumberPicker massFrom;
    NumberPicker massTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_convert);
        String[] units = {
                "kg",
                "gram",
                "lb",
                "oz"

        };
        massFrom = (NumberPicker) findViewById(R.id.numberPicker_MassFrom);
        massFrom.setDisplayedValues(units);
        massFrom.setMinValue(0);
        massFrom.setMaxValue(units.length - 1);

        massTo = (NumberPicker) findViewById(R.id.numberPicker_MassTo);
        massTo.setDisplayedValues(units);
        massTo.setMinValue(0);
        massTo.setMaxValue(units.length - 1);



    }

    public void convert(View view) {
        TextView result = (TextView) findViewById(R.id.textView_MassResult);
        EditText input_mass = (EditText) findViewById(R.id.editText_inputMass);
        double value;

        try {
            value = Double.parseDouble(input_mass.getText().toString());
        }
        catch (Exception e){
            value = 0;
        }
        double output;
        DecimalFormat formatVal = new DecimalFormat("##.####");

        int from = massFrom.getValue();
        int to = massTo.getValue();
        if (value == 0){
            Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_SHORT).show();
        }
        else{

            if (from == 0) {
                if (to == 0) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 1000;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 2.205;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 35.274;
                    result.setText(formatVal.format(output));
                }

            }
            else if (from == 1) {
                if (to == 0) {
                    output = value / 1000;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value / 453.592;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value / 28.3495;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 2) {
                if (to == 0) {
                    output = value * 0.453592;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 453.592;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 16;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 3) {
                if (to == 0) {
                    output = value / 35.274;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 28.3495;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value / 16;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value;
                    result.setText(formatVal.format(output));
                }
            }
        }

    }
}