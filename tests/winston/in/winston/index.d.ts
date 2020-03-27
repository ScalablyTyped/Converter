// Type definitions for winston 3.0
// Project: https://github.com/winstonjs/winston
import * as Config from './lib/winston/config/index';

declare namespace winston {
  // Hoisted namespaces from other modules
  export import config = Config;

  interface LoggerOptions {
    levels?: Config.AbstractConfigSetLevels;
  }

}

export = winston;
