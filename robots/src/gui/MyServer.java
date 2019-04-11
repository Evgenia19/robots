package gui;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable {

    private static Socket clientDialog;

    public MyServer(Socket client) {
        MyServer.clientDialog = client;
    }

    @Override
    public void run() {

        try {

            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            while (!clientDialog.isClosed()) {
                System.out.println("Server start game");
                RobotsProgram program = new RobotsProgram();
                try {
                    String entry = in.readUTF();


                    if (entry.equalsIgnoreCase("quit")) {
                        System.out.println("Client initialize connections suicide ...");
                        out.writeUTF("Server reply - " + entry + " - OK");
                        Thread.sleep(3000);
                        break;
                    }

                    System.out.println("Server try writing to channel");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    System.out.println("Server Wrote message to clientDialog.");
                    out.flush();
                }
                catch (IOException e)
                {
                    program.frame.dispose();
                    break;
                }
            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            in.close();
            out.close();

            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}