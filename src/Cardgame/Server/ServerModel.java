package Cardgame.Server;

import Cardgame.Cards.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerModel {
    ServerSocket server;
    Socket client;

    PrintWriter out;
    BufferedReader in;

    Cardgame.Cards.rogue rogue = new rogue("Rogue", "Rogue", 20, 6, 6);
    Cardgame.Cards.archer archer = new archer("Archer", "Archer", 25, 5, 4);
    Cardgame.Cards.barbarian barbarian = new barbarian("Barbarian", "Barbarian", 30, 5, 2);
    Cardgame.Cards.shaman shaman = new shaman("Shaman", "Shaman", 15, 8, 3);
    Cardgame.Cards.amalgam amalgam = new amalgam("Amalgamation", "Amalgamation", (int)Math.floor(Math.random() *(35 - 15 + 1) + 15), (int)Math.floor(Math.random() *(8 - 5 + 1) + 5), (int)Math.floor(Math.random() *(6 - 2 + 1) + 2));

    String class2 = "";

    public ServerModel(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to open serversocket.");
            e.printStackTrace();
        }
        System.out.println("Cardgame.Server started...");
    }

    public String getRogueStats() {
        return String.valueOf(rogue);
    }

    public String getArcherStats() {
        return String.valueOf(archer);
    }

    public String getBarbarianStats() {
        return String.valueOf(barbarian);
    }

    public String getShamanStats() {
        return String.valueOf(shaman);
    }

    public String getAmalgamStats() {
        return String.valueOf(amalgam);
    }

    public void acceptClient() {
        try {
            client = server.accept();
        } catch (IOException e) {
            System.err.println("Failed to connect to client");
            e.printStackTrace();
        }
        System.out.println("Client connected...");
    }

    public void getStreams() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Streams ready...");
    }

    public void runProtocol() {
        Scanner tgb = new Scanner(System.in);
        String msg = "";
        while (!msg.equals("QUIT")) {
            msg = tgb.nextLine();
            out.println(msg);
        }
    }

    public void shutdown() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTheClass(String class2) {
        return class2;
    }

    public void setClass(String class2) {
        this.class2 = class2;
    }

    public card getPlayer2Class(String class2) {
        if (class2.equals("rogue")) {
            return new rogue("Rogue", "Rogue", 20, 6, 6);
        } else if (class2.equals("archer")) {
            return new archer("Archer", "Archer", 25, 5, 4);
        } else if (class2.equals("shaman")) {
            return new shaman("Shaman", "Shaman", 15, 8, 3);
        } else if (class2.equals("barbarian")) {
            return new barbarian("Barbarian", "Barbarian", 35, 5, 2);
        } else {
            return new amalgam(class2, "Amalgamation", (int) Math.floor(Math.random() * (35 - 15 + 1) + 15), (int) Math.floor(Math.random() * (8 - 5 + 1) + 5), (int) Math.floor(Math.random() * (6 - 2 + 1) + 2));
        }
    }
}
