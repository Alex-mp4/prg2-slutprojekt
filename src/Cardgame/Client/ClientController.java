package Cardgame.Client;

import javax.swing.*;

public class ClientController extends JFrame {
    ClientModel ClientModel;
    ClientView ClientView;

    public ClientController(ClientModel m, ClientView v) {
        this.ClientModel = m;
        this.ClientView = v;

        //ClientView.setRogue(Cardgame.Cards.rogue);

        this.setContentPane(ClientView.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Cardgame Client");
    }

    public static void main(String[] args) {
        ClientModel m = new ClientModel("10.80.47.10", 5858);
        ClientView v = new ClientView();
        ClientController thisIsTheProgram = new ClientController(m,v);
        thisIsTheProgram.setVisible(true);
        m.getStreams();
        ClientListenerThread l = new ClientListenerThread(m.in, thisIsTheProgram);
        Thread listener = new Thread(l);
        listener.start();
        m.runProtocol();
        listener.stop();
        m.shutDown();
    }
}
