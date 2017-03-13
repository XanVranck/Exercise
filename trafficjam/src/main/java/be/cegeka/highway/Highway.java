package be.cegeka.highway;

import be.cegeka.incident.Incident;

import java.util.ArrayList;
import java.util.List;

public class Highway {

    private String name;
    private int distance;
    private List<Incident> incidents = new ArrayList<>();

    public Highway(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void addIncident(Incident incident) {
        if(checkDistance(incident)) {
            incidents.add(incident);
        }
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public boolean checkDistance(Incident incident) {
        if(distance>incident.getDistance()){
            return true;
        }else {
            throw new IllegalArgumentException("The distance of the incident can't be larger than the distance of the highway!");
        }
    }

    public List<Incident> searchIncidents(Highway highway) {
        List<Incident> trafficJamIncidents = new ArrayList<>();
        for (Incident incident : highway.getIncidents()) {
            if (incident.getType().toLowerCase().equals("traffic jam")){
                trafficJamIncidents.add(incident);
            }
        }
        return trafficJamIncidents;
    }


    public List<Incident> resolveIncident(Incident incident) {

        for (Incident incident1 : incidents) {
            if(incident1.equals(incident)){
                incidents.remove(incident1);
                return incidents;
            }
        }
        throw new IllegalArgumentException("The incident doesn't exist");
    }
}
