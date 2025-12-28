public class FoodTask extends Task {

    private int foodPackages;

    public FoodTask(int id, int durationHours, int foodPackages) {
        super(id, durationHours);
        this.foodPackages = foodPackages;
    }

    @Override
    public void execute() {
        System.out.println("Distributing " + foodPackages + " food packages.");
        completed = true;
    }
}
