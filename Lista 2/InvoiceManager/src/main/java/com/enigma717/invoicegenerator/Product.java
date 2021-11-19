package com.enigma717.invoicegenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {

    public String productName;


    public Product(final Scanner userInput, final ArrayList<String> products) {

        System.out.println("+==============================+");
        System.out.println("Input information about product\n");

        System.out.print("Name: ");
        productName = userInput.nextLine();


        products.add(productName);
    }
}