package ru.calculator.service;

public interface Calculator {
    int parseUserInput(String expression);
    int addition(int number1, int number2);
    int subtraction(int number1, int number2);
    int multiplication(int number1, int number2);
    int division(int number1, int number2);
}