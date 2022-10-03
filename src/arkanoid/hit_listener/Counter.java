package arkanoid.hit_listener;
/**
 * @author Gal Giladi
 */
public class Counter {
    // members
    private int counter;

    /**
     * constructor function: the function creates a new Count-type variable from an integer counter.
     * @param counter : a Counter-type variable that represents counts.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * increase function: the function increases the counter.
     * @param number : an integer number we want to add to counter.
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * decrease function: the function decrease the counter.
     * @param number : an integer number we want to subtract from counter.
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * getValue function: the function returns the integer value of the counter.
     * @return an integer variable which is the counter value.
     */
    public int getValue() {
        return this.counter;
    }
} // end class Counter
