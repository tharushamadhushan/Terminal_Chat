import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SMain {
    public static void main(String[] args) {
        try {
            //create a server socket
            ServerSocket serverSocket=new ServerSocket(3002);

            //accept request and move to new socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");

            //java applcation used inputstream to read the data
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message="";
            String reply="";

            while (!message.equals("finish")) {
                message = dataInputStream.readUTF();
                System.out.println(message);
                reply=bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();
            socket.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
