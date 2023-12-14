public class Asteroid{
    String name;
    String discoverBy;
    double diameter;
    double mass;
    int yearDiscovered;
    Asteroid next;

    public Asteroid() {
    }

    public Asteroid(String name, String discoverBy, double diameter, double mass, int yearDiscovered) {
        this.name = name;
        this.discoverBy = discoverBy;
        this.diameter = diameter;
        this.mass = mass;
        this.yearDiscovered = yearDiscovered;
    }

    public String getName() {
        return name;
    }

    public String getDiscoverBy() {
        return discoverBy;
    }


    public double getDiameter() {
        return diameter;
    }

    public double getMass() {
        return mass;
    }

    public int getYearDiscovered() {
        return yearDiscovered;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDiscover By: " + discoverBy +
                "\nDiameter: " + diameter +
                "\nMass: " + mass +
                "\nYear Discovered: " + yearDiscovered + "\n";
    }
}
