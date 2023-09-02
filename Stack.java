/**
 * The interface <b>Stack</b> is the interface which defines five methods isEmpty, push, pop, peek, size,
 * which are used in class <b>LinkedStack<b> to control the behaviour of stacks in the main game.
 * The explanation of each method is given in LinkedStack file.
 */

public interface Stack {
	//your code here
    public abstract boolean isEmpty();
    public abstract void push(Object o);
    public abstract Object pop();
    public abstract Object peek();
    public abstract int size();
}