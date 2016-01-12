public class Goal {
    
    private Task[] tasks;
    private String name;
//    private boolean complete;

    public Goal(String name, Task[] tasks) {
        this.name = name;
        this.tasks = tasks;
//        this.complete = complete;
    }

    public String getName() {
        return name;
    }
    public Task[] getTask() {
        return tasks;
    }
    public boolean isComplete() {
        boolean check = True;
        for (Task t : tasks) {
            check = check && t.getComplete;
        }
//        complete = check;
        return check;
    }

    public void addTask(Task newTask) {

        int i = 0;
        while (i < tasks.length){
            if (tasks[i] == null) {
                tasks[i] = newTask;
                break;
            }
        }
    }

    public String toString() {
        String completeStr = "Complete";
        if (!isComplete()) {
            completeStr = "Incomplete";
        }

        String tasksStr = ""
        for (Task t : tasks) {
            tasksStr = tasksStr + "\n" + t.toString();
        }
        
        return(name + " - " + completeStr + "\n" + tasksStr);

    }


}