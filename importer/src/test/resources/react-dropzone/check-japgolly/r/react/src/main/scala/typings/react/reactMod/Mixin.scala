package typings.react.reactMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Mixin[P, S]
  extends ComponentLifecycle[P, S, js.Any] {
  var childContextTypes: js.UndefOr[ValidationMap[_]] = js.undefined
  var contextTypes: js.UndefOr[ValidationMap[_]] = js.undefined
  var displayName: js.UndefOr[String] = js.undefined
  var getDefaultProps: js.UndefOr[js.Function0[P]] = js.undefined
  var getInitialState: js.UndefOr[js.Function0[S]] = js.undefined
  var mixins: js.UndefOr[js.Array[Mixin[P, S]]] = js.undefined
  var propTypes: js.UndefOr[ValidationMap[_]] = js.undefined
  var statics: js.UndefOr[StringDictionary[js.Any]] = js.undefined
}

object Mixin {
  @scala.inline
  def apply[P, S](
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
  ): Mixin[P, S] = {
    val __obj = js.Dynamic.literal()
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0((() => p.runNow()))))
    UNSAFE_componentWillReceiveProps.foreach(p => __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(((t0: P, t1: /* nextContext */ js.Any) => p(t0, t1).runNow()))))
    UNSAFE_componentWillUpdate.foreach(p => __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    if (childContextTypes != null) __obj.updateDynamic("childContextTypes")(childContextTypes)
    componentDidCatch.foreach(p => __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2(((t0: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, t1: /* errorInfo */ typings.react.reactMod.ErrorInfo) => p(t0, t1).runNow()))))
    componentDidMount.foreach(p => __obj.updateDynamic("componentDidMount")(js.Any.fromFunction0((() => p.runNow()))))
    componentDidUpdate.foreach(p => __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* snapshot */ js.UndefOr[js.Any]) => p(t0, t1, t2).runNow()))))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0((() => p.runNow()))))
    componentWillReceiveProps.foreach(p => __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(((t0: P, t1: /* nextContext */ js.Any) => p(t0, t1).runNow()))))
    componentWillUnmount.foreach(p => __obj.updateDynamic("componentWillUnmount")(js.Any.fromFunction0((() => p.runNow()))))
    componentWillUpdate.foreach(p => __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    if (contextTypes != null) __obj.updateDynamic("contextTypes")(contextTypes)
    if (displayName != null) __obj.updateDynamic("displayName")(displayName)
    getDefaultProps.foreach(p => __obj.updateDynamic("getDefaultProps")(js.Any.fromFunction0((() => p.runNow()))))
    getInitialState.foreach(p => __obj.updateDynamic("getInitialState")(js.Any.fromFunction0((() => p.runNow()))))
    getSnapshotBeforeUpdate.foreach(p => __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(((t0: P, t1: S) => p(t0, t1).runNow()))))
    if (mixins != null) __obj.updateDynamic("mixins")(mixins)
    if (propTypes != null) __obj.updateDynamic("propTypes")(propTypes)
    shouldComponentUpdate.foreach(p => __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(((t0: P, t1: S, t2: /* nextContext */ js.Any) => p(t0, t1, t2).runNow()))))
    if (statics != null) __obj.updateDynamic("statics")(statics)
    __obj.asInstanceOf[Mixin[P, S]]
  }
}

