/**
 * The class <b>LinkedStack</b> is the class that controls created stackes and implements Stack interface.
 * It has the inner class <b>Elem<b> which controls each element of the stack.
 * 
 */

public class LinkedStack implements Stack {

/**
 * The inner class <b>Elem<b> which controls each element of the stack.
 * 
 */
    private static class Elem {
        /**
        * value is the value of the object.
        */
        private Object value;
        /**
        * next is the next element in the stack.
        */
        private Elem next;
        /**
        * constructor for the element of the stack.
        * 
        * @param value  value of the element
        * @param next  next element
        */
        private Elem (Object value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
    * top element in the stack.
    */
    private Elem top;
    /**
    * size of the stack with default value 0.
    */
    private int size = 0;

    /**
     * default constructor with top element null.
     */
    LinkedStack() {
        top = null;
    }

    /**
     * checks if the stack is empty by checking top element is null
     * 
     * @return true/false
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * pushes the object on top of the stack and increases size of the stack
     * 
     * @param o  object pushed on top
     */
    public void push( Object o ) {
        if(top==null) {
            top=new Elem(o,null);
        }
        else{
                Elem temp=new Elem(o,top);
                top=temp;
            }
        size++;
    }

    /**
     * checks/peeks at the value of top object in the stack without removing it
     * 
     * @return the value of top object in the stack
     */
    public Object peek() {
        return top.value;
        
    }

    /**
     * pops the object on top of the stack and returns it's value then decrements the size of the stack (if stack is not empty)
     * 
     * @return the value of top object in the stack or null is stack is empty
     */
    public Object pop() {
        Elem temp;

        if(isEmpty())
            return null;

        temp=top;
        top= top.next;
        temp.next=null;
        size--;
        return temp.value;
    }

    /**
     * returns the size of the stack (how many objects in it)
     * 
     * @return the size of the stack
     */
    public int size() {
        return size;
    }

}