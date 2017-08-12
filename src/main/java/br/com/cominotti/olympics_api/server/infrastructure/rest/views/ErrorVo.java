package br.com.cominotti.olympics_api.server.infrastructure.rest.views;

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
