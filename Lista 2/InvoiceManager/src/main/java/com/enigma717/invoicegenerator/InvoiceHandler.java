package com.enigma717.invoicegenerator;

import java.util.*;

public class InvoiceHandler {

    Scanner input = new Scanner(System.in);

    private final ArrayList<Invoice> invoicesList = new ArrayList<>();
    private final ArrayList<Buyer> buyersList = new ArrayList<>();
    private final ArrayList<String> productsList = new ArrayList<>();


    public void addBuyer() {
        try {
            new Buyer(input, buyersList);
        } catch(IllegalArgumentException ex) {
            System.out.println("Incorrect value!");
        } catch(Exception ex) {
            System.out.println("Given name is either incorrect or not unique!");
        }
    }


    public void addInvoice() {
        try {
            new Invoice(input, invoicesList, buyersList, productsList);
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect value!");
        } catch (Exception ex) {
            System.out.println("Given invoice ID is not unique!");
        }
    }


    public void viewInvoice() {

        System.out.println("+==============================+");
        System.out.print("Input name (buyer must exist): ");

        final String searchedInvoiceName = input.nextLine();
        if(searchedInvoiceName.isEmpty()){
            return;
        }


        System.out.println("\nAvailable invoice ID's for " + searchedInvoiceName);
        for(final Invoice invoices : invoicesList) {
            if(searchedInvoiceName.equals(invoices.invoiceName)) {
                System.out.print("--> " + invoices.invoiceID + "\n");
            }
        }


        System.out.print("Choose invoice ID you want to read: ");
        final int choice = Integer.parseInt(input.nextLine());

        for(final Invoice invoices : invoicesList) {
            if(choice == invoices.invoiceID) {
                for(final Buyer buyers : buyersList) {
                    if(buyers.buyerName.equals(searchedInvoiceName)) {

                        buyers.viewBuyer();
                        invoices.printInvoice();

                    }
                }
            }
        }

    }
}
