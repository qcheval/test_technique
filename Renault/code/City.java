package code;

public class City {
    
    private String city;

    private String country;

    private int elevation;

    private int population;

    public City(String city, String country, int elevation, int population) {
        this.city = city;
        this.country = country;
        this.elevation = elevation;
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getElevation() {
        return elevation;
    }

    public int getPopulation() {
        return population;
    }

    @Override //pour éviter d'afficher code.City@567cd4d (TP1 ou TP2)
    public String toString() {
        return "City: " + city + ", Country: " + country +
               ", Elevation: " + elevation + " m, Population: " + population;
    }

}
