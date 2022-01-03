import java.util.Scanner;

public class LinkedListStack<T> {
    private int top;
    private LinkedListNode<T> element;

    public boolean isEmpty(){
        return top==-1;
    }

    LinkedListStack(){
        top = -1;
        element = new LinkedListNode<>();
    }

    public void push(T n){
        top++;
        if(top == 0){
            element.setData(n);
        }else {
            LinkedListNode<T> next = new LinkedListNode<>(n, element);
            element = next;
        }
    }

    public T pop() throws IndexOutOfBoundsException{
        T data;
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("No data");
        }else{
            data = this.element.getData();
            element = this.element.getNext();
            top--;
        }
        System.out.println("data: " + data);
        return data;
    }

    public int size(){
        return top + 1;
    }

    public T peek(){
        return this.element.getData();
    }

    public void allElement(){
        LinkedListNode<T> tmp = element;
        for(int i=0;i<=top;i++){
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    public T indexOf(int idx) throws IndexOutOfBoundsException{
        T ele = null;
        if(idx > top){
            throw new IndexOutOfBoundsException("Out of bound");
        }else{
            LinkedListNode<T> tmp = element;
            for(int i=0;i<=top-idx;i++){
                if(i!=top-idx){
                    tmp = tmp.getNext();
                }else{
                    ele = tmp.getData();
                }
            }
        }
        return ele;
    }

    public void clear(){
        top = -1;
        element = new LinkedListNode<>();
    }

    public static void main(String[] args){
        LinkedListStack stack = new LinkedListStack();
        Scanner scan = new Scanner(System.in);
        Boolean running = true;
        System.out.println("=====================");
        System.out.println("1) Push");
        System.out.println("2) Pop");
        System.out.println("3) IndexOf");
        System.out.println("4) AllElement");
        System.out.println("5) Clear");
        System.out.println("6) Exit");
        while(running)
        {
            try {
                System.out.printf("Option: ");
                int option = Integer.parseInt(scan.nextLine().trim());
                int num;
                switch (option) {
                    case 1:
                        System.out.printf("A number for Push: ");
                        num = Integer.parseInt(scan.nextLine().trim());
                        stack.push(num);
                        break;
                    case 2:
                        num = (int) stack.pop();
                        System.out.println(num);
                        break;
                    case 3:
                        System.out.printf("A index for Find: ");
                        int idx = Integer.parseInt(scan.nextLine().trim());
                        System.out.printf("The number of idx %d: %d\n", idx, stack.indexOf(idx));
                        break;
                    case 4:
                        stack.allElement();
                        break;
                    case 5:
                        stack.clear();
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Wrong Input");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        scan.close();
    }
}

