declare namespace winston {
  interface AbstractConfigSetLevels {
    [key: string]: number;
  }

  interface Config {
      foo: "bar"
  }
}

declare const winston: winston.Config;
export = winston;
