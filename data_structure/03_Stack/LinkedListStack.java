public class LinkedListStack<T> extends DoublyLinkedList<T> implements Stack<T> {
    private int top;

    LinkedListStack(){
        super();
        top = -1;
    }

    @Override
    public T push(T element){
        top++;
        this.add(element);
        return element;
    }

    public T pop(){
        T data = null;
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }else{
            data = this.getLast();
            this.removeLast();
            top--;
        }
        return data;
    }

    @Override
    public int search(T element) {
        int index = this.indexOf(element) + 1;
        return index;
    }

    public int size(){
        return top + 1;
    }

    @Override
    public boolean empty(){
        return top == -1;
    }

    public T peek(){
        return this.getLast();
    }

    public void clear(){
        super.clear();
        top = -1;
    }

}

