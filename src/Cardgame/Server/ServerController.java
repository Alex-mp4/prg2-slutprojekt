package Cardgame.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerController extends JFrame {
    ServerModel ServerModel;
    ServerView ServerView;

    public ServerController(ServerModel m, ServerView v) {
        this.ServerModel = m;
        this.ServerView = v;

        ServerView.setRogue(m.getRogueStats());
        ServerView.setArcher(m.getArcherStats());
        ServerView.setBarbarian(m.getBarbarianStats());
        ServerView.setShaman(m.getShamanStats());
        ServerView.setAmalgam(m.getAmalgamStats());

        v.getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerModel.setClass(ServerView.getTextField());
                //System.out.println("Player 2 picked: " + m.class2);
                ServerModel.getPlayer2Class(m.class2);
                ServerModel.setMsg(m.class2);
                ServerModel.addMessage(ServerModel.getMsg());
                ServerModel.sendMessage(ServerModel.getMsg());
                //System.out.println(ServerModel.getChat());
                ServerModel.setClass2(ServerModel.getClassFromChat());
                ServerModel.getPlayer1Class(m.class1);
                System.out.println(m.class1);
            }
        });

        this.setContentPane(ServerView.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setTitle("Cardgame Server");
    }

    public static void main(String[] args) {
        ServerModel m = new ServerModel(5858);
        ServerView v = new ServerView();
        ServerController thisIsTheProgram = new ServerController(m,v);
        thisIsTheProgram.setVisible(true);
        m.acceptClient();
        m.getStreams();
        ServerListenerThread l = new ServerListenerThread(m.in, thisIsTheProgram);
        Thread listener = new Thread(l);
        listener.start();
        m.runProtocol();
        listener.stop();
        m.shutdown();
    }

    public void newMessage(String msg) {
        ServerModel.addMessage(msg);
    }
}
