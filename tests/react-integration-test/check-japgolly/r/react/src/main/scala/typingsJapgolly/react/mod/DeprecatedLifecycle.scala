package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DeprecatedLifecycle[P, S] extends js.Object {
  /**
    * Called immediately before mounting occurs, and before `Component#render`.
    * Avoid introducing any side-effects or subscriptions in this method.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use componentDidMount or the constructor instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#initializing-state
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillMount: js.UndefOr[js.Function0[Unit]] = js.native
  /**
    * Called when the component may be receiving new props.
    * React may call this even if props have not changed, so be sure to compare new and existing
    * props if you only want to handle changes.
    *
    * Calling `Component#setState` generally does not trigger this method.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use static getDerivedStateFromProps instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#updating-state-based-on-props
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillReceiveProps: js.UndefOr[js.Function2[/* nextProps */ P, /* nextContext */ js.Any, Unit]] = js.native
  /**
    * Called immediately before rendering when new props or state is received. Not called for the initial render.
    *
    * Note: You cannot call `Component#setState` here.
    *
    * This method will not stop working in React 17.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use getSnapshotBeforeUpdate instead
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#reading-dom-properties-before-an-update
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var UNSAFE_componentWillUpdate: js.UndefOr[
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Unit]
  ] = js.native
  /**
    * Called immediately before mounting occurs, and before `Component#render`.
    * Avoid introducing any side-effects or subscriptions in this method.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use componentDidMount or the constructor instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#initializing-state
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillMount: js.UndefOr[js.Function0[Unit]] = js.native
  /**
    * Called when the component may be receiving new props.
    * React may call this even if props have not changed, so be sure to compare new and existing
    * props if you only want to handle changes.
    *
    * Calling `Component#setState` generally does not trigger this method.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use static getDerivedStateFromProps instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#updating-state-based-on-props
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillReceiveProps: js.UndefOr[js.Function2[/* nextProps */ P, /* nextContext */ js.Any, Unit]] = js.native
  /**
    * Called immediately before rendering when new props or state is received. Not called for the initial render.
    *
    * Note: You cannot call `Component#setState` here.
    *
    * Note: the presence of getSnapshotBeforeUpdate or getDerivedStateFromProps
    * prevents this from being invoked.
    *
    * @deprecated 16.3, use getSnapshotBeforeUpdate instead; will stop working in React 17
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#reading-dom-properties-before-an-update
    * @see https://reactjs.org/blog/2018/03/27/update-on-async-rendering.html#gradual-migration-path
    */
  var componentWillUpdate: js.UndefOr[
    js.Function3[/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any, Unit]
  ] = js.native
}

object DeprecatedLifecycle {
  @scala.inline
  def apply[P, S](
    UNSAFE_componentWillMount: js.UndefOr[Callback] = js.undefined,
    UNSAFE_componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Callback = null,
    UNSAFE_componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback = null,
    componentWillMount: js.UndefOr[Callback] = js.undefined,
    componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Callback = null,
    componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback = null
  ): DeprecatedLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    UNSAFE_componentWillMount.foreach(p => __obj.updateDynamic("UNSAFE_componentWillMount")(p.toJsFn))
    if (UNSAFE_componentWillReceiveProps != null) __obj.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => UNSAFE_componentWillReceiveProps(t0, t1).runNow()))
    if (UNSAFE_componentWillUpdate != null) __obj.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => UNSAFE_componentWillUpdate(t0, t1, t2).runNow()))
    componentWillMount.foreach(p => __obj.updateDynamic("componentWillMount")(p.toJsFn))
    if (componentWillReceiveProps != null) __obj.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => componentWillReceiveProps(t0, t1).runNow()))
    if (componentWillUpdate != null) __obj.updateDynamic("componentWillUpdate")(js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => componentWillUpdate(t0, t1, t2).runNow()))
    __obj.asInstanceOf[DeprecatedLifecycle[P, S]]
  }
  @scala.inline
  implicit class DeprecatedLifecycleOps[Self[p, s] <: DeprecatedLifecycle[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withUNSAFE_componentWillMount(UNSAFE_componentWillMount: js.UndefOr[Callback]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        UNSAFE_componentWillMount.foreach(p => ret.updateDynamic("UNSAFE_componentWillMount")(p.toJsFn))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillMount: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillMount")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withUNSAFE_componentWillReceiveProps(UNSAFE_componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Callback): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (UNSAFE_componentWillReceiveProps != null) ret.updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => UNSAFE_componentWillReceiveProps(t0, t1).runNow()))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillReceiveProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillReceiveProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withUNSAFE_componentWillUpdate(
      UNSAFE_componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback
    ): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (UNSAFE_componentWillUpdate != null) ret.updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => UNSAFE_componentWillUpdate(t0, t1, t2).runNow()))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutUNSAFE_componentWillUpdate: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "UNSAFE_componentWillUpdate")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillMount(componentWillMount: js.UndefOr[Callback]): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        componentWillMount.foreach(p => ret.updateDynamic("componentWillMount")(p.toJsFn))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillMount: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillMount")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillReceiveProps(componentWillReceiveProps: (/* nextProps */ P, /* nextContext */ js.Any) => Callback): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillReceiveProps != null) ret.updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2((t0: /* nextProps */ P, t1: /* nextContext */ js.Any) => componentWillReceiveProps(t0, t1).runNow()))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillReceiveProps: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillReceiveProps")
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withComponentWillUpdate(componentWillUpdate: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Callback): Self[P, S] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentWillUpdate != null) ret.updateDynamic("componentWillUpdate")(js.Any.fromFunction3((t0: /* nextProps */ P, t1: /* nextState */ S, t2: /* nextContext */ js.Any) => componentWillUpdate(t0, t1, t2).runNow()))
        ret.asInstanceOf[Self[P, S]]
    }
    @scala.inline
    def withoutComponentWillUpdate: Self[P, S] = {
        val ret = this.duplicate
        js.special.delete(ret, "componentWillUpdate")
        ret.asInstanceOf[Self[P, S]]
    }
  }
  
}

