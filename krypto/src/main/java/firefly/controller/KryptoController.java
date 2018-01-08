package firefly.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import firefly.service.KryptoService;

;

/**
 * Created by leonogas on 21/12/2017.
 */

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class KryptoController {

    private final KryptoService service;

    public KryptoController(KryptoService imp) {
        this.service = imp;
    }

    @RequestMapping(value = "/encode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String encode (@RequestParam("string") String s){
        return service.encode(s);
    }

    @RequestMapping(value = "/decode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String decode (@RequestParam("string") String s){
        return service.decode(s);
    }

}
