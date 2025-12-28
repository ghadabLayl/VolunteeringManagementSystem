import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final VolunteerDAO volunteerDAO = new VolunteerDAO();
    private static final EventDAO eventDAO = new EventDAO();
    private static final TaskDAO taskDAO = new TaskDAO();
    private static final AssignmentDAO assignmentDAO = new AssignmentDAO();

    public static void main(String[] args) {

        MyJDBC db = new MyJDBC();
        try {
            db.createSchema();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createVolunteer();
                case 2 -> createEvent();
                case 3 -> createTask();
                case 4 -> assignVolunteer();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Volunteer Management System ===");
        System.out.println("1. Create Volunteer");
        System.out.println("2. Create Event");
        System.out.println("3. Add Task to Event");
        System.out.println("4. Assign Volunteer to Task");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    /* ---------- MENU ACTIONS ---------- */

    private static void createVolunteer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Energy level (0–100): ");
        int energy = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Experience (BEGINNER / INTERMEDIATE / EXPERT): ");
        ExperienceLevel level =
                ExperienceLevel.valueOf(scanner.nextLine().toUpperCase());

        Volunteer v = new Volunteer(0, name, email, energy, level);
        volunteerDAO.save(v);

        System.out.println("Volunteer created successfully!");
    }

    private static void createEvent() {
        System.out.print("Event name: ");
        String name = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        LocalDate date = LocalDate.now();

        Event event = new Event(0, name, date, location);
        int eventID = eventDAO.save(event);

        System.out.println("Event created with ID: " + eventID);
    }

    private static void createTask() {
        System.out.print("Event ID: ");
        int eventID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Task type (FOOD / EDUCATION / LOGISTICS): ");
        String type = scanner.nextLine().toUpperCase();

        System.out.print("Duration (hours): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Task task;
        switch (type) {
            case "FOOD" -> {
                System.out.print("Food packages: ");
                int packages = scanner.nextInt();
                scanner.nextLine();
                task = new FoodTask(0, duration, packages);
            }
            case "EDUCATION" -> {
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                task = new EducationTask(0, duration, subject);
            }
            default -> {
                System.out.print("Equipment: ");
                String equipment = scanner.nextLine();
                task = new LogisticsTask(0, duration, equipment);
            }
        }

        taskDAO.save(task, eventID);
        System.out.println("Task added successfully!");
    }

    private static void assignVolunteer() {
        System.out.print("Volunteer ID: ");
        int volunteerID = scanner.nextInt();

        System.out.print("Task ID: ");
        int taskID = scanner.nextInt();

        System.out.print("Hours contributed: ");
        int hours = scanner.nextInt();
        scanner.nextLine();

        assignmentDAO.save(volunteerID, taskID, hours);
        System.out.println("Volunteer assigned successfully!");
    }
}
