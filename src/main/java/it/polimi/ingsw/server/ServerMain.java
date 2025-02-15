package it.polimi.ingsw.server;

import it.polimi.ingsw.client.View.cli.InputParser;
import java.io.IOException;
import java.net.*;

/**
 * Class used to start the server on a given port
 */
public class ServerMain {
    private static final int MIN_PORT = 1024;
    private static final int MAX_PORT = 49151;

    public static void main(String[] args) throws IOException {
        int serverPort;
        InputParser inputParser = new InputParser();
        System.out.println("Welcome");
        System.out.println("Insert the port");
        serverPort = inputParser.intParser();
        while(serverPort<MIN_PORT || serverPort>MAX_PORT){
            System.out.println("Port Number is not valid, please insert a new one");
            serverPort=inputParser.intParser();
        }
        System.out.println("Server ip: "+Inet4Address.getLocalHost().getHostAddress());
        System.out.println("Server listening on port: " + serverPort);
        Server server = new Server(serverPort);
        server.start();
    }




}
