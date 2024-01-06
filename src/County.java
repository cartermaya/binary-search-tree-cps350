// County class
// Maya Carter, 11/10/2023

public class County {

    private String name;
    private int FIPS;
    private String seat;
    private int population;
    private double area;

    // county constructor
    public County(String name, int FIPS, String seat, int population, double area) {
        this.name = name;
        this.FIPS = FIPS;
        this.seat = seat;
        this.population = population;
        this.area = area;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // getter for FIPS
    public int getFIPS() {
        return FIPS;
    }

    // setter for FIPS
    public void setFIPS(int FIPS) {
        this.FIPS = FIPS;
    }

    // getter for seat
    public String getSeat() {
        return seat;
    }

    // setter for seat
    public void setSeat(String seat) {
        this.seat = seat;
    }

    // getter for population
    public int getPopulation() {
        return population;
    }

    // setter for population
    public void setPopulation(int population) {
        this.population = population;
    }

    // getter for area
    public double getArea() {
        return area;
    }

    // setter for area
    public void setArea(double area) {
        this.area = area;
    }

    // method to print out county info as a string
    public String toString() {
        return "Name: " + name + ". FIPS: " + FIPS + ". Seat: " + seat + ". Population: " + population + ". Area: " + area + ".";
    }

} // end County
