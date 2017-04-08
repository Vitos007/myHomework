package HomeworkLecture5;

import java.util.Arrays;

public class Stack {
    private static final int DEFAULT_STACK_SIZE          = 10;// ToDo: HomeWork - implement auto resize of inner array
    private static final int DEFAULT_CAPACITY_MULTIPLIER = 2; // ToDo: you should use this variable to increase/decrease
                                                              // ToDo: holder size in push() & pop() methods.
    private int[] holder;
    private int currentPosition = -1;

    public Stack(int size) {
        this.holder = new int[size];
    }

    public Stack() {
        this.holder = new int[DEFAULT_STACK_SIZE];
    }

    public int pop() {
        if (currentPosition < 0) {
            System.err.println("No elements in stack, returning Integer.MIN_VALUE");
            return Integer.MIN_VALUE;
        }
        if (currentPosition <= DEFAULT_STACK_SIZE / DEFAULT_CAPACITY_MULTIPLIER) {
            int [] holderTemp = new int[holder.length / DEFAULT_CAPACITY_MULTIPLIER];
            System.arraycopy(holder, 0, holderTemp, 0, (holder.length + 1)/2);
            this.holder = new int[holderTemp.length];
            System.arraycopy(holderTemp, 0, holder, 0, holderTemp.length);
        }
        return holder[currentPosition--];
    }

    public void push(int element) {
       /* if (currentPosition == holder.length - 1) {
            System.err.println("Stack is full");
            return;
        }*/
        if (currentPosition == holder.length - 1) {
            int [] holderTemp = new int[DEFAULT_STACK_SIZE*DEFAULT_CAPACITY_MULTIPLIER];
            System.arraycopy(holder, 0, holderTemp, 0, holder.length);
            holder = new int[holderTemp.length];
            System.arraycopy(holderTemp, 0, holder, 0, holderTemp.length);
        }
        holder[++currentPosition] = element;
    }

    public int peek() {
        if (currentPosition < 0) {
            return Integer.MIN_VALUE;
        }
        return holder[currentPosition];
    }

    public void print() {
        if (currentPosition < 0) {
            return;
        }
        int[] realStack = new int[currentPosition + 1];
        System.arraycopy(holder, 0, realStack, 0, currentPosition + 1);
        System.out.println(Arrays.toString(realStack));
    }
}
