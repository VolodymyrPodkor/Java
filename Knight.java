package KnightFight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knight  {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person1 knight1 = new Person1();
        Person2 knight2 = new Person2();
        knight1.heals = 50;
        knight2.heals = 50;

        System.out.println("Введите имя первого рицаря");
        knight1.name = reader.readLine();
        System.out.println("Введите имя второго рицаря");
        knight2.name = reader.readLine();
        System.out.println("Для начала игры введите - start");
        String start = reader.readLine();
        if(start.equals("start")){
            while (true){
                Thread.sleep(1000);
                knight1.attack = (int) (Math.random() * 20);
                knight1.defence = (int) (Math.random() * 10);
                knight1.damage = knight1.attack - knight2.defence;
                if(knight1.damage > 0) {
                    System.out.println(knight1.name + " нанес " + knight1.damage + " урона");
                    knight2.heals = knight2.heals - knight1.damage;
                }
                else {
                    System.out.println(knight1.name + " промахнулся");
                }
                Thread.sleep(1000);
                knight2.attack = (int) (Math.random() * 20);
                knight2.defence = (int) (Math.random() * 10);
                knight2.damage = knight2.attack - knight1.defence;
                if(knight2.damage > 0){
                    System.out.println(knight2.name + " нанес " + knight2.damage + " урона");
                    knight1.heals = knight1.heals - knight2.damage;
                }
                else {
                    System.out.println(knight2.name + " промахнулся");
                }

                if(knight1.heals <= 0){
                    System.out.println(knight1.name + " уничтожен");
                    System.out.println(knight2.name + " победил!");
                    break;
                }
                if (extracted(knight1, knight2)) break;

            }
        }
        else {
            System.out.println("Не правильно ввод, повторите заново");
        }
    }

    private static boolean extracted(Person1 knight1, Person2 knight2) {
        if(knight2.heals <=0){
            System.out.println(knight2.name + " уничтожен");
            System.out.println(knight1.name + " победил!");
            return true;
        }
        return false;
    }



}
