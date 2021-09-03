package com.company;

public class Sword {
    private String name;
    private int damageOfSword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamageOfSword() {
        return damageOfSword;
    }

    public void setDamageOfSword(int damageOfSword) {
        this.damageOfSword = damageOfSword;
    }

    public Sword(String name, int damageOfSword) {
        this.name = name;
        this.damageOfSword = damageOfSword;
    }
}
