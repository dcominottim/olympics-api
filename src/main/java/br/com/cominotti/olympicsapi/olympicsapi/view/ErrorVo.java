package br.com.cominotti.olympicsapi.olympicsapi.view;

import java.util.Objects;

public class ErrorVo {

    private String message;


    public ErrorVo(final String message) {
        this.message = Objects.requireNonNull(message);
    }


    public String getMessage() {
        return message;
    }
}
