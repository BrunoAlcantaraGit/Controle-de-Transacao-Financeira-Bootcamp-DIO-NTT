package org.dio.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MoneyAudit(
        UUID transactionID,
        BanckService tradeService,
        String description,
        OffsetDateTime createdAt
){}