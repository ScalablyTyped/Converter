package com.olvind.tso
package ts

import ammonite.ops.RelPath

case class CompilerOptions(
    module:                           Option[String],
    lib:                              Option[Seq[String]],
    noImplicitAny:                    Option[Boolean],
    noImplicitThis:                   Option[Boolean],
    strictNullChecks:                 Option[Boolean],
    baseUrl:                          Option[RelPath],
    typeRoots:                        Option[Seq[RelPath]],
    types:                            Option[Seq[String]],
    noEmit:                           Option[Boolean],
    forceConsistentCasingInFileNames: Option[Boolean]
)

case class TsConfig(
    compilerOptions: Option[CompilerOptions],
    files:           Option[Seq[String]]
)

case class PackageJsonDeps(
    version:          Option[String],
    dependencies:     Option[Map[String, String]],
    peerDependencies: Option[Map[String, String]],
    typings:          Option[String],
    types:            Option[String],
    files:            Option[Seq[String]]
)

case class NotNeededPackage(
    libraryName:        String,
    typingsPackageName: String,
    sourceRepoURL:      String,
    asOfVersion:        String
)
case class TypingsJson(
    name:   String,
    main:   String,
    files:  Seq[String],
    global: Boolean
)

case class NotNeededPackages(packages: Seq[NotNeededPackage])
