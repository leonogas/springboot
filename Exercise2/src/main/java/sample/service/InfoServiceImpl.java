package sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;
import sample.config.Load;
import sample.model.Info;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;


/**
 * Created by c0244448 on 17/10/2017.
 */
@Service

public class InfoServiceImpl extends RestGatewaySupport implements InfoService {

    //@Value("${endpoint.pivotal}")
    //private String endpoint;
    private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    private Load l;
    public InfoServiceImpl(Load load) {
        l=load;
    }

    public Info getInfo (){
        Info i = new Info();
        Info info = new Info();
        i.setApi_version("testddddddddsdsdsdsde");

        logger.info("Execute REST request to retrieve Interest Rate.");

        //Request

        //http://api.run.pivotal.io/v2/info"
        final String rawResponse = getRestTemplate().getForObject(this.l.getUrl(), String.class);
        //logger.trace("JSON Request on URL: {}", requestDataValue);
        //i.setApi_version(rawResponse);

        ObjectMapper mapper = new ObjectMapper();
        try{
             info = mapper.readValue(rawResponse, Info.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        info.setName("AMRUT Embajador v2");
        info.setBuild("OK PAGO");


        logger.info(rawResponse);

        return info;
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
