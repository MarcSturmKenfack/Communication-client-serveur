package client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class MonClient {
    public static void main (String args[]) throws IOException {
//        creation de la socket client
//        je me connectes au serveur en creant un socket précis
        System.out.println("je me connectes au serveur");
        Socket socket = new Socket("localhost",5200);
//  maintenant la connexion est etablie : creation des objets stream de communication
        String message, reponse;
        Scanner scanner = new  Scanner(System.in);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
//        stream de traitement pour la lecture des  de carractères
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        stream de traitement pour la lecture des carractères
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        stream de traitement pour l'ecriture des chaines
        PrintWriter printWriter = new PrintWriter(outputStream,true);


 try {
        while (true){
            System.out.print("Client: ");
            message = scanner.nextLine();
            printWriter.println(message);
            reponse = bufferedReader.readLine();
            System.out.println("Serveur: "+reponse);
            if (reponse == null)
                break;
        }
//        socket.close();
 }
         catch(SocketException e){
     System.err.println("fin connxexion");         }

    }
}