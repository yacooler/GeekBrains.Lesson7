import java.util.Random;

public class Main {
    public static void main(String[] args) {
        feedCats();
    }

    private static void feedCats() {
        Random random = new Random();

        int catsCount = 10;
        int plateFoodInitialCount = 150;
        int plateAlmostEmptyLimit = random.nextInt(10) + 7;

        //Инициализируем тарелку
        Plate plate = new Plate(random.nextInt(plateFoodInitialCount), plateAlmostEmptyLimit);

        //Инициализируем котов
        Cat[] cats = initCats(catsCount, random);

        //Кормим котов
        for (Cat c:cats){
            //Если тарелка пустая - можем досыпать немного корма
            checkAndIncreaseFood(random, plate);
            //Кормим котов
            feedCat(plate, c);
        }
        //Выводим список ненакормленных котов
        hungryCatList(cats);
    }


    private static Cat[] initCats(int catsCount, Random random) {
        Cat[] cats = new Cat[catsCount];
        for(int i = 0; i < catsCount; i++) {
            cats[i] = new Cat("Cat number " + (i + 1), random.nextInt(20));
        }
        return cats;
    }


    private static void checkAndIncreaseFood(Random random, Plate plate) {
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
            System.out.println(c.getName() + " is trying to eat");
            if (c.eat(plate)) {
                System.out.println(c.getName() + " is satiety now");
            } else {
                System.out.println(c.getName() + " is still hungry");
            }
        }
    }

    private static void hungryCatList(Cat[] cats) {
        System.out.println();
        for (Cat c:cats){
            if (!c.isSatiety()){
                System.out.printf("unfortunately %s  is still hungry. Try to correct it ASAP!\n", c.getName());
            }
        }
    }

}
