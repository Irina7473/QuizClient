package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedWriter out;
    private static BufferedReader in;
    private static BufferedReader reader;


    public void start() throws IOException {
        clientSocket = new Socket("localhost", 8080);//127.0.0.1
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        reader = new BufferedReader(new InputStreamReader(System.in));

        String msg="";
        boolean cont=true;

        System.out.println("Начинаем викторину. Выбирайте номер правильного ответа на вопрос.");
        try {
        while (cont) {
            msg = in.readLine();
            if (msg.equals("1")) {
                for (int i = 0; i < 5; i++) {
                    msg = in.readLine();
                    System.out.println(msg);
                }

                msg = reader.readLine();
                out.write(msg + "\n");
                out.flush();

                msg = in.readLine();
                System.out.println(msg);

                System.out.println("Продолжить викторину? 1 - да, 2 - нет.");
                msg = reader.readLine();
                if (msg.equals("2")) {
                    msg = "stop";
                    cont = false;
                } else msg = "cont";
                out.write(msg + "\n");
                out.flush();
            }
            else {
                cont = false;
                System.out.println(msg);
            }
          }
        }
        catch (IOException e) {System.out.println("Error: "+ e);}

        System.out.println("Викторина окончена.");
        msg = in.readLine();
        System.out.println(msg);

        clientSocket.close();
    }
}
