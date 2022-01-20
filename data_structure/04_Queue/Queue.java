public interface Queue<E> {

    boolean add(E element); // element를 Queue에 추가 저장공간이 부족하면 IllegalStateException

    boolean offer(E element); // element를 Queue에 추가

    E element(); // 삭제없이 front의 요소를 가져온다. 비어있으면 NoSuchElementException

    E peek();  // 삭제없이 front의 요소를 가져온다.

    E remove(); // 객체를 꺼내서 반환  비어있으면 NoSuchElementException

    E poll(); // 객체를 꺼내서 반환
}
