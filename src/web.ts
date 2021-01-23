import { WebPlugin } from '@capacitor/core';
import { MomoPlugin } from './definitions';

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
}

const Momo = new MomoWeb();

export { Momo };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(Momo);
