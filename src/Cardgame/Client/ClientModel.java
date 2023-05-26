package Cardgame.Client;

import Cardgame.Cards.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientModel {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    Cardgame.Cards.rogue rogue = new rogue("Rogue", "Rogue", 20, 6, 6);
    Cardgame.Cards.archer archer = new archer("Archer", "Archer", 25, 5, 4);
    Cardgame.Cards.barbarian barbarian = new barbarian("Barbarian", "Barbarian", 30, 5, 2);
    Cardgame.Cards.shaman shaman = new shaman("Shaman", "Shaman", 15, 8, 3);
    Cardgame.Cards.amalgam amalgam = new amalgam("Amalgamation", "Amalgamation", (int)Math.floor(Math.random() *(35 - 15 + 1) + 15), (int)Math.floor(Math.random() *(8 - 5 + 1) + 5), (int)Math.floor(Math.random() *(6 - 2 + 1) + 2));

    String class1 = "";
    String class2 = "";
    String msg = "";
    String chat = "";
    //public String getRogue() {
        //return Cardgame.Cards.rogue;
    //}

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChat() {
        return chat;
    }

    public String getClassFromChat() {
        chat = getChat();
        int first = chat.indexOf("\n");
        String enemyClass = chat.substring(first+1, chat.indexOf("\n", first + 1));
        return enemyClass;
    }

    public void addMessage(String msg) {
        chat += msg + "\n";
    }

    String name;
    int health;
    int attack;
    int speed;

    public String getName() {
        return name;
    }

    public String getClass1() {
        return class1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public ClientModel(String ip, int port) {
        try {
            socket = new Socket(ip,port);
        } catch (IOException e) {
            System.err.println("Failed to connect to server");
            e.printStackTrace();
        }
        System.out.println("Connection ready...");
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

    public void getStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
            out.println("CLIENT: " + msg);

            //msg = getTextField();
            //setTextArea1() = msg;
        }
    }

    public void shutDown() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTheClass(String class1) {
        return class1;
    }

    public void setClass(String class1) {
        this.class1 = class1;
    }

    public void setClass2(String class2){
        this.class2 = class2;
    }

    public String getTheClass2(String class2){
        return class2;
    }

    public card getPlayer1Class(String class1) {
        if (class1.equals("rogue")) {
            return new rogue("Rogue", "Rogue", 20, 6, 6);
        } else if (class1.equals("archer")) {
            return new archer("Archer", "Archer", 25, 5, 4);
        } else if (class1.equals("shaman")) {
            return new shaman("Shaman", "Shaman", 15, 8, 3);
        } else if (class1.equals("barbarian")) {
            return new barbarian("Barbarian", "Barbarian", 35, 5, 2);
        } else {
            return new amalgam(class1, "Amalgamation", (int) Math.floor(Math.random() * (35 - 15 + 1) + 15), (int) Math.floor(Math.random() * (8 - 5 + 1) + 5), (int) Math.floor(Math.random() * (6 - 2 + 1) + 2));
        }
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
