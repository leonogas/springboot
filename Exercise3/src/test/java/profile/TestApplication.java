package profile;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class TestApplication {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultProfile() throws Exception {
        Application.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("yes");
    }

    @Test
    public void testProductionProfile() throws Exception {
        System.setProperty("spring.profiles.active", "production");
        Application.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("yes");
    }

    @Test
    public void testProductionProfile_withDoption() throws Exception {
        Application.main(new String[]{"--spring.profiles.active=production"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("yes");
    }

    @Test
    public void testPreProductionProfile_withDoption() throws Exception {
        Application.main(new String[]{"--spring.profiles.active=preproduction"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("no");
    }

    @After
    public void after() {
        System.clearProperty("spring.profiles.active");
    }

}
