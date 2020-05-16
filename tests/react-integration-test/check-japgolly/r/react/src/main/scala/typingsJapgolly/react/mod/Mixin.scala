package typingsJapgolly.react.mod

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
  def apply[P, S](): Mixin[P, S] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[Mixin[P, S]]
  }
  @scala.inline
  implicit class MixinOps[Self[p, s] <: Mixin[p, s], P, S] (val x: Self[P, S]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, S] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, S]]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): (Self[P, S]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, S]) with Other]
    @scala.inline
    def withChildContextTypes(value: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("childContextTypes")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutChildContextTypes: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("childContextTypes")(js.undefined)
        ret
    }
    @scala.inline
    def withContextTypes(value: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("contextTypes")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutContextTypes: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("contextTypes")(js.undefined)
        ret
    }
    @scala.inline
    def withDisplayName(value: String): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("displayName")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDisplayName: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("displayName")(js.undefined)
        ret
    }
    @scala.inline
    def withGetDefaultProps(value: CallbackTo[P]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDefaultProps")(value.toJsFn)
        ret
    }
    @scala.inline
    def withoutGetDefaultProps: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getDefaultProps")(js.undefined)
        ret
    }
    @scala.inline
    def withGetInitialState(value: CallbackTo[S]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getInitialState")(value.toJsFn)
        ret
    }
    @scala.inline
    def withoutGetInitialState: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("getInitialState")(js.undefined)
        ret
    }
    @scala.inline
    def withMixins(value: js.Array[Mixin[P, S]]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mixins")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutMixins: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("mixins")(js.undefined)
        ret
    }
    @scala.inline
    def withPropTypes(value: ValidationMap[_]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPropTypes: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propTypes")(js.undefined)
        ret
    }
    @scala.inline
    def withStatics(value: StringDictionary[js.Any]): Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("statics")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutStatics: Self[P, S] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("statics")(js.undefined)
        ret
    }
  }
  
}

