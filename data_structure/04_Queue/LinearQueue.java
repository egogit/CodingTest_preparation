import java.util.NoSuchElementException;

public class LinearQueue<E> implements Queue<E>{
    private int front;
    private int rear;
    private int capacity;
    private E[] array;
    private int size;
    private final int DEFAULT_SIZE = 100;

    LinearQueue(){
        array = (E[])new Object[DEFAULT_SIZE];
        front = 0;
        rear = 0;
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    LinearQueue(int capacity){
        array = (E[])new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E element) {
        boolean isAdd = true;
        if(size == capacity){
            isAdd = false;
        }else {
            if (size != 0) {
                rear++;
            }
            array[rear] = element;
            size++;
        }
        return isAdd;
    }

    @Override
    public boolean add(E element) {
        boolean check = offer(element);
        if(!check){
            throw new IllegalStateException();
        }
        return check;
    }

    @Override
    public E peek() {
        if(size==0){
            return null;
        }
        return array[front];
    }

    @Override
    public E element() {
        E result = peek();
        if(result == null){
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public E poll() {
        if(size==0){
            return null;
        }
        E element = array[front];
        for(int i=1;i<=rear;i++){
            array[i-1] = array[i];
        }
        array[rear--] = null;
        size--;
        return element;
    }

    @Override
    public E remove() {
        E result = poll();
        if(result == null){
            throw new NoSuchElementException();
        }
        return result;
    }
}

