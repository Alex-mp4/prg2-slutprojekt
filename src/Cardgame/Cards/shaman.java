package Cardgame.Cards;

public class shaman extends card {
    public shaman(String name, String class1, int health, int attack, int speed) {
        super(name, class1, health, attack, speed);
    }

    @Override
    public String toString() {
        return "class='" + class1 + '\'' + "\n" +
                "health=" + health + "\n" +
                "attack=" + attack + "\n" +
                "speed=" + speed;
    }
}
