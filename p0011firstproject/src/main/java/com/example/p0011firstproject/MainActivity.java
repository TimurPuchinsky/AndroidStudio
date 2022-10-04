package com.example.p0011firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator;
    Boolean isNew = true;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void clickNumber(View view) {
        if(isNew)
            editText.setText("");
        isNew = false;
        String number = editText.getText().toString();
        switch (view.getId()) {
            case R.id.but0: number = number + "0"; break;
            case R.id.but1: number = number + "1"; break;
            case R.id.but2: number = number + "2"; break;
            case R.id.but3: number = number + "3"; break;
            case R.id.but4: number = number + "4"; break;
            case R.id.but5: number = number + "5"; break;
            case R.id.but6: number = number + "6"; break;
            case R.id.but7: number = number + "7"; break;
            case R.id.but8: number = number + "8"; break;
            case R.id.but9: number = number + "9"; break;
            case R.id.butDot: number = number + "."; break;
            case R.id.butPlusMinus: number = number + "-"; break;
        }
        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        switch(view.getId()){
            case R.id.butMinus: operator="-"; break;
            case R.id.butPlus: operator="+"; break;
            case R.id.butDivide: operator="/"; break;
            case R.id.butMultiply: operator="*"; break;
            case R.id.butPercent: operator="%"; break;
        }
    }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch(operator){
            case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber); break;
            case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber); break;
            case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber); break;
            case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber); break;
            case "%": result = Double.parseDouble(oldNumber) % Double.parseDouble(newNumber); break;
        }
        editText.setText(result+"");
    }

    public void clickClear(View view) {
        editText.setText("0");
        isNew = true;
    }
}
