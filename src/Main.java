import java.util.Random;

public class Main {
    public static void main(String[] args) {
        feedCats();
    }

    private static void feedCats() {
        int catsCount = 10;
        Random random = new Random();
        Plate plate = new Plate(random.nextInt(150), random.nextInt(10) + 7);

        //Инициализируем котов
        Cat[] cats = new Cat[catsCount];
        for(int i = 0; i < catsCount; i++) {
            cats[i] = new Cat("Cat number " + i, random.nextInt(20));
        }

        //Кормим котов
        for (Cat c:cats){
            //Если тарелка пустая - можем досыпать немного корма, а можем и не досыпать
            checkAndIncreasePlate(random, plate);
            //Кормим котов
            feedCat(plate, c);
        }
        //Выводим список ненакормленных котов
        hungryCatList(cats);
    }

    private static void checkAndIncreasePlate(Random random, Plate plate) {
        if (plate.isAlmostEmpty()) {
            System.out.println("The plate is almost empty!");
            if (random.nextBoolean()){
                System.out.println("Place a bit food to the plate");
                plate.increaseFood(random.nextInt(30) + 1);
            }
        }
    }

    private static void feedCat(Plate plate, Cat c) {
        plate.info();
        c.info();
        if (c.isSatiety()){
            System.out.println(c.getName() + " is already satiety");
        } else {
            System.out.println(c.getName() + " is try to eat");
            if (c.eat(plate)) {
                System.out.println(c.getName() + " is satiety now");
            } else {
                System.out.println(c.getName() + " is still hungry");
            }
        }
    }

    private static void hungryCatList(Cat[] cats) {
        for (Cat c:cats){
            if (!c.isSatiety()){
                System.out.printf("unfortunately %s  is still hungry. Try to correct it ASAP!\n", c.getName());
            }
        }
    }

}
