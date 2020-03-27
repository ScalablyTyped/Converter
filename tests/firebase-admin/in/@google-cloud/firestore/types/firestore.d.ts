declare namespace FirebaseFirestore {

  export interface Settings {
    projectId?: string;
  }

  /**
   * `Firestore` represents a Firestore Database and is the entry point for all
   * Firestore operations.
   */
  export class Firestore {
    /**
     * @param settings Configuration object. See [Firestore Documentation]
     * {@link https://firebase.google.com/docs/firestore/}
     */
    public constructor(settings?: Settings);

    /**
     * Specifies custom settings to be used to configure the `Firestore`
     * instance. Can only be invoked once and before any other Firestore
     * method.
     *
     * If settings are provided via both `settings()` and the `Firestore`
     * constructor, both settings objects are merged and any settings provided
     * via `settings()` take precedence.
     *
     * @param {object} settings The settings to use for all Firestore
     * operations.
     */
    settings(settings: Settings): void;

  }
}

declare module '@google-cloud/firestore' {
  export = FirebaseFirestore;
}
