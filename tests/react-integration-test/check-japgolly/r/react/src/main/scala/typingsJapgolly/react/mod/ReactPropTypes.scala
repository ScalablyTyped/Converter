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
    def withAny(any: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.any */ js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("any")(any.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withArray(
      array: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.array */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("array")(array.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withArrayOf(
      arrayOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.arrayOf */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("arrayOf")(arrayOf.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withBool(
      bool: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.bool */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("bool")(bool.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withElement(
      element: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.element */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("element")(element.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withExact(
      exact: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.exact */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("exact")(exact.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFunc(
      func: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.func */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("func")(func.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInstanceOf(
      instanceOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.instanceOf */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("instanceOf")(instanceOf.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNode(
      node: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.node */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("node")(node.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNumber(
      number: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.number */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("number")(number.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withObject(
      `object`: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.object */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("object")(`object`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withObjectOf(
      objectOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.objectOf */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("objectOf")(objectOf.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOneOf(
      oneOf: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOf */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("oneOf")(oneOf.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOneOfType(
      oneOfType: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOfType */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("oneOfType")(oneOfType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withShape(
      shape: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.shape */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("shape")(shape.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withString(
      string: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.string */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("string")(string.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

