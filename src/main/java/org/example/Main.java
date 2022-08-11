package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello client");
        System.out.println("Желаете пройти викторину? 1 - да, 2 - нет.");
        String msg=reader.readLine();

        if (msg.equals("1")) {
            Client client = new Client();
            try {
                client.start();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}