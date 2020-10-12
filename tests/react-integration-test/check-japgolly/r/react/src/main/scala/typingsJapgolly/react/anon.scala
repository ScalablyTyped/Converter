package typingsJapgolly.react

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import typingsJapgolly.react.mod.ComponentType
import typingsJapgolly.std.Exclude
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait `0` extends js.Object {
    
    var defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any = js.native
  }
  object `0` {
    
    @scala.inline
    def apply(
      defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any
    ): `0` = {
      val __obj = js.Dynamic.literal(defaultProps = defaultProps.asInstanceOf[js.Any])
      __obj.asInstanceOf[`0`]
    }
    
    @scala.inline
    implicit class `0Ops`[Self <: `0`] (val x: Self) extends AnyVal {
      
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
      def setDefaultProps(value: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any): Self = this.set("defaultProps", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait `1` extends js.Object {
    
    var ref: js.UndefOr[Exclude[_, String]] = js.native
  }
  object `1` {
    
    @scala.inline
    def apply(): `1` = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[`1`]
    }
    
    @scala.inline
    implicit class `1Ops`[Self <: `1`] (val x: Self) extends AnyVal {
      
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
      def setRef(value: Exclude[_, String]): Self = this.set("ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRef: Self = this.set("ref", js.undefined)
    }
  }
  
  @js.native
  trait Children extends js.Object {
    
    var children: js.UndefOr[Node] = js.native
  }
  object Children {
    
    @scala.inline
    def apply(): Children = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Children]
    }
    
    @scala.inline
    implicit class ChildrenOps[Self <: Children] (val x: Self) extends AnyVal {
      
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
      def setChildrenVdomElement(value: VdomElement): Self = this.set("children", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildren(value: VdomNode): Self = this.set("children", value.rawNode.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
    }
  }
  
  @js.native
  trait DefaultProps extends js.Object {
    
    var defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any = js.native
    
    var propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any = js.native
  }
  object DefaultProps {
    
    @scala.inline
    def apply(
      defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any,
      propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any
    ): DefaultProps = {
      val __obj = js.Dynamic.literal(defaultProps = defaultProps.asInstanceOf[js.Any], propTypes = propTypes.asInstanceOf[js.Any])
      __obj.asInstanceOf[DefaultProps]
    }
    
    @scala.inline
    implicit class DefaultPropsOps[Self <: DefaultProps] (val x: Self) extends AnyVal {
      
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
      def setDefaultProps(value: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any): Self = this.set("defaultProps", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPropTypes(value: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = this.set("propTypes", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Html extends js.Object {
    
    var __html: String = js.native
  }
  object Html {
    
    @scala.inline
    def apply(__html: String): Html = {
      val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
      __obj.asInstanceOf[Html]
    }
    
    @scala.inline
    implicit class HtmlOps[Self <: Html] (val x: Self) extends AnyVal {
      
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
      def set__html(value: String): Self = this.set("__html", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait PropTypes extends js.Object {
    
    var propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any = js.native
  }
  object PropTypes {
    
    @scala.inline
    def apply(propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): PropTypes = {
      val __obj = js.Dynamic.literal(propTypes = propTypes.asInstanceOf[js.Any])
      __obj.asInstanceOf[PropTypes]
    }
    
    @scala.inline
    implicit class PropTypesOps[Self <: PropTypes] (val x: Self) extends AnyVal {
      
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
      def setPropTypes(value: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = this.set("propTypes", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Ref extends js.Object {
    
    var ref: js.UndefOr[
        /* import warning: importer.ImportType#apply Failed type conversion: infer R */ js.Any
      ] = js.native
  }
  object Ref {
    
    @scala.inline
    def apply(): Ref = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Ref]
    }
    
    @scala.inline
    implicit class RefOps[Self <: Ref] (val x: Self) extends AnyVal {
      
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
      def setRef(value: /* import warning: importer.ImportType#apply Failed type conversion: infer R */ js.Any): Self = this.set("ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRef: Self = this.set("ref", js.undefined)
    }
  }
  
  @js.native
  trait Result[T /* <: ComponentType[_] */] extends js.Object {
    
    val _result: T = js.native
  }
  object Result {
    
    @scala.inline
    def apply[T /* <: ComponentType[_] */](_result: T): Result[T] = {
      val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
      __obj.asInstanceOf[Result[T]]
    }
    
    @scala.inline
    implicit class ResultOps[Self <: Result[_], T /* <: ComponentType[_] */] (val x: Self with Result[T]) extends AnyVal {
      
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
      def set_result(value: T): Self = this.set("_result", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Type[T /* <: ComponentType[_] */] extends js.Object {
    
    val `type`: T = js.native
  }
  object Type {
    
    @scala.inline
    def apply[T /* <: ComponentType[_] */](`type`: T): Type[T] = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[Type[T]]
    }
    
    @scala.inline
    implicit class TypeOps[Self <: Type[_], T /* <: ComponentType[_] */] (val x: Self with Type[T]) extends AnyVal {
      
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
      def setType(value: T): Self = this.set("type", value.asInstanceOf[js.Any])
    }
  }
}
