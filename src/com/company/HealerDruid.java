package com.company;

public class HealerDruid extends Healer implements Trainee{
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

    }
}
