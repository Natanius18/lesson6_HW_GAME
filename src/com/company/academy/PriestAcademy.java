package com.company.academy;

import com.company.hero.healer.Healer;
import com.company.program.Trainee;

public class PriestAcademy extends Academy {

    public void teach(Trainee trainee) {
        if(trainee instanceof Healer){
            super.teach(trainee);
        }
    }

}
