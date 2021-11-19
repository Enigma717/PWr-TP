package com.enigma717.invoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


@DisplayName("ProductTest")
public class ProductTest {

    Product testedProduct;

    @Test
    void viewBuyer() {

        ArrayList<String> testArrayProducts = new ArrayList<>();
        String products = "Bread";
        System.setIn(new ByteArrayInputStream(products.getBytes(StandardCharsets.UTF_8)));

        Scanner input = new Scanner(System.in);
        testedProduct = new Product(input, testArrayProducts);
        Assertions.assertEquals(products, testedProduct.productName);
    }
}