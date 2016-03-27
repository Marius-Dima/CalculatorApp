package com.example.setek.calculator;


import com.example.setek.R;

public class CalculatorPresenter {

    private CalculatorView calculatorView;
    private CalculatorService calculatorService;

    public CalculatorPresenter(CalculatorView calculatorView, CalculatorService calculatorService) {
        this.calculatorView = calculatorView;
        this.calculatorService = calculatorService;
    }

    public Double onCalculateClicked(int buttonId) {

        Double first = calculatorView.getFirstNumber();
        if (first == null) {
            calculatorView.showFirstNumberError(R.string.notANumberError);
            return 0d;
        }

        Double second = calculatorView.getSecondNumber();
        if (second == null) {
            calculatorView.showSecondNumberError(R.string.notANumberError);
            return 0d;
        }

        if (buttonId == R.id.addButton) {
            return calculatorService.add(first, second);
        } else if (buttonId == R.id.substractButton) {
            return calculatorService.subtract(first, second);
        } else if (buttonId == R.id.multiplyButton) {
            return calculatorService.multiply(first, second);
        } else if (buttonId == R.id.divideButton) {
            return calculatorService.divide(first, second);
        }

        return 0d;
    }
}
