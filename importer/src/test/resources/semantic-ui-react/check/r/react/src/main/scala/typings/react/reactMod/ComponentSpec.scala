package typings.react.reactMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ComponentSpec[P, S]
  extends Mixin[P, S]
     with /* propertyName */ StringDictionary[js.Any] {
  def render(): ReactNode
}

object ComponentSpec {
  @scala.inline
  def apply[P, S](
    render: () => ReactNode,
    StringDictionary: /* propertyName */ StringDictionary[js.Any] = null,
    UNSAFE_componentWillMount: () => Unit = null,
    UNSAFE_componentWillReceiveProps: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* nextProps */ js.Any, /* nextContext */ js.Any) => Unit = null,
    UNSAFE_componentWillUpdate: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* nextProps */ js.Any, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<S> */ /* nextState */ js.Any, /* nextContext */ js.Any) => Unit = null,
    childContextTypes: ValidationMap[_] = null,
    componentDidCatch: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Error */ /* error */ js.Any, /* errorInfo */ ErrorInfo) => Unit = null,
    componentDidMount: () => Unit = null,
    componentDidUpdate: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* prevProps */ js.Any, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<S> */ /* prevState */ js.Any, /* snapshot */ js.UndefOr[js.Any]) => Unit = null,
    componentWillMount: () => Unit = null,
    componentWillReceiveProps: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* nextProps */ js.Any, /* nextContext */ js.Any) => Unit = null,
    componentWillUnmount: () => Unit = null,
    componentWillUpdate: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* nextProps */ js.Any, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<S> */ /* nextState */ js.Any, /* nextContext */ js.Any) => Unit = null,
    contextTypes: ValidationMap[_] = null,
    displayName: String = null,
    getDefaultProps: () => P = null,
    getInitialState: () => S = null,
    getSnapshotBeforeUpdate: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* prevProps */ js.Any, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<S> */ /* prevState */ js.Any) => js.Any | Null = null,
    mixins: js.Array[Mixin[P, S]] = null,
    propTypes: ValidationMap[_] = null,
    shouldComponentUpdate: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<P> */ /* nextProps */ js.Any, /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Readonly<S> */ /* nextState */ js.Any, /* nextContext */ js.Any) => Boolean = null,
    statics: StringDictionary[js.Any] = null
  ): ComponentSpec[P, S] = {
    val __obj = js.Dynamic.literal(render = js.Any.fromFunction0(render))
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (UNSAFE_componentWillMount != null) __obj.updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(UNSAFE_componentWillMount))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(UNSAFE_componentWillReceiveProps))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(UNSAFE_componentWillUpdate))
    if (childContextTypes != null) __obj.updateDynamic("childContextTypes")(childContextTypes)
    if (componentDidCatch != null) __obj.updateDynamic("componentDidCatch")(js.Any.fromFunction2(componentDidCatch))
    if (componentDidMount != null) __obj.updateDynamic("componentDidMount")(js.Any.fromFunction0(componentDidMount))
    if (componentDidUpdate != null) __obj.updateDynamic("componentDidUpdate")(js.Any.fromFunction3(componentDidUpdate))
    if (componentWillMount != null) __obj.updateDynamic("componentWillMount")(js.Any.fromFunction0(componentWillMount))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(componentWillReceiveProps))
    if (componentWillUnmount != null) __obj.updateDynamic("componentWillUnmount")(js.Any.fromFunction0(componentWillUnmount))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3(componentWillUpdate))
    if (contextTypes != null) __obj.updateDynamic("contextTypes")(contextTypes)
    if (displayName != null) __obj.updateDynamic("displayName")(displayName)
    if (getDefaultProps != null) __obj.updateDynamic("getDefaultProps")(js.Any.fromFunction0(getDefaultProps))
    if (getInitialState != null) __obj.updateDynamic("getInitialState")(js.Any.fromFunction0(getInitialState))
    if (getSnapshotBeforeUpdate != null) __obj.updateDynamic("getSnapshotBeforeUpdate")(js.Any.fromFunction2(getSnapshotBeforeUpdate))
    if (mixins != null) __obj.updateDynamic("mixins")(mixins)
    if (propTypes != null) __obj.updateDynamic("propTypes")(propTypes)
    if (shouldComponentUpdate != null) __obj.updateDynamic("shouldComponentUpdate")(js.Any.fromFunction3(shouldComponentUpdate))
    if (statics != null) __obj.updateDynamic("statics")(statics)
    __obj.asInstanceOf[ComponentSpec[P, S]]
  }
}

