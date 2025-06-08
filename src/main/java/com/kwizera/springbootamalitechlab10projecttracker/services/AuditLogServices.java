package com.kwizera.springbootamalitechlab10projecttracker.services;

import java.util.Map;

public interface AuditLogServices {
    void log(String actionType, String entityType, String entityId, String actorName, Map<String, Object> payload);
}
