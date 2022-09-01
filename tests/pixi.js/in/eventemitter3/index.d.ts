/**
 * Minimal `EventEmitter` interface that is molded against the Node.js
 * `EventEmitter` interface.
 */
declare class EventEmitter<EventTypes> {
}

declare namespace EventEmitter {

  export interface EventEmitterStatic {
    new<EventTypes>(): EventEmitter<EventTypes>;
  }

  export const EventEmitter: EventEmitterStatic;
}

export = EventEmitter;
