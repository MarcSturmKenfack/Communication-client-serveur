package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MonServer {
    public static void main(String arg[]) throws IOException {
//        creation d'un objet serSocket
        ServerSocket serverSocket = new ServerSocket(5200);
//            attente de connection
        System.out.println("j'attends la connexion...");
//        recuperation des données de la socket client qui s'est connectée
        Socket socket = serverSocket.accept();
//        creation des objets stream pour la communication
        InputStream inputStream = socket.getInputStream();
        OutputStream  outputStream = socket.getOutputStream();

        String message, reponse = new String("vide");
        Scanner scanner = new  Scanner(System.in);
//        boolean drapeau = true;
//        stream de traitement pour la lecture des  de carractères
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        stream de traitement pour la lecture des carractères
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        stream de traitement pour l'ecriture des chaines
        PrintWriter printWriter = new PrintWriter(outputStream,true);

        while (true){
            reponse = bufferedReader.readLine();
            if (reponse.equals("END"))
                break;
            System.out.println("Client: "+reponse);
            System.out.print("Serveur: ");
            message = scanner.nextLine();
            printWriter.println(message);


        }
//        socket.close();
//        fermeture du socket server
        serverSocket.close();
    }


}
