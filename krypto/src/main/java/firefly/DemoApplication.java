package firefly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
/*
		String crunchifyValue1 = "Afonso Filipe";

		// Use StandardCharsets
		String ecodedValue1 = URLEncoder.encode(crunchifyValue1, StandardCharsets.UTF_8.name());
		String decodedValue1 = URLDecoder.decode(ecodedValue1, StandardCharsets.UTF_8.name());
		System.out.println("crunchifyValue1 after encoding => " + ecodedValue1);
		System.out.println("crunchifyValue1 after decoding (Original Value): => " + decodedValue1);

*/
	}
}
