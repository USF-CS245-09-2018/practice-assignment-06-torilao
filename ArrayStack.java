public class ArrayStack implements Stack {

    private int head;
    private Object arr[];

    public ArrayStack(){
        head = 0;
        arr = new Object[10];
    }

    @Override
    public void push(Object item){
        if(head >= arr.length){
            growStack();
            arr[head++] = item;
        } else {
            arr[head++] = item;
        }
    }

    @Override
    public Object pop(){
        if (empty()){
            return null;
        } else{
            return arr[--head];
        }
    }

    @Override
    public Object peek(){
        return arr[head];
    }

    @Override
    public boolean empty(){
        if (head == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void growStack(){
        Object[] newArr = new Object[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
