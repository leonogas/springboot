package firefly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import firefly.service.KryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leonogas on 21/12/2017.
 */

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class KryptoController {

    private static final Logger logger = LoggerFactory.getLogger(KryptoController.class);
    private final KryptoService service;

    public KryptoController(KryptoService imp) {
        this.service = imp;
    }

    @GetMapping(value = "/encode")
    public String encode (@RequestParam("string") String s){
        return service.encode(s);
    }

    @GetMapping(value = "/decode")
    public String decode (@RequestParam("string") String s){
        return service.decode(s);
    }

}
