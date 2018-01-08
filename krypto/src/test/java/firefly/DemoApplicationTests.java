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
	public void contextLoads() {
	}


	@Test
	public void teste1() throws Exception {



		String encode = service.encode("stinnnng");
		String decode = service.decode("stinnnng");

		System.out.println(encode);
		System.out.println(decode);

		assertEquals(encode, decode);



	}

}
