package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.AuditLog;
import com.kwizera.springbootamalitechlab10projecttracker.repositories.AuditLogRepository;
import com.kwizera.springbootamalitechlab10projecttracker.services.AuditLogServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuditLogServicesImpl implements AuditLogServices {
    private final AuditLogRepository auditLogRepository;

    @Override
    public void log(String actionType, String entityType, String entityId, String actorName, Map<String, Object> payload) {
        AuditLog log = AuditLog.builder()
                .actionType(actionType)
                .entityType(entityType)
                .entityId(entityId)
                .actorName(actorName)
                .timestamp(Instant.now())
                .payload(payload)
                .build();
        auditLogRepository.save(log);
    }
}
