package sample.model;

/**
 * The type Elixir handler.
 */
public class ElixirHandler {

    private int count;

    /**
     * Instantiates a new Elixir handler.
     */
    public ElixirHandler(){
        count = 4;
    }


    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull(){
        return this.count == 10;
    }

    /**
     * Increase.
     *
     * @param count the count
     */
    public synchronized void increase(int count){
        if (isFull()) return;
        this.count += count;
        if (this.count > 10) this.count = 10;
    }


    /**
     * Decrease.
     *
     * @param count the count
     */
    public synchronized void decrease(int count){
        this.count -= count;
    }

    /**
     * Enough boolean.
     *
     * @param count the count
     * @return the boolean
     */
    public synchronized boolean enough(int count){
        return this.count >= count;
    }

    /**
     * Get count int.
     *
     * @return the int
     */
    public synchronized int getCount(){
        return this.count;
    }
}
