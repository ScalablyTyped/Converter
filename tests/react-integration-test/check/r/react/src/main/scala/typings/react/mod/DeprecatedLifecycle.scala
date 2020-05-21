package typings.react.mod

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
  def apply[P, S](): DeprecatedLifecycle[P, S] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DeprecatedLifecycle[P, S]]
  }
  @scala.inline
  implicit class DeprecatedLifecycleOps[Self <: DeprecatedLifecycle[_, _], P, S] (val x: Self with (DeprecatedLifecycle[P, S])) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withUNSAFE_componentWillMount(value: () => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillMount")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutUNSAFE_componentWillMount: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillMount")(js.undefined)
        ret
    }
    @scala.inline
    def withUNSAFE_componentWillReceiveProps(value: (/* nextProps */ P, /* nextContext */ js.Any) => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillReceiveProps")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutUNSAFE_componentWillReceiveProps: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillReceiveProps")(js.undefined)
        ret
    }
    @scala.inline
    def withUNSAFE_componentWillUpdate(value: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillUpdate")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withoutUNSAFE_componentWillUpdate: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("UNSAFE_componentWillUpdate")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentWillMount(value: () => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillMount")(js.Any.fromFunction0(value))
        ret
    }
    @scala.inline
    def withoutComponentWillMount: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillMount")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentWillReceiveProps(value: (/* nextProps */ P, /* nextContext */ js.Any) => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillReceiveProps")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutComponentWillReceiveProps: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillReceiveProps")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentWillUpdate(value: (/* nextProps */ P, /* nextState */ S, /* nextContext */ js.Any) => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillUpdate")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withoutComponentWillUpdate: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentWillUpdate")(js.undefined)
        ret
    }
  }
  
}

