package lp.v1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class act2 extends Activity {

    private WakeLock mWakeLock;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        Log.i("YYUAN", "on create");



        tv = (TextView) findViewById(R.id.my_text);

        EditText et =(EditText)findViewById(R.id.my_edit);
        et.setTextColor(Color.CYAN);
        et.setHintTextColor(Color.CYAN);
        et.setHint("从这里开始输入...");

        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK  , "myAPKKK");
        putstr("My LOCK KKK=" + mWakeLock + "\n");
        mWakeLock.acquire();
        putstr("11111111111\n");

        if (mWakeLock != null) {
            putstr("22222222222\n");
            if(mWakeLock.isHeld()) {
                mWakeLock.release();
                mWakeLock = null;
            } else {
                putstr("No hold APKKK");
            }
        }

    }

    @Override
    protected  void onDestroy() {
        Log.i("YYUAN", "on destroy");  //Thread.currentThread().getStackTrace()[2].getMethodName());
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.i("YYUAN", "on resume");
    }

   @Override
    protected void onPause() {
       super.onPause();

       Log.i("YYUAN", "on pause");
    }

    public void putstr(String str) {
        if (tv != null) {
            tv.append(str);
        }
    }

}
