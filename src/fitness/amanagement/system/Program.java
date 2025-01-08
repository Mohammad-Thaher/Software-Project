package fitness.amanagement.system;

import java.util.List;

public class Program {
    private int id; 
    private String title;
    private int duration; 
    private String difficultyLevel; 
    private String goals; 
    private String content; 
    private double price; 
    private String schedule; 
    private int enrollmentCount; 
    private boolean isActive; 
    private List<String> feedback; 
 private String difficulty;
    private String focusArea;
    public String getDifficulty() {
        return difficulty;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public Program(int id, String title, int duration, String difficultyLevel, String goals, String content, double price, String schedule, int enrollmentCount, boolean isActive, List<String> feedback, String difficulty, String focusArea) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.difficultyLevel = difficultyLevel;
        this.goals = goals;
        this.content = content;
        this.price = price;
        this.schedule = schedule;
        this.enrollmentCount = enrollmentCount;
        this.isActive = isActive;
        this.feedback = feedback;
        this.difficulty = difficulty;
        this.focusArea = focusArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(int enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public void addFeedback(String clientFeedback) {
        if (feedback != null) {
            feedback.add(clientFeedback);
        }
    }

    public int getEnrollments() {
        return enrollmentCount;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", goals='" + goals + '\'' +
                ", price=" + price +
                ", schedule='" + schedule + '\'' +
                ", enrollmentCount=" + enrollmentCount +
                ", isActive=" + isActive +
                '}';
    }
}