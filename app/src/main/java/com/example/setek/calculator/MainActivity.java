package com.example.setek.calculator;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CalculatorService calculator = new CalculatorService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        double number1 = 0, number2 = 0;
        String result = null;

        TextView resultView = (TextView) findViewById(R.id.result);

        try {
            number1 = getTextAreaValue(R.id.number1);
            number2 = getTextAreaValue(R.id.number2);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Invalid argument supplied, please use numbers only!", Toast.LENGTH_SHORT).show();
            Log.e(this.getLocalClassName(), "Invalid argument(s) supplied, please use number(s)!");
        }

        if (view.getId() == R.id.addButton) {
            result = String.valueOf(calculator.add(number1, number2));
        }

        if (view.getId() == R.id.substractButton) {
            result = String.valueOf(calculator.subtract(number1, number2));
        }

        if (view.getId() == R.id.multiplyButton) {
            result = String.valueOf(calculator.multiply(number1, number2));
        }

        if (view.getId() == R.id.divideButton) {
            result = String.valueOf(calculator.divide(number1, number2));
        }

        resultView.setText(result);
    }

    public void onClearButton(View view) {
        TextView textView = (TextView) findViewById(R.id.result);
        textView.clearComposingText();
        textView.setText("");

        EditText firstNumber = (EditText) findViewById(R.id.number1);
        firstNumber.setText("");

        EditText secondNumber = (EditText) findViewById(R.id.number2);
        secondNumber.setText("");
    }

    private double getTextAreaValue(@IdRes int id) {
        EditText textField = (EditText) findViewById(id);

        return Double.parseDouble(textField.getText().toString());
    }


}
