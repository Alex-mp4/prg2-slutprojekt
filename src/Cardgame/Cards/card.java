package Cardgame.Cards;

public class card {
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
            System.out.println(this.getName() + " has " + speed + " speed. You go first.");
            while (check == true) {
                int enemyTempHp = enemy.getHealth();
                int youTempHp = this.getHealth();
                enemy.setHealth(enemyTempHp - damage);
                if (enemy.getHealth() < 1) {
                    System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                    Thread.sleep(2000);
                    check = false;
                    System.exit(0);
                } else {
                    System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                    Thread.sleep(2000);
                    this.setHealth(youTempHp - enemyDamage);
                    if (this.getHealth() < 1) {
                        System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                        check = false;
                        System.exit(0);
                    }
                    else {
                        System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                        Thread.sleep(2000);
                    }
                }
            }
        } else {
            System.out.println(enemy.getName() + " has " + enemySpeed + " speed. They go first.");
            while (check == true) {
                int enemyTempHp = enemy.getHealth();
                int youTempHp = this.getHealth();
                this.setHealth(youTempHp - enemyDamage);
                if (this.getHealth() < 1) {
                    System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has died.");
                    check = false;
                    System.exit(0);
                } else {
                    System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage" + "\n" + this.getName() + " has " + this.getHealth() + " health.");
                    Thread.sleep(2000);
                    enemy.setHealth(enemyTempHp - damage);
                    if (enemy.getHealth() < 1) {
                        System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has died.");
                        check = false;
                        System.exit(0);
                    }
                    else {
                        System.out.println(this.getName() + " dealt " + damage + " damage" + "\n" + enemy.getName() + " has " + enemy.getHealth() + " health.");
                        Thread.sleep(2000);
                    }
                }
            }
        }
        //check = healthCheck();
    }

    private boolean healthCheck(card enemy) {
        if (this.getHealth() < 1) {
            return false;
        }
        else if (enemy.getHealth() < 1) {
            return false;
        }
        else {
            return false;
        }
    }

    public card(String name, String class1, int health, int attack, int speed) {
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

