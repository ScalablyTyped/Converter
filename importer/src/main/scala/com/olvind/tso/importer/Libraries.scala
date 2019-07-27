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
    "@ant-design/icons",
    "@ant-design/icons-react",
    "@ant-design/colors",
    "@ant-design/react-native",
    "@ant-design/icons-vue",
    "@ant-design/icons-angular",
    "@ant-design/icons-react-native",
    "@ant-design/dark-theme",
    "@ant-design/pro-layout",
    "antd-mobile",
    "antd-mobile-rn",
    "api-service",
    "apollo-client",
    "apollo-link-http-common",
    "apollo-react",
    "apollo-server",
    "authmosphere",
    "auto-loader",
    "ava",
    "@babel/runtime",
    "@babel/types",
    "blake2s-js",
    "@blueprintjs/core",
    "@blueprintjs/datetime",
    "@blueprintjs/icons",
    "@blueprintjs/select",
    "@blueprintjs/table",
    "@blueprintjs/timezone",
    "csw-aas-js",
    "downshift",
    "dva",
    "@elastic/elasticsearch",
    "emotion",
    "emotion-theming",
    "express-frappe",
    "firebase",
    "firebase-admin",
    "formik",
    "formstate",
    "formsy-react",
    "@fortawesome/fontawesome-svg-core",
    "@fortawesome/free-solid-svg-icons",
    "@fortawesome/react-fontawesome",
    "fullcalendar",
    "gatsby",
    "gatsby-image",
    "gestalt",
    "graphql-tools",
    "grommet",
    "@grpc/proto-loader",
    "highcharts",
    "highcharts-react-official",
    "@hyperloris/tyson",
    "indefinite-observable",
    "ionic",
    "@ionic/angular",
    "@ionic/react",
    "@ionic/core",
    "@ionic/storage",
    "io-ts",
    "jcore-react-native",
    "js-joda",
    "@jupyterlab/metapackage",
    "@material-ui/core",
    "@material-ui/icons",
    "@material-ui/lab",
    "meteor-typings",
    "@microsoft/load-themed-styles",
    "@mindbox/redux-helpers",
    "minecraft-scripting-types-client",
    "minecraft-scripting-types-server",
    "mobx-react",
    "mobx-react-devtools",
    "mobx-remotedev",
    "monaco-editor",
    "monocle-ts",
    "@mysticatea/spy",
    "ngx-infinite-scroll",
    "@nivo/axes",
    "@nivo/bar",
    "@nivo/bullet",
    "@nivo/calendar",
    "@nivo/chord",
    "@nivo/circle-packing",
    "@nivo/core",
    "@nivo/generators",
    "@nivo/geo",
    "@nivo/heatmap",
    "@nivo/legends",
    "@nivo/line",
    "@nivo/parallel-coordinates",
    "@nivo/pie",
    "@nivo/radar",
    "@nivo/sankey",
    "@nivo/scales",
    "@nivo/scatterplot",
    "@nivo/stream",
    "@nivo/sunburst",
    "@nivo/treemap",
    "@nivo/voronoi",
    "@nivo/waffle",
    "objection",
    "@octokit/rest",
    "office-ui-fabric-react",
    "onsenui",
    "openapi-types",
    "opentracing",
    "parchment",
    "phaser",
    "@phc/format",
    "@phenomnomnominal/tsquery",
    "pinata-sdk",
    "popmotion-pose",
    "popmotion",
    "preact",
    "primereact",
    "prisma-binding",
    "@protobufjs/aspromise",
    "@protobufjs/codegen",
    "@pulumi/aws",
    "@pulumi/cloud",
    "@pulumi/kubernetes",
    "@pulumi/pulumi",
    "rbx",
    "rc-swipeout",
    "react-ace",
    "react-apollo",
    "react-aria-modal",
    "react-async",
    "react-avatar-editor",
    "react-bulma-components",
    "react-date-range",
    "react-draggable-list",
    "react-emotion",
    "react-fns",
    "react-helmet",
    "react-instantsearch",
    "react-json-view",
    "react-latex-next",
    "react-live",
    "react-localization",
    "react-markdown",
    "react-md",
    "react-mosaic-component",
    "react-native-firebase",
    "@react-native-firebase/app",
    "react-native-svg",
    "react-player",
    "react-popper",
    "react-pose",
    "react-spinners",
    "react-svg",
    "react-testing-library",
    "react-themeable-ts",
    "react-toggled",
    "react-toolbox",
    "react-tools",
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
    "tensorflow",
    "@tensorflow/tfjs-node",
    "@tensorflow/tfjs",
    "tensorscript",
    "tslint",
    "ts-mockito",
    "twilio-chat",
    "typed-github-api",
    "typed-graphql",
    "typedoc",
    "typed-rest-client",
    "typed-undo",
    "typesafe-actions",
    "typescript-optional",
    "typestub-ipfs",
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
    "xstream",
    "zipkin",
  )

  val ignored =
    Set[String](
      "graphene-pk11",
      "rvo2",
      "yfiles",
      "chromecast-caf-receiver",
      "snoowrap",
      // bundles junk files
      "bottleneck",
      // some new kind of circular dependency causes the phase runner to wait forever
      "mali",
      "apollo-tracing",
      "playerframework",
      // these are referenced in notNeededPackages.json but don't exist
      "@sindresorhus/djb2a",
      "navigator-permissions",
      "webassembly-js-api",
      "w3c-permissions",
    )

  /* These are all the libraries used in demos. The set doubles as the extended test set */
  val DemoSet = Set[String](
    "@fortawesome/fontawesome-svg-core",
    "@fortawesome/free-solid-svg-icons",
    "@fortawesome/react-fontawesome",
    "@material-ui/core",
    "@material-ui/icons",
    "angular__common",
    "angular__compiler",
    "angular__core",
    "angular__forms",
    "angular__platform-browser",
    "angular__platform-browser-dynamic",
    "angular__router",
    "antd",
    "antd-slinky-facade",
    "axios",
    "body-parser",
    "chart.js",
    "classnames",
    "connect",
    "core-js",
    "csstype",
    "d3",
    "d3-array",
    "d3-axis",
    "d3-brush",
    "d3-chord",
    "d3-collection",
    "d3-color",
    "d3-contour",
    "d3-dispatch",
    "d3-drag",
    "d3-dsv",
    "d3-ease",
    "d3-fetch",
    "d3-force",
    "d3-format",
    "d3-geo",
    "d3-hierarchy",
    "d3-interpolate",
    "d3-path",
    "d3-polygon",
    "d3-quadtree",
    "d3-random",
    "d3-scale",
    "d3-scale-chromatic",
    "d3-selection",
    "d3-shape",
    "d3-time",
    "d3-time-format",
    "d3-timer",
    "d3-transition",
    "d3-voronoi",
    "d3-zoom",
    "electron",
    "exenv",
    "express",
    "express-serve-static-core",
    "extract-zip",
    "gatsby",
    "geojson",
    "googlemaps",
    "highlight.js",
    "hoist-non-react-statics",
    "ipfs-http-client",
    "is-buffer",
    "jquery",
    "jqueryui",
    "leaflet",
    "lodash",
    "material-ui",
    "mime",
    "mobx",
    "mobx-react",
    "moment",
    "node",
    "p5",
    "prop-types",
    "range-parser",
    "react",
    "react-addons-linked-state-mixin",
    "react-big-calendar",
    "react-dom",
    "react-facade",
    "react-is",
    "react-japgolly-facade",
    "react-lifecycles-compat",
    "react-native",
    "react-native-vector-icons",
    "react-navigation",
    "react-redux",
    "react-redux-facade",
    "react-router-dom",
    "react-router-dom-slinky-facade",
    "react-slick",
    "react-slinky-facade",
    "redux",
    "redux-devtools-extension",
    "reveal",
    "rxjs",
    "semantic-ui-react",
    "semantic-ui-react__event-stack",
    "serve-static",
    "shallowequal",
    "sizzle",
    "std",
    "std-facade",
    "storybook__react",
    "styled-components",
    "symbol-observable",
    "three",
    "tslib",
    "typescript",
    "vue",
    "webpack-env",
    "yandex-maps",
    "zone.js",
  )
}
