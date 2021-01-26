package vn.epco.plugin.momo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import vn.epco.plugin.momo.momoplugin.MomoActivity;
import vn.momo.momo_partner.AppMoMoLib;
import vn.momo.momo_partner.MoMoParameterNamePayment;


@NativePlugin(
      requestCodes={Momo.REQUEST_MOMO_PAYMENT} // register request code(s) for intent results
)
public class Momo extends Plugin {
    protected static final int REQUEST_MOMO_PAYMENT = 2302; // Unique request code
    private String amount = "10000";
    private String fee = "0";
    int environment = 0;//developer default
    private String merchantName = "HORAFARM";
    private String merchantCode = "MOMOZLRN20190911";
    private String merchantNameLabel = "Nhà cung cấp";
    private String description = "Fast & Furious 8";


    @PluginMethod
    public void echo(PluginCall call) {
        JSObject ret = new JSObject();
        call.resolve(ret);
    }

    @PluginMethod
    public void openMomoApp(PluginCall call) {
        saveCall(call);
        JSObject MomoConfig = call.getObject("MomoConfig");
        Intent intent = new Intent(this.getContext(), MomoActivity.class);
        startActivityForResult(call, intent, REQUEST_MOMO_PAYMENT);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        PluginCall savedCall = getSavedCall();
        JSObject r = new JSObject();
        r.put("status", data.getIntExtra("status", -1));
        r.put("message", data.getStringExtra("message"));
        r.put("data", data.getStringExtra("data"));
        r.put("phonenumber", data.getStringExtra("phonenumber"));
        savedCall.resolve(r);

    }

}
