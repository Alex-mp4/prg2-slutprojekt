package Cardgame;

import Cardgame.Client.ClientController;
import Cardgame.Server.ServerController;

public class executable {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() { ServerController.main(args); }
        }).start();
        new Thread(new Runnable() {
            public void run() { ClientController.main(null); }
        }).start();
    }
}
