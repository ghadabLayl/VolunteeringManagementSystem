public class Volunteer {

    private int id;
    private String name;
    private String email;
    private int energyLevel;
    private ExperienceLevel experienceLevel;

    public Volunteer(int id, String name, String email,
                     int energyLevel, ExperienceLevel experienceLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.energyLevel = energyLevel;
        this.experienceLevel = experienceLevel;
    }

    public boolean canWork(int requiredEnergy) {
        return energyLevel >= requiredEnergy;
    }

    public void work(int hours) {
        energyLevel -= hours * 10;
        if (energyLevel < 0) energyLevel = 0;
    }

    public void rest(int hours) {
        energyLevel += hours * 10;
        if (energyLevel > 100) energyLevel = 100;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getEnergyLevel() { return energyLevel; }
    public ExperienceLevel getExperienceLevel() { return experienceLevel; }
}