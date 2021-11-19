package com.enigma717.invoicegenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductAttributes {

    private final Product product;

    private static final double PRODUCT_TAX = 0.23;
    private static final int PERCENT_MULTIPLIER = 100;

    private final double productPrice;
    private final double productAmount;
    private final int productQuantity;


    public ProductAttributes(final Scanner userInput, final ArrayList<String> products,
                             final ArrayList<ProductAttributes> attributes) {

        product = new Product(userInput, products);

        System.out.print("Quantity: ");
        productQuantity = Integer.parseInt(userInput.nextLine());

        System.out.print("Price: ");
        productPrice = Double.parseDouble(userInput.nextLine());

        productAmount = productPrice * productQuantity + productPrice * PRODUCT_TAX * productQuantity;


        attributes.add(this);
    }


    public void viewProducts() {
        System.out.printf("Product name: %-30sQuantity: %-20dNet price: %-20.2fVAT: %-20.0fGross amount: %-1.2f%n",
                product.productName, productQuantity, productPrice, PRODUCT_TAX * PERCENT_MULTIPLIER, productAmount);
    }
}
