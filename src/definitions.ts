declare module '@capacitor/core' {
  interface PluginRegistry {
    Momo: MomoPlugin;
  }
}

export interface MomoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
