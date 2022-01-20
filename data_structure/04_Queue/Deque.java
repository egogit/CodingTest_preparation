public class Deque<E> extends DoublyLinkedList<E> implements Queue<E>{

    Deque(){
        super();
    }

    @Override
    public boolean offer(E element) {
        addLast(element);
        return true;
    }

    public boolean offerFirst(E element){
        addFirst(element);
        return false;
    }

    public boolean offerLast(E element){
        addLast(element);
        return false;
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        return getFirst();
    }

    public E peekLast(){
        return getLast();
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        return removeFirst();
    }

    public E pollLast() {
        return removeLast();
    }
}

