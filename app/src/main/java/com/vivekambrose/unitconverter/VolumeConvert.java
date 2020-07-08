package com.vivekambrose.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class VolumeConvert extends AppCompatActivity {
    NumberPicker volumeFrom;
    NumberPicker volumeTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_convert);
        String[] units = {
                "litre",
                "cc",
                "gallon",
                "oz"

        };
        volumeFrom = (NumberPicker) findViewById(R.id.numberPicker_VolumeFrom);
        volumeFrom.setDisplayedValues(units);
        volumeFrom.setMinValue(0);
        volumeFrom.setMaxValue(units.length - 1);

        volumeTo = (NumberPicker) findViewById(R.id.numberPicker_VolumeTo);
        volumeTo.setDisplayedValues(units);
        volumeTo.setMinValue(0);
        volumeTo.setMaxValue(units.length - 1);



    }

    public void convert(View view) {
        TextView result = (TextView) findViewById(R.id.textView_VolumeResult);
        EditText input_mass = (EditText) findViewById(R.id.editText_inputVolume);
        double value;

        try {
            value = Double.parseDouble(input_mass.getText().toString());
        }
        catch (Exception e){
            value = 0;
        }
        double output;
        DecimalFormat formatVal = new DecimalFormat("##.####");

        int from = volumeFrom.getValue();
        int to = volumeTo.getValue();
        if( value == 0){
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
                    output = value / 4.54609;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 33.814;
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
                    output = value / 4546.09;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value / 28.4131;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 2) {
                if (to == 0) {
                    output = value * 4.54609;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 4546.09;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value * 153.722;
                    result.setText(formatVal.format(output));
                }
            }
            else if (from == 3) {
                if (to == 0) {
                    output = value / 33.814;
                    result.setText(formatVal.format(output));
                } else if (to == 1) {
                    output = value * 28.4131;
                    result.setText(formatVal.format(output));
                } else if (to == 2) {
                    output = value / 152.722;
                    result.setText(formatVal.format(output));
                } else if (to == 3) {
                    output = value;
                    result.setText(formatVal.format(output));
                }
            }
        }

    }
}