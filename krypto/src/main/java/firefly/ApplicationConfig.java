package firefly;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(
            @Value("${krypto.connectionRequestTimeout}") final int connectionRequestTimeout,
            @Value("${krypto.connectionTimeout}") final int connectionTimeout,
            @Value("${krypto.readTimeout}") final int readTimeout) {

        return new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory(
                        connectionRequestTimeout, connectionTimeout, readTimeout)));
    }

    private ClientHttpRequestFactory clientHttpRequestFactory(
            final int connectionRequestTimeout,
            final int connectionTimeout,
            final int readTimeout) {

        final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectionRequestTimeout(connectionRequestTimeout);
        factory.setReadTimeout(connectionTimeout);
        factory.setConnectTimeout(readTimeout);
        return factory;
    }

}
