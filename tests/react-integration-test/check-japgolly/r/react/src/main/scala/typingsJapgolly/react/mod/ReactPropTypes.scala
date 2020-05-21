package typingsJapgolly.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactPropTypes extends js.Object {
  var any: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.any */ js.Any = js.native
  var array: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.array */ js.Any = js.native
  var arrayOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.arrayOf */ js.Any = js.native
  var bool: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.bool */ js.Any = js.native
  var element: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.element */ js.Any = js.native
  var exact: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.exact */ js.Any = js.native
  var func: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.func */ js.Any = js.native
  var instanceOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.instanceOf */ js.Any = js.native
  var node: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.node */ js.Any = js.native
  var number: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.number */ js.Any = js.native
  var `object`: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.object */ js.Any = js.native
  var objectOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.objectOf */ js.Any = js.native
  var oneOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOf */ js.Any = js.native
  var oneOfType: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOfType */ js.Any = js.native
  var shape: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.shape */ js.Any = js.native
  var string: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.string */ js.Any = js.native
}

object ReactPropTypes {
  @scala.inline
  def apply(
    any: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.any */ js.Any,
    array: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.array */ js.Any,
    arrayOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.arrayOf */ js.Any,
    bool: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.bool */ js.Any,
    element: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.element */ js.Any,
    exact: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.exact */ js.Any,
    func: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.func */ js.Any,
    instanceOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.instanceOf */ js.Any,
    node: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.node */ js.Any,
    number: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.number */ js.Any,
    `object`: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.object */ js.Any,
    objectOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.objectOf */ js.Any,
    oneOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOf */ js.Any,
    oneOfType: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOfType */ js.Any,
    shape: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.shape */ js.Any,
    string: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.string */ js.Any
  ): ReactPropTypes = {
    val __obj = js.Dynamic.literal(any = any.asInstanceOf[js.Any], array = array.asInstanceOf[js.Any], arrayOf = arrayOf.asInstanceOf[js.Any], bool = bool.asInstanceOf[js.Any], element = element.asInstanceOf[js.Any], exact = exact.asInstanceOf[js.Any], func = func.asInstanceOf[js.Any], instanceOf = instanceOf.asInstanceOf[js.Any], node = node.asInstanceOf[js.Any], number = number.asInstanceOf[js.Any], objectOf = objectOf.asInstanceOf[js.Any], oneOf = oneOf.asInstanceOf[js.Any], oneOfType = oneOfType.asInstanceOf[js.Any], shape = shape.asInstanceOf[js.Any], string = string.asInstanceOf[js.Any])
    __obj.updateDynamic("object")(`object`.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReactPropTypes]
  }
  @scala.inline
  implicit class ReactPropTypesOps[Self <: ReactPropTypes] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAny(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.any */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("any")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withArray(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.array */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("array")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withArrayOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.arrayOf */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("arrayOf")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withBool(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.bool */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bool")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withElement(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.element */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("element")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withExact(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.exact */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("exact")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withFunc(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.func */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("func")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withInstanceOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.instanceOf */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("instanceOf")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withNode(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.node */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("node")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withNumber(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.number */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("number")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withObject(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.object */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("object")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withObjectOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.objectOf */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("objectOf")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withOneOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOf */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("oneOf")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withOneOfType(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOfType */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("oneOfType")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withShape(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.shape */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("shape")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withString(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.string */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("string")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

