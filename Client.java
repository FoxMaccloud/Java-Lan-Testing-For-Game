import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 1337;

    private static int ID = 0;

    private static Socket s;

    //player vars

    private int HP = 9;
    private int lives = 3;
    private int posX = 0;
    private int posY = 0;


    public static void main(String[] args) throws IOException {
        s = new Socket(IP, PORT);


        // put me inside the while loop? no cause only 1
        ServerHandler fromServer = new ServerHandler(s);

        new Thread(fromServer).start();


        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);


        Boolean running = true;

        //Get unique ID
        out.println("getID");
        out.println("test");

        while (running) {
            System.out.println(">_ ");


            String command = keyboard.readLine();

            // Figure out how to replace keyboard -> send message when connecting!


            // TODO: make disconnect send a disconnect message to server
            // serverHandler?
            if (command.equals("disconnect")) break;

            out.println(command);
        }
        s.close();
    }

    public static void test() {
        try {
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("test");
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println(e);
        }
    }
}