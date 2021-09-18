package com.company.academy;

import com.company.program.Trainee;
import com.company.hero.warrior.Warrior;

public class WarriorAcademy extends Academy {

    @Override
    public void teach(Trainee trainee) {
        if(trainee instanceof Warrior){
            super.teach(trainee);
        }

    }

}
