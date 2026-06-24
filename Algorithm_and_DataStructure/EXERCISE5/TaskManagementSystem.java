package Algorithm_and_DataStructure.EXERCISE5;

public class TaskManagementSystem {

    static class Task {
        int taskId;
        String taskName;
        String status;

        Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId +
                    ", Task Name: " + taskName +
                    ", Status: " + status;
        }
    }

    static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static Node head = null;

    public static void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Task added successfully.");
    }

    public static Task searchTask(int taskId) {
        Node current = head;

        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }

        return null;
    }

    public static void traverseTasks() {
        Node current = head;

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public static void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Task deleted successfully.");
    }

    public static void main(String[] args) {

        addTask(new Task(101, "Design Database", "Pending"));
        addTask(new Task(102, "Develop API", "In Progress"));
        addTask(new Task(103, "Testing", "Pending"));

        System.out.println("\nAll Tasks:");
        traverseTasks();

        System.out.println("\nSearching Task ID 102:");
        Task task = searchTask(102);

        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task ID 102:");
        deleteTask(102);

        System.out.println("\nTasks After Deletion:");
        traverseTasks();
    }
}