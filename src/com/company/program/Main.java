package com.company.program;
import com.company.weapon.Beast;
import com.company.weapon.Saber;
import com.company.hero.healer.Healer;
import com.company.hero.healer.HealerDruid;
import com.company.hero.Hero;
import com.company.hero.warrior.Cossack;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        InterfaceCreator interfaceCreator = new InterfaceCreator();
        interfaceCreator.clearScreen();
        interfaceCreator.helloScreen();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int killsCounter = 0;
        String difficulty = scanner.next();
        Saber startSaber = new Saber("Start saber", 10);
        Hero john = new Cossack(100, 1, 5, 0, 3, startSaber);
        Hero enemy = new Cossack(100, 1, 5, 0, 3, startSaber);
        Beast beast = new Beast("Beast", 50, 100);
        Healer healer = new HealerDruid(100, 1, 0, 0, beast);
        label1:
        while (true) {
            switch (difficulty) {
                case "1":
                    System.out.println("Ты выбрал легкий уровень. Да начнется твоя история!");
                    john.setDamage(20);
                    break label1;
                case "2":
                    System.out.println("Ты выбрал средний уровень. Удачи на твоем пути!");
                    john.setDamage(10);
                    break label1;
                case "3":
                    System.out.println("Ты выбрал сложный уровень. Весьма рискованный шаг, удачи!");
                    break label1;
                default:
                    System.out.print("Есть только 3 уровня, выбери какой-то из них: ");
                    difficulty = scanner.next();
                    break;
            }
        }
        System.out.print("Старт уже через через ");
        for (int i = 3; i > 0 ; i--) {
            try {
                System.out.print(i);
                TimeUnit.SECONDS.sleep(1);
                System.out.print("\b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interfaceCreator.clearScreen();
        System.out.println("Вот информация о Джоне:");
        john.informationAboutHero();
        System.out.println("\nВот информация о первом противнике:");
        enemy.informationAboutHero();

        label:
        while (john.getLifePoints() > 0){
            if (john.getLevel() < 2) {
                System.out.println("\n0 — сдаться; 1 — для атаки; " +
                        "2 - узнать свое состояние");
            } else System.out.println("\n0 — сдаться; 1 — для атаки; " +
                    "2 — узнать свое состояние; 3 — вызвать лекаря");

            String option = scanner.next();
            interfaceCreator.clearScreen();
            switch (option) {
                case "1":
                    interfaceCreator.informationAboutHeroesDuringFight(john, enemy);

                    if (enemy.getLifePoints() < 1) {
                        System.out.println("\nПротивник повержен! Ты заработал одну монету!");
                        killsCounter++;
                        john.setMoney(john.getMoney() + 1);
                        if (killsCounter == john.getLevel()) {
                            killsCounter = 0;
                            john.levelUp();
                        }
                        enemy = new Cossack(
                                100,
                                random.nextInt(john.getLevel() + 1),
                                random.nextInt(john.getLevel() * Integer.parseInt(difficulty) + 5) + 1,
                                0, 3, startSaber);
                        System.out.println("\nТвой новый противник:");
                        enemy.informationAboutHero();

                    }
                    break;
                case "2":
                    john.informationAboutHero();
                    break;
                case "3":
                    interfaceCreator.showShortInfoAboutHero(john);
                    System.out.println("Сколько здоровья хочешь прибавить? У меня курс " + healer.getPowerOfHealing() +
                            " единиц здоровья за 1 монету");
                    String amount = scanner.next();
                    while (true) {
                        try {
                            Integer.parseInt(amount);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Нужно ввести число, кратное " + healer.getPowerOfHealing() +
                                    ", иначе можно потерять монеты.");
                            amount = scanner.next();
                        }
                    }
                    healer.heal(john, Integer.parseInt(amount));
                    break;
                case "0":
                    break label;
                default:
                    System.out.println("Пока рано");
                    break;
            }

        }
        interfaceCreator.gameOver();
    }
}
