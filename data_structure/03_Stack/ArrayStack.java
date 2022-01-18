public class ArrayStack<E> implements Stack<E> {
    private int top;
    static final int MAX_SIZE = 100;
    private E[] stack;

    ArrayStack(){
        top= -1;
        stack = (E[])new Object[MAX_SIZE];
    }

    @Override
    public boolean empty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==MAX_SIZE-1;
    }

    @Override
    public E push(E element){
        E result;
        if(this.isFull()){
            throw new IndexOutOfBoundsException();
        }else{
            top++;
            stack[top] = element;
            result = element;
        }
        return result;
    }

    @Override
    public int search(E element) {
        int index = -1;
        for(int i=0;i<=top;i++){
            if(element.equals(stack[i])){
                index = i;
                break;
            }
        }
        return index + 1;
    }

    @Override
    public E pop(){
        E data = null;
        if(this.empty()) {
            throw new IndexOutOfBoundsException();
        }else{
            data = stack[top];
            stack[top]=null;
            top--;
        }
        return data;
    }

    public int capacity(){
        return MAX_SIZE;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public E peek(){
        E data = null;
        if(empty()){
            throw new IndexOutOfBoundsException();
        }else{
            data = stack[top];
        }
        return data;
    }

    public void clear() {
        int tmp = top;
        for (int i = 0; i <= tmp; i++) {
            stack[i] = null;
            top -= 1;
        }
    }
}

