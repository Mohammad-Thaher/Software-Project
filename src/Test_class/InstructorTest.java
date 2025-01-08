package Test_class;

import java.util.ArrayList;
import java.util.List;

import fitness.amanagement.system.Client;
import fitness.amanagement.system.Instructor;
import fitness.amanagement.system.Program;

public class InstructorTest {
    public static void main(String[] args) {

        Instructor instructor = new Instructor(1, "John Doe", "john@example.com", 101, "Certified Fitness Instructor", "Yoga, Cardio, Strength");

        Program program1 = new Program(1, "Morning Yoga", 30, "Easy", "Stretching, Flexibility", "Content for yoga", 50.0, "Mon-Wed-Fri 7:00 AM", 20, true, new ArrayList<>(), "Easy", "Yoga");
        Program program2 = new Program(2, "Cardio Blast", 45, "Medium", "Weight Loss, Cardio", "Content for cardio", 60.0, "Tue-Thu 6:00 PM", 30, true, new ArrayList<>(), "Medium", "Cardio");

        instructor.createProgram(program1);
        instructor.createProgram(program2);
        instructor.updateProgram(1, new Program(1, "Morning Yoga", 30, "Easy", "Stretching, Flexibility, Meditation", "Updated content for yoga", 55.0, "Mon-Wed-Fri 7:00 AM", 25, true, new ArrayList<>(), "Easy", "Yoga"));
        instructor.deleteProgram(2);

        instructor.setProgramDetails(program1, "Yoga tutorial video", "Yoga images", "Yoga documents");

        Client client1 = new Client(101, "Ammar", "ammar@example.com", true, "Weight Loss", "Vegetarian");
        Client client2 = new Client(101, "ali", "ali@example.com", true, "Weight Loss", "Vegetarian");

        instructor.getEnrolledClients().add(client1);
        instructor.getEnrolledClients().add(client2);

        instructor.communicateWithClient(client1, "Hello Alice, welcome to the program!");
        instructor.provideFeedback(client1, "Great progress on your flexibility!");

        instructor.monitorClientProgress(client1);

        instructor.notifyClients("New fitness program available!");
        instructor.announceNewProgram(program1);
        instructor.announceSpecialOffers("Get 20% off on new programs!");

        List<Program> programs = new ArrayList<>();
        programs.add(program1);
        programs.add(program2);
        instructor.managePrograms(programs);

        instructor.trackProgress();

        instructor.sendNotifications();
    }
}