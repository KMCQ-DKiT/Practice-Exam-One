package ServerFile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.start();
    }
    public void start()
    {
        Scanner k = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("1. Find Result By Team");
            System.out.println("Enter your option: [1-2]");

            String command = k.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());

            boolean continueLooping = true;
            while(continueLooping==true) {
                if (command.equalsIgnoreCase("1"))
                {
                    System.out.println("Enter TeamName: ");
                    String team = k.nextLine();
                    socketWriter.println("DisplayResultsByTeam " + team);
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else{
                    continueLooping = false;
                }

                System.out.println("1. Find Result By Team");
                System.out.println("Enter your option: [1-2]");

                command = k.nextLine();
                socketWriter.println(command);
            }
            socketWriter.close();
            socketReader.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Client message: IOException: "+e);
        }
    }
}