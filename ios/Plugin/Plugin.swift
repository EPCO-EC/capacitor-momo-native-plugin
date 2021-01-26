import Foundation
import Capacitor
import MomoiOSSwiftSdk
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(Momo)
public class Momo: CAPPlugin {


    @objc override public func load() {
        // Called when the plugin is first constructed in the bridge
        NotificationCenter.default.removeObserver(self, name: NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(self.NoficationCenterTokenReceived), name:NSNotification.Name(rawValue: "NoficationCenterTokenReceived"), object: nil)
    }


    @objc func openMomoApp(_ call: CAPPluginCall) {
        let paymentinfo = NSMutableDictionary()
        
        paymentinfo["merchantcode"] = "MOMOZLRN20190911"
        paymentinfo["merchantname"] = "HORAFARM"
        paymentinfo["merchantnamelabel"] = "Service"
        paymentinfo["orderId"] = "012345XXX"
        paymentinfo["orderLabel"] = "OrderID"
        paymentinfo["amount"] = 20000
        paymentinfo["fee"] = 0
        paymentinfo["description"] = "Thanh toán vé xem phim"
        paymentinfo["appScheme"] = "momozlrn20190911"
        MoMoPayment.createPaymentInformation(info: paymentinfo)
        MoMoPayment.requestToken()
    }

    @objc func NoficationCenterTokenReceived(notif: NSNotification) {
            //Token Replied - Call Payment to MoMo Server
            print("::MoMoPay Log::Received Token Replied::\(notif.object!)")
            print("We have somehitng")
    }

}
