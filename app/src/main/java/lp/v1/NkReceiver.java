package lp.v1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NkReceiver extends BroadcastReceiver {
    public NkReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("YYUAN", "Msg recved! ->" + intent.getAction());
        //throw new UnsupportedOperationException("Not yet implemented");

//        Intent inent = getPackageManager().getLaunchIntentForPackage(packageName);
//        context.startActivity(inent );

        String packname = "lp.v1";
        Intent it = context.getPackageManager().getLaunchIntentForPackage(packname);
        context.startActivity(it);
    }
}
