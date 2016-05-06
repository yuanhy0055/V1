package lp.v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class YnetReceiver extends BroadcastReceiver {
    public YnetReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // throw new UnsupportedOperationException("Not yet implemented");
        Log.i("YYUAN", "Msg recved! ->" + intent.getAction());
        //((Nhd)context).yy_msg("Msg recved! ->" + intent.getAction());
        //((Nhd)context.getApplicationContext()).yy_msg("sssssssssss");
        Toast.makeText(context, "Msgrecv->"+intent.getAction(), Toast.LENGTH_LONG).show();
    }
}
