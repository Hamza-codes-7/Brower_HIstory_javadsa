import java.util.Scanner;

class LinearQueue {
    int N = 10;
    int queue[] = new int[N];
    int front = -1;
    int rear = -1;

    void enqueue(int customer) {
        if (rear == N - 1) {
            System.out.println("Queue Full!");
        } 
        else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = customer;
            System.out.println("Customer " + customer + " joined the queue.");
        } 
        else {
            rear++;
            queue[rear] = customer;
            System.out.println("Customer " + customer + " joined the queue.");
        }
    }

    void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty!");
        } 
        else if (front == rear) {
            System.out.println("Customer " + queue[front] + " is served.");
            front = rear = -1;
        } 
        else {
            System.out.println("Customer " + queue[front] + " is served.");
            front++;
        }
    }

    void peek() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty!");
        } 
        else {
            System.out.println("Customer at front: " + queue[front]);
        }
    }

    void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue Empty!");
        } 
        else {
            System.out.println("Customers in the queue:");

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearQueue q = new LinearQueue();

        int choice;
        int customer;

        do {
            System.out.println("\n===== RAILWAY TICKET RESERVATION QUEUE =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer number: ");
                    customer = sc.nextInt();
                    q.enqueue(customer);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
