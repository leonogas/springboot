package firefly.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;
import firefly.model.Info;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by c0244448 on 17/10/2017.
 */
@Service
public class InfoServiceImpl extends RestGatewaySupport implements InfoService {

	@Value("${pivotalAddress}")
    //@Value("http://api.run.pivotal.io/v2/info")
	private  String endpoint;

    private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    /*
    public InfoServiceImpl() {

        //this.endpoint = "http://api.run.pivotal.io/v2/info";
    }*/


    public Info getInfo (){
        Info i = new Info();
        i.setApi_version("teste");

        logger.info("Execute REST request to retrieve Interest Rate.");

        //Request

        //logger.trace("Endpoint: {}", url);
        System.out.print(this.endpoint);
        final String rawResponse = getRestTemplate().getForObject(this.endpoint, String.class);
        //logger.trace("JSON Request on URL: {}", requestDataValue);
        logger.info(rawResponse);

        return i;
    };



	/*public Resource<Info> getInfo() {
		RestTemplate restTemplate = new RestTemplate();
		Info info = restTemplate.getForObject(this.getEndpoint(), Info.class);
		Resource<Info> resource = new Resource<Info>(info);
		return resource;
	}*/


    private RestTemplate createRestTemplate(final int connectionRequestTimeout, final int connectionTimeout,
                                            final int readTimeout) {

        final RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(connectionTimeout)
                .setReadTimeout(readTimeout)
                .build();

        restTemplate.setRequestFactory(getFactory(connectionRequestTimeout, connectionTimeout, readTimeout));
        return restTemplate;
    }
    private ClientHttpRequestFactory getFactory(final int connectionRequestTimeout, final int connectionTimeout,
                                                final int readTimeout) {
        final HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();

        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        factory.setConnectionRequestTimeout(connectionRequestTimeout);
        factory.setHttpClient(getCloseableHttpClient());
        return factory;
    }
    private CloseableHttpClient getCloseableHttpClient() {
        return HttpClientBuilder.create()
                .disableCookieManagement()
                .useSystemProperties()
                .build();
    }
}
