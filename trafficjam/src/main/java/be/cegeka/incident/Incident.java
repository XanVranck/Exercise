package be.cegeka.incident;

public class Incident {

    private String name;
    private String type;
    private int distance;

    public Incident(String name, String type, int distance) {
        this.name = name;
        this.type = type;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }
}
