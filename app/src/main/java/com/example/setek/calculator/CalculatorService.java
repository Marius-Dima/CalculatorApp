package com.example.setek.calculator;

import android.support.v7.app.AppCompatActivity;

public class CalculatorService extends AppCompatActivity {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {

        if (number2 != 0)
            return Math.floor(number1 / number2 * 1000) / 1000;
        else
            throw new ArithmeticException("Cannot divide by 0!");
    }

}
