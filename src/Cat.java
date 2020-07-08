public class Cat {
    private String name;
    private int appetite;
    boolean satiety;

    /**
     *
     * @param name Имя кота
     * @param appetite Стартовый аппетит кота
     */
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = appetite == 0;
    }

    /**
     * Сьесть еду в количестве appetite из тарелки p
     * @param p Тарелка
     * @return Получилось - ли сьесть столько еды
     */
    public boolean eat(Plate p) {
        satiety = p.decreaseFood(appetite);
        return satiety;
    }

    /**
     * @return Является ли кот сытым
     */
    public boolean isSatiety() {
        return satiety;
    }

    /**
     * Печать информации о коте в консоль
     */
    public void info(){
        System.out.printf("%s has appetite %d\n", name, appetite);
    }

    /**
     * Получение имени кота
     * @return Имя кота
     */
    public String getName() {
        return name;
    }

}
