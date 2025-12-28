import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private int id;
    private String name;
    private LocalDate date;
    private String location;

    private List<Task> tasks = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public Event(int id, String name, LocalDate date, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void assignVolunteer(Volunteer volunteer, Task task) {
        assignments.add(new Assignment(volunteer, task));
    }

    public void startEvent() {
        System.out.println("Event started: " + name);

        for (Assignment assignment : assignments) {
            assignment.perform();
        }
    }

    public boolean isCompleted() {
        return tasks.stream().allMatch(Task::isCompleted);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
