import { WebPlugin } from '@capacitor/core';
import { MomoPlugin, MomoConfig } from './definitions';

export class MomoWeb extends WebPlugin implements MomoPlugin {
  constructor() {
    super({
      name: 'Momo',
      platforms: ['web'],
    });
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async openMomoApp(MomoConfig: MomoConfig): Promise<any>{
    return new Promise((resolve) => {
      resolve(MomoConfig);
    })
  }

}

const Momo = new MomoWeb();

export { Momo };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(Momo);
