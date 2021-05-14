package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static final Scanner scan = new Scanner(System.in);
    public static final Charset utf8 = StandardCharsets.UTF_8;
    public static final int shift = 3;
    public static int key = 0;

    public static String encrypt() {
        // Create scanner to scan text file
        Scanner textScan = null;
        try {
            textScan = new Scanner(Paths.get("message.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = textScan.nextLine();
        // Make message all lower case
        message = message.toLowerCase();
        // Create String to store encrypted message
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            int mappingValue = alphabet.indexOf(message.charAt(i));

            int encryptValue = (shift + mappingValue) % 26;
            char Val = alphabet.charAt(encryptValue);
            encryptedMessage += Val;
        }
        try {
            Files.write(Paths.get("message.txt"), encryptedMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Encrypted message : " + encryptedMessage;
    }

    public static String decrypt(int tempKey) {
        Scanner textScan = null;
        try {
            textScan = new Scanner(Paths.get("message.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String message = textScan.nextLine();
        message = message.toLowerCase();

        String decryptedMessage = "";

        if (tempKey != key && key != 0) {
            for (int i = 0; i < message.length(); i++) {
                int mappingValue = alphabet.indexOf(message.charAt(i));

                int decryptValue = (1 + mappingValue) % 26;
                char Val = alphabet.charAt(decryptValue);
                decryptedMessage += Val;
            }
        } else {
            for (int i = 0; i < message.length(); i++) {
                int mappingValue = alphabet.indexOf(message.charAt(i));
                int decryptValue = (mappingValue - shift) % 26;
                if (decryptValue < 0) {
                    decryptValue = alphabet.length() + decryptValue;
                }
                char Val = alphabet.charAt(decryptValue);
                decryptedMessage += Val;
            }
        }
        return "Decrypted message: " + decryptedMessage;
    }

    public static void prompt() {

        System.out.println("Do you wish to encrypt or decrypt a message?");
        String TODO = scan.nextLine();
        TODO = TODO.toLowerCase();
        String message = "";
        if (TODO.equals("encrypt")) {
            System.out.println("Enter your message: ");
            message = scan.nextLine();

            try {
                Files.write(Paths.get("message.txt"), message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Enter the key number (1-52)");
            int temp = scan.nextInt();
            while (true) {
                if (temp >= 0 && temp <= 52) {
                    break;
                } else {
                    System.out.println("Not a valid key, please enter the key number (1-52)");
                    temp = scan.nextInt();
                }
            }
            key = temp;

            System.out.println(encrypt());
            System.out.println();
        }

        if (TODO.equals("decrypt")) {
            System.out.println("Would you like to decrypt a new message or decrypt the previously encrypted message?");
            System.out.println("Enter 1 for new message");
            System.out.println("Enter 2 for previously encrypted message");
            int number = scan.nextInt();

            // If they want to decrypt a new message, store message in file and call decrypt method
            if (number == 1) {
                System.out.println("Enter your message");
                message = scan.nextLine();
                message = scan.nextLine();
                try {
                    Files.write(Paths.get("message.txt"), message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(decrypt(key));
                System.out.println();
            }

            // If they want to decrypt the stored encrypted message. Get the key number to decrypt the stored message.
            if (number == 2) {
                System.out.println("Enter the key number (1-52)");
                int temp = scan.nextInt();
                while (true) {
                    if (temp >= 0 && temp <= 52) {
                        break;
                    } else {
                        System.out.println("Not a valid key, please enter the key number (1-52)");
                        temp = scan.nextInt();
                    }
                }
                System.out.println(decrypt(temp));
                System.out.println();
            }
        }
    }

        public static void main (String[]args){
            // write your code here
            while (true) {


                prompt();
            }
        }
    }
