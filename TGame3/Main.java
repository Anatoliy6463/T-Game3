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
    static int nektarin = 0;
    static char d = '\0';
    static String line = "\0";
    static int money = 100;
    static boolean nektarin_effect, dragonTame = false;
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
        if (nektarin_effect == true && hunger == 0) {
            hp = 150;
            System.out.println("Вы сыты!");
        }
    }
    public static void main(String[] args) {
        System.out.println("Загрузка...");
        engine();
    }
    public static void saving() {
        System.out.println("Загрузка сохранений");
        X = Save.X;
        Y = Save.Y;
        hp = Save.hp;
        hunger = Save.hunger;
        persiki = Save.persiki;
        nektarin = Save.nektarin;
        d = Save.d;
        line = Save.line;
        money = Save.money;
        nektarin_effect = Save.nektarin_effect;
        dragonTame = Save.dragonTame;
        k = Save.k;
        sword = Save.sword;
        dragonhp = Save.dragonhp;
        effectK = Save.effectK;
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
        if (d == 'e' && nektarin == 0) {
            persiki--;
            hunger -= 20;
            if (hunger < 0) hunger = 0;
        }
        if (d == 'e' && nektarin > 0) {
            nektarin--;
            hunger -= 20;
            if (hunger < 0) hunger = 0;
            hp = 150;
            nektarin_effect = true;
            effectK = k;
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
    public static void shop() {
        System.out.println("Добро пожаловать в магазин! Чтобы купить нектарин, нажмите T, чтобы купить меч, нажмите O");
        line = sc.nextLine();
        if (line.equalsIgnoreCase("T")) {
            nektarin++;
            money -= 10;
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
            if (X == 15 && Y == 5) {
                shop();
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
                if (line.equalsIgnoreCase("tame")) {
                    if (nektarin <= 10) {
                        System.out.println("У вас недостаточно нектаринов для приручения дракона");
                    }
                    if (nektarin > 10) {
                        dragonTame = true;
                    }
                }
                if (X % 25 == 0 || Y % 25 == 0 || X % 25 == 0 && Y % 25 == 0) {
                    Save.save();
                    System.out.println("Данные сохранены");
                }
                k++;
                if (k % 50 == 0) {
                    Save.save();
                    System.out.println("Автосохранение...");
                }
                if (hp < 0) {
                    System.out.println("Game over\nЧтобы начать игру с начала, введите reset\nчтобы загрузиться с сохранения, введите checkpoint");
                    line = sc.nextLine();
                    if (line.equalsIgnoreCase("reset")) {
                        X = 1;
                        Y = 1;
                        hp = 100;
                        hunger = 0;
                        persiki = 0;
                        nektarin = 0;
                        d = '\0';
                        line = "\0";
                        money = 100;
                        nektarin_effect = false;
                        dragonTame = false;
                        k = 1;
                        sword = 0;
                        dragonhp = 1000;
                    }
                    if (line.equalsIgnoreCase("checkpoint")) {
                        saving();
                    }
                }
                if (k - 50 == effectK) {
                    nektarin_effect = false;
                    System.out.println("Эффект от нектарина закончился");
                }
            }
        }
    }
}
/*
 * SAVE CLASS
 * PROTECTED BY GNU GPL V3
 * MADE ON 20.11.2023, UPDATED ON 21.11.2023
 * MADE BY ANATOLIY6463
 */
class Save {
    static int X, Y;
    static int hp;
    static int hunger;
    static int persiki;
    static int nektarin;
    static char d;
    static String line;
    static int money;
    static boolean nektarin_effect, dragonTame;
    static int k;
    static int sword;
    static int dragonhp;
    static int effectK;
    public static void save() {
        X = Main.X;
        Y = Main.Y;
        hp = Main.hp;
        hunger = Main.hunger;
        persiki = Main.persiki;
        nektarin = Main.nektarin;
        d = Main.d;
        line = Main.line;
        money = Main.money;
        nektarin_effect = Main.nektarin_effect;
        dragonTame = Main.dragonTame;
        k = Main.k;
        sword = Main.sword;
        dragonhp = Main.dragonhp;
        effectK = Main.effectK;
    }
    public static void main(String[] args){
        Main.saving();
    }
}
