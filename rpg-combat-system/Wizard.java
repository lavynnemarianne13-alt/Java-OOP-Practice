public class Wizard {

    private String name;
    private String element;
    private int mana;
    private int damage;
    private double life;

    public Wizard(String name, String element, int mana, int damage, double life) {
        this.name = name;
        this.element = element;
        this.mana = mana;
        this.damage = damage;
        this.life = life;
    }

    public void castSpellOn(Wizard other) {
        if (this.mana < 10) {
            System.out.println(this.name + " doesn't have enough mana!");
            return;
        }
        this.mana -= 10;

        double multiplier = 1.0;
        if (this.element.equals("FIRE") && other.element.equals("EARTH")) {
            multiplier = 1.5;
        } else if (this.element.equals("EARTH") && other.element.equals("WATER")) {
            multiplier = 1.5;
        } else if (this.element.equals("WATER") && other.element.equals("FIRE")) {
            multiplier = 1.5;
        } else if (this.element.equals("FIRE") && other.element.equals("WATER")) {
            multiplier = 0.5;
        } else if (this.element.equals("EARTH") && other.element.equals("FIRE")) {
            multiplier = 0.5;
        } else if (this.element.equals("WATER") && other.element.equals("EARTH")) {
            multiplier = 0.5;
        }

        double damageDealt = this.damage * multiplier;
        other.life -= damageDealt;
        if (other.life < 0.0) {
            other.life = 0.0;
        }
    }

    public void restoreMana(int amount) {
        if (amount > 0) {
            mana += amount;
        } else {
            System.out.println("Only numbers greater than zero are acceptable!");
        }
    }

    public String toString() {
        String situation = (life == 0.0) ? " - defeated" : "";
        return name
              + ", mana: " + mana
              + ", life: " + life
              + ", element: " + element
              + situation;
    }

    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public String getElement() {
        return element;
    }
}
