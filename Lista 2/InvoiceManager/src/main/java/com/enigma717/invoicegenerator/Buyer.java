package com.enigma717.invoicegenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Buyer {

    private static final int NIP_LENGTH = 10;
    private static final int PHONE_NUMBER_LENGTH = 9;

    public final String buyerName;
    public final String buyerNIP;
    public final String buyerPhoneNumber;
    public final String buyerCity;
    public final String buyerStreet;


    public Buyer(final Scanner userInput, final ArrayList<Buyer> buyers) throws Exception {

        System.out.println("+==============================+");
        System.out.println("Please input information about yourself\n");

        System.out.print("Name: ");
        buyerName = userInput.nextLine();
        for(final Buyer buyer : buyers) {
            if(buyer.buyerName.equals(buyerName) || buyerName.isEmpty()) {
                throw new Exception();
            }
        }

        System.out.print("NIP : ");
        buyerNIP = userInput.nextLine();
        if(buyerNIP.length() != NIP_LENGTH) {
            throw new IllegalArgumentException();
        }

        System.out.print("Phone number: ");
        buyerPhoneNumber = userInput.nextLine();
        if(buyerPhoneNumber.length() != PHONE_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        System.out.print("City: ");
        buyerCity = userInput.nextLine();
        if(buyerCity.matches(".*\\d+.*")) {
            throw new IllegalArgumentException();
        }

        System.out.print("Street: ");
        buyerStreet = userInput.nextLine();


        buyers.add(this);
    }


    public void viewBuyer() {
        System.out.printf("%nName: %-38sNIP: %-25sPhone number: %-17sCity: %-19sStreet: %s%n%n",
                buyerName, buyerNIP, buyerPhoneNumber, buyerCity, buyerStreet);
    }
}
