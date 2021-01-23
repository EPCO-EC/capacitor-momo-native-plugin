declare module '@capacitor/core' {
  interface PluginRegistry {
    Momo: MomoPlugin;
  }
}

export interface MomoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  openMomoApp(MomoConfig: MomoConfig): Promise<any>;
}

export interface MomoConfig{
  merchantcode:  string //"CGV01"
  merchantname: string // "CGV Cinemas"
  merchantnamelabel: string //"Service"
  orderId: string //"012345XXX"
  orderLabel: string //"OrderID"
  amount: string
  fee: number
  description: string //"Thanh toán vé xem phim"
  extra?: {} // "{\"key1\":\"value1\",\"key2\":\"value2\"}"
  username?: string //user id/user identify/user email
  appScheme: string  //partnerSchemeId provided by MoMo , get from business.momo.vn
}
