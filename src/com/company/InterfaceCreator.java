package com.company;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InterfaceCreator {
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void waitMe(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void helloScreen() {
        System.out.println("Добро пожаловать!");
        waitMe(1);
        System.out.println("Ты играешь за Джона. Помоги ему пройти путь от новобранца до великого воина!");
        waitMe(2);
        System.out.println("\nПравила игры следующие:\n" +
                "1. Перед тобой будут появляться враги. Твоя задача убить их.\n" +
                "2. За каждого убитого врага ты получаешь одну монету. Их можно будет на что-то поменять в будущем.\n" +
                "3. Чтобы перейти на следующий уровень, тебе нужно убить n врагов, где n — твой уровень на данный момент.\n" +
                "4. Ты сможешь выбирать, в какую часть тела противника целиться и какую свою часть тела защищать.\n" +
                "5. От этого выбора зависит сколько урона будет нанесено: \nпопадание в голову — полный урон, \n" +
                "в тело — половина урона, \nв ноги — треть урона. \nПротивник, в свою очередь, тоже будет выбирать, куда бить, " +
                "поэтому ты должен будешь угадать, что защитить. \nПри успешной защите урон не наносится." +
                " Противники, кстати, тоже защищаются. \n" +
                "6. Существует 3 уровня сложности. От него зависит твой урон и урон противников.\n" +
                "7. Твои противники могут быть твоего уровня либо уровня ниже.\n" +
                "8. Если почувствуешь, что больше нет сил, ты можешь заставить Джона убить себя, нажав на 0.");
        waitMe(10);
        System.out.println("\nВыбери уровень сложности:\n1 - легкий\n2 - средний\n3 - сложный");
    }

    public void showShortInfoAboutTwoHeroes(Hero john, Hero enemy) {
        System.out.println(john.getLevel() + " уровень    \uD83E\uDE99  " + john.getMoney());
        System.out.printf("%-121s %4s %n", "Джон", "Враг");
        System.out.printf("%-70s %25s %n", john.lifePointsVisualisation1(), enemy.lifePointsVisualisationForEnemyInFight());
    }

    public void showShortInfoAboutHero(Hero john) {
        System.out.println(john.getLevel() + " уровень    \uD83E\uDE99  " + john.getMoney());
        System.out.println("Джон");
        System.out.println(john.lifePointsVisualisation1());
    }

    public void informationAboutHeroesDuringFight(Hero john, Hero enemy) {
        showShortInfoAboutTwoHeroes(john, enemy);
        int aimOfJohn = john.attackChose();
        int protection = john.protectionChose();
        Random random = new Random();
        int aimOfEnemy = random.nextInt(3) + 1;
        int protectionOfEnemy = random.nextInt(3) + 1;

        System.out.print("Ты целился противнику ");
        switch (aimOfJohn) {
            case 0:
                System.out.print("непонятно куда");
                break;
            case 1:
                System.out.print("в голову");
                break;
            case 2:
                System.out.print("в тело");
                break;
            case 3:
                System.out.print("в ноги");
                break;
        }


        if (aimOfJohn == protectionOfEnemy) {
            System.out.println(", но он успешно отбил удар!");
        } else if (aimOfJohn == 0) {
            System.out.println(", и он не получил урона...");
        } else {
            System.out.print(", пока он ожидал атаки в ");

            switch (protectionOfEnemy) {
                case 1:
                    System.out.println("голову");
                    break;
                case 2:
                    System.out.println("тело");
                    break;
                case 3:
                    System.out.println("ноги");
                    break;
            }
            john.attack(enemy, john.getDamage() / aimOfJohn);
        }


        System.out.print("Твой противник целился тебе в ");
        switch (aimOfEnemy) {
            case 1:
                System.out.print("голову");
                break;
            case 2:
                System.out.print("тело");
                break;
            case 3:
                System.out.print("ноги");
                break;
        }

        if (protection == aimOfEnemy) {
            System.out.println(", но ты выбрал удачную защиту!");
        } else if (protection == 0) {
            System.out.println(", а ты все прозевал...");
            enemy.attack(john, enemy.getDamage() / aimOfEnemy);
        } else {
            System.out.print(", пока ты защищал ");

            switch (protection) {
                case 1:
                    System.out.println("голову");
                    break;
                case 2:
                    System.out.println("тело");
                    break;
                case 3:
                    System.out.println("ноги");
                    break;
            }
            enemy.attack(john, enemy.getDamage() / aimOfEnemy);
        }
        waitMe(6);
        clearScreen();
        showShortInfoAboutTwoHeroes(john, enemy);
    }


    public void gameOver() {
        System.out.println("Ты умер, game, так сказать, over :( \n" +
                "███████████████████████████\n" +
                "███████▀▀▀░░░░░░░▀▀▀███████\n" +
                "████▀░░░░░░░░░░░░░░░░░▀████\n" +
                "███│░░░░░░░░░░░░░░░░░░░│███\n" +
                "██▌│░░░░░░░░░░░░░░░░░░░│▐██\n" +
                "██░└┐░░░░░░░░░░░░░░░░░┌┘░██\n" +
                "██░░└┐░░░░░░░░░░░░░░░┌┘░░██\n" +
                "██░░┌┘▄▄▄▄▄░░░░░▄▄▄▄▄└┐░░██\n" +
                "██▌░│██████▌░░░▐██████│░▐██\n" +
                "███░│▐███▀▀░░▄░░▀▀███▌│░███\n" +
                "██▀─┘░░░░░░░▐█▌░░░░░░░└─▀██\n" +
                "██▄░░░▄▄▄▓░░▀█▀░░▓▄▄▄░░░▄██\n" +
                "████▄─┘██▌░░░░░░░▐██└─▄████\n" +
                "█████░░▐█─┬┬┬┬┬┬┬─█▌░░█████\n" +
                "████▌░░░▀┬┼┼┼┼┼┼┼┬▀░░░▐████\n" +
                "█████▄░░░└┴┴┴┴┴┴┴┘░░░▄█████\n" +
                "███████▄░░░░░░░░░░░▄███████\n" +
                "██████████▄▄▄▄▄▄▄██████████\n" +
                "███████████████████████████");
    }

}
