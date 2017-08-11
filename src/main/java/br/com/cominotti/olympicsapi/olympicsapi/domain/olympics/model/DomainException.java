package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import br.com.cominotti.olympicsapi.olympicsapi.infra.localization.ErrorMessages;

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
