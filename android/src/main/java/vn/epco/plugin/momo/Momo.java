package vn.epco.plugin.momo;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import android.util.Log;
import vn.momo.momo_partner.AppMoMoLib;
import vn.momo.momo_partner.MoMoParameterNameMap;


@NativePlugin
public class Momo extends Plugin {
    public void load() {
        Log.v("Something", "is new");
    }


    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("MomoConfig");

        JSObject ret = new JSObject();


        call.resolve(ret);
    }
    @PluginMethod
    public void openMomoApp(PluginCall call) {
        JSObject value = call.getString("value");
        call.resolve(ret);
    }
}
