package ru.calculator.service;

import ru.calculator.exception.BaseRuntimeException;
import ru.calculator.misc.RomanNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RomanCalculator extends ArabicCalculator {

    @Override
    public int parseUserInput(String expression) {
        StringTokenizer st = new StringTokenizer(expression, " +-/*");
        if (st.countTokens() != 2){
            throw new BaseRuntimeException("Incorrect input. The program was terminated.");
        }
        List<RomanNumber> romanNumbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            romanNumbers.add(RomanNumber.valueOf(st.nextToken()));
        }
        String mathSymbol = expression.replaceAll("[X{0,3})(IX|IV|V?I{0,3})$ ]","");
        int result = 0;
        switch (mathSymbol){
            case "+": result = addition(convertToArabicNumbers(romanNumbers.get(0)), convertToArabicNumbers(romanNumbers.get(1)));
                break;
            case "-": result = subtraction(convertToArabicNumbers(romanNumbers.get(0)), convertToArabicNumbers(romanNumbers.get(1)));
                break;
            case "*": result = multiplication(convertToArabicNumbers(romanNumbers.get(0)), convertToArabicNumbers(romanNumbers.get(1)));
                break;
            case "/": result = division(convertToArabicNumbers(romanNumbers.get(0)), convertToArabicNumbers(romanNumbers.get(1)));
                break;
            default:
                break;
        }
        return result;
    }

    private int convertToArabicNumbers(RomanNumber romanNumber){
        int arabicNumber = 0;
        switch (romanNumber) {
            case I: arabicNumber = 1;
                break;
            case II: arabicNumber = 2;
                break;
            case III: arabicNumber = 3;
                break;
            case IV: arabicNumber = 4;
                break;
            case V: arabicNumber = 5;
                break;
            case VI: arabicNumber = 6;
                break;
            case VII: arabicNumber = 7;
                break;
            case VIII: arabicNumber = 8;
                break;
            case IX: arabicNumber = 9;
                break;
            case X: arabicNumber = 10;
                break;
            default:
                break;
        }
        return arabicNumber;
    }
}