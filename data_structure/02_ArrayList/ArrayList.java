import java.lang.reflect.Array;

public class ArrayList<E> implements List<E>, Cloneable{

    int capacity;
    private E[] array;
    int size;

    ArrayList(){
        capacity = 1;
        array = (E[])new Object[capacity];
        size = 0;
    }

    ArrayList(int capacity){
        this.capacity = capacity;
        array = (E[])new Object[capacity];
        size = 0;
    }

    public void expand(){
        capacity *= 2;
        E[] tmp = array;
        array = (E[])new Object[capacity];
        copy(tmp, array);
    }

    public void copy(E[] origin, E[] target){
        for(int i = 0; i < origin.length; i++){
            target[i] = origin[i];
            origin[i]= null;
        }
    }

    public void addFirst(E element){
        if(size >= capacity){
            expand();
        }
        for(int i = size-1; i >= 0; i--){
            array[i+1] = array[i];
        }
        array[0] = element;
        size++;
    }

    public void addLast(E element){
        if(size >= capacity){
            expand();
        }
        array[size++] = element;
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }else if(size >= capacity){
            expand();
        }
        if (size == 0) {
            addFirst(element);
            return;
        }else if(size == capacity - 1){
            addLast(element);
            return;
        }else {
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = element;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        E data = array[index];
        for(int i = index + 1; i < size; i++){
            array[i-1] = array[i];
        }
        array[size-1] = null;
        size--;
        return data;
    }

    @Override
    public boolean remove(Object element) { 
        int idx = indexOf(element);
        if(idx == -1){
            return false;
        }
        remove(idx);
        return true;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, E element) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = element;
    }

    @Override
    public boolean contains(Object element) {
        boolean isExist = indexOf(element) != -1 ? true : false;
        return isExist;
    }

    @Override
    public int indexOf(Object element) {
        int idx = -1;
        for(int i = 0; i < size ; i++){
            if(array[i].equals(element)){
                idx = i;
                break;
            }
        }
        return idx;
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
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    public ArrayList<? super E> clone() throws CloneNotSupportedException{
        ArrayList<? super E> clone = (ArrayList<? super E>) super.clone();
        clone.array = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            clone.array[i] = this.array[i];
        }
        return clone;
    }

    public Object[] toArray(){
        Object[] result = new Object[size];
        for(int i = 0; i < size; i++){
            result[i] = array[i];
        }
        return result;
    }

    public <E> E[] toArray(E[] a){
        if(a.length < size){
            a = (E[]) Array.newInstance(a.getClass().getComponentType(),size);
        }
        Object[] result = a;
        for(int i = 0; i < size; i++){
            result[i] = array[i];
        }
        return a;
    }
}

