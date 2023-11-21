/*
    Saving class
    Made by Antoliy6463 on 20.11.2023
    Version v0.01
    Protected by GNU GPL v3
*/
package TGame3;

import java.util.Scanner;

public class Save {
    static int X, Y;
    static int hp;
    static int hunger;
    static int persiki;
    static int nektarin;
    static char d;
    static String line;
    static int money;
    static boolean nektarin_effect, dragonTame;
    static Scanner sc = new Scanner(System.in);
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
}
