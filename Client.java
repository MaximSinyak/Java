package ru.geekbrains.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final  int SERVER_PORT = 9195;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Server started" + socket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() ->{
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threadReader.setDaemon(true);
            threadReader.start();


            while (true){
                String str = inputStream.readUTF();

                if (str.equals("/end")){
                    System.out.println("Client disconnected");
                    outputStream.writeUTF("/end");
                    break;
                }
                System.out.println("Server: " + str);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
