package com.example.setek.calculator;


public interface CalculatorView {

    Double getFirstNumber();

    Double getSecondNumber();

    void showFirstNumberError(int resId);

    void showSecondNumberError(int resId);
}
