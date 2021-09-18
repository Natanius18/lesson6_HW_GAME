package com.company.hero.warrior;

import com.company.hero.Hero;

public abstract class Warrior extends Hero {
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

    public Warrior(int lifePoints, int level, int damage, int money) {
        super(lifePoints, level, damage, money);
        this.damageMultiplier = 1;
    }

    public void hardBlow(){
        System.out.println("Ударил");
    }

    @Override
    public void informationAboutHero(){
        System.out.print("Уровень: " + this.getLevel() + " ");
        levelVisualisation();
        System.out.print("Очки жизни: ");
        System.out.println(lifePointsVisualisation1());
        System.out.println("Урон: " + this.getDamage() +
                "\nКоличество монет: " + this.getMoney());
    }
}
