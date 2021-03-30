package typingsJapgolly.reactMarkdown

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.ElementType
import japgolly.scalajs.react.raw.React.Node
import org.scalablytyped.runtime.StringDictionary
import org.scalablytyped.runtime.TopLevel
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @scala.inline
  def apply(props: ReactMarkdownProps): Element = ^.asInstanceOf[js.Dynamic].apply(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
  @JSImport("react-markdown", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  @JSImport("react-markdown", "renderers")
  @js.native
  val renderers: Renderers_ = js.native
  
  @scala.inline
  def uriTransformer(uri: String): String = ^.asInstanceOf[js.Dynamic].applyDynamic("uriTransformer")(uri.asInstanceOf[js.Any]).asInstanceOf[String]
  
  @js.native
  trait ChildrenProp extends StObject {
    
    val children: String = js.native
  }
  object ChildrenProp {
    
    @scala.inline
    def apply(children: String): ChildrenProp = {
      val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
      __obj.asInstanceOf[ChildrenProp]
    }
    
    @scala.inline
    implicit class ChildrenPropMutableBuilder[Self <: ChildrenProp] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(value: String): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
    }
  }
  
  type LinkTargetResolver = js.Function3[/* uri */ String, /* text */ String, /* title */ js.UndefOr[String], String]
  
  type MutuallyExclusive[T, U] = (T with Not[U]) | (U with Not[T])
  
  type Not[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ key in keyof T ]:? never}
    */ typingsJapgolly.reactMarkdown.reactMarkdownStrings.Not with TopLevel[js.Any]
  
  type ReactMarkdownProps = ReactMarkdownPropsBase with (MutuallyExclusive[ChildrenProp, SourceProp])
  
  @js.native
  trait ReactMarkdownPropsBase extends StObject {
    
    val allowNode: js.UndefOr[js.Function1[/* index */ Double, Boolean]] = js.native
    
    val className: js.UndefOr[String] = js.native
    
    val linkTarget: js.UndefOr[String | LinkTargetResolver] = js.native
    
    val transformLinkUri: js.UndefOr[
        (js.Function3[
          /* uri */ String, 
          /* children */ js.UndefOr[Node], 
          /* title */ js.UndefOr[String], 
          String
        ]) | Null
      ] = js.native
  }
  object ReactMarkdownPropsBase {
    
    @scala.inline
    def apply(): ReactMarkdownPropsBase = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ReactMarkdownPropsBase]
    }
    
    @scala.inline
    implicit class ReactMarkdownPropsBaseMutableBuilder[Self <: ReactMarkdownPropsBase] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setAllowNode(value: /* index */ Double => Boolean): Self = StObject.set(x, "allowNode", js.Any.fromFunction1(value))
      
      @scala.inline
      def setAllowNodeUndefined: Self = StObject.set(x, "allowNode", js.undefined)
      
      @scala.inline
      def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      @scala.inline
      def setLinkTarget(value: String | LinkTargetResolver): Self = StObject.set(x, "linkTarget", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setLinkTargetFunction3(value: (/* uri */ String, /* text */ String, /* title */ js.UndefOr[String]) => String): Self = StObject.set(x, "linkTarget", js.Any.fromFunction3(value))
      
      @scala.inline
      def setLinkTargetUndefined: Self = StObject.set(x, "linkTarget", js.undefined)
      
      @scala.inline
      def setTransformLinkUri(
        value: (/* uri */ String, /* children */ js.UndefOr[Node], /* title */ js.UndefOr[String]) => String
      ): Self = StObject.set(x, "transformLinkUri", js.Any.fromFunction3(value))
      
      @scala.inline
      def setTransformLinkUriNull: Self = StObject.set(x, "transformLinkUri", null)
      
      @scala.inline
      def setTransformLinkUriUndefined: Self = StObject.set(x, "transformLinkUri", js.undefined)
    }
  }
  
  type Renderer[T] = js.Function1[/* props */ T, ElementType]
  
  type Renderers_ = StringDictionary[String | Renderer[js.Any]]
  
  @js.native
  trait SourceProp extends StObject {
    
    /** @deprecated use children */
    val source: String = js.native
  }
  object SourceProp {
    
    @scala.inline
    def apply(source: String): SourceProp = {
      val __obj = js.Dynamic.literal(source = source.asInstanceOf[js.Any])
      __obj.asInstanceOf[SourceProp]
    }
    
    @scala.inline
    implicit class SourcePropMutableBuilder[Self <: SourceProp] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setSource(value: String): Self = StObject.set(x, "source", value.asInstanceOf[js.Any])
    }
  }
}
