package sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Load {

    @Value("${endpoint.pivotal}")
    private String url;


    public String getUrl() {
        return url;
    }
}