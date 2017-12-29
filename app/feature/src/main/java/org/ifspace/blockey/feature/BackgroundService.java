package org.ifspace.blockey.feature;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class BackgroundService extends IntentService {
    AndroidWebServer webServer = new AndroidWebServer("localhost",8080);

    // Action names that describe tasks that this IntentService can perform
    private static final String ACTION_SETSCRATCHID = "org.ifspace.blockey.feature.action.SETSCRATCHID";

    // Action parameters
    private static final String EXTRA_SCRATCHID = "org.ifspace.blockey.feature.extra.SCRATCHID";

    public BackgroundService() {

        super("BackgroundService");
    }

    /**
     * Starts this service to perform action SetScratchId with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // helper method
    public static void startActionSetScratchId(Context context, String id) {
        Intent intent = new Intent(context, BackgroundService.class);
        intent.setAction(ACTION_SETSCRATCHID);
        intent.putExtra(EXTRA_SCRATCHID, id);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SETSCRATCHID.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_SCRATCHID);
                handleActionSetScratchId(param1);
            }
        }
    }

    /**
     * Handle action SetScratchId in the provided background thread with the provided
     * parameters.
     */
    private void handleActionSetScratchId(String id) {
        if(webServer != null)
        {
            webServer.stop();
            webServer = null;
        }
        webServer = new AndroidWebServer("localhost",8080);
        webServer.setScratchProgId(id);
    }
}
