import java.util.NoSuchElementException;

public class LinkedListQueue<E> extends DoublyLinkedList<E> implements Queue<E> {

    LinkedListQueue(){
        super();
    }

    @Override
    public boolean offer(E element) {
        addLast(element);
        return true;
    }

    @Override
    public E element() {
        E ele = getFirst();
        if(ele == null){
            throw new NoSuchElementException();
        }
        return ele;
    }

    @Override
    public E peek() {
        E element = getFirst();
        return element;
    }

    @Override
    public E poll() {
        if(size==0){
            throw new NoSuchElementException();
        }
        E element = removeFirst();
        return element;
    }
}

