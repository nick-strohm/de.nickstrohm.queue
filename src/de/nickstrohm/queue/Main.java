package de.nickstrohm.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(33);
        queue.enqueue(66);
        queue.enqueue(80);
        queue.enqueue(22);
        queue.enqueue(64);
        queue.enqueue(11);
        queue.enqueue(99);
        queue.enqueue(101);
        queue.dequeue();
        queue.enqueue(33);
        queue.dequeue();
        queue.enqueue(55);
        queue.write();
    }

    public static <T extends Object> String strJoin(T[] aArr, String sSep) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0, il = aArr.length; i < il; i++) {
            if (i > 0)
                sbStr.append(sSep);
            sbStr.append(aArr[i].toString());
        }
        return sbStr.toString();
    }
}
