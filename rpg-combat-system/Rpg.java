import java.util.Scanner;

public class Rpg {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Element: ");
        String element1 = sc.nextLine();
        System.out.print("Mana: ");
        int mana1 = sc.nextInt();
        System.out.print("Damage: ");
        int damage1 = sc.nextInt();
        sc.nextLine();

        System.out.println("");
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Element: ");
        String element2 = sc.nextLine();
        System.out.print("Mana: ");
        int mana2 = sc.nextInt();
        System.out.print("Damage: ");
        int damage2 = sc.nextInt();
        sc.nextLine();

        double life1 = 100;
        double life2 = 100;

        Wizard rpg1 = new Wizard(name1, element1, mana1, damage1, life1);
        Wizard rpg2 = new Wizard(name2, element2, mana2, damage2, life2);

        System.out.println("");
        System.out.print("How many turns? ");
        int turns = sc.nextInt();

        for (int i = 0; i < turns; i++) {

            System.out.println("");
            System.out.printf("=== Turn %d ===\n", i + 1);

            if (i % 2 == 0) {
                rpg1.castSpellOn(rpg2);
                System.out.printf("%s casts a spell on %s\n", name1, name2);
            } else {
                rpg2.castSpellOn(rpg1);
                System.out.printf("%s casts a spell on %s\n", name2, name1);
            }
            System.out.println(rpg1);
            System.out.println(rpg2);

            if (rpg1.getLife() == 0.0 || rpg2.getLife() == 0.0) {
                break;
            }
        }

        System.out.println("END OF COMBAT");

        sc.close();
    }
}
