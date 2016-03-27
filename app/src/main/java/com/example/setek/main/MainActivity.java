package com.example.setek.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.setek.R;
import com.example.setek.calculator.CalculatorPresenter;
import com.example.setek.calculator.CalculatorService;
import com.example.setek.calculator.CalculatorView;

public class MainActivity extends Activity implements CalculatorView {


    private EditText firstNumberView;
    private EditText secondNumberView;
    private TextView resultView;
    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberView = (EditText) findViewById(R.id.number1);
        secondNumberView = (EditText) findViewById(R.id.number2);
        resultView = (TextView) findViewById(R.id.result);
        calculatorPresenter = new CalculatorPresenter(this, new CalculatorService());
    }

    public void onButtonClick(View view) {
        Double result = calculatorPresenter.onCalculateClicked(view.getId());
        resultView.setText(String.valueOf(result));
    }

    public void onClearButtonClick(View view) {
        firstNumberView.setText("");
        secondNumberView.setText("");
        resultView.setText("");
    }

    private Double convertToNumber(String number) {
        try {
            return Double.parseDouble(number);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Double getFirstNumber() {
        return convertToNumber(firstNumberView.getText().toString());
    }

    @Override
    public Double getSecondNumber() {
        return convertToNumber(secondNumberView.getText().toString());
    }

    @Override
    public void showFirstNumberError(int resId) {
        firstNumberView.setError(getString(resId));
    }

    @Override
    public void showSecondNumberError(int resId) {
        secondNumberView.setError(getString(resId));
    }
}
