public class TaskManagementSystem {

    static class Task {
        int taskId;
        String taskName;
        String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String toString() {
            return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class TaskLinkedList {
        private Node head;

        public void addTask(Task task) {
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
            System.out.println("Task added.");
        }

        public void searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.taskId == taskId) {
                    System.out.println("Task found: " + current.task);
                    return;
                }
                current = current.next;
            }
            System.out.println("Task not found.");
        }

        public void traverseTasks() {
            if (head == null) {
                System.out.println("No tasks available.");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(int taskId) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }

            if (head.task.taskId == taskId) {
                head = head.next;
                System.out.println("Task deleted.");
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.taskId == taskId) {
                    current.next = current.next.next;
                    System.out.println("Task deleted.");
                    return;
                }
                current = current.next;
            }
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Write Backend", "In Progress"));
        taskList.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("\nAll Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch for Task ID 2:");
        taskList.searchTask(2);

        System.out.println("\nDelete Task ID 1:");
        taskList.deleteTask(1);

        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}
