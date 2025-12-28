public abstract class Task {

    protected int id;
    protected int durationHours;
    protected boolean completed = false;

    public Task(int id, int durationHours) {
        this.id = id;
        this.durationHours = durationHours;
    }

    public abstract void execute();

    public int getRequiredEnergy() {
        return durationHours * 10;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }
}
