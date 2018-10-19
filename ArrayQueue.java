public class ArrayQueue implements Queue {

    private int head;
    private int tail;
    private Object[] arr;

    public ArrayQueue(){
        head = 0;
        tail = 0;
        arr = new Object[10];
    }

    @Override
    public Object dequeue(){
        if(!empty()) {
            return arr[head++];
        } else {
            return null;
        }
    }

    @Override
    public void enqueue(Object item){
        if ((tail)%(arr.length) < head) {
            arr[tail%(arr.length)] = item;
            tail++;
        } else if (full()) {
            growQueue();
            arr[tail++] = item;
        } else {
            arr[tail++] = item;
        }
    }

    @Override
    public boolean empty(){
        if(head == tail){
            return true;
        }
        return false;
    }

    public boolean full(){
        if (tail >= arr.length){
            return true;
        } else{
            return false;
        }
    }

    public void growQueue(){
        Object[] newArr = new Object[arr.length * 2];
        for (int x = 0; x < arr.length; x++) {
            newArr[x] = arr[(x + head)%(arr.length)];
        }
        arr = newArr;
    }
}
