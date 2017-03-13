package be.cegeka.incident;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xanv on 6/03/2017.
 */
public class IncidentTest {
    private Incident incident;

    @Before
    public void setUp(){
        incident = new Incident("name", "traffic jam", 25);
    }

    @Test
    public void getNameShouldReturnName(){
        Assertions.assertThat(incident.getName()).isEqualTo("name");
    }

    @Test
    public void getTypeShouldReturnType(){
        Assertions.assertThat(incident.getType()).isEqualTo("traffic jam");
    }

    @Test
    public void getDistanceShouldReturnDistance(){
        Assertions.assertThat(incident.getDistance()).isEqualTo(25);
    }

}
