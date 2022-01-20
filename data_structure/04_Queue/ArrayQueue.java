import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>{
    private int front;
    private int rear;
    private int capacity;
    private int size;
    private E[] array;
    private final int DEFAULT_SIZE = 100;

    ArrayQueue(){
        array = (E[])new Object[DEFAULT_SIZE];
        front = 0;
        rear = 0;
        capacity = DEFAULT_SIZE;
        size = 0;
    }

    ArrayQueue(int capacity){
        array = (E[])new Object[capacity];
        front = 0;
        rear = 0;
        this.capacity = capacity;
        size = 0;
    }

    @Override
    public boolean offer(E element) {
        boolean isAdd = true;
        if(size == capacity){
            isAdd = false;
        }else{
            if (size != 0) {
                rear++;
                rear %= capacity;
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
        array[front++] = null;
        size--;
        if(front == capacity){
            front %= capacity;
        }
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

