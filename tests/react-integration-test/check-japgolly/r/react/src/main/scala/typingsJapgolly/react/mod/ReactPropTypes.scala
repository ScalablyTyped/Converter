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
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setAny(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.any */ js.Any
    ): Self = this.set("any", value.asInstanceOf[js.Any])
    @scala.inline
    def setArray(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.array */ js.Any
    ): Self = this.set("array", value.asInstanceOf[js.Any])
    @scala.inline
    def setArrayOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.arrayOf */ js.Any
    ): Self = this.set("arrayOf", value.asInstanceOf[js.Any])
    @scala.inline
    def setBool(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.bool */ js.Any
    ): Self = this.set("bool", value.asInstanceOf[js.Any])
    @scala.inline
    def setElement(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.element */ js.Any
    ): Self = this.set("element", value.asInstanceOf[js.Any])
    @scala.inline
    def setExact(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.exact */ js.Any
    ): Self = this.set("exact", value.asInstanceOf[js.Any])
    @scala.inline
    def setFunc(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.func */ js.Any
    ): Self = this.set("func", value.asInstanceOf[js.Any])
    @scala.inline
    def setInstanceOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.instanceOf */ js.Any
    ): Self = this.set("instanceOf", value.asInstanceOf[js.Any])
    @scala.inline
    def setNode(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.node */ js.Any
    ): Self = this.set("node", value.asInstanceOf[js.Any])
    @scala.inline
    def setNumber(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.number */ js.Any
    ): Self = this.set("number", value.asInstanceOf[js.Any])
    @scala.inline
    def setObject(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.object */ js.Any
    ): Self = this.set("object", value.asInstanceOf[js.Any])
    @scala.inline
    def setObjectOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.objectOf */ js.Any
    ): Self = this.set("objectOf", value.asInstanceOf[js.Any])
    @scala.inline
    def setOneOf(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOf */ js.Any
    ): Self = this.set("oneOf", value.asInstanceOf[js.Any])
    @scala.inline
    def setOneOfType(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.oneOfType */ js.Any
    ): Self = this.set("oneOfType", value.asInstanceOf[js.Any])
    @scala.inline
    def setShape(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.shape */ js.Any
    ): Self = this.set("shape", value.asInstanceOf[js.Any])
    @scala.inline
    def setString(
      value: /* import warning: ResolveTypeQueries.resolve Couldn't resolve typeof PropTypes.string */ js.Any
    ): Self = this.set("string", value.asInstanceOf[js.Any])
  }
  
}

