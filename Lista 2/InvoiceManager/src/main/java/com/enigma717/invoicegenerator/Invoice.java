package com.enigma717.invoicegenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {

    private final ArrayList<ProductAttributes> attributes;

    public int invoiceID;
    public String invoiceName;


    public Invoice(Scanner userInput, ArrayList<Invoice> invoices,
                   ArrayList<Buyer> buyers, ArrayList<String> products) throws Exception {

        attributes = new ArrayList<>();

        boolean buyerExists = false;
        int i = 0;
        int choice;


        System.out.println("+==============================+");
        System.out.print("Input name (buyer must exist): ");
        invoiceName = userInput.nextLine();

        for(Buyer buyer : buyers) {
            if(buyer.buyerName.equals(invoiceName)) {
                buyerExists = true;
                break;
            }
        }
        if(!buyerExists) {
            throw new IllegalArgumentException();
        }


        System.out.print("Create unique number invoice ID : ");
        invoiceID = Integer.parseInt(userInput.nextLine());


        for(Invoice invoice : invoices) {
            if(invoice.invoiceID == invoiceID) {
                throw new Exception();
            }
        }


        do {
            System.out.println("\n[1] Add new product");
            System.out.println("[2] Finish creating the invoice");
            System.out.print("\nYour choice: ");
            choice = Integer.parseInt(userInput.nextLine());

            switch(choice) {
                case 1 -> new ProductAttributes(userInput, products, attributes);
                case 2 -> i = 1;
                default -> System.out.println("Please choose correct option");
            }

        }while(i == 0);

        invoices.add(this);
    }


    public void printInvoice() {
        for(ProductAttributes allProducts : attributes) {
            allProducts.viewProducts();
        }
    }
}
