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
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final Logger logger = LoggerFactory.getLogger(KryptoServiceImpl.class);

    public KryptoServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        setRestTemplate(restTemplate);

    }

    @Override
    public String encode(String s) {
        return Base64.getEncoder().encodeToString(s.getBytes(UTF_8));
    }

    @Override
    public String decode(String s) {
        byte[] decodedString = Base64.getDecoder().decode(s.getBytes(UTF_8));
        return new String(decodedString, UTF_8);
    }
}
