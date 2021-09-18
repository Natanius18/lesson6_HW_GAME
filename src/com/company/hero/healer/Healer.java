package com.company.hero.healer;

import com.company.hero.Hero;

public abstract class Healer extends Hero {
    private int powerOfHealing;

    public Healer(int lifePoints, int level, int damage, int money, int powerOfHealing) {
        super(lifePoints, level, damage, money);
        this.powerOfHealing = powerOfHealing;
    }

    public int getPowerOfHealing() {
        return powerOfHealing;
    }

    public void setPowerOfHealing(int powerOfHealing) {
        this.powerOfHealing = powerOfHealing;
    }

    public void heal(Hero hero, int amount){
        double tmp = (double)amount / powerOfHealing;
        if(tmp > hero.getMoney()){
            System.out.println("У тебя недостаточно монет для такого...");
            return;
        }
        hero.setMoney(hero.getMoney() - Math.max((int)tmp, 1));
        hero.setLifePoints(Math.min(100, hero.getLifePoints() + (int)(powerOfHealing * tmp)));
        System.out.println("Спасибо за " + Math.max((int)tmp, 1) + " монет. Залатал тебя тут немного. " +
                "Теперь у тебя на " + amount + " очков жизни больше.");
    }

    public void heal(int amount){
        this.setLifePoints(this.getLifePoints() + amount);
        System.out.println("Подлечил себя на " + amount + " очков жизни.");
    }


        @Override
    public void informationAboutHero() {
            System.out.println("Я лекарь. Могу лечить тебя, а могу себя :)");
    }
}
