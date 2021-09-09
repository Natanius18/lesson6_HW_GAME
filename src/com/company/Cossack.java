package com.company;

public class Cossack extends Warrior implements Trainee{
    private Saber saber;

    public Cossack(int lifePoints, int level, int damage, int money, int damageMultiplier, Saber saber) {
        super(lifePoints, level, damage, money, damageMultiplier);
        this.saber = saber;
    }

    public void cutWithSaber(){
        System.out.println("Порубил");
    }

    @Override
    public void informationAboutHero() {
        System.out.println(
                "Уровень: " + getLevel() +
                        "\nОчки жизни: " + getLifePoints() +
                        "\nУрон: " + getDamage() +
                        "\nМножитель урона: "+ getDamageMultiplier() +
                        "\nСабля: " + saber
        );
    }

    @Override
    public void train() {

    }
}
