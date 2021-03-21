interface ViewabilityConfig {}
interface ViewToken {}

interface ViewabilityConfigCallbackPair {
    viewabilityConfig: ViewabilityConfig;
    onViewableItemsChanged: ((info: { viewableItems: Array<ViewToken>; changed: Array<ViewToken> }) => void) | null;
}
