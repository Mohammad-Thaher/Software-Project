package fitness.amanagement.system;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private int adminId;
    private String name;
    private String email;
    private List<Content> content;

    private List<Instructor> instructors;
    private List<Complaint> complaints;
    private List<Client> clients;
    private List<Program> programs;
    private List<String> wellnessArticles; 
 private List<String> approvedArticles;
    private List<String> rejectedArticles;
    private List<String> approvedTips;
    private List<String> feedbacks;
      public void approveArticle(int articleId) {

        String article = "Article_" + articleId;  
        approvedArticles.add(article);  
        System.out.println("Article " + articleId + " has been approved.");
    }

    public void rejectArticle(int articleId) {

        String article = "Article_" + articleId;  
        rejectedArticles.add(article);  
        System.out.println("Article " + articleId + " has been rejected.");
    }

    public void approveTip(int tipId) {

        String tip = "Tip_" + tipId;  
        approvedTips.add(tip);  
        System.out.println("Health and Wellness Tip " + tipId + " has been approved.");
    }

    public void handleFeedback(int userId, String feedbackOrComplaint) {

        String feedback = "Feedback from User " + userId + ": " + feedbackOrComplaint;
        feedbacks.add(feedback);  
        System.out.println("Feedback/Complaint from User " + userId + " has been handled: " + feedbackOrComplaint);
    }

    public List<String> getApprovedArticles() {
        return approvedArticles;
    }

    public List<String> getRejectedArticles() {
        return rejectedArticles;
    }

    public List<String> getApprovedTips() {
        return approvedTips;
    }

    public void manageSubscriptions(Client client) {
        System.out.println("\n--- Manage Subscription for Client: " + client.getName() + " ---");
        System.out.println("Current Subscription: " + client.getSubscriptionType());

        if (client.getSubscriptionType().equals("Free")) {
            client.setSubscriptionType("Premium");  
            System.out.println(client.getName() + "'s subscription has been upgraded to Premium.");
        } else {
            System.out.println(client.getName() + " already has a " + client.getSubscriptionType() + " subscription.");
        }
    }
    public List<String> getFeedbacks() {
        return feedbacks;
    }
    public Admin(int adminId, String name, String email) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.instructors = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.wellnessArticles = new ArrayList<>();
        
        this.programs = new ArrayList<>();
        this.content = new ArrayList<>();
        this.complaints = new ArrayList<>();
    }
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    // Method to handle (view and resolve) complaints
    public void handleUserComplaints() {
        System.out.println("User Complaints:");
        if (complaints.isEmpty()) {
            System.out.println("No complaints to handle.");
        } else {
            for (Complaint complaint : complaints) {
                System.out.println(complaint);
            }
        }
    }
    public void approveContent(String contentText, User instructor) {
        for (Content c : content) {
            if (c.getContentText().equals(contentText) && c.getInstructor().equals(instructor)) {
                c.approveContent();
                System.out.println("Content approved: " + c);
                return;
            }
        }
        System.out.println("Content not found or instructor mismatch.");
    }

    // Method to reject content
    public void rejectContent(String contentText, User instructor) {
        for (Content c : content) {
            if (c.getContentText().equals(contentText) && c.getInstructor().equals(instructor)) {
                c.rejectContent();
                System.out.println("Content rejected: " + c);
                return;
            }
        }
        System.out.println("Content not found or instructor mismatch.");
    }
    // Method to resolve a complaint by its ID
    public void resolveComplaint(int complaintId) {
        for (Complaint complaint : complaints) {
            if (complaint.getComplaintId() == complaintId) {
                complaint.resolveComplaint();
                System.out.println("Complaint resolved: " + complaint);
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }
    public void addInstructor(Instructor instructor) {
        if (instructor.isActive()) {
            instructors.add(instructor);
            System.out.println("Instructor added: " + instructor.getName());
        } else {
            System.out.println("Instructor registration not approved yet.");
        }
    }

    public void updateInstructor(Instructor instructor, String newName, String newEmail) {
        if (instructors.contains(instructor)) {
            instructor.setName(newName);
            instructor.setEmail(newEmail);
            System.out.println("Instructor information updated: " + instructor.getName());
        } else {
            System.out.println("Instructor not found.");
        }
    }

    public void updateClient(Client client, String newName, String newEmail) {
        if (clients.contains(client)) {
            client.setName(newName);
            client.setEmail(newEmail);
            System.out.println("Client information updated: " + client.getName());
        } else {
            System.out.println("Client not found.");
        }
    }

    public void deactivateInstructor(Instructor instructor) {
        if (instructors.contains(instructor)) {
            instructor.setActive(false);
            System.out.println("Instructor deactivated: " + instructor.getName());
        } else {
            System.out.println("Instructor not found.");
        }
    }

    public void deactivateClient(Client client) {
        if (clients.contains(client)) {
            client.setActive(false);
            System.out.println("Client deactivated: " + client.getName());
        } else {
            System.out.println("Client not found.");
        }
    }

    public void approveInstructorRegistration(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructor.setActive(true);
            System.out.println("Instructor approved for registration: " + instructor.getName());
        } else {
            System.out.println("Instructor is already registered.");
        }
    }

    public void monitorUserActivity() {
        System.out.println("Monitoring user activity:");
        System.out.println("Total Instructors: " + instructors.size());
        System.out.println("Total Clients: " + clients.size());

    }

    public void approveInstructor(Instructor instructor) {
        System.out.println("Instructor approved: " + instructor.getName());
    }

    public void addClient(Client client) {
        clients.add(client);
        System.out.println("Client added: " + client.getName());
    }

    public void deactivateAccount(int userId, String role) {
        if (role.equalsIgnoreCase("Instructor")) {
            instructors.removeIf(instructor -> instructor.getInstructorId() == userId);
            System.out.println("Instructor account deactivated.");
        } else if (role.equalsIgnoreCase("Client")) {
            clients.removeIf(client -> client.getUserId() == userId);
            System.out.println("Client account deactivated.");
        }
    }

    public void viewProgramStatistics() {
        System.out.println("Most popular programs by enrollment:");
        for (Program program : programs) {
            System.out.println(program.getTitle() + " - Enrollments: " + program.getEnrollments());
        }
    }

    public void generateReports() {
        System.out.println("Generating reports on revenue, attendance, and client progress...");

    }

    public void trackPrograms() {
        System.out.println("Tracking active and completed programs...");
        for (Program program : programs) {
            System.out.println(program.getTitle() + " - Status: " + (program.isActive() ? "Active" : "Completed"));
        }
    }

    public void approveWellnessArticle(String article) {
        wellnessArticles.add(article);
        System.out.println("Wellness article approved: " + article);
    }

    public void handleFeedback(String feedback) {
        System.out.println("User feedback received: " + feedback);

    }

    public void manageSubscription(Client client, String subscriptionType) {
        client.setSubscriptionType(subscriptionType);
        System.out.println("Subscription updated for client: " + client.getName() + " to " + subscriptionType);
    }
    public void viewUsers() {
        System.out.println("Users:");
        for (User user : clients) {
            System.out.println(user);
        }
        for (User user : instructors) {
            System.out.println(user);
        }
    }

    

    // Method to view all content (articles, tips, etc.)
    public void viewContent() {
        System.out.println("Content:");
        for (Content contentItem : content) {
            System.out.println(contentItem);
        }
    }
    public void addProgram(Program program) {
        program.setId(programs.size());
        programs.add(program);
        System.out.println("Program added successfully: " + program.getTitle());
    }

    public void viewPrograms() {
        if (programs.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            System.out.println("Programs:");
            for (Program program : programs) {
                System.out.println(program);
            }
        }
    }

    public void removeProgram(int programId) {
        Program programToRemove = null;
        for (Program program : programs) {
            if (program.getId() == programId) {
                programToRemove = program;
                break;
            }
        }

        if (programToRemove != null) {
            programs.remove(programToRemove);
            System.out.println("Program removed successfully: " + programToRemove.getTitle());
        } else {
            System.out.println("Program with ID " + programId + " not found.");
        }
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}