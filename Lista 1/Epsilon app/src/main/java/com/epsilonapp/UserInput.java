package com.epsilonapp;

import java.util.Scanner;

public class UserInput {

    public float userNumber;

    public UserInput() {
        final Scanner enterNumber = new Scanner(System.in);
        System.out.print("Enter positive real number: ");
        userNumber = enterNumber.nextFloat();
    }
}
