package lp.v1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class act3 extends AppCompatActivity {


    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);

        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("YYUAN", "7777777777777777777777777777");
                Context mContext =  getApplicationContext();
                ActivityManager mActivityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
                Method method = null;
                try {
                    method = Class.forName("android.app.ActivityManager").getMethod("forceStopPackage", String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                method.setAccessible(true);

                try {
                    method.invoke(mActivityManager, "com.tencent.mm");  //packageName是需要强制停止的应用程序包名
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

        int id= android.os.Process.myPid();
        int uid = android.os.Process.myUid();
        Log.i("YYUAN", "PID="+id+", UID="+uid);
    }
}
