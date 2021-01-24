package vn.epco.plugin.momo;

import android.content.Intent;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import org.json.JSONObject;

import vn.epco.plugin.momo.momoplugin.MomoActivity;


@NativePlugin(
      requestCodes={Momo.REQUEST_MOMO_PAYMENT} // register request code(s) for intent results
)
public class Momo extends Plugin {
    protected static final int REQUEST_MOMO_PAYMENT = 2302; // Unique request code

    @PluginMethod
    public void echo(PluginCall call) {
        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void openMomoApp(PluginCall call) {
        saveCall(call);
        JSObject MomoConfig = call.getObject("MomoConfig");
        Log.v("MomoPlugin", "Plugin call success");
        Intent intent = new Intent(this.getContext(), MomoActivity.class);
        startActivityForResult(call, intent, REQUEST_MOMO_PAYMENT);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);

        // Get the previously saved call
        PluginCall savedCall = getSavedCall();
//        JSObject r = new JSObject();
//        r.put("msg", "WOA Success");

        if (savedCall == null) {
            return;
        }
//        savedCall.resolve(r);

        if (requestCode == REQUEST_MOMO_PAYMENT) {
            // Do something with the data
        }
    }

}
