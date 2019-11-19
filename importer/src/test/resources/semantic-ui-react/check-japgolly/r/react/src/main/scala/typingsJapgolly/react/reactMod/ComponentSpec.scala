package typingsJapgolly.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentSpec[P, S]
  extends Mixin[P, S]
     with /* propertyName */ StringDictionary[js.Any] {
  def render(): Node
}

object ComponentSpec {
  @scala.inline
  def apply[P, S](
    render: CallbackTo[Node],
    StringDictionary: /* propertyName */ StringDictionary[js.Any] = null,
    UNSAFE_componentWillMount: js.UndefOr[Callback] = js.undefined,
    UNSAFE_componentWillReceiveProps: js.UndefOr[(P, /* nextContext */ js.Any) => Callback] = js.undefined,
    UNSAFE_componentWillUpdate: js.UndefOr[(P, S, /* nextContext */ js.Any) => Callback] = js.undefined,
    childContextTypes: ValidationMap[_] = null,
    componentDidCatch: js.UndefOr[
      (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Callback
    ] = js.undefined,
    componentDidMount: js.UndefOr[Callback] = js.undefined,
    componentDidUpdate: js.UndefOr[(P, S, /* snapshot */ js.UndefOr[js.Any]) => Callback] = js.undefined,
    componentWillMount: js.UndefOr[Callback] = js.undefined,
    componentWillReceiveProps: js.UndefOr[(P, /* nextContext */ js.Any) => Callback] = js.undefined,
    componentWillUnmount: js.UndefOr[Callback] = js.undefined,
    componentWillUpdate: js.UndefOr[(P, S, /* nextContext */ js.Any) => Callback] = js.undefined,
    contextTypes: ValidationMap[_] = null,
    displayName: String = null,
    getDefaultProps: js.UndefOr[CallbackTo[P]] = js.undefined,
    getInitialState: js.UndefOr[CallbackTo[S]] = js.undefined,
    getSnapshotBeforeUpdate: js.UndefOr[(P, S) => CallbackTo[js.Any | Null]] = js.undefined,
    mixins: js.Array[Mixin[P, S]] = null,
    propTypes: ValidationMap[_] = null,
    shouldComponentUpdate: js.UndefOr[(P, S, /* nextContext */ js.Any) => CallbackTo[Boolean]] = js.undefined,
    statics: StringDictionary[js.Any] = null
  ): ComponentSpec[P, S] = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("render")(render.toJsFn)
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(p.toJsFn))
    UNSAFE_componentWillReceiveProps.foreach(x => __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => x(t0, t1).runNow())))
    UNSAFE_componentWillUpdate.foreach(x => __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => x(t0, t1, t2).runNow())))
    if (childContextTypes != null) __obj.updateDynamic("childContextTypes")(childContextTypes.asInstanceOf[js.Any])
    componentDidCatch.foreach(x => __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2((t0: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, t1: /* errorInfo */ typingsJapgolly.react.reactMod.ErrorInfo) => x(t0, t1).runNow())))
    componentDidMount.foreach(p => __obj.updateDynamic("componentDidMount")(p.toJsFn))
    componentDidUpdate.foreach(x => __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* snapshot */ js.UndefOr[js.Any]) => x(t0, t1, t2).runNow())))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(p.toJsFn))
    componentWillReceiveProps.foreach(x => __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => x(t0, t1).runNow())))
    componentWillUnmount.foreach(p => __obj.updateDynamic("componentWillUnmount")(p.toJsFn))
    componentWillUpdate.foreach(x => __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => x(t0, t1, t2).runNow())))
    if (contextTypes != null) __obj.updateDynamic("contextTypes")(contextTypes.asInstanceOf[js.Any])
    if (displayName != null) __obj.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
    getDefaultProps.foreach(p => __obj.updateDynamic("getDefaultProps")(p.toJsFn))
    getInitialState.foreach(p => __obj.updateDynamic("getInitialState")(p.toJsFn))
    getSnapshotBeforeUpdate.foreach(x => __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2((t0: P, t1: S) => x(t0, t1).runNow())))
    if (mixins != null) __obj.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
    if (propTypes != null) __obj.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
    shouldComponentUpdate.foreach(x => __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => x(t0, t1, t2).runNow())))
    if (statics != null) __obj.updateDynamic("statics")(statics.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentSpec[P, S]]
  }
}

