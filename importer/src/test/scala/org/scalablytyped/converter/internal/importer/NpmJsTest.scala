package org.scalablytyped.converter.internal.importer

import org.scalablytyped.converter.internal.Json
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalatest.funsuite.AnyFunSuite

class NpmJsTest extends AnyFunSuite {
  test("example 1") {
    val content =
      """{
        |  "analyzedAt": "2022-08-30T17:02:31.611Z",
        |  "collected": {
        |    "metadata": {
        |      "name": "@fortawesome/fontawesome-common-types",
        |      "scope": "fortawesome",
        |      "version": "6.2.0",
        |      "description": "The iconic font, CSS, and SVG framework",
        |      "keywords": [
        |        "font",
        |        "awesome",
        |        "fontawesome",
        |        "icon",
        |        "svg",
        |        "bootstrap"
        |      ],
        |      "date": "2022-08-30T16:57:47.832Z",
        |      "author": {
        |        "name": "The Font Awesome Team",
        |        "url": "https://github.com/orgs/FortAwesome/people"
        |      },
        |      "publisher": {
        |        "username": "robmadole",
        |        "email": "robmadole@gmail.com"
        |      },
        |      "maintainers": [
        |        {
        |          "username": "jasonlundien",
        |          "email": "jason@fontawesome.com"
        |        },
        |        {
        |          "username": "devoto13",
        |          "email": "devoto13@gmail.com"
        |        },
        |        {
        |          "username": "jrjohnson",
        |          "email": "jon.johnson@ucsf.edu"
        |        },
        |        {
        |          "username": "robmadole",
        |          "email": "robmadole@gmail.com"
        |        },
        |        {
        |          "username": "supercodepoet",
        |          "email": "travis@travischase.me"
        |        },
        |        {
        |          "username": "fortawesome-admin",
        |          "email": "admin@fortawesome.com"
        |        },
        |        {
        |          "username": "mwilkerson",
        |          "email": "mwilkerson@gmail.com"
        |        }
        |      ],
        |      "repository": {
        |        "type": "git",
        |        "url": "git+https://github.com/FortAwesome/Font-Awesome.git"
        |      },
        |      "links": {
        |        "npm": "https://www.npmjs.com/package/%40fortawesome%2Ffontawesome-common-types",
        |        "homepage": "https://fontawesome.com",
        |        "repository": "https://github.com/FortAwesome/Font-Awesome",
        |        "bugs": "https://github.com/FortAwesome/Font-Awesome/issues"
        |      },
        |      "license": "MIT",
        |      "releases": [
        |        {
        |          "from": "2022-07-31T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 0
        |        },
        |        {
        |          "from": "2022-06-01T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 1
        |        },
        |        {
        |          "from": "2022-03-03T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 3
        |        },
        |        {
        |          "from": "2021-08-30T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 6
        |        },
        |        {
        |          "from": "2020-08-30T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 11
        |        }
        |      ],
        |      "readme": "# @fortawesome/fontawesome-common-types - SVG with JavaScript\n\n> \"I came here to chew bubblegum and install Font Awesome 6 - and I'm all out of bubblegum\"\n\n[![npm](https://img.shields.io/npm/v/@fortawesome/fontawesome-common-types.svg?style=flat-square)](https://www.npmjs.com/package/@fortawesome/fontawesome-common-types)\n\n## What is this package?\n\nFont Awesome 6 JavaScript packages support TypeScript. This package abstracts out some of the common definitions that those packages use.\n\n## Here be dragons\n\nIf you are trying to import types from this package we *highly* recommend you do the following instead as *all types in this package are re-exported to the main fontawesome package*.\n\nyour.ts\n\n```\nimport {\n  IconName\n} from `@fortawesome/fontawesome-svg-core`\n\nconst myIcon: IconName = \"...\"\n```\n\n## Issues and support\n\nStart with [GitHub issues](https://github.com/FortAwesome/Font-Awesome/issues) and ping us on [Twitter](https://twitter.com/fontawesome) if you need to."
        |    },
        |    "npm": {
        |      "downloads": [
        |        {
        |          "from": "2022-08-29T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 289285
        |        },
        |        {
        |          "from": "2022-08-23T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 1609477
        |        },
        |        {
        |          "from": "2022-07-31T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 6686244
        |        },
        |        {
        |          "from": "2022-06-01T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 19865790
        |        },
        |        {
        |          "from": "2022-03-03T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 38986217
        |        },
        |        {
        |          "from": "2021-08-30T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 70184507
        |        }
        |      ],
        |      "starsCount": 0
        |    },
        |    "github": {
        |      "homepage": "https://fontawesome.com",
        |      "starsCount": 70007,
        |      "forksCount": 12135,
        |      "subscribersCount": 1384,
        |      "issues": {
        |        "count": 19146,
        |        "openCount": 5321,
        |        "distribution": {
        |          "3600": 3307,
        |          "10800": 1711,
        |          "32400": 1684,
        |          "97200": 1416,
        |          "291600": 555,
        |          "874800": 568,
        |          "2624400": 617,
        |          "7873200": 620,
        |          "23619600": 923,
        |          "70858800": 1483,
        |          "212576400": 6262
        |        },
        |        "isDisabled": false
        |      },
        |      "contributors": [
        |        {
        |          "username": "tagliala",
        |          "commitsCount": 3
        |        },
        |        {
        |          "username": "robmadole",
        |          "commitsCount": 5
        |        }
        |      ],
        |      "commits": [
        |        {
        |          "from": "2022-08-23T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 0
        |        },
        |        {
        |          "from": "2022-07-31T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 0
        |        },
        |        {
        |          "from": "2022-06-01T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 1
        |        },
        |        {
        |          "from": "2022-03-03T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 5
        |        },
        |        {
        |          "from": "2021-08-30T00:00:00.000Z",
        |          "to": "2022-08-30T00:00:00.000Z",
        |          "count": 8
        |        }
        |      ]
        |    },
        |    "source": {
        |      "files": {
        |        "readmeSize": 983,
        |        "testsSize": 0,
        |        "hasChangelog": true
        |      },
        |      "badges": [
        |        {
        |          "urls": {
        |            "original": "https://img.shields.io/npm/v/@fortawesome/fontawesome-common-types.svg?style=flat-square",
        |            "shields": "https://img.shields.io/npm/v/@fortawesome/fontawesome-common-types.svg",
        |            "content": "https://img.shields.io/npm/v/@fortawesome/fontawesome-common-types.json"
        |          },
        |          "info": {
        |            "service": "npm",
        |            "type": "version",
        |            "modifiers": {
        |              "type": "v"
        |            }
        |          }
        |        }
        |      ]
        |    }
        |  },
        |  "evaluation": {
        |    "quality": {
        |      "carefulness": 0.7899999999999999,
        |      "tests": 0,
        |      "health": 1,
        |      "branding": 0.55
        |    },
        |    "popularity": {
        |      "communityInterest": 83528,
        |      "downloadsCount": 6621930,
        |      "downloadsAcceleration": 13723.063337138497,
        |      "dependentsCount": 0
        |    },
        |    "maintenance": {
        |      "releasesFrequency": 0.7766267123287671,
        |      "commitsFrequency": 0.35455479452054794,
        |      "openIssues": 0.8701382360110033,
        |      "issuesDistribution": 0
        |    }
        |  },
        |  "score": {
        |    "final": 0.6668084283578304,
        |    "detail": {
        |      "quality": 0.6225681418134527,
        |      "popularity": 0.7054017430579984,
        |      "maintenance": 0.6661353592671292
        |    }
        |  }
        |}
        |""".stripMargin

    succeed
  }

  test("example 2") {
    val content =
      """{
        |  "analyzedAt": "2022-09-16T08:05:13.417Z",
        |  "collected": {
        |    "metadata": {
        |      "name": "@angular/compiler",
        |      "scope": "angular",
        |      "version": "14.2.2",
        |      "description": "Angular - the compiler library",
        |      "date": "2022-09-15T02:48:05.341Z",
        |      "author": {
        |        "name": "angular"
        |      },
        |      "publisher": {
        |        "username": "google-wombot",
        |        "email": "node-team-npm+wombot@google.com"
        |      },
        |      "maintainers": [
        |        {
        |          "username": "angular",
        |          "email": "devops+npm@angular.io"
        |        },
        |        {
        |          "username": "google-wombot",
        |          "email": "node-team-npm+wombot@google.com"
        |        }
        |      ],
        |      "repository": {
        |        "type": "git",
        |        "url": "git+https://github.com/angular/angular.git",
        |        "directory": "packages/compiler"
        |      },
        |      "links": {
        |        "npm": "https://www.npmjs.com/package/%40angular%2Fcompiler",
        |        "homepage": "https://github.com/angular/angular#readme",
        |        "repository": "https://github.com/angular/angular",
        |        "bugs": "https://github.com/angular/angular/issues"
        |      },
        |      "license": "MIT",
        |      "dependencies": {
        |        "tslib": "^2.3.0"
        |      },
        |      "peerDependencies": {
        |        "@angular/core": "14.2.2"
        |      },
        |      "releases": [
        |        {
        |          "from": "2022-08-17T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 9
        |        },
        |        {
        |          "from": "2022-06-18T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 23
        |        },
        |        {
        |          "from": "2022-03-20T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 52
        |        },
        |        {
        |          "from": "2021-09-16T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 110
        |        },
        |        {
        |          "from": "2020-09-16T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 220
        |        }
        |      ]
        |    },
        |    "npm": {
        |      "downloads": [
        |        {
        |          "from": "2022-09-15T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 621453
        |        },
        |        {
        |          "from": "2022-09-09T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 3168614
        |        },
        |        {
        |          "from": "2022-08-17T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 13155129
        |        },
        |        {
        |          "from": "2022-06-18T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 37337884
        |        },
        |        {
        |          "from": "2022-03-20T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 75481342
        |        },
        |        {
        |          "from": "2021-09-16T00:00:00.000Z",
        |          "to": "2022-09-16T00:00:00.000Z",
        |          "count": 148061548
        |        }
        |      ],
        |      "starsCount": 9
        |    }
        |  },
        |  "evaluation": {
        |    "quality": {
        |      "carefulness": 0.33,
        |      "tests": 0,
        |      "health": 0,
        |      "branding": 0
        |    },
        |    "popularity": {
        |      "communityInterest": 9,
        |      "downloadsCount": 12445961.333333334,
        |      "downloadsAcceleration": 11637.233866057839,
        |      "dependentsCount": 0
        |    },
        |    "maintenance": {
        |      "releasesFrequency": 1,
        |      "commitsFrequency": 0,
        |      "openIssues": 0,
        |      "issuesDistribution": 0
        |    }
        |  },
        |  "score": {
        |    "final": 0.31382466072823334,
        |    "detail": {
        |      "quality": 0.20086796360358883,
        |      "popularity": 0.3911360142299715,
        |      "maintenance": 0.3333333333333333
        |    }
        |  }
        |}""".stripMargin
    succeed
  }
}
