import java.util.Scanner;

class ArrayStack {
    private String[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
        this.top = -1;
    }

    public void push(String url) {
        if (top == capacity - 1) {
            System.out.println("History Full! Cannot store more URLs.");
            return;
        }
        top++;
        stack[top] = url;
        System.out.println("Visited: " + url);
    }

    public String pop() {
        if (top == -1) {
            System.out.println("No history available to go back!");
            return null;
        }
        String removedUrl = stack[top];
        top--;
        System.out.println("Navigated back from: " + removedUrl);
        return removedUrl;
    }

    public String peek() {
        if (top == -1) {
            System.out.println("No active page in history.");
            return null;
        }
        return stack[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Browser history is empty.");
            return;
        }
        System.out.println("\n--- Browser History (Newest First) ---");
        for (int i = top; i >= 0; i--) {
            System.out.println((top - i + 1) + ". " + stack[i]);
        }
        System.out.println("------------------------------------");
    }
}

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter maximum browser history limit: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        ArrayStack browserHistory = new ArrayStack(size);
        boolean running = true;

        while (running) {
            System.out.println("\n*** BROWSER HISTORY MENU ***");
            System.out.println("1. Visit New Page (Push)");
            System.out.println("2. Back Button (Pop)");
            System.out.println("3. Current Page (Peek)");
            System.out.println("4. Show Full History (Display)");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL (e.g., google.com): ");
                    String url = scanner.nextLine();
                    browserHistory.push(url);
                    break;

                case 2:
                    browserHistory.pop();
                    break;

                case 3:
                    String current = browserHistory.peek();
                    if (current != null) {
                        System.out.println("Current Page: " + current);
                    }
                    break;

                case 4:
                    browserHistory.display();
                    break;

                case 5:
                    System.out.println("Exiting browser simulation...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
