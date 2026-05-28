package org.levimc.launcher.ui.dialogs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import org.levimc.launcher.R;

public class PlayStoreValidationDialog {

    public static void showNotFromPlayStoreDialog(Context context) {
    }

    public static void showNotInstalledDialog(Context context) {
        new CustomAlertDialog(context)
                .setTitleText(context.getString(R.string.minecraft_not_installed_title))
                .setMessage(context.getString(R.string.minecraft_not_installed_message))
                .setPositiveButton(context.getString(R.string.install_minecraft), v -> {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/topics/minecraft-bedrock"));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(context,
                                context.getString(R.string.error_no_browser),
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(context.getString(R.string.cancel), null)
                .show();
    }
}
