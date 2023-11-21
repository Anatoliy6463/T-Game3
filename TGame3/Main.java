/* 
 *  MAIN CLASS
 * Made by Anatoliy6463 on 20.11.2023
 * Version 0.0.1
 * Protected with Apache License 2.0
*/
package TGame3;
import java.util.Scanner;
public class Main {
    static int X, Y = 1;
    static int hp = 100;
    static int hunger = 0;  
    static int persiki = 0;
    static char d = '\0';
    static String line = "\0";
    static int money = 100;
    static boolean dragonTame = false;
    static Scanner sc = new Scanner(System.in);
    static int k = 1;
    static int sword = 0;
    static int dragonhp = 1000;
    static int effectK;
    public static void saturation() {
        if (nektarin_effect == false && hunger == 0) {
            System.out.println("Вы сыты!");
            hp = 100;
        }
    }
    public static void main(String[] args) {
        System.out.println("Загрузка...");
        engine();
    }
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
        if (d == 'e' && persik > 0) {
            persiki--;
            hunger -= 20;
            if (hunger < 0) {hunger = 0;}
        }
        if (d == 'p') {
            System.out.println("У вас " + persiki + "персиков");
        }
        if (d == 'q') {
            Save.save();
            System.exit(0);
        }
        if (d == 'f') {
            Save.save();
        }
        if (d == 'r') {
            saving();
            if (X == Save.X && hp == Save.hp && d == Save.d && money == Save.money) {
                System.out.println("Загрузка прошла успешно");
            }
        }
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
            if (X >= 20 && X <= 30 && Y >= 20 && Y <= 30 && dragonhp > 0 && dragonTame != true) {
                System.out.println("Здесь живёт дракон!");
                hp -= 5;
                line = sc.nextLine();
                if (line.equalsIgnoreCase("attack")) {
                    if (sword == 0) {
                        dragonhp -= 10;
                    }
                    if (sword == 1) {
                        dragonhp -= 30;
                    }
                }
                if (hp < 0) {
                    System.out.println("Game over");
                    System.exit(0);
                    }
                }
            }
        }
    }
}
