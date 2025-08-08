package org.dio.model;

public record Investment(
        long id,
        long tax,
        long daysToRecue,
        long initialFunds
) {
}
