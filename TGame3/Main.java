/*MAIN FILE
 * Made by Anatoliy6463 on 20.11.2023
 * Version 0.0.1
*/
package TGame3;
import java.util.Scanner;
public class Main {
    static int X, Y = 1;
    static int armor, sword = 0;
    static int hp = 100;
    static int hunger = 0;
    static int persiki = 0;
    static char d = '\0';
    static String line = "\0";
    static Scanner sc = new Scanner(System.in);
    public static void controller() {
        if (d == 'w') {
            Y++;
        }
        if (d == 's') {
            Y--;
        }
        if (d == 'a') {
            X--;
        }
        if (d == 'd') {
            X++;
        }
        if (d == 'e') {
            persiki--;
            hunger -= 20;
            if (hunger < 0) hunger = 0;
        }
        if (d == 'p') {
            System.out.println("У вас " + persiki + "персиков");
        }
        if (d == 'q') {
            System.exit(0);
        }
    }
    public static void shop() {
        System.out.println("Магазин закрыт до выхода обновления v0.0.2");
    }
    public static void engine() {
        while (d != 'q') {
            System.out.println("Ваши координаты: " + X + ";" + Y + "Уровень голода:" + hunger + "HP=" + hp);
            d = sc.next().charAt(0);
            controller();
            if (X % 7 == 0 && X != 0 || Y % 7 == 0 && Y != 0 || X % 7 == 0 && X != 0 && Y % 7 == 0 && Y != 0) {
                persiki++; // peaches :)
                System.out.println("Вы нашли персик!");
            }
            if (X == 15 && Y == 5) {
                shop();
            }
        }
    }
}
