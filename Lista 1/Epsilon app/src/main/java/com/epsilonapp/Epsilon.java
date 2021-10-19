package com.epsilonapp;

import static java.lang.Math.abs;

public class Epsilon {

    UserInput input = new UserInput();

    public Epsilon() {
        float epsilon;

        if (input.userNumber < 0.0) {
            input.userNumber = abs(input.userNumber);
        }

        epsilon = input.userNumber;

        double auxNumber;

        do {
            epsilon /= 2.0;
            auxNumber = input.userNumber + epsilon;
        } while (input.userNumber != auxNumber);

        System.out.printf("\nYour number read by processor: %.10e", input.userNumber);
        System.out.println("\nMachine epsilon for your number equals: " + epsilon);

        System.out.println("\nProof:\n  (your number)    +     (epsilon)    =     (your number)");
        System.out.printf("%.10e", input.userNumber);
        System.out.print("   +   " + epsilon + "   =   ");
        System.out.printf("%.10e", input.userNumber + epsilon);

        System.out.println("Test");
    }
}
