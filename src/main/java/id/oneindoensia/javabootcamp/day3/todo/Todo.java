package id.oneindoensia.javabootcamp.day3.todo;

public class Todo {
    private int id;
    private String task;
    private boolean status;

    public Todo(String task, boolean status) {
        this.task = task;
        this.status = status;
    }

    public Todo(int id, String task, boolean status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", status=" + status +
                '}';
    }
}
