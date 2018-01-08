/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package firefly;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultHandler;
import firefly.controller.InfoController;
import firefly.model.Info;
import firefly.service.InfoService;
import firefly.service.InfoServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class SampleHateoasApplicationTests {

    @Autowired
    private InfoService userService;

    private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
    private static final ResultHandler logResultHandler = result ->logger.info(result.getResponse().getContentAsString());

    @Test
    public void teste1() throws Exception {

        InfoService a = new InfoServiceImpl();
        Info i = a.getInfo();
        System.out.print(i.getApi_version());
        String test = i.getApi_version().toLowerCase();
        System.out.print("afonso-> " + test);



    }

	/*@Test
	public void hasHalLinks() throws Exception {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/info",
				String.class);
		//assertThat(entity.getStatusCode()).isEqualTo(HttpMethod.GET);
		System.out.print(entity.getBody());
		assertThat(entity.getBody()).startsWith(
				"{\"name");
		//assertThat(entity.getBody()).contains("_links\":{\"self\":{\"href\"");

	}

	@Test
	public void producesJsonWhenXmlIsPreferred() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, "application/xml;q=0.9,application/json;q=0.8");
		HttpEntity<?> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = this.restTemplate.exchange("/info",
				HttpMethod.GET, request, String.class);
		//assertThat(response.getStatusCode()).isEqualTo(HttpStatus.GET);
		assertThat(response.getHeaders().getContentType())
				.isEqualTo(MediaType.parseMediaType("application/json;charset=UTF-8"));
	}*/


}
