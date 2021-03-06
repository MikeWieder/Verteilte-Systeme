
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import verteile_systeme_aufgabe4_server.FileHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike Wieder
 */
public class Server {
    
    ServerSocket socket;
    
    public Server()  {
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket server = new ServerSocket(4711);
        Socket client = null;
        FileHandler fileHandler = new FileHandler("src\\verteile_systeme_aufgabe4_server\\VotingResults.xml");
        while(true) {
            client = server.accept();
            new ClientThread(client,fileHandler).start();    
        }
        
    }

}
