package lp.v3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Y2Svc extends Service {
    private static final String TAG = "YYUAN";

    public Y2Svc() {
    }

//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "ServiceDemo onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "ServiceDemo onCreate");
        super.onCreate();
    }

//    @Override
//    public void onStart(Intent intent, int startId) {
//        Log.v(TAG, "ServiceDemo onStart");
//        super.onStart(intent, startId);
//    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "ServiceDemo onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
