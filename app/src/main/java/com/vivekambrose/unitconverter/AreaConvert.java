package com.vivekambrose.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class AreaConvert extends AppCompatActivity {
    NumberPicker areaFrom;
    NumberPicker areaTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_convert);
        String[] units = {
                "Sq. meter",
                "Sq. cm",
                "Sq. in",
                "Sq. feet"

        };
        areaFrom = (NumberPicker) findViewById(R.id.numberPicker_AreaFrom);
        areaFrom.setDisplayedValues(units);
        areaFrom.setMinValue(0);
        areaFrom.setMaxValue(units.length - 1);

        areaTo = (NumberPicker) findViewById(R.id.numberPicker_AreaTo);
        areaTo.setDisplayedValues(units);
        areaTo.setMinValue(0);
        areaTo.setMaxValue(units.length - 1);



    }

    public void convert(View view) {
        TextView result = (TextView) findViewById(R.id.textView_AreaResult);
        EditText input_mass = (EditText) findViewById(R.id.editText_inputArea);
        double value;

        try {
            value = Double.parseDouble(input_mass.getText().toString());
        }
        catch (Exception e){
            value = 0;
        }
        double output;
        DecimalFormat formatVal = new DecimalFormat("##.####");

        int from = areaFrom.getValue();
        int to = areaTo.getValue();
        if(value == 0){
            Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_SHORT).show();
        }
        else {
            if (from == 0) {
                if (to == 0) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 10000;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 1550.003;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 10.76391;
                    result.setText(formatVal.format(output));
                }

            }
            else if (from == 1) {
                if (to == 0) {
                    output = value / 10000;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 0.155;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 0.001076;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 2) {
                if (to == 0) {
                    output = value / 1550.003;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value / 0.155;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value / 144;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 3) {
                if (to == 0) {
                    output = value / 10.76391;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value / 0.001076;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value * 144;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value;
                    result.setText(formatVal.format(output));
                }
            }
        }

    }
}