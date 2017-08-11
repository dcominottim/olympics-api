package br.com.cominotti.olympicsapi.olympicsapi.infra.localization;

public enum ErrorMessages {

    GENERIC_INTERNAL_SERVER_ERROR,
    GENERIC_BAD_DATA,

    SCHEDULE_MAXIMUM_COMPETITIONS_PER_DAY_THRESHOLD_REACHED,
    SCHEDULE_INVALID_COMPETITION_CRITERIA,

    COMPETITION_INVALID_TIME_INTERVAL,
    COMPETITION_INVALID_COMPETITORS;


    @Override
    public String toString() {
        return name();
    }
}
