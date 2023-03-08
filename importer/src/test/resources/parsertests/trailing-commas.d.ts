
import { Sample1, Sample2, Sample3, } from './samples';

declare type Constructor<T> = new (...args: any[]) => T;

declare function CollapsibleMixin<T extends Constructor<HTMLElement>>(
    base: T,
): Constructor<CollapsibleMixinClass> & T;

declare class CollapsibleMixinClass {
    /**
     * If true, the collapsible content is visible.
     */
    opened: boolean;

    /**
     * List of elements assigned to the default `<slot>`
     * that represent the collapsible content.
     */
    protected _contentElements: HTMLElement[];
}

declare function ControllerMixin<T extends Constructor<HTMLElement>>(
    superclass: T,
): Constructor<ControllerMixinClass> & T;

interface ReactiveControllerHost {
    /**
     * Adds a controller to the host, which sets up the controller's lifecycle
     * methods to be called with the host's lifecycle.
     */
    addController(controller: ReactiveController): void;
    /**
     * Removes a controller from the host.
     */
    removeController(controller: ReactiveController): void;
    /**
     * Requests a host update which is processed asynchronously. The update can
     * be waited on via the `updateComplete` property.
     */
    requestUpdate(): void;
    /**
     * Returns a Promise that resolves when the host has completed updating.
     * The Promise value is a boolean that is `true` if the element completed the
     * update without triggering another update. The Promise result is `false` if
     * a property was set inside `updated()`. If the Promise is rejected, an
     * exception was thrown during the update.
     *
     * @return A promise of a boolean that indicates if the update resolved
     *     without triggering another update.
     */
    readonly updateComplete: Promise<boolean>;
}

/**
 * A Reactive Controller is an object that enables sub-component code
 * organization and reuse by aggregating the state, behavior, and lifecycle
 * hooks related to a single feature.
 *
 * Controllers are added to a host component, or other object that implements
 * the `ReactiveControllerHost` interface, via the `addController()` method.
 * They can hook their host components's lifecycle by implementing one or more
 * of the lifecycle callbacks, or initiate an update of the host component by
 * calling `requestUpdate()` on the host.
 */
interface ReactiveController {
    /**
     * Called when the host is connected to the component tree. For custom
     * element hosts, this corresponds to the `connectedCallback()` lifecycle,
     * which is only called when the component is connected to the document.
     */
    hostConnected?(): void;
    /**
     * Called when the host is disconnected from the component tree. For custom
     * element hosts, this corresponds to the `disconnectedCallback()` lifecycle,
     * which is called the host or an ancestor component is disconnected from the
     * document.
     */
    hostDisconnected?(): void;
    /**
     * Called during the client-side host update, just before the host calls
     * its own update.
     *
     * Code in `update()` can depend on the DOM as it is not called in
     * server-side rendering.
     */
    hostUpdate?(): void;
    /**
     * Called after a host update, just before the host calls firstUpdated and
     * updated. It is not called in server-side rendering.
     *
     */
    hostUpdated?(): void;
}

declare class ControllerMixinClass
    implements Pick<ReactiveControllerHost, 'addController' | 'removeController'>
{
    /**
     * Registers a controller to participate in the element update cycle.
     */
    addController(controller: ReactiveController): void;

    /**
     * Removes a controller from the element.
     */
    removeController(controller: ReactiveController): void;
}


declare class Details extends CollapsibleMixin(
    ControllerMixin(HTMLElement),
){
    /**
     * A text that is displayed in the summary, if no
     * element is assigned to the `summary` slot.
     */
    summary: string | null | undefined;
}

export {
    Constructor,
    CollapsibleMixin,
    CollapsibleMixinClass,
    ControllerMixin,
    ReactiveControllerHost,
    ReactiveController,
    ControllerMixinClass,
    Details,
};
