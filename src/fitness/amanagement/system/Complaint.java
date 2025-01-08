package fitness.amanagement.system;

public class Complaint {
    private int complaintId;
    private User user;
    private String description;
    private String status; 

    public Complaint(int complaintId, User user, String description) {
        this.complaintId = complaintId;
        this.user = user;
        this.description = description;
        this.status = "Pending";  
    }

    public int getComplaintId() {
        return complaintId;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void resolveComplaint() {
        this.status = "Resolved";
    }

    @Override
    public String toString() {
        return "Complaint ID: " + complaintId + ", User: " + user.getName() + ", Description: " + description + ", Status: " + status;
    }
}
