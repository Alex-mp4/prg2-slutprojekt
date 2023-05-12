package Cardgame.Client;

import com.sun.security.ntlm.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController extends JFrame {
    ClientModel ClientModel;
    ClientView ClientView;

    public ClientController(ClientModel m, ClientView v) {
        this.ClientModel = m;
        this.ClientView = v;

        ClientView.setRogue(m.getRogueStats());
        ClientView.setArcher(m.getArcherStats());
        ClientView.setBarbarian(m.getBarbarianStats());
        ClientView.setShaman(m.getShamanStats());
        ClientView.setAmalgam(m.getAmalgamStats());

        v.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientModel.setClass(ClientView.getTextField());
                System.out.println("Player 1 picked: " + m.class1);
                ClientModel.getPlayer1Class(m.class1);
            }
        });

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
