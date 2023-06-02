package Cardgame.Cards;

public class card {
    Cardgame.Client.ClientView ClientView;
    Cardgame.Server.ServerView ServerView;
    String name;
    String class1;
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

    public void brawl(card enemy) throws InterruptedException {
        int health = this.getHealth();
        int enemyHealth = enemy.getHealth();
        int damage = this.getAttack();
        int enemyDamage = enemy.getAttack();
        int speed = this.getSpeed();
        int enemySpeed = enemy.getSpeed();
        boolean check = true;

        if (this.getSpeed() > enemy.getSpeed()) {
            //ServerView.setTextArea(this.getName() + " has " + speed + " speed. You go first.");
            //ClientView.setTextArea(this.getName() + " has " + speed + " speed. You go first.");
            System.out.println(this.getName() + " has " + speed + " speed. You go first.");
            while (check == true) {
                int enemyTempHp = enemy.getHealth();
                int youTempHp = this.getHealth();
                enemy.setHealth(enemyTempHp - damage);
                if (enemy.getHealth() < 1) {
                    //ServerView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                    //ClientView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                    System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                    Thread.sleep(2000);
                    check = false;
                } else {
                    //ClientView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                    //ServerView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                    System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                    Thread.sleep(2000);
                    this.setHealth(youTempHp - enemyDamage);
                    if (this.getHealth() < 1) {
                        //ClientView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                        //ServerView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                        System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                        check = false;
                    }
                    else {
                        //ClientView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                        //ServerView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                        System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                        Thread.sleep(2000);
                    }
                }
            }
        } else {
            //ClientView.setTextArea(enemy.getName() + " has " + enemySpeed + " speed. They go first.");
            //ServerView.setTextArea(enemy.getName() + " has " + enemySpeed + " speed. They go first.");
            System.out.println(enemy.getName() + " has " + enemySpeed + " speed. They go first.");
            while (check == true) {
                int enemyTempHp = enemy.getHealth();
                int youTempHp = this.getHealth();
                this.setHealth(youTempHp - enemyDamage);
                if (this.getHealth() < 1) {
                    //ClientView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                    //ServerView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                    System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                    check = false;
                } else {
                    //ClientView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                    //ServerView.setTextArea(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                    System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                    Thread.sleep(2000);
                    enemy.setHealth(enemyTempHp - damage);
                    if (enemy.getHealth() < 1) {
                        //ClientView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                        //ServerView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                        System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                        check = false;
                    }
                    else {
                        //ClientView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                        //ServerView.setTextArea(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                        System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                        Thread.sleep(2000);
                    }
                }
            }
        }
    }

    public card(String name, String class1, int health, int attack, int speed) {
        //ClientView ClientView, ServerView ServerView,
        //this.ClientView = ClientView;
        //this.ServerView = ServerView;

        this.name = name;
        this.class1 = class1;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "card{" +
                "name='" + name + '\'' +
                ", class1='" + class1 + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", speed=" + speed +
                '}';
    }
}

