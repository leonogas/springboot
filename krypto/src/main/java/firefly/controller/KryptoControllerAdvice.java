package firefly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by leonogas on 09/01/2018.
 */

@ControllerAdvice
public class KryptoControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(KryptoControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    String globalException(final Exception e) {
        logger.error(e.getLocalizedMessage(), e);

        return e.getLocalizedMessage();
    }
}
