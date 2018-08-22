package com.olvind.tso

import java.net.URI
import java.time.ZoneId

import scala.io.Codec

/**
  * Todo: this is mostly config, and it's only lazyness that it's all here static
  */
object constants {
  val ScalablyTypedRepo   = "git@github.com:oyvindberg/ScalablyTyped.git"
  val DefinitelyTypedRepo = new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
  val Pedantic            = false
  val pkg                 = "ScalablyTyped"
  val offline             = false
  val freshRepo           = false

  val TimeZone = ZoneId.of("GMT")
  val Utf8     = Codec.UTF8.charSet

  /**
    * A good combination of interesting libraries, and libraries that are needed by libs in DT.
    */
  val extraExternals = Set(
    "activex-helpers",
    "ajv-keywords",
    "androiduix",
    "@angular/common",
    "@angular/core",
    "api-service",
    "apollo-client",
    "apollo-link-http-common",
    "apollo-react",
    "apollo-server",
    "authmosphere",
    "auto-loader",
    "@babel/runtime",
    "@babel/types",
    "downshift",
    "dva-core",
    "emotion",
    "emotion-theming",
    "express-frappe",
    "@firebase/app-types",
    "@firebase/auth-types",
    "@firebase/functions-types",
    "@firebase/storage-types",
    "formik",
    "formstate",
    "fullcalendar",
    "graphql-tools",
    "@hyperloris/tyson",
    "indefinite-observable",
    "@ionic/discover",
    "io-ts",
    "jcore-react-native",
    "@material-ui/core",
    "@material-ui/icons",
    "@material-ui/lab",
    "meteor-typings",
    "@microsoft/load-themed-styles",
    "@mindbox/redux-helpers",
    "mobx-react",
    "mobx-react-devtools",
    "mobx-remotedev",
    "monaco-editor",
    "ngx-infinite-scroll",
    "objection",
    "office-ui-fabric-react",
    "@onsenui/custom-elements",
    "opentracing",
    "parchment",
    "phaser",
    "@phc/format",
    "preact",
    "prisma-binding",
    "@protobufjs/aspromise",
    "@protobufjs/codegen",
    "react-apollo",
    "react-ace",
    "react-emotion",
    "react-helmet",
    "react-localization",
    "react-markdown",
    "react-md",
    "react-mosaic-component",
    "react-native-svg",
    "react-popper",
    "react-themeable-ts",
    "react-waypoint",
    "react-vis",
    "redbox-react",
    "redux-observable",
    "reselect",
    "rollup-typescript",
    "rxjs",
    "rxjs-compat",
    "semantic-ui-form",
    "semantic-ui-react",
    "signals.js",
    "snabbdom",
    "storm-react-diagrams",
    "styled-components",
    "sw-toolbox",
    "@tanem/svg-injector",
    "ts-cookie",
    "ts-mockito",
    "tslint",
    "typed-rest-client",
    "typed-undo",
    "typedoc",
    "typesafe-actions",
    "typescript-optional",
    "@uifabric/merge-styles",
    "@uifabric/styling",
    "vscode-languageserver",
    "vscode-languageserver-types",
    "vue-class-component",
    "vuex",
    "what-input",
    "zipkin",
  )

  val ignored =
    Set[String](
      "graphene-pk11",
      "rvo2",
      "yfiles",
      "chromecast-caf-receiver",
      "snoowrap",
      // these are just slow
//      "dojo",
//      "react-icons",
//      "aws-sdk",
//      "winrt-uwp",
    )
}
