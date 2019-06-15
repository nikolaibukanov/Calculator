package ru.calculator.service;

import ru.calculator.exception.BaseRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArabicCalculator implements Calculator {

    public int parseUserInput(String expression) {
        StringTokenizer st = new StringTokenizer(expression, " +-/*");
        if (st.countTokens() != 2){
            throw new BaseRuntimeException("Incorrect input. The program was terminated.");
        }
        List<Integer> integerList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            integerList.add(Integer.parseInt(st.nextToken()));
        }
        String mathSymbol = expression.replaceAll("[0-9 ]","");
        int result = 0;
        switch (mathSymbol){
            case "+": result = addition(integerList.get(0), integerList.get(1));
                break;
            case "-": result = subtraction(integerList.get(0), integerList.get(1));
                break;
            case "*": result = multiplication(integerList.get(0), integerList.get(1));
                break;
            case "/": result = division(integerList.get(0), integerList.get(1));
                break;
            default:
                break;
        }
        return result;
    }

    public int addition(int number1, int number2) {
        int result = number1 + number2;
        if (((number1 ^ result) & (number2 ^ result)) < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        return result;
    }

    public int subtraction(int number1, int number2) {
        int result = number1 - number2;
        if (((number1 ^ number2) & (number2 ^ result)) < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        return result;
    }

    public int multiplication(int number1, int number2) {
        long result = (long)number1 * (long)number2;
        if (result > (long)Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return (int) result;
    }

    public int division(int number1, int number2) {
        int result = number1/number2;
        if ((number1 ^ number2) < 0 && (result * number2 != number1)){
            result--;
        }
        return result;
    }
}