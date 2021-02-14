package typingsSlinky.react

import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import typingsSlinky.std.Exclude
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait `0` extends StObject {
    
    var defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any = js.native
  }
  object `0` {
    
    @scala.inline
    implicit class `0MutableBuilder`[Self <: `0`] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDefaultProps(value: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any): Self = StObject.set(x, "defaultProps", value.asInstanceOf[js.Any])
    }
    
    @scala.inline
    def apply(
      defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any
    ): `0` = {
      val __obj = js.Dynamic.literal(defaultProps = defaultProps.asInstanceOf[js.Any])
      __obj.asInstanceOf[`0`]
    }
  }
  
  @js.native
  trait `1` extends StObject {
    
    var ref: js.UndefOr[Exclude[_, String]] = js.native
  }
  object `1` {
    
    @scala.inline
    implicit class `1MutableBuilder`[Self <: `1`] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRef(value: Exclude[_, String]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
    }
    
    @scala.inline
    def apply(): `1` = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[`1`]
    }
  }
  
  @js.native
  trait Children extends StObject {
    
    var children: js.UndefOr[ReactElement] = js.native
  }
  object Children {
    
    @scala.inline
    def apply(): Children = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Children]
    }
    
    @scala.inline
    implicit class ChildrenMutableBuilder[Self <: Children] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenReactElement(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
    }
  }
  
  @js.native
  trait DefaultProps extends StObject {
    
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
    implicit class DefaultPropsMutableBuilder[Self <: DefaultProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDefaultProps(value: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any): Self = StObject.set(x, "defaultProps", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPropTypes(value: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = StObject.set(x, "propTypes", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Html extends StObject {
    
    var __html: String = js.native
  }
  object Html {
    
    @scala.inline
    def apply(__html: String): Html = {
      val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
      __obj.asInstanceOf[Html]
    }
    
    @scala.inline
    implicit class HtmlMutableBuilder[Self <: Html] (val x: Self) extends AnyVal {
      
      @scala.inline
      def set__html(value: String): Self = StObject.set(x, "__html", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait PropTypes extends StObject {
    
    var propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any = js.native
  }
  object PropTypes {
    
    @scala.inline
    def apply(propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): PropTypes = {
      val __obj = js.Dynamic.literal(propTypes = propTypes.asInstanceOf[js.Any])
      __obj.asInstanceOf[PropTypes]
    }
    
    @scala.inline
    implicit class PropTypesMutableBuilder[Self <: PropTypes] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setPropTypes(value: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = StObject.set(x, "propTypes", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Ref extends StObject {
    
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
    implicit class RefMutableBuilder[Self <: Ref] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRef(value: /* import warning: importer.ImportType#apply Failed type conversion: infer R */ js.Any): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
    }
  }
  
  @js.native
  trait Result[T /* <: ReactComponentClass[_] */] extends StObject {
    
    val _result: T = js.native
  }
  object Result {
    
    @scala.inline
    def apply[T /* <: ReactComponentClass[_] */](_result: T): Result[T] = {
      val __obj = js.Dynamic.literal(_result = _result.asInstanceOf[js.Any])
      __obj.asInstanceOf[Result[T]]
    }
    
    @scala.inline
    implicit class ResultMutableBuilder[Self <: Result[_], T /* <: ReactComponentClass[_] */] (val x: Self with Result[T]) extends AnyVal {
      
      @scala.inline
      def set_result(value: T): Self = StObject.set(x, "_result", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait Type[T /* <: ReactComponentClass[_] */] extends StObject {
    
    val `type`: T = js.native
  }
  object Type {
    
    @scala.inline
    def apply[T /* <: ReactComponentClass[_] */](`type`: T): Type[T] = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[Type[T]]
    }
    
    @scala.inline
    implicit class TypeMutableBuilder[Self <: Type[_], T /* <: ReactComponentClass[_] */] (val x: Self with Type[T]) extends AnyVal {
      
      @scala.inline
      def setType(value: T): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
}
