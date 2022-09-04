import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final Socket clientSocket;      /* to send and receive data from server */
        final BufferedReader in;        /* to read data from socket */
        final PrintWriter out;          /* to write data into the socket */
        final Scanner scanner = new Scanner(System.in);

        try{
            clientSocket = new Socket("127.0.0.1", 5000);
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
                            System.out.println("Server: " + msg);
                            msg = in.readLine();
                        }

                        System.out.println("Server is out of service");
                        out.close();
                        clientSocket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receiver.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
