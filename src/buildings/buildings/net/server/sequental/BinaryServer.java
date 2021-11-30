package buildings.buildings.net.server.sequental;

import buildings.Buildings;
import exception.BuildingUnderArrestException;
import inter.Building;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class BinaryServer {
    private static ServerSocket server;
    private static Socket clientSocket;
    private static BufferedReader in;
    private static PrintWriter writer;
    static int multiplier = 2000;

    public static void main(String[] args) throws IOException {
        String buildingType;
        double cost;
        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен");
                clientSocket = server.accept();
                System.out.println("Клиент присоединен");
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    buildingType = in.readLine();
                    System.out.println(buildingType);
                    setMultiplier(buildingType);
                    System.out.println(multiplier);
                    writer.write("ваш тип дома " + buildingType);
                    writer.println(cost = calculateCost(Buildings.readBuilding(in)));
                    System.out.println(cost);
                    writer.flush();
                } finally {
                    clientSocket.close();
                    in.close();
                    writer.close();
                }

            } finally {
                System.out.println("Сервер закрыт");
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void setMultiplier(String buildingType) {
        switch (buildingType) {
            case "Dwelling":
                multiplier = 1000;
                break;
            case "Office":
                multiplier = 1500;
                break;
            case "Hotel":
                multiplier = 2000;
                break;
        }
    }

    private static double calculateCost(Building building) {
        Random random = new Random();
        if (random.nextInt(10) == 5) {
            try {
                throw new BuildingUnderArrestException();
            } catch (BuildingUnderArrestException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(building);
            return building.getAllArea() * multiplier;
        }
        return 0;
    }
}
