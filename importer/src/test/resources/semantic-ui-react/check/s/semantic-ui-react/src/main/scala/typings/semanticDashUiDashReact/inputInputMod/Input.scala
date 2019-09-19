package typings.semanticDashUiDashReact.inputInputMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* import warning: RemoveDifficultInheritance.summarizeChanges 
- Dropped / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify React.Component<InputProps, {}> * / any */ trait Input extends js.Object {
  def focus(): Unit
  def select(): Unit
}

object Input {
  @scala.inline
  def apply(focus: () => Unit, select: () => Unit): Input = {
    val __obj = js.Dynamic.literal(focus = js.Any.fromFunction0(focus), select = js.Any.fromFunction0(select))
  
    __obj.asInstanceOf[Input]
  }
}

