package ru.calculator;

import ru.calculator.exception.BaseRuntimeException;
import ru.calculator.service.Calculator;
import ru.calculator.service.ArabicCalculator;
import ru.calculator.service.RomanCalculator;

import java.util.Scanner;
//TODO: добавить доку и тесты
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Please enter two numbers from 1 to 10 separated by  math symbol such as “+”, “-”, “*”, “/”." +
                " You can use arabic or roman numbers. Examples: '2 + 2', 'X * II'git ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            Calculator calculator = calculatorSelection(userInput);
            System.out.println(calculator.parseUserInput(userInput));
        }
    }

    private static Calculator calculatorSelection(String userInput){
        if (userInput.matches("^\\s*([-+]?)(?:[1-9]|10)(?:\\s*([-+*\\/])\\s*((?:\\s[-+])?[1-9]|10)\\s*)+$")){
            return new ArabicCalculator();
        } if (userInput.matches("^\\s*([-+]?)(?:(X|IX|IV|V?I{0,3}))(?:\\s*([-+*\\/])\\s*((?:\\s[-+])?(X|IX|IV|V?I{0,3}))\\s*)+$")){
            return new RomanCalculator();
        } else {
            throw new BaseRuntimeException("Incorrect input. The program was terminated.");
        }
    }
}