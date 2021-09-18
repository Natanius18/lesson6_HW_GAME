package com.company.weapon;

public class Beast {
    private String name;
    private int power;
    private int lifePoints;

    public Beast(String name, int power, int lifePoints) {
        this.name = name;
        this.power = power;
        this.lifePoints = lifePoints;
    }

    public final void attackAsBeast() {
        System.out.println("Атаковал как зверь");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
