package Test_class;

import java.util.ArrayList;
import java.util.List;

import fitness.amanagement.system.Admin;
import fitness.amanagement.system.Client;
import fitness.amanagement.system.Complaint;
import fitness.amanagement.system.Instructor;
import fitness.amanagement.system.Program;
import fitness.amanagement.system.Subscription;

public class SystemTest {

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
        admin.updateClient(client1, client1.getEmail(), "a@f.com");
        admin.deactivateAccount(client1.getUserId(), "client");
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

        List<String> feedback1 = new ArrayList<>();
        List<String> feedback2 = new ArrayList<>();
        List<String> feedback3 = new ArrayList<>();

        Program program2 = new Program(1, "Yoga for Beginners", 30, "Beginner", "Flexibility", "A gentle yoga program to improve flexibility.", 10.99, "30 minutes daily", 100, true, feedback1, "Beginner", "Flexibility");
        Program program3 = new Program(2, "Muscle Building Basics", 45, "Intermediate", "Muscle Building", "A program focused on building muscle strength.", 19.99, "45 minutes daily", 200, true, feedback2, "Intermediate", "Muscle Building");
        Program program4 = new Program(3, "Advanced Weight Loss", 60, "Advanced", "Weight Loss", "An intense program to help you lose weight quickly.", 29.99, "1 hour daily", 300, true, feedback3, "Advanced", "Weight Loss");

        List<Program> availablePrograms = new ArrayList<>();
        availablePrograms.add(program2);
        availablePrograms.add(program3);
        availablePrograms.add(program4);

        Client client3 = new Client(101, "Ammar", "ammar@example.com", true, "Weight Loss", "Vegetarian");

        client3.customizeProfile("Muscle Building", "Non-Vegetarian");
        client3.viewProgramsByFilters("Beginner", "Flexibility", availablePrograms);
        client3.enrollInProgram(program2);
        client3.enrollInProgram(program3);
        client3.trackProgress();
        client3.updateAttendance();
        client3.addMilestone("Completed 1 week of Yoga");
        client3.provideFeedback(program2, "Challenging but rewarding.");
        client3.viewFeedbacks();

        Subscription subscription = new Subscription("Premium", 29.99);
        client3.subscribeToPlan(subscription);
        client3.manageAccount();

        Instructor instructor2 = new Instructor(1, "John Doe", "john@example.com", 101, "Certified Fitness Instructor", "Yoga, Cardio, Strength");

        Program program5 = new Program(1, "Morning Yoga", 30, "Easy", "Stretching, Flexibility", "Content for yoga", 50.0, "Mon-Wed-Fri 7:00 AM", 20, true, new ArrayList<>(), "Easy", "Yoga");
        Program program6 = new Program(2, "Cardio Blast", 45, "Medium", "Weight Loss, Cardio", "Content for cardio", 60.0, "Tue-Thu 6:00 PM", 30, true, new ArrayList<>(), "Medium", "Cardio");

        instructor2.createProgram(program5);
        instructor2.createProgram(program6);
        instructor2.updateProgram(1, new Program(1, "Morning Yoga", 30, "Easy", "Stretching, Flexibility, Meditation", "Updated content for yoga", 55.0, "Mon-Wed-Fri 7:00 AM", 25, true, new ArrayList<>(), "Easy", "Yoga"));
        instructor2.deleteProgram(2);
        instructor2.setProgramDetails(program5, "Yoga tutorial video", "Yoga images", "Yoga documents");

        Client client4 = new Client(101, "Ammar", "ammar@example.com", true, "Weight Loss", "Vegetarian");
        Client client5 = new Client(101, "Ali", "ali@example.com", true, "Weight Loss", "Vegetarian");

        instructor2.getEnrolledClients().add(client4);
        instructor2.getEnrolledClients().add(client5);

        instructor2.communicateWithClient(client4, "Hello Alice, welcome to the program!");
        instructor2.provideFeedback(client4, "Great progress on your flexibility!");
        instructor2.monitorClientProgress(client4);
        instructor2.notifyClients("New fitness program available!");
        instructor2.announceNewProgram(program5);
        instructor2.announceSpecialOffers("Get 20% off on new programs!");

        List<Program> programs = new ArrayList<>();
        programs.add(program5);
        programs.add(program6);
        instructor2.managePrograms(programs);
        instructor2.trackProgress();
        instructor2.sendNotifications();
    }
}