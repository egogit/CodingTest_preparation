import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements List<T>, Cloneable {

    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    private DoublyLinkedListNode<T> search(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedListNode<T> tmp = head;
        for(int i=0; i<index; i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void addFirst(T element){
        DoublyLinkedListNode<T> tmp = head;
        head = new DoublyLinkedListNode<>(element);
        if(tmp == null){
            tail = head;
            size++;
            return;
        }
        tmp.setPrev(head);
        head.setNext(tmp);
        size++;
    }

    public void addLast(T element){
        if(size == 0){
            addFirst(element);
            return;
        }
        DoublyLinkedListNode<T> tmp = tail;
        tail = new DoublyLinkedListNode<>(element);
        tmp.setNext(tail);
        tail.setPrev(tmp);
        size++;
    }

    @Override
    public boolean add(T element) {
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            addFirst(element);
            return;
        }
        if(index==size){
            addLast(element);
            return;
        }
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(element);
        DoublyLinkedListNode<T> prevNode = search(index-1);
        DoublyLinkedListNode<T> nextNode = prevNode.getNext();

        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);
        newNode.setNext(nextNode);
        nextNode.setPrev(newNode);
        size++;
    }

    public T remove(){
        DoublyLinkedListNode<T> headNode = head;
        if(headNode == null){
            throw new NoSuchElementException();
        }
        T element = headNode.getData();
        DoublyLinkedListNode<T> nextNode = head.getNext();
        head.setData(null);
        head.setNext(null);
        head = nextNode;
        size--;

        if(size==9){
            tail = null;
        }
        return element;
    }

    @Override
    public T remove(int index) {
        if(index == 0){
            return remove();
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedListNode<T> prevNode = search(index-1);
        DoublyLinkedListNode<T> targetNode = prevNode.getNext();
        DoublyLinkedListNode<T> nextNode = targetNode.getNext();
        T data = targetNode.getData();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        targetNode.setData(null);
        targetNode.setNext(null);
        targetNode.setPrev(null);
        size--;
        return data;
    }

    @Override
    public boolean remove(Object element) {
        DoublyLinkedListNode<T> prevNode = head;
        DoublyLinkedListNode<T> tmp = head;

        for(;tmp != null; tmp = tmp.getNext()){
            if(element.equals(tmp.getData())){
                break;
            }
            prevNode = tmp;
        }

        if(tmp == null){
            return false;
        }

        if(tmp.equals(head)){
            remove();
        }else{
            prevNode.setNext(tmp.getNext());
            tmp.getNext().setPrev(prevNode);
            tmp.setData(null);
            tmp.setNext(null);
            size--;
        }
        return false;
    }

    @Override
    public T get(int index) {
        DoublyLinkedListNode<T> targetNode = search(index);
        return targetNode.getData();
    }

    @Override
    public void set(int index, T element) {
        DoublyLinkedListNode<T> targetNode = search(index);
        targetNode.setData(element);
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element)>=0;
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        for(DoublyLinkedListNode<T> i = head; i!=null;i=i.getNext()){
            if(element.equals(i.getData())){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for(DoublyLinkedListNode<T> i = head; i!= null;){
            DoublyLinkedListNode<T> nextNode = i.getNext();
            i.setData(null);
            i.setNext(null);
            i.setPrev(null);
            i = nextNode.getNext();
        }
        head = null;
        tail = null;
        size = 0;
    }

    public Object clone() throws CloneNotSupportedException {
        DoublyLinkedList<? super T> clone = (DoublyLinkedList<? super T>) super.clone();
        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        for(DoublyLinkedListNode<T> i = head; i!= null;i=i.getNext()){
            clone.addLast(i.getData());
        }
        return clone;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        int index = 0;
        for(DoublyLinkedListNode<T> i = head; i!=null;i=i.getNext()){
            array[index++] = (T) i.getData();
        }
        return array;
    }

    public <E> E[] toArray(E[] array){
        if(array.length<size) {
            array = (E[]) Array.newInstance(array.getClass().getComponentType(), size);
        }
            int index = 0;
            Object[] result = array;
            for(DoublyLinkedListNode<T> j=head; j!=null; j=j.getNext()){
                result[index++] = j.getData();
            }
            return array;
    }
}

