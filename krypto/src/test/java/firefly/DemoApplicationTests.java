package firefly;

import firefly.controller.KryptoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultHandler;
import firefly.service.KryptoService;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;
import javax.security.auth.callback.Callback;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private KryptoService service;

	private static final Logger logger = LoggerFactory.getLogger(KryptoController.class);
	private static final ResultHandler logResultHandler = result ->logger.info(result.getResponse().getContentAsString());

	@Test
	public void contextLoads() {}


	@Test
	public void allFalse() throws Exception {

		String encode = service.encode("stinnnng");
		String decode = service.decode("stinnnng");

		assertNotEquals(encode, decode);
	}

	@Test
	public void eachEqualAndAllEqualMockito(){

		KryptoService mocked = org.mockito.Mockito.mock(KryptoService.class);

		when(mocked.encode("stinnnng")).thenReturn("encoded from");
		when(mocked.decode("stinnnng")).thenReturn("decoded from");

		assertNotEquals(mocked.encode("stinnnng"), mocked.decode("stinnnng"));

	}

	@Test
	public void eachEqualAndAllEqualSpy(){

		KryptoService mocked =spy(KryptoService.class);

		when(mocked.encode("stinnnng")).thenReturn("encoded from");
		when(mocked.decode("stinnnng")).thenReturn("decoded from");

		assertNotEquals(mocked.encode("stinnnng"), mocked.decode("stinnnng"));
	}

    @Test(expected = RuntimeException.class)
    public void adviceToBeThrown() {
	    throw new RuntimeException("PUM");
    }
}
