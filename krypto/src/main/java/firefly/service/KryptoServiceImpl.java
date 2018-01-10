package firefly.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

/**
 * Created by leonogas on 21/12/2017.
 */

@Service
public class KryptoServiceImpl extends RestGatewaySupport implements KryptoService {

    @Value("${key.encode}")
    private String encode;
    @Value("${key.decode}")
    private String decode;

    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KryptoServiceImpl.class);

    public KryptoServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        setRestTemplate(restTemplate);

    }

    @Override
    public String encode(String s) {
        return this.encode;
    }

    @Override
    public String decode(String s) {
        return this.decode;
    }
}
