package vn.epco.plugin.momo;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import android.util.Log;

@NativePlugin
public class Momo extends Plugin {
    public void load() {
        Log.v("Something", "is new");
    }


    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("aka", "this is android");

        Log.v("Something", "is new");
        Log.v("Something", "is new");
        Log.v("Something", "is new");
        Log.e("Something wrong here", "very wrong");

        call.resolve(ret);
    }
}
