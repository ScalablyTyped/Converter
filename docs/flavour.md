---
id: flavour
title: Flavour
---

ScalablyTyped flavours are so far used for interop with react.

You specify which one you want like this:
```scala
project.settings(
 // for Slinky web projects
  Compile / stFlavour := Flavour.Slinky,
  // for Slinky native projects
  Compile / stFlavour := Flavour.SlinkyNative,
  // for scalajs-react projects
  Compile / stFlavour := Flavour.Japgolly
)
``` 

## How?
They all work quite similarly:
- Replace all possible type references from generated types to types from scala-js-dom and the relevant React wrapper
- Identify all react components
- Generate a scala package with all the necessary boilerplate to make usage smooth.

## Example
Let's have a look at an example, react-slick. This is a carousel library with one component and a pretty complicated interface.

The entire typescript definition looks like this:
```typescript
// Type definitions for react-slick 0.23
// Project: https://github.com/akiran/react-slick
// Definitions by: Andrey Balokha <https://github.com/andrewBalekha>
//                 Giedrius Grabauskas <https://github.com/GiedriusGrabauskas>
//                 Andrew Makarov <https://github.com/r3nya>
//                 Shannor Trotty <https://github.com/Shannor>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// TypeScript Version: 2.8

import * as React from "react";

type ComponentConstructor<TProps> =
    | React.ComponentClass<TProps>
    | React.StatelessComponent<TProps>;

export interface CustomArrowProps {
    className?: string;
    style?: React.CSSProperties;
    onClick?: React.MouseEventHandler<any>;
    currentSlide?: number;
    slideCount?: number;
}

export interface ResponsiveObject {
    breakpoint: number;
    settings: "unslick" | Settings;
}

export type SwipeDirection = "left" | "down" | "right" | "up" | string;

export type LazyLoadTypes = "ondemand" | "progressive";

export interface Settings {
    accessibility?: boolean;
    adaptiveHeight?: boolean;
    afterChange?(currentSlide: number): void;
    appendDots?(dots: React.ReactNode): JSX.Element;
    arrows?: boolean;
    asNavFor?: Slider;
    autoplaySpeed?: number;
    autoplay?: boolean;
    beforeChange?(currentSlide: number, nextSlide: number): void;
    centerMode?: boolean;
    centerPadding?: string;
    className?: string;
    cssEase?: string;
    customPaging?(index: number): JSX.Element;
    dotsClass?: string;
    dots?: boolean;
    draggable?: boolean;
    easing?: string;
    edgeFriction?: number;
    fade?: boolean;
    focusOnSelect?: boolean;
    infinite?: boolean;
    initialSlide?: number;
    lazyLoad?: LazyLoadTypes;
    nextArrow?: JSX.Element;
    onEdge?(swipeDirection: SwipeDirection): void;
    onInit?(): void;
    onLazyLoad?(slidesToLoad: number[]): void;
    onReInit?(): void;
    onSwipe?(swipeDirection: SwipeDirection): void;
    pauseOnDotsHover?: boolean;
    pauseOnFocus?: boolean;
    pauseOnHover?: boolean;
    prevArrow?: JSX.Element;
    responsive?: ResponsiveObject[];
    rows?: number;
    rtl?: boolean;
    slide?: string;
    slidesPerRow?: number;
    slidesToScroll?: number;
    slidesToShow?: number;
    speed?: number;
    swipeToSlide?: boolean;
    swipe?: boolean;
    swipeEvent?(swipeDirection: SwipeDirection): void;
    touchMove?: boolean;
    touchThreshold?: number;
    useCSS?: boolean;
    useTransform?: boolean;
    variableWidth?: boolean;
    vertical?: boolean;
    verticalSwiping?: boolean;
    waitForAnimate?: boolean;
}

declare class Slider extends React.Component<Settings, never> {
    slickNext(): void;
    slickPause(): void;
    slickPlay(): void;
    slickPrev(): void;
    slickGoTo(slideNumber: number, dontAnimate?: boolean): void;
}

export default Slider;

```

## Slinky

```scala
package typings.reactSlick.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.TagMod
import slinky.web.html.`*`.tag
import typings.reactSlick.mod.LazyLoadTypes
import typings.reactSlick.mod.ResponsiveObject
import typings.reactSlick.mod.Settings
import typings.reactSlick.mod.Slider
import typings.reactSlick.mod.SwipeDirection
import typings.reactSlick.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSlick
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  @JSImport("react-slick", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  /* The following DOM/SVG props were specified: className, draggable, rows */
  def apply(
    accessibility: js.UndefOr[Boolean] = js.undefined,
    adaptiveHeight: js.UndefOr[Boolean] = js.undefined,
    afterChange: /* currentSlide */ Double => Unit = null,
    appendDots: /* dots */ TagMod[Any] => typings.react.mod._Global_.JSX.Element = null,
    arrows: js.UndefOr[Boolean] = js.undefined,
    asNavFor: Slider = null,
    autoplay: js.UndefOr[Boolean] = js.undefined,
    autoplaySpeed: Int | Double = null,
    beforeChange: (/* currentSlide */ Double, /* nextSlide */ Double) => Unit = null,
    centerMode: js.UndefOr[Boolean] = js.undefined,
    centerPadding: String = null,
    cssEase: String = null,
    customPaging: /* index */ Double => typings.react.mod._Global_.JSX.Element = null,
    dots: js.UndefOr[Boolean] = js.undefined,
    dotsClass: String = null,
    easing: String = null,
    edgeFriction: Int | Double = null,
    fade: js.UndefOr[Boolean] = js.undefined,
    focusOnSelect: js.UndefOr[Boolean] = js.undefined,
    infinite: js.UndefOr[Boolean] = js.undefined,
    initialSlide: Int | Double = null,
    lazyLoad: LazyLoadTypes = null,
    nextArrow: typings.react.mod._Global_.JSX.Element = null,
    onEdge: /* swipeDirection */ SwipeDirection => Unit = null,
    onInit: () => Unit = null,
    onLazyLoad: /* slidesToLoad */ js.Array[Double] => Unit = null,
    onReInit: () => Unit = null,
    onSwipe: /* swipeDirection */ SwipeDirection => Unit = null,
    pauseOnDotsHover: js.UndefOr[Boolean] = js.undefined,
    pauseOnFocus: js.UndefOr[Boolean] = js.undefined,
    pauseOnHover: js.UndefOr[Boolean] = js.undefined,
    prevArrow: typings.react.mod._Global_.JSX.Element = null,
    responsive: js.Array[ResponsiveObject] = null,
    rtl: js.UndefOr[Boolean] = js.undefined,
    slide: String = null,
    slidesPerRow: Int | Double = null,
    slidesToScroll: Int | Double = null,
    slidesToShow: Int | Double = null,
    speed: Int | Double = null,
    swipe: js.UndefOr[Boolean] = js.undefined,
    swipeEvent: /* swipeDirection */ SwipeDirection => Unit = null,
    swipeToSlide: js.UndefOr[Boolean] = js.undefined,
    touchMove: js.UndefOr[Boolean] = js.undefined,
    touchThreshold: Int | Double = null,
    useCSS: js.UndefOr[Boolean] = js.undefined,
    useTransform: js.UndefOr[Boolean] = js.undefined,
    variableWidth: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    verticalSwiping: js.UndefOr[Boolean] = js.undefined,
    waitForAnimate: js.UndefOr[Boolean] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(accessibility)) __obj.updateDynamic("accessibility")(accessibility.asInstanceOf[js.Any])
    if (!js.isUndefined(adaptiveHeight)) __obj.updateDynamic("adaptiveHeight")(adaptiveHeight.asInstanceOf[js.Any])
    if (afterChange != null) __obj.updateDynamic("afterChange")(js.Any.fromFunction1(afterChange))
    if (appendDots != null) __obj.updateDynamic("appendDots")(js.Any.fromFunction1(appendDots))
    if (!js.isUndefined(arrows)) __obj.updateDynamic("arrows")(arrows.asInstanceOf[js.Any])
    if (asNavFor != null) __obj.updateDynamic("asNavFor")(asNavFor.asInstanceOf[js.Any])
    if (!js.isUndefined(autoplay)) __obj.updateDynamic("autoplay")(autoplay.asInstanceOf[js.Any])
    if (autoplaySpeed != null) __obj.updateDynamic("autoplaySpeed")(autoplaySpeed.asInstanceOf[js.Any])
    if (beforeChange != null) __obj.updateDynamic("beforeChange")(js.Any.fromFunction2(beforeChange))
    if (!js.isUndefined(centerMode)) __obj.updateDynamic("centerMode")(centerMode.asInstanceOf[js.Any])
    if (centerPadding != null) __obj.updateDynamic("centerPadding")(centerPadding.asInstanceOf[js.Any])
    if (cssEase != null) __obj.updateDynamic("cssEase")(cssEase.asInstanceOf[js.Any])
    if (customPaging != null) __obj.updateDynamic("customPaging")(js.Any.fromFunction1(customPaging))
    if (!js.isUndefined(dots)) __obj.updateDynamic("dots")(dots.asInstanceOf[js.Any])
    if (dotsClass != null) __obj.updateDynamic("dotsClass")(dotsClass.asInstanceOf[js.Any])
    if (easing != null) __obj.updateDynamic("easing")(easing.asInstanceOf[js.Any])
    if (edgeFriction != null) __obj.updateDynamic("edgeFriction")(edgeFriction.asInstanceOf[js.Any])
    if (!js.isUndefined(fade)) __obj.updateDynamic("fade")(fade.asInstanceOf[js.Any])
    if (!js.isUndefined(focusOnSelect)) __obj.updateDynamic("focusOnSelect")(focusOnSelect.asInstanceOf[js.Any])
    if (!js.isUndefined(infinite)) __obj.updateDynamic("infinite")(infinite.asInstanceOf[js.Any])
    if (initialSlide != null) __obj.updateDynamic("initialSlide")(initialSlide.asInstanceOf[js.Any])
    if (lazyLoad != null) __obj.updateDynamic("lazyLoad")(lazyLoad.asInstanceOf[js.Any])
    if (nextArrow != null) __obj.updateDynamic("nextArrow")(nextArrow.asInstanceOf[js.Any])
    if (onEdge != null) __obj.updateDynamic("onEdge")(js.Any.fromFunction1(onEdge))
    if (onInit != null) __obj.updateDynamic("onInit")(js.Any.fromFunction0(onInit))
    if (onLazyLoad != null) __obj.updateDynamic("onLazyLoad")(js.Any.fromFunction1(onLazyLoad))
    if (onReInit != null) __obj.updateDynamic("onReInit")(js.Any.fromFunction0(onReInit))
    if (onSwipe != null) __obj.updateDynamic("onSwipe")(js.Any.fromFunction1(onSwipe))
    if (!js.isUndefined(pauseOnDotsHover)) __obj.updateDynamic("pauseOnDotsHover")(pauseOnDotsHover.asInstanceOf[js.Any])
    if (!js.isUndefined(pauseOnFocus)) __obj.updateDynamic("pauseOnFocus")(pauseOnFocus.asInstanceOf[js.Any])
    if (!js.isUndefined(pauseOnHover)) __obj.updateDynamic("pauseOnHover")(pauseOnHover.asInstanceOf[js.Any])
    if (prevArrow != null) __obj.updateDynamic("prevArrow")(prevArrow.asInstanceOf[js.Any])
    if (responsive != null) __obj.updateDynamic("responsive")(responsive.asInstanceOf[js.Any])
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
    if (slide != null) __obj.updateDynamic("slide")(slide.asInstanceOf[js.Any])
    if (slidesPerRow != null) __obj.updateDynamic("slidesPerRow")(slidesPerRow.asInstanceOf[js.Any])
    if (slidesToScroll != null) __obj.updateDynamic("slidesToScroll")(slidesToScroll.asInstanceOf[js.Any])
    if (slidesToShow != null) __obj.updateDynamic("slidesToShow")(slidesToShow.asInstanceOf[js.Any])
    if (speed != null) __obj.updateDynamic("speed")(speed.asInstanceOf[js.Any])
    if (!js.isUndefined(swipe)) __obj.updateDynamic("swipe")(swipe.asInstanceOf[js.Any])
    if (swipeEvent != null) __obj.updateDynamic("swipeEvent")(js.Any.fromFunction1(swipeEvent))
    if (!js.isUndefined(swipeToSlide)) __obj.updateDynamic("swipeToSlide")(swipeToSlide.asInstanceOf[js.Any])
    if (!js.isUndefined(touchMove)) __obj.updateDynamic("touchMove")(touchMove.asInstanceOf[js.Any])
    if (touchThreshold != null) __obj.updateDynamic("touchThreshold")(touchThreshold.asInstanceOf[js.Any])
    if (!js.isUndefined(useCSS)) __obj.updateDynamic("useCSS")(useCSS.asInstanceOf[js.Any])
    if (!js.isUndefined(useTransform)) __obj.updateDynamic("useTransform")(useTransform.asInstanceOf[js.Any])
    if (!js.isUndefined(variableWidth)) __obj.updateDynamic("variableWidth")(variableWidth.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    if (!js.isUndefined(verticalSwiping)) __obj.updateDynamic("verticalSwiping")(verticalSwiping.asInstanceOf[js.Any])
    if (!js.isUndefined(waitForAnimate)) __obj.updateDynamic("waitForAnimate")(waitForAnimate.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  def apply(mods: TagMod[tag.type]*): BuildingComponent[tag.type, default] = new slinky.core.BuildingComponent[slinky.web.html.`*`.tag.type, typings.reactSlick.mod.default](js.Array(component.asInstanceOf[js.Any], js.Dictionary.empty)).apply(mods: _*)
  type Props = Settings
}

```

## Scalajs-react

```scala
package typings.reactSlick.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StringDictionary
import typings.react.mod._Global_.JSX.Element
import typings.reactSlick.mod.LazyLoadTypes
import typings.reactSlick.mod.ResponsiveObject
import typings.reactSlick.mod.Settings
import typings.reactSlick.mod.Slider
import typings.reactSlick.mod.SwipeDirection
import typings.reactSlick.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSlick {
  def apply(
    accessibility: js.UndefOr[Boolean] = js.undefined,
    adaptiveHeight: js.UndefOr[Boolean] = js.undefined,
    afterChange: /* currentSlide */ Double => Callback = null,
    appendDots: /* dots */ Node => CallbackTo[Element] = null,
    arrows: js.UndefOr[Boolean] = js.undefined,
    asNavFor: Slider = null,
    autoplay: js.UndefOr[Boolean] = js.undefined,
    autoplaySpeed: Int | Double = null,
    beforeChange: (/* currentSlide */ Double, /* nextSlide */ Double) => Callback = null,
    centerMode: js.UndefOr[Boolean] = js.undefined,
    centerPadding: String = null,
    className: String = null,
    cssEase: String = null,
    customPaging: /* index */ Double => CallbackTo[Element] = null,
    dots: js.UndefOr[Boolean] = js.undefined,
    dotsClass: String = null,
    draggable: js.UndefOr[Boolean] = js.undefined,
    easing: String = null,
    edgeFriction: Int | Double = null,
    fade: js.UndefOr[Boolean] = js.undefined,
    focusOnSelect: js.UndefOr[Boolean] = js.undefined,
    infinite: js.UndefOr[Boolean] = js.undefined,
    initialSlide: Int | Double = null,
    lazyLoad: LazyLoadTypes = null,
    nextArrow: Element = null,
    onEdge: /* swipeDirection */ SwipeDirection => Callback = null,
    onInit: js.UndefOr[Callback] = js.undefined,
    onLazyLoad: /* slidesToLoad */ js.Array[Double] => Callback = null,
    onReInit: js.UndefOr[Callback] = js.undefined,
    onSwipe: /* swipeDirection */ SwipeDirection => Callback = null,
    pauseOnDotsHover: js.UndefOr[Boolean] = js.undefined,
    pauseOnFocus: js.UndefOr[Boolean] = js.undefined,
    pauseOnHover: js.UndefOr[Boolean] = js.undefined,
    prevArrow: Element = null,
    responsive: js.Array[ResponsiveObject] = null,
    rows: Int | Double = null,
    rtl: js.UndefOr[Boolean] = js.undefined,
    slide: String = null,
    slidesPerRow: Int | Double = null,
    slidesToScroll: Int | Double = null,
    slidesToShow: Int | Double = null,
    speed: Int | Double = null,
    swipe: js.UndefOr[Boolean] = js.undefined,
    swipeEvent: /* swipeDirection */ SwipeDirection => Callback = null,
    swipeToSlide: js.UndefOr[Boolean] = js.undefined,
    touchMove: js.UndefOr[Boolean] = js.undefined,
    touchThreshold: Int | Double = null,
    useCSS: js.UndefOr[Boolean] = js.undefined,
    useTransform: js.UndefOr[Boolean] = js.undefined,
    variableWidth: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    verticalSwiping: js.UndefOr[Boolean] = js.undefined,
    waitForAnimate: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[Settings, default, Unit, Settings] = {
    val __obj = js.Dynamic.literal()
  
      if (!js.isUndefined(accessibility)) __obj.updateDynamic("accessibility")(accessibility.asInstanceOf[js.Any])
    if (!js.isUndefined(adaptiveHeight)) __obj.updateDynamic("adaptiveHeight")(adaptiveHeight.asInstanceOf[js.Any])
    if (afterChange != null) __obj.updateDynamic("afterChange")(js.Any.fromFunction1((t0: /* currentSlide */ scala.Double) => afterChange(t0).runNow()))
    if (appendDots != null) __obj.updateDynamic("appendDots")(js.Any.fromFunction1((t0: /* dots */ japgolly.scalajs.react.raw.React.Node) => appendDots(t0).runNow()))
    if (!js.isUndefined(arrows)) __obj.updateDynamic("arrows")(arrows.asInstanceOf[js.Any])
    if (asNavFor != null) __obj.updateDynamic("asNavFor")(asNavFor.asInstanceOf[js.Any])
    if (!js.isUndefined(autoplay)) __obj.updateDynamic("autoplay")(autoplay.asInstanceOf[js.Any])
    if (autoplaySpeed != null) __obj.updateDynamic("autoplaySpeed")(autoplaySpeed.asInstanceOf[js.Any])
    if (beforeChange != null) __obj.updateDynamic("beforeChange")(js.Any.fromFunction2((t0: /* currentSlide */ scala.Double, t1: /* nextSlide */ scala.Double) => beforeChange(t0, t1).runNow()))
    if (!js.isUndefined(centerMode)) __obj.updateDynamic("centerMode")(centerMode.asInstanceOf[js.Any])
    if (centerPadding != null) __obj.updateDynamic("centerPadding")(centerPadding.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (cssEase != null) __obj.updateDynamic("cssEase")(cssEase.asInstanceOf[js.Any])
    if (customPaging != null) __obj.updateDynamic("customPaging")(js.Any.fromFunction1((t0: /* index */ scala.Double) => customPaging(t0).runNow()))
    if (!js.isUndefined(dots)) __obj.updateDynamic("dots")(dots.asInstanceOf[js.Any])
    if (dotsClass != null) __obj.updateDynamic("dotsClass")(dotsClass.asInstanceOf[js.Any])
    if (!js.isUndefined(draggable)) __obj.updateDynamic("draggable")(draggable.asInstanceOf[js.Any])
    if (easing != null) __obj.updateDynamic("easing")(easing.asInstanceOf[js.Any])
    if (edgeFriction != null) __obj.updateDynamic("edgeFriction")(edgeFriction.asInstanceOf[js.Any])
    if (!js.isUndefined(fade)) __obj.updateDynamic("fade")(fade.asInstanceOf[js.Any])
    if (!js.isUndefined(focusOnSelect)) __obj.updateDynamic("focusOnSelect")(focusOnSelect.asInstanceOf[js.Any])
    if (!js.isUndefined(infinite)) __obj.updateDynamic("infinite")(infinite.asInstanceOf[js.Any])
    if (initialSlide != null) __obj.updateDynamic("initialSlide")(initialSlide.asInstanceOf[js.Any])
    if (lazyLoad != null) __obj.updateDynamic("lazyLoad")(lazyLoad.asInstanceOf[js.Any])
    if (nextArrow != null) __obj.updateDynamic("nextArrow")(nextArrow.asInstanceOf[js.Any])
    if (onEdge != null) __obj.updateDynamic("onEdge")(js.Any.fromFunction1((t0: /* swipeDirection */ typings.reactSlick.mod.SwipeDirection) => onEdge(t0).runNow()))
    onInit.foreach(p => __obj.updateDynamic("onInit")(p.toJsFn))
    if (onLazyLoad != null) __obj.updateDynamic("onLazyLoad")(js.Any.fromFunction1((t0: /* slidesToLoad */ js.Array[scala.Double]) => onLazyLoad(t0).runNow()))
    onReInit.foreach(p => __obj.updateDynamic("onReInit")(p.toJsFn))
    if (onSwipe != null) __obj.updateDynamic("onSwipe")(js.Any.fromFunction1((t0: /* swipeDirection */ typings.reactSlick.mod.SwipeDirection) => onSwipe(t0).runNow()))
    if (!js.isUndefined(pauseOnDotsHover)) __obj.updateDynamic("pauseOnDotsHover")(pauseOnDotsHover.asInstanceOf[js.Any])
    if (!js.isUndefined(pauseOnFocus)) __obj.updateDynamic("pauseOnFocus")(pauseOnFocus.asInstanceOf[js.Any])
    if (!js.isUndefined(pauseOnHover)) __obj.updateDynamic("pauseOnHover")(pauseOnHover.asInstanceOf[js.Any])
    if (prevArrow != null) __obj.updateDynamic("prevArrow")(prevArrow.asInstanceOf[js.Any])
    if (responsive != null) __obj.updateDynamic("responsive")(responsive.asInstanceOf[js.Any])
    if (rows != null) __obj.updateDynamic("rows")(rows.asInstanceOf[js.Any])
    if (!js.isUndefined(rtl)) __obj.updateDynamic("rtl")(rtl.asInstanceOf[js.Any])
    if (slide != null) __obj.updateDynamic("slide")(slide.asInstanceOf[js.Any])
    if (slidesPerRow != null) __obj.updateDynamic("slidesPerRow")(slidesPerRow.asInstanceOf[js.Any])
    if (slidesToScroll != null) __obj.updateDynamic("slidesToScroll")(slidesToScroll.asInstanceOf[js.Any])
    if (slidesToShow != null) __obj.updateDynamic("slidesToShow")(slidesToShow.asInstanceOf[js.Any])
    if (speed != null) __obj.updateDynamic("speed")(speed.asInstanceOf[js.Any])
    if (!js.isUndefined(swipe)) __obj.updateDynamic("swipe")(swipe.asInstanceOf[js.Any])
    if (swipeEvent != null) __obj.updateDynamic("swipeEvent")(js.Any.fromFunction1((t0: /* swipeDirection */ typings.reactSlick.mod.SwipeDirection) => swipeEvent(t0).runNow()))
    if (!js.isUndefined(swipeToSlide)) __obj.updateDynamic("swipeToSlide")(swipeToSlide.asInstanceOf[js.Any])
    if (!js.isUndefined(touchMove)) __obj.updateDynamic("touchMove")(touchMove.asInstanceOf[js.Any])
    if (touchThreshold != null) __obj.updateDynamic("touchThreshold")(touchThreshold.asInstanceOf[js.Any])
    if (!js.isUndefined(useCSS)) __obj.updateDynamic("useCSS")(useCSS.asInstanceOf[js.Any])
    if (!js.isUndefined(useTransform)) __obj.updateDynamic("useTransform")(useTransform.asInstanceOf[js.Any])
    if (!js.isUndefined(variableWidth)) __obj.updateDynamic("variableWidth")(variableWidth.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    if (!js.isUndefined(verticalSwiping)) __obj.updateDynamic("verticalSwiping")(verticalSwiping.asInstanceOf[js.Any])
    if (!js.isUndefined(waitForAnimate)) __obj.updateDynamic("waitForAnimate")(waitForAnimate.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactSlick.mod.Settings, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactSlick.mod.default](this.componentImport)
    f(__obj.asInstanceOf[typings.reactSlick.mod.Settings])(children: _*)
  }
  @JSImport("react-slick", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}


```
