import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    private Node<T> search(int index){
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> tmp = head;
        for(int i=0;i<index;i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void addFirst(T element) {

        Node<T> newNode = new Node<T>(element);
        newNode.setNext(head);
        head = newNode;
        size++;
        if(head.getNext() == null){
            tail = head;
        }
    }

    public void addLast(T element){
        Node<T> newNode = new Node<T>(element);
        if(size == 0){
            addFirst(element);
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
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
        Node<T> newNode = new Node<T>(element);
        Node<T> prevNode = search(index-1);
        Node<T> nextNode = prevNode.getNext();

        prevNode.setNext(null);
        prevNode.setNext(newNode);
        newNode.setNext(nextNode);
        size++;
    }

    public T remove(){
        Node<T> headNode = head;
        if(headNode == null){
            throw new NoSuchElementException();
        }
        T element = headNode.getData();
        Node<T> nextNode = head.getNext();
        head.setData(null);
        head.setNext(null);
        head = nextNode;
        size--;

        if(size==0){
            tail = null;
        }
        return element;
    }

    @Override
    public T remove(int index) {
        if(index == 0){
            return remove();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> prevNode = search(index - 1);
        Node<T> targetNode = prevNode.getNext();
        Node<T> nextNode = targetNode.getNext();
        T data = nextNode.getData();

        prevNode.setNext(nextNode);
        targetNode.setNext(null);
        targetNode.setData(null);
        size--;
        return data;
    }

    @Override
    public boolean remove(Object element) {
        Node<T> prevNode = head;
        Node<T> tmp = head;

        for(;tmp!=null;tmp=tmp.getNext()){
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
            tmp.setData(null);
            tmp.setNext(null);
            size--;
        }
        return true;
    }

    @Override
    public T get(int index) {
        Node<T> targetNode = search(index);
        return targetNode.getData();
    }

    @Override
    public void set(int index, T element) {
        Node<T> targetNode = search(index);
        targetNode.setData(null);
        targetNode.setData(element);
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element)>=0;
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        for(Node<T> i=head; i!=null; i=i.getNext()){
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
        for(Node<T> i=head;i!=null;){
            Node<T> nextNode = i.getNext();
            i.setData(null);
            i.setNext(null);
            i = nextNode.getNext();
        }
        head = null;
        tail = null;
        size = 0;
    }

    public Object clone() throws CloneNotSupportedException{
        SinglyLinkedList<? super T> clone = (SinglyLinkedList<? super T>) super.clone();
        clone.head = null;
        clone.tail = null;
        clone.size =0;

        for(Node<T> i = head; i!=null;i = i.getNext()){
            clone.addLast(i.getData());
        }
        return clone;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        int idx = 0;
        for(Node<T> i = head; i != null; i = i.getNext()){
            array[idx++] = (T) i.getData();
        }
        return array;
    }

    public <E> E[] toArray(E[] a){
        if(a.length<size){
            a = (E[]) Array.newInstance(a.getClass().getComponentType(),size);
        }
        int i=0;
        Object[] result = a;
        for(Node<T> j = head; j!=null; j=j.getNext()){
            result[i++] = j.getData();
        }
        return a;
    }
}
