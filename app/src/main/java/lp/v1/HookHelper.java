package lp.v1;

import android.app.Instrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by nico on 2016/3/28.
 */
public class HookHelper {

    public static void attachContext() throws Exception {
        // 获得ActivityThread Class
        Class<?> activityThreadClass = Class.forName("android.app.ActivityThread");
        Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
        currentActivityThreadMethod.setAccessible(true);
        Object currentActivityThread = currentActivityThreadMethod.invoke(null);

        //拿到原始的 mInstrumentation
        Field mInstrumentationField = activityThreadClass.getDeclaredField("mInstrumentation");
        mInstrumentationField.setAccessible(true);
        Instrumentation mInstrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);

        //创建代理对象
        Instrumentation evilInstrumentation = new EvilInstrumentation(mInstrumentation);

        //偷梁换柱
        mInstrumentationField.set(currentActivityThread, evilInstrumentation);
    }
}
