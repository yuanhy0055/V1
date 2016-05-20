package lp.v3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Nhd extends Activity implements View.OnClickListener {
    private EditText myet;
    private final String TAG = "YYUAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhd);

        findViewById(R.id.yy_btn1).setOnClickListener(this);
        findViewById(R.id.yy_btn2).setOnClickListener(this);

        myet = (EditText) findViewById(R.id.yyet);
        //myet.setCursorVisible(true);
        //myet.setEnabled(false);
        myet.append("  message->\n");
    }


    public void yy_msg(String str) {
        if(null != myet) {
            myet.append(str);
        }
    }

    @Override
    public void onClick(View v) {
        yy_msg("Call my click FUNC!\n");
        switch(v.getId()) {
            case R.id.yy_btn1:
                Log.d(TAG, "BT1");
                break;
            case R.id.yy_btn2:
                Log.d(TAG, "BT2");
                break;
            default:
                break;
        }
    }
}
