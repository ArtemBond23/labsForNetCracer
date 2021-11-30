package buildings.buildings.net.client;

import buildings.Buildings;
import inter.Building;

import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

public class bynaryClient {

    private static Socket clintSocket;
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static PrintWriter  out; // поток записи в сокет


    public static void main(String[] args) throws IOException {
        try {
            try {
                Scanner typeScanner = new Scanner(Paths.get("typeFile.txt"));
                Scanner buildScanner = new Scanner(Paths.get("OfficeBuilding1.txt"));
                clientSocket = new Socket("localhost", 4004);
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new PrintWriter (new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Введите тип здания");
                out.println(typeScanner.nextLine());
                Building building = Buildings.readBuilding(buildScanner);
                System.out.println(building.toString());
                Buildings.writeBuilding(building, out);
                out.flush();
                String serverWord = in.readLine(); // ждём, что скажет сервер
                System.out.println(serverWord);// получив - выводим на экран

            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
