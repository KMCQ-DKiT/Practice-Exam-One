package ServerFile;

import DAOs.FootballDaoInterface;
import DAOs.MySqlFootballDao;
import DTOs.Football;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Exception.DaoException;
public class Server
{

    public FootballDaoInterface IUserDao = new MySqlFootballDao();

    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();

    }

    public void start()
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber)
        {
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);
                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true);
                this.clientNumber = clientNumber;
                this.socket = clientSocket;
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);


                    if (message.startsWith("DisplayResultsByTeam"))
                    {
                        String[] tokens = message.split(" ");
                        String team = (tokens[1]);
                        Football resultByTeam = IUserDao.findResultByTeam(team);
                        socketWriter.println(resultByTeam);
                    }
                }
                socket.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}