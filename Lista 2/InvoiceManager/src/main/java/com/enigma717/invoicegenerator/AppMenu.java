package com.enigma717.invoicegenerator;

import java.util.Scanner;

public class AppMenu {

    public AppMenu() {

        Scanner input = new Scanner(System.in);
        InvoiceHandler handler = new InvoiceHandler();

        int exitFlag = 0;
        int choice = 0;


        System.out.println("\n+==============================+");
        System.out.println("Welcome to invoice generator");

        do{

            System.out.println("+==============================+");
            System.out.println("[1] Add new buyer");
            System.out.println("[2] Create new invoice");
            System.out.println("[3] Print existing invoice");
            System.out.println("[4] Exit the app");
            System.out.print("\nChoice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch(NumberFormatException ex) {
                System.out.println("\nOnly numbers are permitted in menu!\n");
            }

            switch(choice) {
                case 1 -> handler.addBuyer();
                case 2 -> handler.addInvoice();
                case 3 -> handler.viewInvoice();
                case 4 -> {
                    System.out.println("\nShutting down the application...");
                    exitFlag = 1;
                }
                default -> System.out.println("\nPlease choose an option from the list above\n");
            }

        }while(exitFlag == 0);
    }
}