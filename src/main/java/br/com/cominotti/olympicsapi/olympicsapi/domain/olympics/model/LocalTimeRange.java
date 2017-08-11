package br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model;

import java.time.LocalTime;
import java.util.Objects;

public class LocalTimeRange {

    private final LocalTime from;

    private final LocalTime to;


    public LocalTimeRange(final LocalTime from,
                          final LocalTime to) {
        this.from = Objects.requireNonNull(from);
        this.to = Objects.requireNonNull(to);
    }


    public boolean overlaps(final LocalTimeRange other) {
        Objects.requireNonNull(other);
        return isBetween(other.from, this.from, this.to)
                || isBetween(other.to, this.from, this.to)
                || isBetween(this.from, other.from, other.to)
                || isBetween(this.to, other.from, other.to)
                || other.from.equals(this.from);
    }


    private static boolean isBetween(final LocalTime t,
                                     final LocalTime from,
                                     final LocalTime to) {
        if (from.isBefore(to)) { // same day
            return from.isBefore(t) && t.isBefore(to);
        } else { // spans to the next day.
            return from.isBefore(t) || t.isBefore(to);
        }
    }
}
