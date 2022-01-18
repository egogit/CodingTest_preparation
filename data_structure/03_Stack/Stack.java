/**
 * 자바 Stack Interface<br>
 * Stack은 Array, ArrayList, DoublyLinkedList에 의해 각각 구현합니다.
 *
 * @param <E> the type of elements in this Stack
 */

public interface Stack<E>  {

    /**
     * 리스트가 비어있는지 여부를 반환합니다.
     *
     * @return 리스트에 요소가 없는 경우 {@code false} 요소가 있는 경우 {@code true}
     */
    boolean empty();

    /**
     * top에 위치한 요소를 반환합니다.
     *
     * @return   top에 위치한 요소를 반환하고 없다면 -1을 반환
     */
    E peek();

    /**
     * 리스트가 비어있는지 여부를 반환합니다.
     *
     * @return   top에 위치한 요소를 삭제하고 반환하며 없다면 -1을 반환
     */
    E pop();

    /**
     * 스택의 top부분에 element를 추가합니다.
     *
     * @param element top부분에 넣을 요소
     * @return 리스트에 요소가 없는 경우 {@code false} 요소가 있는 경우 {@code true}
     */
    E push(E element);

    /**
     * 특정 요소의 위치(1-based)를 반환합니다.
     *
     * @param element 찾을 요소
     * @return 찾는 요소의 index를 반환하며 없다면 null을 반환
     */
    int search(E element);
}
