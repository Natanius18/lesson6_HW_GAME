package com.company.hero.wizard;

import com.company.program.Trainee;

public class DarkWizard extends Wizard implements Trainee {

    public DarkWizard(int lifePoints, int level, int damage, int money, int magicDamage) {
        super(lifePoints, level, damage, money, magicDamage);
    }

    @Override
    public void train() {
        setMagicDamage(getMagicDamage() + 5);
    }
}
