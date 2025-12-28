public class LogisticsTask extends Task {

    private String equipment;

    public LogisticsTask(int id, int durationHours, String equipment) {
        super(id, durationHours);
        this.equipment = equipment;
    }

    @Override
    public void execute() {
        System.out.println("Managing logistics for: " + equipment);
        completed = true;
    }
}
