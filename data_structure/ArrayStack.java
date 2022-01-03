import java.lang.reflect.Array;
import java.util.Scanner;

public class ArrayStack<T> {
    private int top;
    static final int MAX_SIZE = 100;
    private T[] stack;

    ArrayStack(Class<T> classinfo){
        top= -1;
        stack = (T[]) Array.newInstance(classinfo,MAX_SIZE);
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==MAX_SIZE-1;
    }

    public void push(T n) throws IndexOutOfBoundsException{
        if(this.isFull()){
            throw new IndexOutOfBoundsException("Full data");
        }else{
            top++;
            stack[top] = n;
        }
    }

    public T pop() throws IndexOutOfBoundsException{
        T data;
        if(this.isEmpty()) {
            throw new IndexOutOfBoundsException("No data");
        }else{
            data = stack[top];
            stack[top]=null;
            top--;
        }
        return data;
    }

    public int capacity(){
        return MAX_SIZE;
    }

    public int size() {
        return top+1;
    }

    public T peek(){
        T data = stack[top];
        return data;
    }

    public T indexOf(int idx) throws  IndexOutOfBoundsException{
        if(idx > top){
            throw new IndexOutOfBoundsException("Out of bound");
        }else{
            return stack[idx];
        }
    }

    public void clear(){
        int tmp = top;
        for(int i=0;i<=tmp;i++){
            stack[i]=null;
            top -= 1;
        }
    }

    public void allElement(){
        for(int i=0;i<=top;i++){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(Integer.class);
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
