package Test_class;

import java.util.ArrayList;
import java.util.List;

import fitness.amanagement.system.Client;
import fitness.amanagement.system.Program;
import fitness.amanagement.system.Subscription;

public class ClientTest {

    public static void main(String[] args) {

        List<String> feedback1 = new ArrayList<>();
        List<String> feedback2 = new ArrayList<>();
        List<String> feedback3 = new ArrayList<>();

        Program program1 = new Program(
                1, "Yoga for Beginners", 30, "Beginner", "Flexibility", 
                "A gentle yoga program to improve flexibility.", 10.99, 
                "30 minutes daily", 100, true, feedback1, "Beginner", "Flexibility");

        Program program2 = new Program(
                2, "Muscle Building Basics", 45, "Intermediate", "Muscle Building", 
                "A program focused on building muscle strength.", 19.99, 
                "45 minutes daily", 200, true, feedback2, "Intermediate", "Muscle Building");

        Program program3 = new Program(
                3, "Advanced Weight Loss", 60, "Advanced", "Weight Loss", 
                "An intense program to help you lose weight quickly.", 29.99, 
                "1 hour daily", 300, true, feedback3, "Advanced", "Weight Loss");

        List<Program> availablePrograms = new ArrayList<>();
        availablePrograms.add(program1);
        availablePrograms.add(program2);
        availablePrograms.add(program3);

        Client client = new Client(101, "Ammar", "ammar@example.com", true, "Weight Loss", "Vegetarian");

        client.customizeProfile("Muscle Building", "Non-Vegetarian");

        client.viewProgramsByFilters("Beginner", "Flexibility", availablePrograms);

        client.enrollInProgram(program1);
        client.enrollInProgram(program2);

        client.trackProgress();

        client.updateAttendance();

        client.addMilestone("Completed 1 week of Yoga");

        client.provideFeedback(program1, "Great program, very relaxing.");
        client.provideFeedback(program2, "Challenging but rewarding.");

        client.viewFeedbacks();

        Subscription subscription = new Subscription("Premium", 29.99);
        client.subscribeToPlan(subscription);

        client.manageAccount();
    }
}