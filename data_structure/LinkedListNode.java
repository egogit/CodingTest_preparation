public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> next;

    LinkedListNode(){
        data = null;
        next = null;
    }

    LinkedListNode(T data){
        this.data = data;
        next = null;
    }

    LinkedListNode(T data, LinkedListNode<T> next){
        this.data = data;
        this.next = next;
    }

    T getData(){
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    LinkedListNode<T> getNext(){
        return this.next;
    }

    void setNext(LinkedListNode<T> next){
        this.next = next;
    }
}
