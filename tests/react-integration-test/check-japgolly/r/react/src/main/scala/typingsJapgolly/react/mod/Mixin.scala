package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Mixin[P, S]
  extends ComponentLifecycle[P, S, js.Any] {
  var childContextTypes: js.UndefOr[ValidationMap[_]] = js.native
  var contextTypes: js.UndefOr[ValidationMap[_]] = js.native
  var displayName: js.UndefOr[String] = js.native
  var getDefaultProps: js.UndefOr[js.Function0[P]] = js.native
  var getInitialState: js.UndefOr[js.Function0[S]] = js.native
  var mixins: js.UndefOr[js.Array[Mixin[P, S]]] = js.native
  var propTypes: js.UndefOr[ValidationMap[_]] = js.native
  var statics: js.UndefOr[StringDictionary[js.Any]] = js.native
}

object Mixin {
  @scala.inline
  def apply[P, S](
    UNSAFE_componentWillMount: js.UndefOr[Callback] = js.undefined,
    UNSAFE_componentWillReceiveProps: (P, /* nextContext */ js.Any) => Callback = null,
    UNSAFE_componentWillUpdate: (P, S, /* nextContext */ js.Any) => Callback = null,
    childContextTypes: ValidationMap[_] = null,
    componentDidCatch: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Callback = null,
    componentDidMount: js.UndefOr[Callback] = js.undefined,
    componentDidUpdate: (P, S, /* snapshot */ js.UndefOr[js.Any]) => Callback = null,
    componentWillMount: js.UndefOr[Callback] = js.undefined,
    componentWillReceiveProps: (P, /* nextContext */ js.Any) => Callback = null,
    componentWillUnmount: js.UndefOr[Callback] = js.undefined,
    componentWillUpdate: (P, S, /* nextContext */ js.Any) => Callback = null,
    contextTypes: ValidationMap[_] = null,
    displayName: String = null,
    getDefaultProps: js.UndefOr[CallbackTo[P]] = js.undefined,
    getInitialState: js.UndefOr[CallbackTo[S]] = js.undefined,
    getSnapshotBeforeUpdate: (P, S) => CallbackTo[js.Any | Null] = null,
    mixins: js.Array[Mixin[P, S]] = null,
    propTypes: ValidationMap[_] = null,
    shouldComponentUpdate: (P, S, /* nextContext */ js.Any) => CallbackTo[Boolean] = null,
    statics: StringDictionary[js.Any] = null
  ): Mixin[P, S] = {
    val __obj = js.Dynamic.literal()
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(p.toJsFn))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => UNSAFE_componentWillReceiveProps(t0, t1).runNow()))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => UNSAFE_componentWillUpdate(t0, t1, t2).runNow()))
    if (childContextTypes != null) __obj.updateDynamic("childContextTypes")(childContextTypes.asInstanceOf[js.Any])
    if (componentDidCatch != null) __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2((t0: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, t1: /* errorInfo */ ErrorInfo) => componentDidCatch(t0, t1).runNow()))
    componentDidMount.foreach(p => __obj.updateDynamic("componentDidMount")(p.toJsFn))
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* snapshot */ js.UndefOr[js.Any]) => componentDidUpdate(t0, t1, t2).runNow()))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(p.toJsFn))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2((t0: P, t1: /* nextContext */ js.Any) => componentWillReceiveProps(t0, t1).runNow()))
    componentWillUnmount.foreach(p => __obj.updateDynamic("componentWillUnmount")(p.toJsFn))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => componentWillUpdate(t0, t1, t2).runNow()))
    if (contextTypes != null) __obj.updateDynamic("contextTypes")(contextTypes.asInstanceOf[js.Any])
    if (displayName != null) __obj.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
    getDefaultProps.foreach(p => __obj.updateDynamic("getDefaultProps")(p.toJsFn))
    getInitialState.foreach(p => __obj.updateDynamic("getInitialState")(p.toJsFn))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2((t0: P, t1: S) => getSnapshotBeforeUpdate(t0, t1).runNow()))
    if (mixins != null) __obj.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
    if (propTypes != null) __obj.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
    if (shouldComponentUpdate != null) __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3((t0: P, t1: S, t2: /* nextContext */ js.Any) => shouldComponentUpdate(t0, t1, t2).runNow()))
    if (statics != null) __obj.updateDynamic("statics")(statics.asInstanceOf[js.Any])
    __obj.asInstanceOf[Mixin[P, S]]
  }
  @scala.inline
  implicit class MixinOps[Self[p, s] <: Mixin[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withChildContextTypes(childContextTypes: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (childContextTypes != null) ret.updateDynamic("childContextTypes")(childContextTypes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutChildContextTypes: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "childContextTypes")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withContextTypes(contextTypes: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (contextTypes != null) ret.updateDynamic("contextTypes")(contextTypes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutContextTypes: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "contextTypes")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withDisplayName(displayName: String): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (displayName != null) ret.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutDisplayName: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "displayName")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withGetDefaultProps(getDefaultProps: js.UndefOr[CallbackTo[P]]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        getDefaultProps.foreach(p => ret.updateDynamic("getDefaultProps")(p.toJsFn))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutGetDefaultProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "getDefaultProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withGetInitialState(getInitialState: js.UndefOr[CallbackTo[S]]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        getInitialState.foreach(p => ret.updateDynamic("getInitialState")(p.toJsFn))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutGetInitialState: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "getInitialState")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withMixins(mixins: js.Array[Mixin[P, S]]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (mixins != null) ret.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutMixins: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "mixins")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withPropTypes(propTypes: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (propTypes != null) ret.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutPropTypes: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "propTypes")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withStatics(statics: StringDictionary[js.Any]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (statics != null) ret.updateDynamic("statics")(statics.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutStatics: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "statics")
        ret.asInstanceOf[Self[P, S]]
    }
  }
  
}

