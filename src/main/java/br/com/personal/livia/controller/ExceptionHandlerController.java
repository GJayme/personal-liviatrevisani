package br.com.personal.livia.controller;

import br.com.personal.livia.view.ErrorView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorView handleException(Exception ex) {
        return new ErrorView(ex.getMessage());
    }

}
