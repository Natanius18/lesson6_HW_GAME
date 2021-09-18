package com.company.hero.healer;

import com.company.weapon.Beast;
import com.company.program.Trainee;

public class HealerDruid extends Healer implements Trainee {
    private Beast beast;

    public Beast getBeast() {
        return beast;
    }

    public void setBeast(Beast beast) {
        this.beast = beast;
    }

    public HealerDruid(int lifePoints, int level, int damage, int powerOfHealing, Beast beast) {
        super(lifePoints, level, damage,0, powerOfHealing);
        this.beast = beast;
    }

    public void tameTheBeast(){
        System.out.println("Приручил");
    }

    @Override
    public void informationAboutHero() {
        System.out.println(
                "Уровень: " + getLevel() +
                    "\nОчки жизни: " + getLifePoints() +
                        "\nУрон: " + getDamage() +
                            "\nСила исцеления: " + getPowerOfHealing() +
                                "\nПрирученный зверь: " + beast
        );
    }

    @Override
    public void train() {
        setDamage(getDamage() + 5);
    }
}
