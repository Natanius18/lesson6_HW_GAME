package com.company;

public class Warrior extends Hero {
    private int damageMultiplier;

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public Warrior(int lifePoints, int level, int damage, int money, int damageMultiplier) {
        super(lifePoints, level, damage, money);
        this.damageMultiplier = damageMultiplier;
    }

    public void hardBlow(){
        System.out.println("Ударил");
    }

}
