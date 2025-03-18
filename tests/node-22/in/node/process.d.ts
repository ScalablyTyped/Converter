declare module "process" {
  global {
    namespace NodeJS {
      interface Process{
        getBuiltinModule(id: "os"): typeof import("os");
        getBuiltinModule(id: "http2"): typeof import("http2");
      }
    }
  }
}