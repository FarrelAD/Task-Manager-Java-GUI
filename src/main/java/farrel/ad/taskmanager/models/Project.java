package farrel.ad.taskmanager.models;

import java.util.ArrayList;

public class Project {
    private String projectName;
    private ArrayList<Task> tasks;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
