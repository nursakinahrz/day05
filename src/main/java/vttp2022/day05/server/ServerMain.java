package vttp2022.day05.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {

    public static void main (String[] args) throws IOException{

        // create a server socket and listent o a port
        ServerSocket server = new ServerSocket(3000);
        // wait for connection to come in

        System.out.println("Waiting for connection...");
        Socket sock = server.accept();
        System.out.println("Connection is accepted");

         //Get the input and output stream - bytes
        // Get the input sttream

        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        //Get the output stream

        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        // read request from client
        String request = dis.readUTF();
        
        //perform request from client
        request = request.toUpperCase();

        //write back the data to the client
        dos.writeUTF(request);

        
        //close the streams
        is.close();
        os.close();

        //close the socket
        sock.close();

    }
    
}