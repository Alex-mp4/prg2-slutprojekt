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
                //System.out.println("Player 1 picked: " + m.class1);
                ClientModel.getPlayer1Class(m.class1);
                ClientModel.setMsg(m.class1);
                ClientModel.addMessage(ClientModel.getMsg());
                ClientModel.sendMessage(ClientModel.getMsg());
                //System.out.println(ClientModel.getChat());
                ClientModel.setClass2(ClientModel.getClassFromChat());
                ClientModel.getPlayer2Class(m.class2);
                ClientView.setTextField(m.class2);
                System.out.println(m.class2);
                try {
                    ClientModel.getPlayer1Class(m.class1).brawl(ClientModel.getPlayer2Class(m.class2));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });

        this.setContentPane(ClientView.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Cardgame Client");
    }

    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog("Set IP");
        //10.80.47.10
        ClientModel m = new ClientModel(ip, 5858);
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

    public void newMessage(String msg) {
        ClientModel.addMessage(msg);
    }
}
