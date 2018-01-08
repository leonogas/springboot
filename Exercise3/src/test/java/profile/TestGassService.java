package profile;

import profile.service.Gass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("production")
public class TestGassService {

    @Autowired
    Gass gass;

    @Test
    public void testProductionProfile() throws Exception {
        String output = gass.write();
        assertThat(output).contains("yes");
    }
}
