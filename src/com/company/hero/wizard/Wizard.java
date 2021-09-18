package com.company.hero.wizard;

import com.company.hero.Hero;

public abstract class Wizard extends Hero {

    int magicDamage;

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public Wizard(int lifePoints, int level, int damage, int money, int magicDamage) {
        super(lifePoints, level, damage, money);
        this.magicDamage = magicDamage;
    }

    void magicAttack(){}


    @Override
    public void informationAboutHero() {

    }
}
