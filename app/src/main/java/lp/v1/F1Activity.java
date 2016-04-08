package lp.v1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class F1Activity extends Activity {
    private static final String TGG = "YYUAN";
    private EditText et = null;
    private Button btn0 = null;
    private RelativeLayout yy_layout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);

        yy_layout = (RelativeLayout) findViewById(R.id.yy_layout);
        yy_layout.setBackgroundColor(Color.CYAN);
        yy_layout.setGravity(Gravity.CENTER_VERTICAL);

        btn0 = new Button(this);
        btn0.setText("PROXY");
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.setData(Uri.parse("https://www.google.com/ncr"));
                intent.setData(Uri.parse("https://m.baidu.com"));
                getApplicationContext().startActivity(intent);
            }
        });
        yy_layout.addView(btn0);

//        et = new EditText(this);
//        int it = et.getInputType();
//        et.setInputType(it | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
//        et.setGravity(et.getGravity() | Gravity.TOP);
//        et.setBackgroundColor(Color.YELLOW);
//        yy_layout.addView(et); //setContentView(et);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

        //HookHelper
        Log.d(TGG, "Attaccccccccccc!!!!");
    }
}
