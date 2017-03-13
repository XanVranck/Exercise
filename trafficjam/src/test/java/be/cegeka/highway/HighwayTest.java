package be.cegeka.highway;

import be.cegeka.incident.Incident;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class HighwayTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Highway highway, highway2;
    private Incident incident, incident2, incident3;
    private List<Incident> incidents;

    @Before
    public void setUp() {
        incidents = new ArrayList<>();
        highway = new Highway("name", 655);
        highway2 = new Highway("name", 24);
        incident = new Incident("inci1", "traffic jam", 25);
        incident2 = new Incident("inci2", "burp", 25);
        incident3 = new Incident("inci3", "traffic JAM", 25);
    }

    @Test
    public void getNameShouldReturnName() {

        Assertions.assertThat(highway.getName()).isEqualTo("name");
    }

    @Test
    public void getDistanceShouldReturnDistance() {
        Assertions.assertThat(highway.getDistance()).isEqualTo(655);
    }

    @Test
    public void addIncidentShouldAddAnIncidentToHighWay() {
        incidents.add(incident);
        highway.addIncident(incident);
        Assertions.assertThat(highway.getIncidents()).isEqualTo(incidents);
    }

    @Test
    public void cantAddIncidentIfDistanceOfIncidentIsLargerThanDistanceOfHighway() throws Exception {
        expectedException.expectMessage("The distance of the incident can't be larger than the distance of the highway!");
        highway2.addIncident(incident);
    }

    @Test
    public void searchIncidentsOfTypeTrafficJam() {
        incidents.add(incident);
        incidents.add(incident3);
        highway.addIncident(incident);
        highway.addIncident(incident2);
        highway.addIncident(incident3);
        Assertions.assertThat(highway.searchIncidents(highway)).isEqualTo(incidents);
    }

    @Test
    public void searchIncidentsWithoutTypeTrafficJam() {
        highway.addIncident(incident2);
        Assertions.assertThat(highway.searchIncidents(highway)).isEmpty();
    }

    @Test
    public void resolveAnIncident() {
        highway.addIncident(incident);
        highway.addIncident(incident2);
        incidents.add(incident2);
        Assertions.assertThat(highway.resolveIncident(incident)).isEqualTo(incidents);
    }

    @Test
    public void resolveIncidentDoesNotExistException() throws Exception {
        expectedException.expectMessage("The incident doesn't exist");
        highway.addIncident(incident);
        highway.addIncident(incident2);
        highway.resolveIncident(incident3);
    }
}
