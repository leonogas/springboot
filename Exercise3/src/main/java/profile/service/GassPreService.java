package profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("preproduction")
public class GassPreService implements Gass {

    @Override
    public String write() {
        return "no";
    }

}
