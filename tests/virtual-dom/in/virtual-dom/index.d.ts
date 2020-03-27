
declare namespace VirtualDOM {
  function h(): any;
}

declare module "virtual-dom/h" {
  // export = VirtualDOM.h; works just fine, but the DT checker doesn't like it
  import h = VirtualDOM.h;
  export = h;
}
