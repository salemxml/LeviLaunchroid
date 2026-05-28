package org.levimc.launcher.core.auth;

import android.content.Context;

import java.util.UUID;

public class OfflineAccountManager {

    public static final String OFFLINE_PREFIX = "offline_";

    public static MsftAccountStore.MsftAccount addOfflineAccount(Context context, String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        String trimmed = username.trim();
        String fakeUserId = OFFLINE_PREFIX + UUID.randomUUID().toString();
        long fakeXuidNum = (Math.abs((long) trimmed.hashCode()) % 900000000L) + 1000000000L;
        String fakeXuid = String.valueOf(fakeXuidNum);

        return MsftAccountStore.addOrUpdate(
                context,
                fakeUserId,
                null,
                trimmed,
                trimmed,
                fakeXuid,
                null
        );
    }

    public static boolean isOfflineAccount(MsftAccountStore.MsftAccount account) {
        return account != null
                && account.msUserId != null
                && account.msUserId.startsWith(OFFLINE_PREFIX);
    }
}
