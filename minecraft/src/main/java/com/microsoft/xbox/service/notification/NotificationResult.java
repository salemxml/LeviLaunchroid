package com.microsoft.xbox.service.notification;

public class NotificationResult {
    public String body;
    public String data;
    public NotificationType notificationType;
    public String title;

    public NotificationResult() {
        this.notificationType = NotificationType.Unknown;
    }

    public enum NotificationType {
        Achievement,
        Invite,
        Unknown
    }
}
