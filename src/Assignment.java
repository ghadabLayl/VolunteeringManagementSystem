public class Assignment {

    private Volunteer volunteer;
    private Task task;

    public Assignment(Volunteer volunteer, Task task) {
        this.volunteer = volunteer;
        this.task = task;
    }

    public void perform() {
        if (volunteer.canWork(task.getRequiredEnergy())) {
            volunteer.work(task.durationHours);
            task.execute();
        } else {
            System.out.println(volunteer.getName() + " is too tired.");
        }
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public Task getTask() {
        return task;
    }
}
