import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        final ServerSocket serverSocket;    /* server ti listen to a port */
        final Socket clientSocket;          /* uses to send and receive data from clients */
        final BufferedReader in;            /* to read data from clientSocket object */
        final PrintWriter out;              /* to write data into clientSocket object */
        final Scanner scanner = new Scanner(System.in);

        try{
            serverSocket = new ServerSocket(5000);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(new Runnable() {
                String msg; /* Msg by user */
                @Override
                public void run() {
                    while(true){
                        msg = scanner.nextLine();
                        out.println(msg);
                        out.flush();        /* force the data sending */
                    }
                }
            });
            sender.start();

            Thread receiver= new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    try{
                        msg = in.readLine();
                         while (msg != null){
                             System.out.println("Client: " + msg);
                             msg = in.readLine();
                         }

                        System.out.println("Client disconnected");
                         out.close();
                         clientSocket.close();
                         serverSocket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
