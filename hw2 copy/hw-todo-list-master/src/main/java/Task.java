public class Task {

    private String name;
    private boolean complete;
    private String dueDate;
    private String priority;
    public Task(String name, boolean complete, String dueDate,
        String priority) {
        this.name = name;
        this.complete = complete;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getName() {
        return name;

    }
    public boolean getComplete() {
        return complete;

    }
    public String getDueDate() {
        return dueDate;

    }
    public String getPriority() {
        return priority;

    }
// method to convert False to True or true to false
    public void changeComplete() {
        complete = false;

    }
    public String toString() {
        if (complete) {
            return (name + "- " + priority + " - due " + dueDate + " - Complete");
        } else {
            return (name + "- " + priority + " - due " + dueDate + " - Incomplete");
        }
    }
}