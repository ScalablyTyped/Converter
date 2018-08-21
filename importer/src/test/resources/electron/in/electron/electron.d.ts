// Type definitions for Electron 2.0.0
// Project: http://electron.atom.io/
// Definitions by: The Electron Team <https://github.com/electron/electron>
// Definitions: https://github.com/electron/electron-typescript-definitions

/// <reference types="node" />

type GlobalEvent = Event;

declare namespace Electron {
  class EventEmitter {
    addListener(event: string, listener: Function): this;
  }

  interface Event extends GlobalEvent {
    preventDefault: () => void;
    returnValue: any;
    ctrlKey?: boolean;
    metaKey?: boolean;
    shiftKey?: boolean;
    altKey?: boolean;
  }

  interface CommonInterface {
  }

  interface MainInterface extends CommonInterface {
    app: App;
  }


  interface AllElectron extends MainInterface {}

  const app: App;

  interface App extends EventEmitter {

    // Docs: http://electron.atom.io/docs/api/app

    /**
     * Emitted when Chrome's accessibility support changes. This event fires when
     * assistive technologies, such as screen readers, are enabled or disabled. See
     * https://www.chromium.org/developers/design-documents/accessibility for more
     * details.
     */
    on(event: 'accessibility-support-changed', listener: any): string;
  }
}

declare module 'electron' {
  export = Electron;
}

declare module 'original-fs' {
  import * as fs from 'fs';
  export = fs;
}

declare namespace NodeJS {
  interface Process extends EventEmitter {
    foo: "bar"
  }
}
