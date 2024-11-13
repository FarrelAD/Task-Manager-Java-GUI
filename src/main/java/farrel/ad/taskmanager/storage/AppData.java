package farrel.ad.taskmanager.storage;

import farrel.ad.taskmanager.models.Project;
import farrel.ad.taskmanager.models.Task;

import java.util.HashMap;
import java.util.Map;

public class AppData {
    private static Map<String, Project> projectsData = new HashMap<>();

    static {
        initializeData();
    }

    public static void initializeData() {
        Project softwareDevelopment = new Project("Software Development");
        softwareDevelopment.addTask(new Task("Code Review", "Review the latest pull requests", "To Do"));
        softwareDevelopment.addTask(new Task("Fix Bugs", "Address bugs in the user authentication system", "In Progress"));
        softwareDevelopment.addTask(new Task("Write Unit Tests", "Write unit tests for new features", "To Do"));
        softwareDevelopment.addTask(new Task("Deploy to Production", "Deploy the updated code to production", "Done"));
        softwareDevelopment.addTask(new Task("Refactor Code", "Refactor legacy code for better readability", "To Do"));
        softwareDevelopment.addTask(new Task("Attend Stand-up Meeting", "Daily team stand-up meeting for updates", "Done"));
        softwareDevelopment.addTask(new Task("Document API Endpoints", "Document all API endpoints for the backend", "To Do"));
        softwareDevelopment.addTask(new Task("Collaborate on New Features", "Brainstorm new features with the product team", "In Progress"));

        // Project 2: Personal Website
        Project personalWebsite = new Project("Personal Website");
        personalWebsite.addTask(new Task("Design Homepage", "Create a design for the homepage", "To Do"));
        personalWebsite.addTask(new Task("Build Blog Section", "Develop the blog section with dynamic content", "In Progress"));
        personalWebsite.addTask(new Task("Optimize Images", "Reduce image sizes for faster load times", "Done"));
        personalWebsite.addTask(new Task("Set Up Hosting", "Choose a hosting platform and deploy the website", "To Do"));
        personalWebsite.addTask(new Task("Add Contact Form", "Create a contact form on the website", "To Do"));
        personalWebsite.addTask(new Task("Create About Me Page", "Write content for the About Me page", "In Progress"));
        personalWebsite.addTask(new Task("SEO Optimization", "Optimize website for search engines", "To Do"));
        personalWebsite.addTask(new Task("Integrate Analytics", "Set up Google Analytics for tracking visitors", "In Progress"));

        // Project 3: Exercise Routine
        Project exerciseRoutine = new Project("Exercise Routine");
        exerciseRoutine.addTask(new Task("Morning Stretch", "Stretch for 15 minutes in the morning", "Done"));
        exerciseRoutine.addTask(new Task("Go for a Run", "Run 5 kilometers in the evening", "In Progress"));
        exerciseRoutine.addTask(new Task("Yoga Session", "Attend an online yoga class", "To Do"));
        exerciseRoutine.addTask(new Task("Strength Training", "Lift weights for strength building", "To Do"));
        exerciseRoutine.addTask(new Task("Track Nutrition", "Log daily calories and nutrition intake", "In Progress"));
        exerciseRoutine.addTask(new Task("Meditation", "Meditate for 10 minutes before bed", "To Do"));
        exerciseRoutine.addTask(new Task("Stretch After Run", "Do stretching exercises after a run", "To Do"));
        exerciseRoutine.addTask(new Task("Attend Fitness Class", "Join a fitness class at the local gym", "Done"));

        // Project 4: Learning New Technology
        Project learningNewTech = new Project("Learning New Technology");
        learningNewTech.addTask(new Task("Learn JavaScript ES6", "Study ES6 features like async/await and promises", "To Do"));
        learningNewTech.addTask(new Task("Build a Simple React App", "Create a basic to-do list app using React", "To Do"));
        learningNewTech.addTask(new Task("Watch a Tutorial on Node.js", "Watch a 2-hour tutorial on Node.js basics", "In Progress"));
        learningNewTech.addTask(new Task("Write a Blog Post on React", "Write a blog post to explain React basics", "Done"));
        learningNewTech.addTask(new Task("Read a Book on Python", "Read 'Automate the Boring Stuff with Python'", "To Do"));
        learningNewTech.addTask(new Task("Complete a Full-Stack Tutorial", "Complete a full-stack JavaScript tutorial", "In Progress"));
        learningNewTech.addTask(new Task("Contribute to an Open Source Project", "Submit a pull request to an open source repo", "To Do"));
        learningNewTech.addTask(new Task("Practice Algorithms", "Solve 5 coding problems on LeetCode", "Done"));

        projectsData.put(softwareDevelopment.getProjectName(), softwareDevelopment);
        projectsData.put(personalWebsite.getProjectName(), personalWebsite);
        projectsData.put(exerciseRoutine.getProjectName(), exerciseRoutine);
        projectsData.put(learningNewTech.getProjectName(), learningNewTech);
    }

    public static Map<String, Project> getProjectsData() {
        return projectsData;
    }

    public static void createNewProject() {

    }

    public static void updateProject() {

    }

    public static void deleteProject() {

    }

    public static void createNewTask() {

    }

    public static void updateTask() {

    }

    public static void deleteTask() {

    }
}
