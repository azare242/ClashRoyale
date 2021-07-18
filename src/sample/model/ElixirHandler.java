package sample.model;

public class ElixirHandler {

    private int count;

    public ElixirHandler(){
        count = 4;
    }


    public boolean isFull(){
        return this.count == 10;
    }
    public synchronized void increase(int count){
        if (isFull()) return;
        this.count += count;
    }


    public synchronized void decrease(int count){
        this.count -= count;
    }

    public synchronized boolean enough(int count){
        return this.count <= count;
    }

    public synchronized int getCount(){
        return this.count;
    }
}
