package lp.v3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class Nhd extends Activity {
    private EditText myet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhd);

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
}
