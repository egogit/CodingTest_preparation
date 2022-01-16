public class DoublyLinkedListNode<T> {

    private T data;
    private DoublyLinkedListNode<T> prev;
    private DoublyLinkedListNode<T> next;

    DoublyLinkedListNode(T data){
        this.data = data;
        prev = null;
        next = null;
    }

    T getData(){
        return data;
    }

    void setData(T data){
        this.data = data;
    }

    DoublyLinkedListNode<T> getPrev(){
        return prev;
    }

    void setPrev(DoublyLinkedListNode<T> prev){
        this.prev = prev;
    }

    DoublyLinkedListNode<T> getNext(){
        return next;
    }

    void setNext(DoublyLinkedListNode<T> next){
        this.next = next;
    }
}

