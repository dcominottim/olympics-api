package br.com.cominotti.olympics_api.server.domain.model;

import br.com.cominotti.olympics_api.server.infrastructure.localization.ErrorMessages;

public class DomainException extends RuntimeException {

    private final ErrorMessages errorMessage;


    public DomainException(final ErrorMessages errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }


    public String getErrorMessageKey() {
        return errorMessage.toString();
    }

    @Override
    public String toString() {
        return errorMessage.toString();
    }
}
