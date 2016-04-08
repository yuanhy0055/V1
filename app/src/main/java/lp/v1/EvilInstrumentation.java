package lp.v1;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by nico on 2016/3/29.
 */
public class EvilInstrumentation extends Instrumentation {
    private static final String TGG = "YYUAN";

    //ActivityThread中原始的对象,保存起来
    Instrumentation mBase;

    public EvilInstrumentation(Instrumentation base) {
        mBase = base;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        Log.d(TGG, "执行了startActivity, Param=[]");

        //开始调用原始方法
        //方法是隐藏的,因此需要反射调用

        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod(
                    "execStartActivity",Context.class,IBinder.class, Activity.class,
                    Intent.class, int.class, Bundle.class);
            execStartActivity.setAccessible(true);
            return (ActivityResult)execStartActivity.invoke(mBase, who,
                    contextThread, token, target, intent, requestCode, options);
        } catch (Exception e) {
            //某ROM修改了, 需手动适配
            throw new RuntimeException("do not support!!! PLS adapte it!");
        }
    }
}
