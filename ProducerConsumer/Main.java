import java.util.*;

public class Main {
    public static final int BUFFER_SIZE = 4;
    public static int mutex = 1;
    public static int full = 0;
    public static int empty = BUFFER_SIZE;
    public static LinkedList<String> bufferItems = new LinkedList<String>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1 for Producer");
            System.out.println("2 for Consumer\n>>");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    producer();
                    break;
                case 2:
                    consumer();
                    break;
                default:
                    return;
            }
        }

    }

    public static void producer() {
        if (empty == 0 || mutex == 0) {
            System.out.println("FAILED: CANNOT ADD");
            return;
        }
        empty = wait(empty);
        mutex = wait(mutex);
        System.out.println("Enter the input: ");
        bufferItems.addLast(scanner.nextLine());
        System.out.println("Added to buffer: " + bufferItems.size());
        mutex = signal(mutex);
        full = signal(full);
    }

    public static void consumer() {
        if (empty == BUFFER_SIZE || mutex == 0) {
            System.out.println("FAILED REMOVE");
            return;
        }
        full = wait(full);
        mutex = wait(mutex);
        String el = bufferItems.peekFirst();
        bufferItems.removeFirst();
        System.out.println("Removed element: " + el);
        mutex = signal(mutex);
        empty = signal(empty);

    }

    public static int wait(int object) {
        return object - 1;
    }

    public static int signal(int object) {
        return object + 1;
    }
}