package com.olvind.tso
package importer

object Libraries {

  /**
    * A good combination of interesting libraries, and libraries that are needed by libs in DT.
    */
  val extraExternals = Set(
    "activex-helpers",
    "ajv-keywords",
    "androiduix",
    "@angular/animations",
    "@angular/common",
    "@angular/compiler",
    "@angular/core",
    "@angular/forms",
    "@angular/http",
    "@angular/platform-browser",
    "@angular/platform-browser-dynamic",
    "@angular/router",
    "api-service",
    "apollo-client",
    "apollo-link-http-common",
    "apollo-react",
    "apollo-server",
    "authmosphere",
    "auto-loader",
    "@babel/runtime",
    "@babel/types",
    "@blueprintjs/core",
    "@blueprintjs/datetime",
    "@blueprintjs/icons",
    "@blueprintjs/select",
    "@blueprintjs/table",
    "@blueprintjs/timezone",
    "downshift",
    "dva",
    "emotion",
    "emotion-theming",
    "express-frappe",
    "firebase",
    "fastify",
    "formik",
    "formstate",
    "formsy-react",
    "fullcalendar",
    "gatsby",
    "gatsby-image",
    "gestalt",
    "graphql-tools",
    "grommet",
    "@grpc/proto-loader",
    "@hyperloris/tyson",
    "indefinite-observable",
    "@ionic/discover",
    "io-ts",
    "jcore-react-native",
    "js-joda",
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
    "monocle-ts",
    "ngx-infinite-scroll",
    "objection",
    "office-ui-fabric-react",
    "onsenui",
    "openapi-types",
    "opentracing",
    "parchment",
    "phaser",
    "@phc/format",
    "preact",
    "primereact",
    "prisma-binding",
    "@protobufjs/aspromise",
    "@protobufjs/codegen",
    "@pulumi/aws",
    "@pulumi/pulumi",
    "@pulumi/cloud",
    "@pulumi/kubernetes",
    "rbx",
    "rc-swipeout",
    "react-ace",
    "react-async",
    "react-apollo",
    "react-aria-modal",
    "react-avatar-editor",
    "react-bulma-components",
    "react-draggable-list",
    "react-emotion",
    "react-fns",
    "react-helmet",
    "react-instantsearch",
    "react-json-view",
    "react-latex-next",
    "react-localization",
    "react-markdown",
    "react-md",
    "react-mosaic-component",
    "react-native-svg",
    "react-native-firebase",
    "react-player",
    "react-popper",
    "react-spinners",
    "react-themeable-ts",
    "react-toggled",
    "react-toolbox",
    "react-waypoint",
    "react-widgets",
    "react-window",
    "reapop",
    "rebass",
    "redbox-react",
    "redux-observable",
    "re-reselect",
    "reselect",
    "rmc-calendar",
    "rmc-date-picker",
    "rmc-picker",
    "rollup-typescript",
    "rxjs",
    "rxjs-compat",
    "semantic-ui-form",
    "semantic-ui-react",
    "signals.js",
    "snabbdom",
    "source-map-support",
    "storm-react-diagrams",
    "styled-components",
    "superagent-proxy",
    "sw-toolbox",
    "ts-mockito",
    "tslint",
    "typed-graphql",
    "typed-rest-client",
    "typed-github-api",
    "typed-undo",
    "typedoc",
    "typesafe-actions",
    "typescript-optional",
    "@uifabric/merge-styles",
    "@uifabric/styling",
    "@uirouter/angularjs",
    "vscode-languageclient",
    "vscode-languageserver",
    "vscode-languageserver-types",
    "vue-class-component",
    "vue-cli",
    "vue-loader",
    "vue-router",
    "vue-rx",
    "vue-server-renderer",
    "vuex",
    "what-input",
    "zipkin",
    "xstream",
  )

  val ignored =
    Set[String](
      "graphene-pk11",
      "rvo2",
      "yfiles",
      "chromecast-caf-receiver",
      "snoowrap",
      // some new kind of circular dependency causes the phase runner to wait forever
      "mali",
      "apollo-tracing",
      "playerframework"
    )
}
