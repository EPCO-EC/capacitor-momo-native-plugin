import Foundation
import Capacitor
import MomoiOSSwiftSdk
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(Momo)
public class Momo: CAPPlugin {

    var call: CAPPluginCall

    override func viewDidLoad() {
	    // Do any additional setup after loading the view.
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.NoficationCenterTokenReceived), name:NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
    }	 

    @objc override public func load() {
        // Called when the plugin is first constructed in the bridge
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.NoficationCenterTokenReceived), name:NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
    }


    @objc func openMomoApp(_ call: CAPPluginCall) {
        self.call = call;
        let paymentinfo = NSMutableDictionary()
        
        paymentinfo["merchantcode"] = "CGV01"
        paymentinfo["merchantname"] = "CGV Cinemas"
        paymentinfo["merchantnamelabel"] = "Service"
        paymentinfo["orderId"] = "012345XXX"
        paymentinfo["orderLabel"] = "OrderID"
        paymentinfo["amount"] = 20000
        paymentinfo["fee"] = 0
        paymentinfo["description"] = "Thanh toán vé xem phim"
        paymentinfo["extra"] = "{\"key1\":\"value1\",\"key2\":\"value2\"}"
        paymentinfo["username"] = payment_username //user id/user identify/user email
        paymentinfo["appScheme"] = "partnerSchemeId"   //partnerSchemeId provided by MoMo , get from business.momo.vn
        MoMoPayment.createPaymentInformation(info: paymentinfo)
        MoMoPayment.requestToken()
    }

    @objc func NoficationCenterTokenReceived(notif: NSNotification) {
            //Token Replied - Call Payment to MoMo Server
            print("::MoMoPay Log::Received Token Replied::\(notif.object!)")
            //lblMessage.text = "RequestToken response:\n  \(notif.object as Any)"
            
            let response:NSMutableDictionary = notif.object! as! NSMutableDictionary
            self.call.resolve();
            let _reference_orderId = response["orderId"] as! String
            let _statusStr = "\(response["status"] as! String)"
            let _messageStr = "\(response["message"] as! String)"	    
    }

}
