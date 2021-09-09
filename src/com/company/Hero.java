package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hero{
    private int lifePoints;
    private int level;
    private int damage;
    private int money;

    public Hero(int lifePoints, int level, int damage, int money) {
        this.lifePoints = lifePoints;
        this.level = level;
        this.damage = damage;
        this.money = money;
    }

    public void informationAboutHero(){
        System.out.print("Уровень: " + level + " ");
        levelVisualisation();
        System.out.print("Очки жизни: ");
        System.out.println(lifePointsVisualisation1());
        System.out.println("Урон: " + damage +
                "\nКоличество монет: " + money);
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String lifePointsVisualisation1(){
        String out = String.valueOf(getLifePoints()) + " [";
        for (int i = 0; i < 50; i++) {
            if (i < lifePoints/2) {
                out += "■";
            }
            else {
                out += "·";
            }
        }
        out += "]";
        return out;
    }
    public String lifePointsVisualisationForEnemyInFight(){
        String out = "[";
        int lim = 50 - (lifePoints/2);
        for (int i = 0; i < 50; i++) {
            if (i < lim) {
                out += "·";
            }
            else {
                out += "■";
            }
        }
        out += "] " + String.valueOf(getLifePoints());
        return out;
    }

    public void levelVisualisation(){
        for (int i = 0; i < level; i++) {
            System.out.print("★");
        }
        System.out.println();
    }

    public void attack(Hero enemy, int damage){
        enemy.lifePoints = (Math.max(enemy.lifePoints - damage, 0));
    }


    public int attackChose(){
        System.out.println("\nКуда будем целиться?\n\n" +
                " (•.•)   ⟵—————1 - в голову\n" +
                "  ╱▓╲¸  ⟵————— 2 - в тело\n" +
                " _/ \\_  ⟵————— 3 - в ноги");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        try {
            Integer.parseInt(option);
        } catch (NumberFormatException ex) {
            System.out.println("Упс! Кажется, промахнусь :(");
            return 0;
        }
        if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3){
            System.out.println("Упс! Кажется, промахнусь :(");
            return 0;
        }
        return Integer.parseInt(option);
    }


    public int protectionChose(){
        System.out.println("\nЧто будем защищать?\n\n" +
                " (•.•)   ⟵————— 1 - голову\n" +
                "  ╱▓╲¸  ⟵————— 2 - тело\n" +
                " _/ \\_  ⟵————— 3 - ноги");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        try {
            Integer.parseInt(option);
        } catch (NumberFormatException ex) {
            System.out.println("Ой, отвлекся...");
            return 0;
        }
        if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 3){
            System.out.println("Ой, отвлекся...");
            return 0;
        }
        return Integer.parseInt(option);
    }


    public void levelUp(){
        level++;
        System.out.print("\nПоздравляю, ты перешел на " + level + " уровень! ");
        levelVisualisation();
        if (level == 2){
            System.out.println("Начиная с этого уровня, у тебя появляется возможность получить лечение от лекаря за монеты.");
        }
    }
}