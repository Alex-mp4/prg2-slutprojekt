package Cardgame.Cards;

public class rogue extends card {
    public rogue(String name, String class1, int health, int attack, int speed) {
        super(name, class1, health, attack, speed);
    }

    @Override
    public String toString() {
        return "rogue{" +
                "name='" + name + '\'' +
                ", class1='" + class1 + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", speed=" + speed +
                '}';
    }
}
