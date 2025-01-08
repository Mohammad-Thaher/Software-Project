package fitness.amanagement.system;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private int instructorId;
    private String bio;
    private String expertise;
    private List<Program> programsCreated;
    private List<Client> enrolledClients;

    public Instructor(int userId, String name, String email, int instructorId, String bio, String expertise) {
        super(userId, name, email, true); 
        this.instructorId = instructorId;
        this.bio = bio;
        this.expertise = expertise;
        this.programsCreated = new ArrayList<>(); 
        this.enrolledClients = new ArrayList<>(); 
    }

    public void createProgram(Program program) {
        programsCreated.add(program);
        System.out.println("Program created: " + program.getTitle());
    }

    public void updateProgram(int programId, Program updatedProgram) {
        for (int i = 0; i < programsCreated.size(); i++) {
            if (programsCreated.get(i).getId() == programId) {
                programsCreated.set(i, updatedProgram);
                System.out.println("Program " + programId + " updated.");
                return;
            }
        }
        System.out.println("Program not found.");
    }

    public void deleteProgram(int programId) {
        programsCreated.removeIf(program -> program.getId() == programId);
        System.out.println("Program " + programId + " deleted.");
    }

    public void setProgramDetails(Program program, String videoTutorials, String images, String documents) {
        System.out.println("Setting details for program " + program.getTitle() + ":");
        System.out.println("Video Tutorials: " + videoTutorials);
        System.out.println("Images: " + images);
        System.out.println("Documents: " + documents);
    }

    public void communicateWithClient(Client client, String message) {
        System.out.println("Message to " + client.getName() + ": " + message);
    }

    public void provideFeedback(Client client, String feedback) {
        System.out.println("Feedback for client " + client.getName() + ": " + feedback);
    }

    public void monitorClientProgress(Client client) {
        System.out.println("Monitoring progress for client: " + client.getName());
        System.out.println("Completion Rate: 75%"); 
        System.out.println("Attendance: 10/12 sessions attended.");
    }

    public void notifyClients(String message) {
        for (Client client : enrolledClients) {
            System.out.println("Notification to " + client.getName() + ": " + message);
        }
    }

    public void announceNewProgram(Program program) {
        System.out.println("Announcing new program: " + program.getTitle());
    }

    public void announceSpecialOffers(String offerDetails) {
        System.out.println("Announcing special offer: " + offerDetails);
    }

    public void managePrograms(List<Program> programs) {
        System.out.println("Managing programs...");
        for (Program program : programsCreated) {
            System.out.println("Program: " + program.getTitle());
        }
    }

    public void interactWithClients() {
        System.out.println("Interacting with clients...");
        for (Client client : enrolledClients) {
            communicateWithClient(client, "Hello " + client.getName() + ", how are you?");
        }
    }

    public void trackProgress() {
        System.out.println("Tracking progress...");
        for (Client client : enrolledClients) {
            monitorClientProgress(client);
        }
    }

    public void sendNotifications() {
        System.out.println("Sending notifications...");
        String notificationMessage = "New fitness program available!";
        notifyClients(notificationMessage);
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public List<Program> getProgramsCreated() {
        return programsCreated;
    }

    public void setProgramsCreated(List<Program> programsCreated) {
        this.programsCreated = programsCreated;
    }

    public List<Client> getEnrolledClients() {
        return enrolledClients;
    }

    public void setEnrolledClients(List<Client> enrolledClients) {
        this.enrolledClients = enrolledClients;
    }
}