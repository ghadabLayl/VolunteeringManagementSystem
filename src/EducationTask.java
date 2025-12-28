public class EducationTask extends Task {

    private String subject;

    public EducationTask(int id, int durationHours, String subject) {
        super(id, durationHours);
        this.subject = subject;
    }

    @Override
    public void execute() {
        System.out.println("Teaching subject: " + subject);
        completed = true;
    }
}
