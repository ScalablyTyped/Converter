package typings.react.mod

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
    UNSAFE_componentWillMount: () => Unit = null,
    UNSAFE_componentWillReceiveProps: (P, /* nextContext */ js.Any) => Unit = null,
    UNSAFE_componentWillUpdate: (P, S, /* nextContext */ js.Any) => Unit = null,
    childContextTypes: ValidationMap[_] = null,
    componentDidCatch: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Unit = null,
    componentDidMount: () => Unit = null,
    componentDidUpdate: (P, S, /* snapshot */ js.UndefOr[js.Any]) => Unit = null,
    componentWillMount: () => Unit = null,
    componentWillReceiveProps: (P, /* nextContext */ js.Any) => Unit = null,
    componentWillUnmount: () => Unit = null,
    componentWillUpdate: (P, S, /* nextContext */ js.Any) => Unit = null,
    contextTypes: ValidationMap[_] = null,
    displayName: String = null,
    getDefaultProps: () => P = null,
    getInitialState: () => S = null,
    getSnapshotBeforeUpdate: (P, S) => js.Any | Null = null,
    mixins: js.Array[Mixin[P, S]] = null,
    propTypes: ValidationMap[_] = null,
    shouldComponentUpdate: (P, S, /* nextContext */ js.Any) => Boolean = null,
    statics: StringDictionary[js.Any] = null
  ): Mixin[P, S] = {
    val __obj = js.Dynamic.literal()
    if (UNSAFE_componentWillMount != null) __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(UNSAFE_componentWillMount))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(UNSAFE_componentWillReceiveProps))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(UNSAFE_componentWillUpdate))
    if (childContextTypes != null) __obj.updateDynamic("childContextTypes")(childContextTypes.asInstanceOf[js.Any])
    if (componentDidCatch != null) __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2(componentDidCatch))
    if (componentDidMount != null) __obj.updateDynamic("componentDidMount")(js.Any.fromFunction0(componentDidMount))
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(componentDidUpdate))
    if (componentWillMount != null) __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0(componentWillMount))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(componentWillReceiveProps))
    if (componentWillUnmount != null) __obj.updateDynamic("componentWillUnmount")(js.Any.fromFunction0(componentWillUnmount))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(componentWillUpdate))
    if (contextTypes != null) __obj.updateDynamic("contextTypes")(contextTypes.asInstanceOf[js.Any])
    if (displayName != null) __obj.updateDynamic("displayName")(displayName.asInstanceOf[js.Any])
    if (getDefaultProps != null) __obj.updateDynamic("getDefaultProps")(js.Any.fromFunction0(getDefaultProps))
    if (getInitialState != null) __obj.updateDynamic("getInitialState")(js.Any.fromFunction0(getInitialState))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(getSnapshotBeforeUpdate))
    if (mixins != null) __obj.updateDynamic("mixins")(mixins.asInstanceOf[js.Any])
    if (propTypes != null) __obj.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
    if (shouldComponentUpdate != null) __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(shouldComponentUpdate))
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
    def withGetDefaultProps(getDefaultProps: () => P): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getDefaultProps != null) ret.updateDynamic("getDefaultProps")(js.Any.fromFunction0(getDefaultProps))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutGetDefaultProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "getDefaultProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withGetInitialState(getInitialState: () => S): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (getInitialState != null) ret.updateDynamic("getInitialState")(js.Any.fromFunction0(getInitialState))
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

