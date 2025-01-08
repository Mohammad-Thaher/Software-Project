package fitness.amanagement.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends User {

    private String fitnessGoals;
    private String dietaryPreferences;
    private String subscriptionType;
    private List<Program> enrolledPrograms;
    private ArrayList<String> feedbacks;
    private Subscription subscription;
    private int attendanceCount;
    private ArrayList<String> progressMilestones;

    // Constructor for Client
    public Client(int userId, String name, String email, boolean isActive, String fitnessGoals, String dietaryPreferences) {
        super(userId, name, email, isActive); 
        this.fitnessGoals = fitnessGoals;
        this.dietaryPreferences = dietaryPreferences;
        this.subscriptionType = "Free"; 
        this.enrolledPrograms = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.progressMilestones = new ArrayList<>();
        this.attendanceCount = 0; 
    }

    // Method to view programs by filters
    public void viewProgramsByFilters(String difficulty, String focusArea, List<Program> availablePrograms) {
        System.out.println("Browsing programs with filters - Difficulty: " + difficulty + ", Focus Area: " + focusArea);

        boolean foundProgram = false;

        for (Program program : availablePrograms) {
            boolean matchesDifficulty = (difficulty == null || program.getDifficulty().equalsIgnoreCase(difficulty));
            boolean matchesFocusArea = (focusArea == null || program.getFocusArea().equalsIgnoreCase(focusArea));

            if (matchesDifficulty && matchesFocusArea) {
                System.out.println(program.toString()); 
                foundProgram = true;
            }
        }

        if (!foundProgram) {
            System.out.println("No programs found with the selected filters.");
        }
    }

    // Method to customize the profile
    public void customizeProfile(String fitnessGoals, String dietaryPreferences) {
        this.fitnessGoals = fitnessGoals;
        this.dietaryPreferences = dietaryPreferences;
        System.out.println("Profile updated for client: " + getName());
    }

    // Method to enroll in a program
    public void enrollInProgram(Program program) {
        enrolledPrograms.add(program);
        System.out.println("Successfully enrolled in program: " + program.getTitle());
    }

    // Method to track progress (attendance, milestones)
    public void trackProgress() {
        System.out.println("Progress for client: " + getName());
        System.out.println("Attendance Count: " + attendanceCount);
        if (progressMilestones.isEmpty()) {
            System.out.println("No milestones achieved yet.");
        } else {
            System.out.println("Milestones Achieved:");
            for (String milestone : progressMilestones) {
                System.out.println(milestone);
            }
        }
    }

    // Method to update attendance count
    public void updateAttendance() {
        attendanceCount++;
        System.out.println("Attendance updated for client: " + getName());
    }

    // Method to add progress milestone
    public void addMilestone(String milestone) {
        progressMilestones.add(milestone);
        System.out.println("Milestone achieved: " + milestone);
    }

    // Method to provide feedback for programs
    public void provideFeedback(Program program, String feedback) {
        feedbacks.add("Feedback for program \"" + program.getTitle() + "\": " + feedback);
        System.out.println("Feedback submitted for program: " + program.getTitle());
    }

    // Method to view feedbacks
    public void viewFeedbacks() {
        if (feedbacks.isEmpty()) {
            System.out.println("No feedback provided yet.");
        } else {
            System.out.println("Client Feedbacks:");
            for (String feedback : feedbacks) {
                System.out.println(feedback);
            }
        }
    }

    // Method to subscribe to a plan
    public void subscribeToPlan(Subscription subscription) {
        this.subscription = subscription;
        this.subscriptionType = subscription.getPlanName();
        System.out.println("Client " + getName() + " subscribed to plan: " + subscription.getPlanName());
    }

    // Method to manage account details
    public void manageAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Managing account for client: " + getName());
        System.out.println("Client Info:");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Fitness Goals: " + fitnessGoals);
        System.out.println("Dietary Preferences: " + dietaryPreferences);
        System.out.println("Subscription Type: " + subscriptionType);

        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Update Fitness Goals");
        System.out.println("2. Update Dietary Preferences");
        System.out.println("3. Update Subscription Type");
        System.out.println("4. Update Email");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:
                System.out.print("Enter new fitness goals: ");
                fitnessGoals = scanner.nextLine();
                System.out.println("Fitness Goals updated.");
                break;
            case 2:
                System.out.print("Enter new dietary preferences: ");
                dietaryPreferences = scanner.nextLine();
                System.out.println("Dietary Preferences updated.");
                break;
            case 3:
                System.out.print("Enter new subscription type: ");
                subscriptionType = scanner.nextLine();
                System.out.println("Subscription Type updated.");
                break;
            case 4:
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                setEmail(newEmail);  
                System.out.println("Email updated.");
                break;
            case 5:
                System.out.println("Exiting account management.");
                break;
            default:
                System.out.println("Invalid choice. Exiting account management.");
                break;
        }
    }

    // Getters and Setters for other attributes
    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public List<Program> getEnrolledPrograms() {
        return enrolledPrograms;
    }

    public void setEnrolledPrograms(List<Program> enrolledPrograms) {
        this.enrolledPrograms = enrolledPrograms;
    }

    public ArrayList<String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(ArrayList<String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void browsePrograms(List<Program> programs) {
        System.out.println("Browsing available programs...");
        if (programs.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            for (Program program : programs) {
                System.out.println(program.toString());
                System.out.println("-------------------------");
            }
        }
    }
}
