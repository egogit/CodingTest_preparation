/**
 * 자바 List Interface<br>
 * List는 ArrayList, SinglyLinkedList, DoublyLinked에 의해 각각 구현합니다.
 *
 * @param <T> the type of elements in this list
 */

public interface List<T> {
    /**
     * 리스트에 요소를 추가
     *
     * @param element 리스트에 추가할 요소
     * @return  리스트에서 중복을 허용하지 않은 경우 리스트에 이미 중복되는
     *          요소가 있는 경우 {@code false}를 반환하고, 중복되는 원소가
     *          없을 경우 {@code true}를 반환
     */
    boolean add(T element);

    /**
     * 리스트에 요소를 특정 위치에 추가합니다.
     * 특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀립니다.
     *
     * @param index  리스트에 추가할 특정 위치
     * @param element 리스트에 추가할 요소
     */
    void add(int index, T element);

    /**
     * 리스트의 index 위치의 요소를 제거합니다.
     *
     * @param index 리스트에서 삭제할 요소의 위치
     * @return 삭제한 요소를 반환
     */
    T remove(int index);

    /**
     * 리스트에서 특정 요소를 삭제합니다.
     * 여러 개일 경우 가장 처음 발견한 요소만 삭제됩니다.
     *
     * @param element 리스트에서 삭제할 요소
     * @return 리스트에서 삭제할 요소가 없거나 삭제 실패시 {@return false}
     *         삭제에 성공할 경우 {@return true}
     */
    boolean remove(Object element);

    /**
     * 리스트에서 index 위치의 요소를 반환합니다.
     *
     * @param index 리스트에서 접근할 위치
     * @return 해당 index의 요소
     */
    T get(int index);

    /**
     * 리스트에서 특정 위치에 있는 요소를 새 요소로 대체합니다.
     *
     * @param index 값을 수정할 위치
     * @param element 새로 대체할 값
     */
    void set(int index, T element);

    /**
     * 특정 요소가 리스트에 있는지 확인합니다
     *
     * @param element
     * @return 리스트에 특정 요소가 존재하는 경우 {@code true}
     *          존재하지 않는 경우 {@code false}
     */
    boolean contains(Object element);

    /**
     * 리스트에 특정 요소가 위치한 위치를 반환합니다
     *
     * @param element
     * @return 리스트에 처음으로 element와 일치하는 index를 반환하고 없다면 -1를 반환
     *
     */
    int indexOf(Object element);

    /**
     * 리스트에 들어있는 요소의 개수를 반환합니다.
     *
     * @return 리스트에 들어있는 요소의 수 를 반환
     */
    int size();

    /**
     * 리스트가 비어있는지 여부를 반환합니다
     *
     * @return 리스트에 요소가 없는 경우 {@code false} 요소가 있는 경우 {@code true}
     */
    boolean isEmpty();

    /**
     * 리스트를 비웁니다.
     */
    public void clear();
}
