package Test_class;

import java.util.List;

import fitness.amanagement.system.Admin;
import fitness.amanagement.system.Client;
import fitness.amanagement.system.Complaint;
import fitness.amanagement.system.Instructor;
import fitness.amanagement.system.Program;

import java.util.ArrayList;

public class AdminTest {

    public static void main(String[] args) {

        Admin admin = new Admin(1, "Admin", "admin@fitness.com");

        Client client1 = new Client(2, "John Doe", "john.doe@example.com", true, "Lose Weight", "Vegetarian");
        Client client2 = new Client(3, "Jane Smith", "jane.smith@example.com", true, "Gain Muscle", "Non-Vegetarian");

        Instructor instructor1 = new Instructor(4, "Mike Johnson", "mike.johnson@example.com", 101, "Certified Fitness Coach", "Strength Training");

        Program program1 = new Program(1, "Beginner Yoga", 30, "Easy", "Improve flexibility and relaxation", "Basic yoga poses and breathing exercises", 0.0, "Mon, Wed, Fri 10:00 AM", 100, true, new ArrayList<>(), "Easy", "Flexibility");

        admin.addClient(client1);
        admin.addClient(client2);

        admin.addInstructor(instructor1);

        admin.approveInstructorRegistration(instructor1);

        admin.monitorUserActivity();

        client1.enrollInProgram(program1);

        admin.updateClient(client1,client1.getEmail(),"a@f.com");

        admin.deactivateAccount(client1.getUserId(),"client");

        admin.viewProgramStatistics();
        admin.generateReports();

        admin.trackPrograms();

        admin.approveContent("Wellness Tip: Drink more water", instructor1);
        admin.rejectContent("Wellness Tip: Skip meals for weight loss", instructor1);

        Complaint complaint1 = new Complaint(1, client1, "Program not accessible.");
        Complaint complaint2 = new Complaint(2, client2, "Unable to cancel subscription.");

        admin.addComplaint(complaint1);
        admin.addComplaint(complaint2);

        admin.handleUserComplaints();  
        admin.resolveComplaint(1);     
        admin.handleUserComplaints();  

        admin.manageSubscription(client1, "Premium");

        admin.viewUsers();
        admin.viewPrograms();
        admin.viewContent();
    }
}