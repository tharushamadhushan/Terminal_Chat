import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CMain {
    public static void main(String[] args) {
        try {

            Socket socket=new Socket("localhost",3002);
            System.out.println("send");

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            String message="";
            String reply="";

            while (!message.equals("finish")) {

                reply=bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                message = dataInputStream.readUTF();
                System.out.println(message);
                dataOutputStream.flush();

            }

            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();


        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
