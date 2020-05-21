package typings.node.NodeJS

import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ErrnoException extends Error {
  var code: js.UndefOr[String] = js.native
  var errno: js.UndefOr[Double] = js.native
  var path: js.UndefOr[String] = js.native
  var syscall: js.UndefOr[String] = js.native
}

object ErrnoException {
  @scala.inline
  def apply(
    code: String = null,
    errno: Int | Double = null,
    path: String = null,
    stack: String = null,
    syscall: String = null
  ): ErrnoException = {
    val __obj = js.Dynamic.literal()
    if (code != null) __obj.updateDynamic("code")(code.asInstanceOf[js.Any])
    if (errno != null) __obj.updateDynamic("errno")(errno.asInstanceOf[js.Any])
    if (path != null) __obj.updateDynamic("path")(path.asInstanceOf[js.Any])
    if (stack != null) __obj.updateDynamic("stack")(stack.asInstanceOf[js.Any])
    if (syscall != null) __obj.updateDynamic("syscall")(syscall.asInstanceOf[js.Any])
    __obj.asInstanceOf[ErrnoException]
  }
  @scala.inline
  implicit class ErrnoExceptionOps[Self <: ErrnoException] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCode(code: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (code != null) ret.updateDynamic("code")(code.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCode: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "code")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withErrno(errno: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (errno != null) ret.updateDynamic("errno")(errno.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutErrno: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "errno")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPath(path: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (path != null) ret.updateDynamic("path")(path.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPath: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "path")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSyscall(syscall: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (syscall != null) ret.updateDynamic("syscall")(syscall.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSyscall: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "syscall")
        ret.asInstanceOf[Self]
    }
  }
  
}

