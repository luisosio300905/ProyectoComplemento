package org.luis.proyecto.infrastructure.rest.response;

import java.time.Instant;

public record ErrorResponse (
    String message,
    int status,
    Instant timestamp
) {}