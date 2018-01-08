package profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"production", "default"})
public class GassProService implements Gass {

    @Override
    public String write() {
        return "yes";
    }

}
