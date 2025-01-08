package fitness.amanagement.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
private static List<Program> availablePrograms;
    public static void main(String[] args) {
         availablePrograms.add(new Program(1, "Beginner Yoga", 30, "Easy", "Improve flexibility and relaxation", "Basic yoga poses and breathing exercises", 0.0, "Mon, Wed, Fri 10:00 AM", 100, true, new ArrayList<>(), "Easy", "Flexibility"));
        availablePrograms.add(new Program(2, "Advanced Strength Training", 45, "Hard", "Build muscle strength", "Weight lifting and advanced exercises", 30.0, "Mon, Wed, Fri 6:00 PM", 50, true, new ArrayList<>(), "Hard", "Strength"));
        availablePrograms.add(new Program(3, "Intermediate Pilates", 40, "Medium", "Enhance core strength and flexibility", "Pilates exercises for intermediate level", 20.0, "Tue, Thu 8:00 AM", 75, true, new ArrayList<>(), "Medium", "Flexibility"));
        availablePrograms.add(new Program(4, "Cardio Blast", 30, "Medium", "Increase cardiovascular endurance", "Cardio exercises, such as jumping jacks, sprints", 15.0, "Mon, Wed, Fri 7:00 AM", 200, true, new ArrayList<>(), "Medium", "Endurance"));
        availablePrograms.add(new Program(5, "Advanced Kickboxing", 50, "Hard", "Build strength and improve combat skills", "Kickboxing training for advanced participants", 25.0, "Mon, Thu 5:00 PM", 60, true, new ArrayList<>(), "Hard", "Strength"));
        Admin admin = new Admin(1, "Ahmad Ali", "admin@example.com");

        Instructor instructor = new Instructor(1, "Ahmed Alali", "ahmed@example.com", 
            101, "Expert Trainer in Fitness", "Strength Training");
      Client client = new Client(1, "Fatima Zahra", "fatima@example.com", 
            true, "Weight Loss", "Vegetarian");

        Subscription basicSubscription = new Subscription("Basic", 50.0);

        int choice;
        do {
            showMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    adminMenu(admin, client, availablePrograms);
                    break;
                case 2: 
                    instructorMenu(instructor, availablePrograms);
                    break;
                case 3: 
                    clientMenu(client, availablePrograms, basicSubscription);
                    break;
                case 4: 
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice != 4);
    }

    private static void showMainMenu() {
        System.out.println("\n--- Fitness Management System ---");
        System.out.println("1. Admin Features");
        System.out.println("2. Instructor Features");
        System.out.println("3. Client Features");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    private static void adminMenu(Admin admin, Client client, List<Program> programs) {
        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. User Management");
            System.out.println("2. Program Monitoring");
            System.out.println("3. Content Management");
            System.out.println("4. Subscription Management");
            System.out.println("5. Return to Main Menu");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageUsers(admin);
                    break;
                case 2:
                    monitorPrograms(admin);
                    break;
                case 3:
                    manageContent(admin);
                    break;
                case 4:
                    manageSubscriptions(admin, client);
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 5);
    }

    private static void instructorMenu(Instructor instructor, List<Program> programs) {
        int choice;
        do {
            System.out.println("\n--- Instructor Menu ---");
            System.out.println("1. Manage Programs");
            System.out.println("2. Interact with Clients");
            System.out.println("3. Track Client Progress");
            System.out.println("4. Notifications and Updates");
            System.out.println("5. Return to Main Menu");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    instructor.managePrograms(programs);
                    break;
                case 2:
                    instructor.interactWithClients();
                    break;
                case 3:
                    instructor.trackProgress();
                    break;
                case 4:
                    instructor.sendNotifications();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 5);
    }

    private static void clientMenu(Client client, List<Program> programs, Subscription subscription) {
        int choice;
        do {
            System.out.println("\n--- Client Menu ---");
            System.out.println("1. Browse and Enroll in Programs");
            System.out.println("2. Track Progress");
            System.out.println("3. Provide Feedback");
            System.out.println("4. Manage Account");
              System.out.println("5.view Programs By Filters");
            System.out.println("6. Return to Main Menu");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    client.browsePrograms(programs);
                    break;
                case 2:
                    client.trackProgress();
                    break;
                case 3:
                    System.out.print("Enter feedback: ");
                    String feedback = scanner.nextLine();
                    client.provideFeedback(programs.get(0), feedback);
                    break;
                case 4:
                    client.manageAccount();
                   case 5:
                       String difficulty;
                        String focusArea;
                         for (Program program : availablePrograms) {
                             System.out.println(program.getDifficulty());
                              System.out.println(program.getFocusArea());

                         }
                         System.out.println(" Input difficulty");
                         difficulty=scanner.next();
                          System.out.println(" Input focusArea");
                         focusArea=scanner.next();
                   client.viewProgramsByFilters(difficulty, focusArea, availablePrograms);
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 5);
    }

      private static void manageUsers(Admin admin) {
        System.out.println("\n--- Manage Users ---");
        System.out.println("1. Add Instructor");
        System.out.println("2. Update Instructor");
        System.out.println("3. Deactivate Instructor");
        System.out.println("4. Add Client");
        System.out.println("5. Update Client");
        System.out.println("6. Deactivate Client");
        System.out.println("7. Approve Instructor Registration");
        System.out.println("8. Monitor User Activity");
        System.out.println("9. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:

                System.out.println("Enter Instructor ID:");
                int instructorId = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Enter Instructor Name:");
                String instructorName = scanner.nextLine();
                System.out.println("Enter Instructor Email:");
                String instructorEmail = scanner.nextLine();
                System.out.println("Enter Instructor Bio:");
                String bio = scanner.nextLine();
                System.out.println("Enter Instructor Expertise:");
                String expertise = scanner.nextLine();

                Instructor newInstructor = new Instructor(instructorId, instructorName, instructorEmail, instructorId, bio, expertise);
                admin.addInstructor(newInstructor);
                break;

            case 2:

                System.out.println("Enter Instructor ID to Update:");
                int updateInstructorId = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Enter New Instructor Name:");
                String newInstructorName = scanner.nextLine();
                System.out.println("Enter New Instructor Email:");
                String newInstructorEmail = scanner.nextLine();
                Instructor instructorToUpdate = findInstructorById(admin, updateInstructorId);
                if (instructorToUpdate != null) {
                    admin.updateInstructor(instructorToUpdate, newInstructorName, newInstructorEmail);
                } else {
                    System.out.println("Instructor not found.");
                }
                break;

            case 3:

                System.out.println("Enter Instructor ID to Deactivate:");
                int deactivateInstructorId = scanner.nextInt();
                Instructor instructorToDeactivate = findInstructorById(admin, deactivateInstructorId);
                if (instructorToDeactivate != null) {
                    admin.deactivateInstructor(instructorToDeactivate);
                } else {
                    System.out.println("Instructor not found.");
                }
                break;

            case 4:

                System.out.println("Enter Client User ID:");
                int clientId = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Enter Client Name:");
                String clientName = scanner.nextLine();
                System.out.println("Enter Client Email:");
                String clientEmail = scanner.nextLine();
                System.out.println("Enter Client Fitness Goals:");
                String fitnessGoals = scanner.nextLine();
                System.out.println("Enter Client Dietary Preferences:");
                String dietaryPreferences = scanner.nextLine();

                Client newClient = new Client(clientId, clientName, clientEmail, true, fitnessGoals, dietaryPreferences);
                admin.addClient(newClient);
                break;

            case 5:

                System.out.println("Enter Client ID to Update:");
                int updateClientId = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Enter New Client Name:");
                String newClientName = scanner.nextLine();
                System.out.println("Enter New Client Email:");
                String newClientEmail = scanner.nextLine();
                Client clientToUpdate = findClientById(admin, updateClientId);
                if (clientToUpdate != null) {
                    admin.updateClient(clientToUpdate, newClientName, newClientEmail);
                } else {
                    System.out.println("Client not found.");
                }
                break;

            case 6:

                System.out.println("Enter Client ID to Deactivate:");
                int deactivateClientId = scanner.nextInt();
                Client clientToDeactivate = findClientById(admin, deactivateClientId);
                if (clientToDeactivate != null) {
                    admin.deactivateClient(clientToDeactivate);
                } else {
                    System.out.println("Client not found.");
                }
                break;

            case 7:

                System.out.println("Enter Instructor ID to Approve:");
                int approveInstructorId = scanner.nextInt();
                Instructor instructorToApprove = findInstructorById(admin, approveInstructorId);
                if (instructorToApprove != null) {
                    admin.approveInstructorRegistration(instructorToApprove);
                } else {
                    System.out.println("Instructor not found.");
                }
                break;

            case 8:

                admin.monitorUserActivity();
                break;

            case 9:
                System.out.println("Exiting...");
                return;  

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
private static Instructor findInstructorById(Admin admin, int instructorId) {
        for (Instructor instructor : admin.getInstructors()) {
            if (instructor.getInstructorId() == instructorId) {
                return instructor;
            }
        }
        return null;
    }

    private static Client findClientById(Admin admin, int clientId) {
        for (Client client : admin.getClients()) {
            if (client.getUserId() == clientId) {
                return client;
            }
        }
        return null;
    }

    private static void monitorPrograms(Admin admin) {
        System.out.println("\n--- Monitor Programs ---");
        admin.trackPrograms();
         admin.viewProgramStatistics();
    }

    private static void manageContent(Admin admin) {
        System.out.println("\n--- Manage Content ---");
        System.out.println("1. Approve or Reject Wellness Articles");
        System.out.println("2. Approve Health and Wellness Tips");
        System.out.println("3. Handle User Feedback and Complaints");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:

                System.out.println("Enter Article ID to approve/reject:");
                int articleId = scanner.nextInt();
                scanner.nextLine();  
                System.out.println("Enter 'approve' to approve or 'reject' to reject:");
                String decision = scanner.nextLine();

                if ("approve".equalsIgnoreCase(decision)) {
                    System.out.println("Wellness Article " + articleId + " has been approved.");
                    admin.approveArticle(articleId);
                } else if ("reject".equalsIgnoreCase(decision)) {
                    System.out.println("Wellness Article " + articleId + " has been rejected.");
                    admin.rejectArticle(articleId);
                } else {
                    System.out.println("Invalid decision.");
                }
                break;

            case 2:

                System.out.println("Enter Tip ID to approve:");
                int tipId = scanner.nextInt();
                scanner.nextLine();  

                System.out.println("Health and Wellness Tip " + tipId + " has been approved.");
                admin.approveTip(tipId);
                break;

            case 3:

                System.out.println("Enter User ID to view feedback/complaint:");
                int userId = scanner.nextInt();
                scanner.nextLine();  

                System.out.println("Enter the feedback/complaint:");
                String feedbackOrComplaint = scanner.nextLine();
                System.out.println("Handling feedback/complaint from User " + userId + ": " + feedbackOrComplaint);
                admin.handleFeedback(userId, feedbackOrComplaint);
                break;

            case 4:
                System.out.println("Exiting Content Management.");
                return;  

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageSubscriptions(Admin admin, Client client) {

        System.out.println("\n--- Manage Subscriptions ---");
        System.out.println("Available Subscription Types:");
        System.out.println("1. Free");
        System.out.println("2. Silver");
        System.out.println("3. Gold");
        System.out.println("4. Premium");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter subscription type number (1-4): ");
        int choice = scanner.nextInt();

        String subscriptionType = "";
        switch (choice) {
            case 1:
                subscriptionType = "Free";
                break;
            case 2:
                subscriptionType = "Silver";
                break;
            case 3:
                subscriptionType = "Gold";
                break;
            case 4:
                subscriptionType = "Premium";
                break;
            default:
                System.out.println("Invalid choice! Subscription not changed.");
                return;
        }

        admin.manageSubscription(client, subscriptionType);
    }
}