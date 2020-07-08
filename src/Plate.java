public class Plate {
    private int food;
    private int almostEmptyLimit;

    /**
     *
     * @param food - стартовое количество еды в тарелке
     * @param almostEmptyLimit - предельное количество еды, чтобы считать, что тарелка почти пуста
     */
    public Plate(int food, int almostEmptyLimit) {
        this.food = food;
        this.almostEmptyLimit = almostEmptyLimit;
    }

    /**
     * Взять еду из тарелки
     * @param n - сколько еды из тарелки взяли
     * @return - получилось ли взять n еды из тарелки
     */
    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Добавить еду в тарелку
     * @param n - количество добавляемой еды
     */
    public void increaseFood(int n){
        food += n;
    }

    /**
     * @return Признак того, что тарелка почти пуста
     */
    public boolean isAlmostEmpty(){
        return food <= almostEmptyLimit;
    }

    /**
     * Печать информации в консоль о содержимом тарелки
     */
    public void info() {
        System.out.println("plate contains: " + food);
    }
}
