package com.fortuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        System.out.println("Inserisci ip del server");
        Scanner scan = new Scanner(System.in);

        String ip = scan.nextLine();
        System.out.println("Inserisci porta del server");
        int port = Integer.parseInt(scan.nextLine());

        Socket mioSocket = new Socket(ip, port);

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);

        String stringaMinuscola;
        do {
            System.out.println("Inserisci stringa: ");
            stringaMinuscola = scan.nextLine();

            if (stringaMinuscola.equals("exit")) {
                out.println("!");
                break;
            }
            out.println(stringaMinuscola);

            System.out.println("Stringa ricevuta: " + in.readLine());
        } while (true);

        mioSocket.close();
        scan.close();
    }
}