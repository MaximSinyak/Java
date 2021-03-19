package server;

//import com.sun.media.sound.RIFFInvalidFormatException;
import commands.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int PORT = 8189; // проверить свободный порт
    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private List<ClientHandler> clients;
    private AuthService authService;
    //4
    private ExecutorService executorService;

    public ExecutorService getExecutorService() {
        return executorService;
    }
    //4


    public Server() {
        //4
        executorService = Executors.newCachedThreadPool();
        //4
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthServise();

        try {
            server = new ServerSocket(PORT);
//            System.out.println("Server started");
            // подключение через базу данных
            if (!SQLHandler.connect()){
                throw new RuntimeException("Не удалось подключиться к БД");
            }
            authService = new DBAuthServise();
            //

            while (true){
                socket = server.accept();
                System.out.println("Client connected");

                new ClientHandler(this, socket);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //
            SQLHandler.disconnect();
            //
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg){
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        // доделать дату
        Date date = new Date();
        SQLHandler.addMessage(sender.getNickname(), "null", msg, date.getHours() + ":" + date.getMinutes());
        //
        for (ClientHandler c : clients){
            c.sendMsg(message);
        }
    }

    public void privateMsg(ClientHandler sender, String receiver, String msg){
        String message = String.format("[ %s ] to [ %s ]: %s", sender.getNickname(), receiver, msg);
        for (ClientHandler c : clients){
            if (c.getNickname().equals(receiver)) {
                c.sendMsg(message);
                // доделать дату
                Date date = new Date();
                SQLHandler.addMessage(sender.getNickname(), receiver, msg, date.getHours() + ":" + date.getMinutes());
                //
                if (!c.equals(sender)) {
                    sender.sendMsg(msg);
                }
                return;
            }
        }
        sender.sendMsg(String.format("User %s not found", receiver));
    }

    public void subscribe (ClientHandler clientHandler){
        clients.add(clientHandler);
        broadcastClientlist();
    }

    public void unsubscribe (ClientHandler clientHandler){
        clients.remove(clientHandler);
        broadcastClientlist();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isLoginAuthenticated(String login){
        for (ClientHandler c : clients) {
            if(c.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void broadcastClientlist(){
        StringBuilder sb = new StringBuilder(Command.CLIENT_LIST);

        for (ClientHandler c : clients){
            sb.append(" ").append(c.getNickname());
        }

        String msg = sb.toString();

        for (ClientHandler c : clients){
            c.sendMsg(msg);
        }
    }
}
