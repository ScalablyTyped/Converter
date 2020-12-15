package typings.webpackEnv

import org.scalablytyped.runtime.StringDictionary
import typings.std.Error
import typings.std.RegExp
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object WebpackModuleApi {
  
  @js.native
  trait AcceptOptions extends js.Object {
    
    /**
      * Indicates that apply() is automatically called by check function
      */
    var autoApply: js.UndefOr[Boolean] = js.native
    
    /**
      * If true the update process continues even if some modules are not accepted (and would bubble to the entry point).
      */
    var ignoreUnaccepted: js.UndefOr[Boolean] = js.native
  }
  object AcceptOptions {
    
    @scala.inline
    def apply(): AcceptOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AcceptOptions]
    }
    
    @scala.inline
    implicit class AcceptOptionsOps[Self <: AcceptOptions] (val x: Self) extends AnyVal {
      
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
      def setAutoApply(value: Boolean): Self = this.set("autoApply", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAutoApply: Self = this.set("autoApply", js.undefined)
      
      @scala.inline
      def setIgnoreUnaccepted(value: Boolean): Self = this.set("ignoreUnaccepted", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIgnoreUnaccepted: Self = this.set("ignoreUnaccepted", js.undefined)
    }
  }
  
  @js.native
  trait Hot extends js.Object {
    
    /**
      * Accept code updates for this module without notification of parents.
      * This should only be used if the module doesn’t export anything.
      * The errHandler can be used to handle errors that occur while loading the updated module.
      * @param errHandler
      */
    def accept(): Unit = js.native
    /**
      * Accept code updates for the specified dependencies. The callback is called when dependencies were replaced.
      * @param dependencies
      * @param callback
      */
    def accept(
      dependencies: js.Array[String],
      callback: js.Function1[/* updatedDependencies */ js.Array[ModuleId], Unit]
    ): Unit = js.native
    /**
      * Accept code updates for the specified dependencies. The callback is called when dependencies were replaced.
      * @param dependency
      * @param callback
      */
    def accept(dependency: String, callback: js.Function0[Unit]): Unit = js.native
    def accept(errHandler: js.Function1[/* err */ Error, Unit]): Unit = js.native
    
    var active: Boolean = js.native
    
    /**
      * Add a one time handler, which is executed when the current module code is replaced.
      * Here you should destroy/remove any persistent resource you have claimed/created.
      * If you want to transfer state to the new module, add it to data object.
      * The data will be available at module.hot.data on the new module.
      * @param callback
      */
    def addDisposeHandler(callback: js.Function1[/* data */ js.Any, Unit]): Unit = js.native
    @JSName("addDisposeHandler")
    def addDisposeHandler_T[T](callback: js.Function1[/* data */ T, Unit]): Unit = js.native
    
    /** Register a callback on status change. */
    def addStatusHandler(callback: js.Function1[/* status */ String, Unit]): Unit = js.native
    
    /**
      * If status() != "ready" it throws an error.
      * Continue the update process.
      * @param callback
      */
    @JSName("apply")
    def apply(callback: js.Function2[/* err */ Error, /* outdatedModules */ js.Array[ModuleId], Unit]): Unit = js.native
    /**
      * If status() != "ready" it throws an error.
      * Continue the update process.
      * @param options
      * @param callback
      */
    @JSName("apply")
    def apply(
      options: AcceptOptions,
      callback: js.Function2[/* err */ Error, /* outdatedModules */ js.Array[ModuleId], Unit]
    ): Unit = js.native
    
    /**
      * Throws an exceptions if status() is not idle.
      * Check all currently loaded modules for updates and apply updates if found.
      * If no update was found, the callback is called with null.
      * If autoApply is truthy the callback will be called with all modules that were disposed.
      * apply() is automatically called with autoApply as options parameter.
      * If autoApply is not set the callback will be called with all modules that will be disposed on apply().
      * @param autoApply
      * @param callback
      */
    def check(
      autoApply: Boolean,
      callback: js.Function2[/* err */ Error, /* outdatedModules */ js.Array[ModuleId], Unit]
    ): Unit = js.native
    /**
      * Throws an exceptions if status() is not idle.
      * Check all currently loaded modules for updates and apply updates if found.
      * If no update was found, the callback is called with null.
      * The callback will be called with all modules that will be disposed on apply().
      * @param callback
      */
    def check(callback: js.Function2[/* err */ Error, /* outdatedModules */ js.Array[ModuleId], Unit]): Unit = js.native
    
    var data: js.Any = js.native
    
    /**
      * Flag the current module as not update-able. If updated the update code would fail with code "decline".
      */
    def decline(): Unit = js.native
    /**
      * Do not accept updates for the specified dependencies. If any dependencies is updated, the code update fails with code "decline".
      */
    def decline(dependencies: js.Array[String]): Unit = js.native
    /**
      * Do not accept updates for the specified dependencies. If any dependencies is updated, the code update fails with code "decline".
      */
    def decline(dependency: String): Unit = js.native
    
    /**
      * Add a one time handler, which is executed when the current module code is replaced.
      * Here you should destroy/remove any persistent resource you have claimed/created.
      * If you want to transfer state to the new module, add it to data object.
      * The data will be available at module.hot.data on the new module.
      * @param callback
      */
    def dispose(callback: js.Function1[/* data */ js.Any, Unit]): Unit = js.native
    
    /**
      * Remove a handler.
      * This can useful to add a temporary dispose handler. You could i. e. replace code while in the middle of a multi-step async function.
      * @param callback
      */
    def removeDisposeHandler(callback: js.Function1[/* data */ js.Any, Unit]): Unit = js.native
    @JSName("removeDisposeHandler")
    def removeDisposeHandler_T[T](callback: js.Function1[/* data */ T, Unit]): Unit = js.native
    
    /**
      * Remove a registered status change handler.
      * @param callback
      */
    def removeStatusHandler(callback: js.Function1[/* status */ String, Unit]): Unit = js.native
    
    /**
      * Return one of idle, check, watch, watch-delay, prepare, ready, dispose, apply, abort or fail.
      */
    def status(): String = js.native
    /** Register a callback on status change. */
    def status(callback: js.Function1[/* status */ String, Unit]): Unit = js.native
  }
  
  @js.native
  trait Module extends js.Object {
    
    var children: js.Array[_] = js.native
    
    var exports: js.Any = js.native
    
    var filename: String = js.native
    
    var hot: js.UndefOr[Hot] = js.native
    
    var id: String = js.native
    
    var loaded: Boolean = js.native
    
    var parent: js.Any = js.native
    
    def require(id: String): js.Any = js.native
    @JSName("require")
    def require_T_T[T](id: String): T = js.native
  }
  
  /**
    * Inside env you can pass any variable
    */
  @js.native
  trait NodeProcess extends js.Object {
    
    var env: js.UndefOr[js.Any] = js.native
  }
  object NodeProcess {
    
    @scala.inline
    def apply(): NodeProcess = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[NodeProcess]
    }
    
    @scala.inline
    implicit class NodeProcessOps[Self <: NodeProcess] (val x: Self) extends AnyVal {
      
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
      def setEnv(value: js.Any): Self = this.set("env", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEnv: Self = this.set("env", js.undefined)
    }
  }
  
  @js.native
  trait RequireContext extends js.Object {
    
    def apply(id: String): js.Any = js.native
    
    def keys(): js.Array[String] = js.native
    
    def resolve(id: String): String = js.native
  }
  
  @js.native
  trait RequireFunction extends js.Object {
    
    /**
      * Returns the exports from a dependency. The call is sync. No request to the server is fired. The compiler ensures that the dependency is available.
      */
    def apply(path: String): js.Any = js.native
    /**
      * Behaves similar to require.ensure, but the callback is called with the exports of each dependency in the paths array. There is no option to provide a chunk name.
      */
    def apply(paths: js.Array[String], callback: js.Function1[/* repeated */ js.Any, Unit]): Unit = js.native
    
    /**
      * Multiple requires to the same module result in only one module execution and only one export. Therefore a cache in the runtime exists. Removing values from this cache cause new module execution and a new export. This is only needed in rare cases (for compatibility!).
      */
    var cache: StringDictionary[js.Any] = js.native
    
    def context(path: String): RequireContext = js.native
    def context(path: String, deep: js.UndefOr[scala.Nothing], filter: RegExp): RequireContext = js.native
    def context(path: String, deep: Boolean): RequireContext = js.native
    def context(path: String, deep: Boolean, filter: RegExp): RequireContext = js.native
    
    /**
      * Download additional dependencies on demand. The paths array lists modules that should be available. When they are, callback is called. If the callback is a function expression, dependencies in that source part are extracted and also loaded on demand. A single request is fired to the server, except if all modules are already available.
      *
      * This creates a chunk. The chunk can be named. If a chunk with this name already exists, the dependencies are merged into that chunk and that chunk is used.
      */
    def ensure(paths: js.Array[String], callback: js.Function1[/* require */ NodeRequire, Unit]): Unit = js.native
    def ensure(
      paths: js.Array[String],
      callback: js.Function1[/* require */ NodeRequire, Unit],
      chunkName: String
    ): Unit = js.native
    
    /**
      * Ensures that the dependency is available, but don’t execute it. This can be use for optimizing the position of a module in the chunks.
      */
    def include(path: String): Unit = js.native
    
    /**
      * Returns the module id of a dependency. The call is sync. No request to the server is fired. The compiler ensures that the dependency is available.
      *
      * The module id is a number in webpack (in contrast to node.js where it is a string, the filename).
      */
    def resolve(path: String): Double | String = js.native
    
    /**
      * Like require.resolve, but doesn’t include the module into the bundle. It’s a weak dependency.
      */
    def resolveWeak(path: String): Double | String = js.native
  }
  
  type ModuleId = String | Double
  
  type Require1 = js.Function1[/* id */ String, js.Any]
  
  type Require2 = js.Function1[/* id */ String, js.Any]
  
  type RequireLambda = Require1 with Require2
}
