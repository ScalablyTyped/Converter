package org.scalablytyped.converter.internal
package ts

//column-editing driven development FTW
trait TreeTransformation[T] { self =>
  def withTree(t: T, tree: TsTree): T

  def enterTsDeclClass(t:            T)(x: TsDeclClass):            TsDeclClass            = x
  def enterTsDeclEnum(t:             T)(x: TsDeclEnum):             TsDeclEnum             = x
  def enterTsDeclFunction(t:         T)(x: TsDeclFunction):         TsDeclFunction         = x
  def enterTsGlobal(t:               T)(x: TsGlobal):               TsGlobal               = x
  def enterTsDeclInterface(t:        T)(x: TsDeclInterface):        TsDeclInterface        = x
  def enterTsDeclModule(t:           T)(x: TsDeclModule):           TsDeclModule           = x
  def enterTsAugmentedModule(t:      T)(x: TsAugmentedModule):      TsAugmentedModule      = x
  def enterTsDeclNamespace(t:        T)(x: TsDeclNamespace):        TsDeclNamespace        = x
  def enterTsDeclTypeAlias(t:        T)(x: TsDeclTypeAlias):        TsDeclTypeAlias        = x
  def enterTsDeclVar(t:              T)(x: TsDeclVar):              TsDeclVar              = x
  def enterTsEnumMember(t:           T)(x: TsEnumMember):           TsEnumMember           = x
  def enterTsExportAsNamespace(t:    T)(x: TsExportAsNamespace):    TsExportAsNamespace    = x
  def enterTsExporteeNames(t:        T)(x: TsExporteeNames):        TsExporteeNames        = x
  def enterTsExporteeStar(t:         T)(x: TsExporteeStar):         TsExporteeStar         = x
  def enterTsExporteeTree(t:         T)(x: TsExporteeTree):         TsExporteeTree         = x
  def enterTsExport(t:               T)(x: TsExport):               TsExport               = x
  def enterTsFunParam(t:             T)(x: TsFunParam):             TsFunParam             = x
  def enterTsFunSig(t:               T)(x: TsFunSig):               TsFunSig               = x
  def enterTsImportedDestructured(t: T)(x: TsImportedDestructured): TsImportedDestructured = x
  def enterTsImportedIdent(t:        T)(x: TsImportedIdent):        TsImportedIdent        = x
  def enterTsImportedStar(t:         T)(x: TsImportedStar):         TsImportedStar         = x
  def enterTsImporteeFrom(t:         T)(x: TsImporteeFrom):         TsImporteeFrom         = x
  def enterTsImporteeLocal(t:        T)(x: TsImporteeLocal):        TsImporteeLocal        = x
  def enterTsImporteeRequired(t:     T)(x: TsImporteeRequired):     TsImporteeRequired     = x
  def enterTsImport(t:               T)(x: TsImport):               TsImport               = x
  def enterTsLiteralBoolean(t:       T)(x: TsLiteralBoolean):       TsLiteralBoolean       = x
  def enterTsLiteralNumber(t:        T)(x: TsLiteralNumber):        TsLiteralNumber        = x
  def enterTsLiteralString(t:        T)(x: TsLiteralString):        TsLiteralString        = x
  def enterTsMemberCall(t:           T)(x: TsMemberCall):           TsMemberCall           = x
  def enterTsMemberCtor(t:           T)(x: TsMemberCtor):           TsMemberCtor           = x
  def enterTsMemberFunction(t:       T)(x: TsMemberFunction):       TsMemberFunction       = x
  def enterTsMemberIndex(t:          T)(x: TsMemberIndex):          TsMemberIndex          = x
  def enterTsMemberProperty(t:       T)(x: TsMemberProperty):       TsMemberProperty       = x
  def enterTsMemberTypeMapped(t:     T)(x: TsMemberTypeMapped):     TsMemberTypeMapped     = x
  def enterTsParsedFile(t:           T)(x: TsParsedFile):           TsParsedFile           = x
  def enterTsQIdent(t:               T)(x: TsQIdent):               TsQIdent               = x
  def enterTsTypeAsserts(t:          T)(x: TsTypeAsserts):          TsTypeAsserts          = x
  def enterTsTypeConstructor(t:      T)(x: TsTypeConstructor):      TsTypeConstructor      = x
  def enterTsTypeConditional(t:      T)(x: TsTypeConditional):      TsTypeConditional      = x
  def enterTsTypeExtends(t:          T)(x: TsTypeExtends):          TsTypeExtends          = x
  def enterTsTypeFunction(t:         T)(x: TsTypeFunction):         TsTypeFunction         = x
  def enterTsTypeKeyOf(t:            T)(x: TsTypeKeyOf):            TsTypeKeyOf            = x
  def enterTsTypeIntersect(t:        T)(x: TsTypeIntersect):        TsTypeIntersect        = x
  def enterTsTypeIs(t:               T)(x: TsTypeIs):               TsTypeIs               = x
  def enterTsTypeInfer(t:            T)(x: TsTypeInfer):            TsTypeInfer            = x
  def enterTsTypeLiteral(t:          T)(x: TsTypeLiteral):          TsTypeLiteral          = x
  def enterTsTypeLookup(t:           T)(x: TsTypeLookup):           TsTypeLookup           = x
  def enterTsTypeObject(t:           T)(x: TsTypeObject):           TsTypeObject           = x
  def enterTsTypeParam(t:            T)(x: TsTypeParam):            TsTypeParam            = x
  def enterTsTypeQuery(t:            T)(x: TsTypeQuery):            TsTypeQuery            = x
  def enterTsTypeRef(t:              T)(x: TsTypeRef):              TsTypeRef              = x
  def enterTsTypeRepeated(t:         T)(x: TsTypeRepeated):         TsTypeRepeated         = x
  def enterTsTypeThis(t:             T)(x: TsTypeThis):             TsTypeThis             = x
  def enterTsTypeTuple(t:            T)(x: TsTypeTuple):            TsTypeTuple            = x
  def enterTsTypeUnion(t:            T)(x: TsTypeUnion):            TsTypeUnion            = x
  def enterIndexingDict(t:           T)(x: IndexingDict):           IndexingDict           = x
  def enterIndexingSingle(t:         T)(x: IndexingSingle):         IndexingSingle         = x

  def enterTsTree(t:            T)(x: TsTree):            TsTree            = x
  def enterTsDecl(t:            T)(x: TsDecl):            TsDecl            = x
  def enterTsNamedDecl(t:       T)(x: TsNamedDecl):       TsNamedDecl       = x
  def enterTsContainer(t:       T)(x: TsContainer):       TsContainer       = x
  def enterTsContainerOrDecl(t: T)(x: TsContainerOrDecl): TsContainerOrDecl = x
  def enterTsTerm(t:            T)(x: TsTerm):            TsTerm            = x
  def enterTsLiteral(t:         T)(x: TsLiteral):         TsLiteral         = x
  def enterTsType(t:            T)(x: TsType):            TsType            = x
  def enterTsMember(t:          T)(x: TsMember):          TsMember          = x
  def enterTsImported(t:        T)(x: TsImported):        TsImported        = x
  def enterTsImportee(t:        T)(x: TsImportee):        TsImportee        = x
  def enterTsExportee(t:        T)(x: TsExportee):        TsExportee        = x
  def enterIndexing(t:          T)(x: Indexing):          Indexing          = x

  //lazy
  def leaveTsParsedFile(t:      T)(x: TsParsedFile):      TsParsedFile      = x
  def leaveTsDeclModule(t:      T)(x: TsDeclModule):      TsDeclModule      = x
  def leaveTsDeclClass(t:       T)(x: TsDeclClass):       TsDeclClass       = x
  def leaveTsDeclInterface(t:   T)(x: TsDeclInterface):   TsDeclInterface   = x
  def leaveTsAugmentedModule(t: T)(x: TsAugmentedModule): TsAugmentedModule = x
  def leaveTsDeclNamespace(t:   T)(x: TsDeclNamespace):   TsDeclNamespace   = x
  def leaveTsGlobal(t:          T)(x: TsGlobal):          TsGlobal          = x
  def leaveTsType(t:            T)(x: TsType):            TsType            = x
  def leaveTsTypeRef(t:         T)(x: TsTypeRef):         TsTypeRef         = x
  def leaveTsTypeObject(t:      T)(x: TsTypeObject):      TsTypeObject      = x

  final def visitTsDeclClass(t: T)(x: TsDeclClass): TsDeclClass = {
    val xx = enterTsDeclClass(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsDeclClass(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10) =>
        TsDeclClass(
          _1,
          _2,
          _3,
          _4,
          _5.map(visitTsTypeParam(tt)),
          _6.map(visitTsTypeRef(tt)),
          _7.map(visitTsTypeRef(tt)),
          _8.map(visitTsMember(tt)),
          _9,
          _10,
        )
    }
    leaveTsDeclClass(tt)(xxx)
  }

  final def visitTsDeclEnum(t: T)(x: TsDeclEnum): TsDeclEnum = {
    val xx = enterTsDeclEnum(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsDeclEnum(_1, _2, _3, _4, _5, _6, _7, _8, _9) =>
        TsDeclEnum(_1, _2, _3, _4, _5.map(visitTsEnumMember(tt)), _6, _7.map(visitTsTypeRef(tt)), _8, _9)
    }
  }
  final def visitTsDeclFunction(t: T)(x: TsDeclFunction): TsDeclFunction = {
    val xx = enterTsDeclFunction(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsDeclFunction(_1, _2, _3, _4, _5, _6) =>
        TsDeclFunction(_1, _2, _3, visitTsFunSig(tt)(_4), _5, _6)
    }
  }
  final def visitTsDeclGlobal(t: T)(x: TsGlobal): TsGlobal = {
    val xx = enterTsGlobal(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsGlobal(_1, _2, _3, _4) => TsGlobal(_1, _2, _3.map(visitTsContainerOrDecl(tt)), _4)
    }
    leaveTsGlobal(tt)(xxx)
  }
  final def visitTsDeclInterface(t: T)(x: TsDeclInterface): TsDeclInterface = {
    val xx = enterTsDeclInterface(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsDeclInterface(_1, _2, _3, _4, _5, _6, _7) =>
        TsDeclInterface(
          _1,
          _2,
          _3,
          _4.map(visitTsTypeParam(tt)),
          _5.map(visitTsTypeRef(tt)),
          _6.map(visitTsMember(tt)),
          _7,
        )
    }
    leaveTsDeclInterface(tt)(xxx)
  }
  final def visitTsDeclModule(t: T)(x: TsDeclModule): TsDeclModule = {
    val xx = enterTsDeclModule(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsDeclModule(_1, _2, _3, _4, _5, _6) =>
        TsDeclModule(_1, _2, _3, _4.map(visitTsContainerOrDecl(tt)), _5, _6)
    }
    leaveTsDeclModule(tt)(xxx)
  }

  final def visitTsAugmentedModule(t: T)(x: TsAugmentedModule): TsAugmentedModule = {
    val xx = enterTsAugmentedModule(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsAugmentedModule(_1, _2, _3, _4, _5) =>
        TsAugmentedModule(_1, _2, _3.map(visitTsContainerOrDecl(tt)), _4, _5)
    }
    leaveTsAugmentedModule(tt)(xxx)
  }

  final def visitTsDeclNamespace(t: T)(x: TsDeclNamespace): TsDeclNamespace = {
    val xx = enterTsDeclNamespace(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsDeclNamespace(_1, _2, _3, _4, _5, _6) =>
        TsDeclNamespace(_1, _2, _3, _4.map(visitTsContainerOrDecl(tt)), _5, _6)
    }
    leaveTsDeclNamespace(tt)(xxx)
  }
  final def visitTsDeclTypeAlias(t: T)(x: TsDeclTypeAlias): TsDeclTypeAlias = {
    val xx = enterTsDeclTypeAlias(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsDeclTypeAlias(_1, _2, _3, _4, _5, _6) =>
        TsDeclTypeAlias(_1, _2, _3, _4.map(visitTsTypeParam(tt)), visitTsType(tt)(_5), _6)
    }
  }
  final def visitTsDeclVar(t: T)(x: TsDeclVar): TsDeclVar = {
    val xx = enterTsDeclVar(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsDeclVar(_1, _2, _3, _4, _5, _6, _7, _8) =>
        TsDeclVar(_1, _2, _3, _4, _5.map(visitTsType(tt)), _6, _7, _8)
    }
  }
  final def visitTsEnumMember(t: T)(x: TsEnumMember): TsEnumMember = {
    val xx = enterTsEnumMember(withTree(t, x))(x)
    xx match {
      case TsEnumMember(_1, _2, _3) => TsEnumMember(_1, _2, _3)
    }
  }

  final def visitTsExportAsNamespace(t: T)(x: TsExportAsNamespace): TsExportAsNamespace =
    enterTsExportAsNamespace(withTree(t, x))(x)

  final def visitTsExporteeNames(t: T)(x: TsExporteeNames): TsExporteeNames = {
    val xx = enterTsExporteeNames(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsExporteeNames(_1, _2) =>
        TsExporteeNames(_1.map(a => (visitTsQIdent(tt)(a._1), a._2)), _2)
    }
  }

  final def visitTsExporteeStar(t: T)(x: TsExporteeStar): TsExporteeStar =
    enterTsExporteeStar(withTree(t, x))(x)

  final def visitTsExporteeTree(t: T)(x: TsExporteeTree): TsExporteeTree = {
    val xx = enterTsExporteeTree(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsExporteeTree(_1) =>
        TsExporteeTree(visitTsDecl(tt)(_1))
    }
  }
  final def visitTsExport(t: T)(x: TsExport): TsExport = {
    val xx = enterTsExport(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsExport(_1, _2, _3, _4) => TsExport(_1, _2, _3, visitTsExportee(tt)(_4))
    }
  }
  final def visitTsFunParam(t: T)(x: TsFunParam): TsFunParam = {
    val xx = enterTsFunParam(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsFunParam(_1, _2, _3) =>
        TsFunParam(_1, _2, _3.map(visitTsType(tt)))
    }
  }
  final def visitTsFunSig(t: T)(x: TsFunSig): TsFunSig = {
    val xx = enterTsFunSig(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsFunSig(_1, _2, _3, _4) =>
        TsFunSig(_1, _2.map(visitTsTypeParam(tt)), _3.map(visitTsFunParam(tt)), _4.map(visitTsType(tt)))
    }
  }

  final def visitTsImportedDestructured(
      t: T,
  )(x:   TsImportedDestructured): TsImportedDestructured =
    enterTsImportedDestructured(withTree(t, x))(x)
  final def visitTsImportedIdent(t: T)(x: TsImportedIdent): TsImportedIdent =
    enterTsImportedIdent(withTree(t, x))(x)
  final def visitTsImportedStar(t: T)(x: TsImportedStar): TsImportedStar =
    enterTsImportedStar(withTree(t, x))(x)
  final def visitTsImporteeFrom(t: T)(x: TsImporteeFrom): TsImporteeFrom =
    enterTsImporteeFrom(withTree(t, x))(x)
  final def visitTsImporteeLocal(t: T)(x: TsImporteeLocal): TsImporteeLocal = {
    val xx = enterTsImporteeLocal(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsImporteeLocal(_1) => TsImporteeLocal(visitTsQIdent(tt)(_1))
    }
  }
  final def visitTsImporteeRequired(t: T)(x: TsImporteeRequired): TsImporteeRequired =
    enterTsImporteeRequired(withTree(t, x))(x)
  final def visitTsImport(t: T)(x: TsImport): TsImport = {
    val xx = enterTsImport(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsImport(_1, _2, _3) => TsImport(_1, _2.map(visitTsImported(tt)), visitTsImportee(tt)(_3))
    }
  }
  final def visitTsLiteralBoolean(t: T)(x: TsLiteralBoolean): TsLiteralBoolean =
    enterTsLiteralBoolean(withTree(t, x))(x)
  final def visitTsLiteralNumber(t: T)(x: TsLiteralNumber): TsLiteralNumber =
    enterTsLiteralNumber(withTree(t, x))(x)
  final def visitTsLiteralString(t: T)(x: TsLiteralString): TsLiteralString =
    enterTsLiteralString(withTree(t, x))(x)
  final def visitTsMemberCall(t: T)(x: TsMemberCall): TsMemberCall = {
    val xx = enterTsMemberCall(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberCall(_1, _2, _3) => TsMemberCall(_1, _2, visitTsFunSig(tt)(_3))
    }
  }
  final def visitTsMemberCtor(t: T)(x: TsMemberCtor): TsMemberCtor = {
    val xx = enterTsMemberCtor(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberCtor(_1, _2, _3) => TsMemberCtor(_1, _2, visitTsFunSig(tt)(_3))
    }
  }
  final def visitTsMemberFunction(t: T)(x: TsMemberFunction): TsMemberFunction = {
    val xx = enterTsMemberFunction(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberFunction(_1, _2, _3, _4, _5, _6, _7) =>
        TsMemberFunction(_1, _2, _3, _4, visitTsFunSig(tt)(_5), _6, _7)
    }
  }
  final def visitTsMemberIndex(t: T)(x: TsMemberIndex): TsMemberIndex = {
    val xx = enterTsMemberIndex(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberIndex(_1, _2, _3, _4, _5) =>
        TsMemberIndex(_1, _2, _3, visitIndexing(tt)(_4), _5.map(visitTsType(tt)))
    }
  }
  final def visitTsMemberProperty(t: T)(x: TsMemberProperty): TsMemberProperty = {
    val xx = enterTsMemberProperty(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberProperty(_1, _2, _3, _4, _5, _6, _7) =>
        TsMemberProperty(_1, _2, _3, _4.map(visitTsType(tt)), _5, _6, _7)
    }
  }
  final def visitTsMemberTypeMapped(t: T)(x: TsMemberTypeMapped): TsMemberTypeMapped = {
    val xx = enterTsMemberTypeMapped(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsMemberTypeMapped(_1, _2, _3, _4, _5, _6, _7) =>
        TsMemberTypeMapped(_1, _2, _3, _4, visitTsType(tt)(_5), _6, visitTsType(tt)(_7))
    }
  }
  final def visitTsParsedFile(t: T)(x: TsParsedFile): TsParsedFile = {
    val xx = enterTsParsedFile(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsParsedFile(_1, _2, _3, _4) => TsParsedFile(_1, _2, _3.map(visitTsContainerOrDecl(tt)), _4)
    }
    leaveTsParsedFile(tt)(xxx)
  }

  final def visitTsQIdent(t: T)(x: TsQIdent): TsQIdent =
    enterTsQIdent(withTree(t, x))(x)

  final def visitTsTypeAsserts(t: T)(x: TsTypeAsserts): TsTypeAsserts = {
    val xx = enterTsTypeAsserts(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeAsserts(_1, _2) => TsTypeAsserts(_1, _2.map(visitTsTypeRef(tt)))
    }
  }

  final def visitTsTypeConstructor(t: T)(x: TsTypeConstructor): TsTypeConstructor = {
    val xx = enterTsTypeConstructor(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeConstructor(_1) => TsTypeConstructor(visitTsTypeFunction(tt)(_1))
    }
  }
  final def visitTsTypeConditional(t: T)(x: TsTypeConditional): TsTypeConditional = {
    val xx = enterTsTypeConditional(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeConditional(_1, _2, _3) =>
        TsTypeConditional(visitTsType(tt)(_1), visitTsType(tt)(_2), visitTsType(tt)(_3))
    }
  }
  final def visitTsTypeExtends(t: T)(x: TsTypeExtends): TsTypeExtends = {
    val xx = enterTsTypeExtends(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeExtends(_1, _2) => TsTypeExtends(visitTsType(tt)(_1), visitTsType(tt)(_2))
    }
  }
  final def visitTsTypeFunction(t: T)(x: TsTypeFunction): TsTypeFunction = {
    val xx = enterTsTypeFunction(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeFunction(_1) => TsTypeFunction(visitTsFunSig(tt)(_1))
    }
  }
  final def visitTsTypeKeyOf(t: T)(x: TsTypeKeyOf): TsTypeKeyOf = {
    val xx = enterTsTypeKeyOf(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeKeyOf(_1) => TsTypeKeyOf(visitTsType(tt)(_1))
    }
  }
  final def visitTsTypeIntersect(t: T)(x: TsTypeIntersect): TsTypeIntersect = {
    val xx = enterTsTypeIntersect(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeIntersect(_1) => TsTypeIntersect(_1.map(visitTsType(tt)))
    }
  }

  final def visitTsTypeIs(t: T)(x: TsTypeIs): TsTypeIs = {
    val xx = enterTsTypeIs(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeIs(_1, _2) => TsTypeIs(_1, visitTsType(tt)(_2))
    }
  }

  final def visitTsTypeInfer(t: T)(x: TsTypeInfer): TsTypeInfer = {
    val xx = enterTsTypeInfer(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeInfer(_1) => TsTypeInfer(visitTsTypeParam(tt)(_1))
    }
  }

  final def visitTsTypeLiteral(t: T)(x: TsTypeLiteral): TsTypeLiteral = {
    val xx = enterTsTypeLiteral(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeLiteral(_1) => TsTypeLiteral(visitTsLiteral(tt)(_1))
    }
  }
  final def visitTsTypeLookup(t: T)(x: TsTypeLookup): TsTypeLookup = {
    val xx = enterTsTypeLookup(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeLookup(_1, _2) =>
        TsTypeLookup(visitTsType(tt)(_1), visitTsType(tt)(_2))
    }
  }
  final def visitTsTypeObject(t: T)(x: TsTypeObject): TsTypeObject = {
    val xx = enterTsTypeObject(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsTypeObject(_1, _2) => TsTypeObject(_1, _2.map(visitTsMember(tt)))
    }
    leaveTsTypeObject(withTree(t, xxx))(xxx)
  }
  final def visitTsTypeParam(t: T)(x: TsTypeParam): TsTypeParam = {
    val xx = enterTsTypeParam(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeParam(_1, _2, _3, _4) =>
        TsTypeParam(_1, _2, _3.map(visitTsType(tt)), _4.map(visitTsType(tt)))
    }
  }
  final def visitTsTypeQuery(t: T)(x: TsTypeQuery): TsTypeQuery = {
    val xx = enterTsTypeQuery(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeQuery(_1) => TsTypeQuery(visitTsQIdent(tt)(_1))
    }
  }
  final def visitTsTypeRef(t: T)(x: TsTypeRef): TsTypeRef = {
    val xx = enterTsTypeRef(withTree(t, x))(x)
    val tt = withTree(t, xx)
    val xxx = xx match {
      case TsTypeRef(_1, _2, _3) => TsTypeRef(_1, visitTsQIdent(tt)(_2), _3.map(visitTsType(tt)))
    }
    leaveTsTypeRef(tt)(xxx)
  }
  final def visitTsTypeRepeated(t: T)(x: TsTypeRepeated): TsTypeRepeated = {
    val xx = enterTsTypeRepeated(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeRepeated(_1) => TsTypeRepeated(visitTsType(tt)(_1))
    }
  }
  final def visitTsTypeThis(t: T)(x: TsTypeThis): TsTypeThis =
    enterTsTypeThis(withTree(t, x))(x)
  final def visitTsTypeTuple(t: T)(x: TsTypeTuple): TsTypeTuple = {
    val xx = enterTsTypeTuple(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeTuple(_1) => TsTypeTuple(_1.map(visitTsTupleElem(tt)))
    }
  }
  final def visitTsTypeUnion(t: T)(x: TsTypeUnion): TsTypeUnion = {
    val xx = enterTsTypeUnion(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case TsTypeUnion(_1) => TsTypeUnion(_1.map(visitTsType(tt)))
    }
  }

  final def visitIndexingDict(t: T)(x: IndexingDict): IndexingDict = {
    val xx = enterIndexingDict(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case IndexingDict(_1, _2) => IndexingDict(_1, visitTsType(tt)(_2))
    }
  }
  final def visitIndexingSingle(t: T)(x: IndexingSingle): IndexingSingle = {
    val xx = enterIndexingSingle(withTree(t, x))(x)
    val tt = withTree(t, xx)
    xx match {
      case IndexingSingle(_1) => IndexingSingle(visitTsQIdent(tt)(_1))
    }
  }

  final def visitTsTree(t: T)(x: TsTree): TsTree =
    enterTsTree(withTree(t, x))(x) match {
      case x: TsContainerOrDecl => visitTsContainerOrDecl(t)(x)
      case x: TsType            => visitTsType(t)(x)
      case x: TsMember          => visitTsMember(t)(x)
      case x: TsTerm            => visitTsTerm(t)(x)
      case x: TsEnumMember      => visitTsEnumMember(t)(x)
      case x: TsFunSig          => visitTsFunSig(t)(x)
      case x: TsFunParam        => visitTsFunParam(t)(x)
      case x: TsTypeParam       => visitTsTypeParam(t)(x)
      case x: TsQIdent          => visitTsQIdent(t)(x)
      case x: TsExportee        => visitTsExportee(t)(x)
      case x: TsImported        => visitTsImported(t)(x)
      case x: TsImportee        => visitTsImportee(t)(x)
      case x: Indexing          => visitIndexing(t)(x)
    }

  final def visitTsDecl(t: T)(x: TsDecl): TsDecl =
    enterTsDecl(withTree(t, x))(x) match {
      case x: TsNamedDecl         => visitTsNamedDecl(t)(x)
      case x: TsExport            => visitTsExport(t)(x)
      case x: TsImport            => visitTsImport(t)(x)
      case x: TsExportAsNamespace => visitTsExportAsNamespace(t)(x)
    }

  final def visitTsNamedDecl(t: T)(x: TsNamedDecl): TsNamedDecl =
    enterTsNamedDecl(withTree(t, x))(x) match {
      case x: TsAugmentedModule => visitTsAugmentedModule(t)(x)
      case x: TsDeclModule      => visitTsDeclModule(t)(x)
      case x: TsDeclNamespace   => visitTsDeclNamespace(t)(x)
      case x: TsDeclFunction    => visitTsDeclFunction(t)(x)
      case x: TsDeclTypeAlias   => visitTsDeclTypeAlias(t)(x)
      case x: TsDeclVar         => visitTsDeclVar(t)(x)
      case x: TsDeclClass       => visitTsDeclClass(t)(x)
      case x: TsDeclEnum        => visitTsDeclEnum(t)(x)
      case x: TsDeclInterface   => visitTsDeclInterface(t)(x)
    }

  final def visitTsContainer(t: T)(x: TsContainer): TsContainer =
    enterTsContainer(withTree(t, x))(x) match {
      case x: TsAugmentedModule => visitTsAugmentedModule(t)(x)
      case x: TsParsedFile      => visitTsParsedFile(t)(x)
      case x: TsGlobal          => visitTsDeclGlobal(t)(x)
      case x: TsDeclModule      => visitTsDeclModule(t)(x)
      case x: TsDeclNamespace   => visitTsDeclNamespace(t)(x)
    }

  final def visitTsContainerOrDecl(t: T)(x: TsContainerOrDecl): TsContainerOrDecl =
    enterTsContainerOrDecl(withTree(t, x))(x) match {
      case x: TsContainer => visitTsContainer(t)(x)
      case x: TsDecl      => visitTsDecl(t)(x)
    }

  final def visitTsExportee(t: T)(x: TsExportee): TsExportee =
    enterTsExportee(withTree(t, x))(x) match {
      case x: TsExporteeNames => visitTsExporteeNames(t)(x)
      case x: TsExporteeTree  => visitTsExporteeTree(t)(x)
      case x: TsExporteeStar  => visitTsExporteeStar(t)(x)
    }

  final def visitTsTerm(t: T)(x: TsTerm): TsTerm =
    enterTsTerm(withTree(t, x))(x) match {
      case x: TsLiteral => visitTsLiteral(t)(x)
      case x: TsIdent   => x
    }

  final def visitTsLiteral(t: T)(x: TsLiteral): TsLiteral =
    enterTsLiteral(withTree(t, x))(x) match {
      case x: TsLiteralBoolean => visitTsLiteralBoolean(t)(x)
      case x: TsLiteralString  => visitTsLiteralString(t)(x)
      case x: TsLiteralNumber  => visitTsLiteralNumber(t)(x)
    }

  final def visitTsType(t: T)(x: TsType): TsType =
    leaveTsType(withTree(t, x))(enterTsType(withTree(t, x))(x) match {
      case x: TsTypeAsserts     => visitTsTypeAsserts(t)(x)
      case x: TsTypeConstructor => visitTsTypeConstructor(t)(x)
      case x: TsTypeConditional => visitTsTypeConditional(t)(x)
      case x: TsTypeExtends     => visitTsTypeExtends(t)(x)
      case x: TsTypeFunction    => visitTsTypeFunction(t)(x)
      case x: TsTypeKeyOf       => visitTsTypeKeyOf(t)(x)
      case x: TsTypeIntersect   => visitTsTypeIntersect(t)(x)
      case x: TsTypeIs          => visitTsTypeIs(t)(x)
      case x: TsTypeInfer       => visitTsTypeInfer(t)(x)
      case x: TsTypeLiteral     => visitTsTypeLiteral(t)(x)
      case x: TsTypeLookup      => visitTsTypeLookup(t)(x)
      case x: TsTypeObject      => visitTsTypeObject(t)(x)
      case x: TsTypeQuery       => visitTsTypeQuery(t)(x)
      case x: TsTypeRef         => visitTsTypeRef(t)(x)
      case x: TsTypeRepeated    => visitTsTypeRepeated(t)(x)
      case x: TsTypeThis        => visitTsTypeThis(t)(x)
      case x: TsTypeTuple       => visitTsTypeTuple(t)(x)
      case x: TsTypeUnion       => visitTsTypeUnion(t)(x)
    })

  final def visitTsTupleElem(t: T)(tupleElem: TsTupleElement): TsTupleElement =
    TsTupleElement(tupleElem.label, visitTsType(t)(tupleElem.tpe))

  final def visitTsMember(t: T)(x: TsMember): TsMember =
    enterTsMember(withTree(t, x))(x) match {
      case x: TsMemberCall       => visitTsMemberCall(t)(x)
      case x: TsMemberCtor       => visitTsMemberCtor(t)(x)
      case x: TsMemberFunction   => visitTsMemberFunction(t)(x)
      case x: TsMemberIndex      => visitTsMemberIndex(t)(x)
      case x: TsMemberTypeMapped => visitTsMemberTypeMapped(t)(x)
      case x: TsMemberProperty   => visitTsMemberProperty(t)(x)
    }

  final def visitTsImported(t: T)(x: TsImported): TsImported =
    enterTsImported(withTree(t, x))(x) match {
      case x: TsImportedIdent        => visitTsImportedIdent(t)(x)
      case x: TsImportedDestructured => visitTsImportedDestructured(t)(x)
      case x: TsImportedStar         => visitTsImportedStar(t)(x)
    }

  final def visitTsImportee(t: T)(x: TsImportee): TsImportee =
    enterTsImportee(withTree(t, x))(x) match {
      case x: TsImporteeRequired => visitTsImporteeRequired(t)(x)
      case x: TsImporteeFrom     => visitTsImporteeFrom(t)(x)
      case x: TsImporteeLocal    => visitTsImporteeLocal(t)(x)
    }

  final def visitIndexing(t: T)(x: Indexing): Indexing =
    enterIndexing(withTree(t, x))(x) match {
      case x: IndexingDict   => visitIndexingDict(t)(x)
      case x: IndexingSingle => visitIndexingSingle(t)(x)
    }

  final def >>(that: TreeTransformation[T]): TreeTransformation[T] =
    combine(that)

  final def combine(that: TreeTransformation[T]): TreeTransformation[T] =
    new TreeTransformation[T] {
      override def withTree(t: T, tree: TsTree): T =
        self.withTree(t, tree)
      override def enterTsDeclClass(t: T)(x: TsDeclClass): TsDeclClass =
        self.enterTsDeclClass(t)(that.enterTsDeclClass(t)(x))
      override def enterTsDeclEnum(t: T)(x: TsDeclEnum): TsDeclEnum =
        self.enterTsDeclEnum(t)(that.enterTsDeclEnum(t)(x))
      override def enterTsDeclFunction(t: T)(x: TsDeclFunction): TsDeclFunction =
        self.enterTsDeclFunction(t)(that.enterTsDeclFunction(t)(x))
      override def enterTsGlobal(t: T)(x: TsGlobal): TsGlobal =
        self.enterTsGlobal(t)(that.enterTsGlobal(t)(x))
      override def enterTsDeclInterface(t: T)(x: TsDeclInterface): TsDeclInterface =
        self.enterTsDeclInterface(t)(that.enterTsDeclInterface(t)(x))
      override def enterTsDeclModule(t: T)(x: TsDeclModule): TsDeclModule =
        self.enterTsDeclModule(t)(that.enterTsDeclModule(t)(x))
      override def enterTsDeclNamespace(t: T)(x: TsDeclNamespace): TsDeclNamespace =
        self.enterTsDeclNamespace(t)(that.enterTsDeclNamespace(t)(x))
      override def enterTsDeclTypeAlias(t: T)(x: TsDeclTypeAlias): TsDeclTypeAlias =
        self.enterTsDeclTypeAlias(t)(that.enterTsDeclTypeAlias(t)(x))
      override def enterTsDeclVar(t: T)(x: TsDeclVar): TsDeclVar =
        self.enterTsDeclVar(t)(that.enterTsDeclVar(t)(x))
      override def enterTsEnumMember(t: T)(x: TsEnumMember): TsEnumMember =
        self.enterTsEnumMember(t)(that.enterTsEnumMember(t)(x))
      override def enterTsExportAsNamespace(t: T)(x: TsExportAsNamespace): TsExportAsNamespace =
        self.enterTsExportAsNamespace(t)(that.enterTsExportAsNamespace(t)(x))
      override def enterTsExporteeNames(t: T)(x: TsExporteeNames): TsExporteeNames =
        self.enterTsExporteeNames(t)(that.enterTsExporteeNames(t)(x))
      override def enterTsExporteeStar(t: T)(x: TsExporteeStar): TsExporteeStar =
        self.enterTsExporteeStar(t)(that.enterTsExporteeStar(t)(x))
      override def enterTsExporteeTree(t: T)(x: TsExporteeTree): TsExporteeTree =
        self.enterTsExporteeTree(t)(that.enterTsExporteeTree(t)(x))
      override def enterTsExport(t: T)(x: TsExport): TsExport =
        self.enterTsExport(t)(that.enterTsExport(t)(x))
      override def enterTsFunParam(t: T)(x: TsFunParam): TsFunParam =
        self.enterTsFunParam(t)(that.enterTsFunParam(t)(x))
      override def enterTsFunSig(t: T)(x: TsFunSig): TsFunSig =
        self.enterTsFunSig(t)(that.enterTsFunSig(t)(x))
      override def enterTsImportedDestructured(t: T)(x: TsImportedDestructured): TsImportedDestructured =
        self.enterTsImportedDestructured(t)(that.enterTsImportedDestructured(t)(x))
      override def enterTsImportedIdent(t: T)(x: TsImportedIdent): TsImportedIdent =
        self.enterTsImportedIdent(t)(that.enterTsImportedIdent(t)(x))
      override def enterTsImportedStar(t: T)(x: TsImportedStar): TsImportedStar =
        self.enterTsImportedStar(t)(that.enterTsImportedStar(t)(x))
      override def enterTsImporteeFrom(t: T)(x: TsImporteeFrom): TsImporteeFrom =
        self.enterTsImporteeFrom(t)(that.enterTsImporteeFrom(t)(x))
      override def enterTsImporteeLocal(t: T)(x: TsImporteeLocal): TsImporteeLocal =
        self.enterTsImporteeLocal(t)(that.enterTsImporteeLocal(t)(x))
      override def enterTsImporteeRequired(t: T)(x: TsImporteeRequired): TsImporteeRequired =
        self.enterTsImporteeRequired(t)(that.enterTsImporteeRequired(t)(x))
      override def enterTsImport(t: T)(x: TsImport): TsImport =
        self.enterTsImport(t)(that.enterTsImport(t)(x))
      override def enterTsLiteralBoolean(t: T)(x: TsLiteralBoolean): TsLiteralBoolean =
        self.enterTsLiteralBoolean(t)(that.enterTsLiteralBoolean(t)(x))
      override def enterTsLiteralNumber(t: T)(x: TsLiteralNumber): TsLiteralNumber =
        self.enterTsLiteralNumber(t)(that.enterTsLiteralNumber(t)(x))
      override def enterTsLiteralString(t: T)(x: TsLiteralString): TsLiteralString =
        self.enterTsLiteralString(t)(that.enterTsLiteralString(t)(x))
      override def enterTsMemberCall(t: T)(x: TsMemberCall): TsMemberCall =
        self.enterTsMemberCall(t)(that.enterTsMemberCall(t)(x))
      override def enterTsMemberCtor(t: T)(x: TsMemberCtor): TsMemberCtor =
        self.enterTsMemberCtor(t)(that.enterTsMemberCtor(t)(x))
      override def enterTsMemberFunction(t: T)(x: TsMemberFunction): TsMemberFunction =
        self.enterTsMemberFunction(t)(that.enterTsMemberFunction(t)(x))
      override def enterTsMemberIndex(t: T)(x: TsMemberIndex): TsMemberIndex =
        self.enterTsMemberIndex(t)(that.enterTsMemberIndex(t)(x))
      override def enterTsMemberProperty(t: T)(x: TsMemberProperty): TsMemberProperty =
        self.enterTsMemberProperty(t)(that.enterTsMemberProperty(t)(x))
      override def enterTsMemberTypeMapped(t: T)(x: TsMemberTypeMapped): TsMemberTypeMapped =
        self.enterTsMemberTypeMapped(t)(that.enterTsMemberTypeMapped(t)(x))
      override def enterTsParsedFile(t: T)(x: TsParsedFile): TsParsedFile =
        self.enterTsParsedFile(t)(that.enterTsParsedFile(t)(x))
      override def enterTsQIdent(t: T)(x: TsQIdent): TsQIdent =
        self.enterTsQIdent(t)(that.enterTsQIdent(t)(x))
      override def enterTsTypeAsserts(t: T)(x: TsTypeAsserts): TsTypeAsserts =
        self.enterTsTypeAsserts(t)(that.enterTsTypeAsserts(t)(x))
      override def enterTsTypeConstructor(t: T)(x: TsTypeConstructor): TsTypeConstructor =
        self.enterTsTypeConstructor(t)(that.enterTsTypeConstructor(t)(x))
      override def enterTsTypeConditional(t: T)(x: TsTypeConditional): TsTypeConditional =
        self.enterTsTypeConditional(t)(that.enterTsTypeConditional(t)(x))
      override def enterTsTypeExtends(t: T)(x: TsTypeExtends): TsTypeExtends =
        self.enterTsTypeExtends(t)(that.enterTsTypeExtends(t)(x))
      override def enterTsTypeFunction(t: T)(x: TsTypeFunction): TsTypeFunction =
        self.enterTsTypeFunction(t)(that.enterTsTypeFunction(t)(x))
      override def enterTsTypeKeyOf(t: T)(x: TsTypeKeyOf): TsTypeKeyOf =
        self.enterTsTypeKeyOf(t)(that.enterTsTypeKeyOf(t)(x))
      override def enterTsTypeIntersect(t: T)(x: TsTypeIntersect): TsTypeIntersect =
        self.enterTsTypeIntersect(t)(that.enterTsTypeIntersect(t)(x))
      override def enterTsTypeIs(t: T)(x: TsTypeIs): TsTypeIs =
        self.enterTsTypeIs(t)(that.enterTsTypeIs(t)(x))
      override def enterTsTypeInfer(t: T)(x: TsTypeInfer): TsTypeInfer =
        self.enterTsTypeInfer(t)(that.enterTsTypeInfer(t)(x))
      override def enterTsTypeLiteral(t: T)(x: TsTypeLiteral): TsTypeLiteral =
        self.enterTsTypeLiteral(t)(that.enterTsTypeLiteral(t)(x))
      override def enterTsTypeLookup(t: T)(x: TsTypeLookup): TsTypeLookup =
        self.enterTsTypeLookup(t)(that.enterTsTypeLookup(t)(x))
      override def enterTsTypeObject(t: T)(x: TsTypeObject): TsTypeObject =
        self.enterTsTypeObject(t)(that.enterTsTypeObject(t)(x))
      override def enterTsTypeParam(t: T)(x: TsTypeParam): TsTypeParam =
        self.enterTsTypeParam(t)(that.enterTsTypeParam(t)(x))
      override def enterTsTypeQuery(t: T)(x: TsTypeQuery): TsTypeQuery =
        self.enterTsTypeQuery(t)(that.enterTsTypeQuery(t)(x))
      override def enterTsTypeRef(t: T)(x: TsTypeRef): TsTypeRef =
        self.enterTsTypeRef(t)(that.enterTsTypeRef(t)(x))
      override def enterTsTypeRepeated(t: T)(x: TsTypeRepeated): TsTypeRepeated =
        self.enterTsTypeRepeated(t)(that.enterTsTypeRepeated(t)(x))
      override def enterTsTypeThis(t: T)(x: TsTypeThis): TsTypeThis =
        self.enterTsTypeThis(t)(that.enterTsTypeThis(t)(x))
      override def enterTsTypeTuple(t: T)(x: TsTypeTuple): TsTypeTuple =
        self.enterTsTypeTuple(t)(that.enterTsTypeTuple(t)(x))
      override def enterTsTypeUnion(t: T)(x: TsTypeUnion): TsTypeUnion =
        self.enterTsTypeUnion(t)(that.enterTsTypeUnion(t)(x))
      override def enterTsTree(t: T)(x: TsTree): TsTree =
        self.enterTsTree(t)(that.enterTsTree(t)(x))
      override def enterTsDecl(t: T)(x: TsDecl): TsDecl =
        self.enterTsDecl(t)(that.enterTsDecl(t)(x))
      override def enterTsContainer(t: T)(x: TsContainer): TsContainer =
        self.enterTsContainer(t)(that.enterTsContainer(t)(x))
      override def enterTsTerm(t: T)(x: TsTerm): TsTerm =
        self.enterTsTerm(t)(that.enterTsTerm(t)(x))
      override def enterTsLiteral(t: T)(x: TsLiteral): TsLiteral =
        self.enterTsLiteral(t)(that.enterTsLiteral(t)(x))
      override def enterTsType(t: T)(x: TsType): TsType =
        self.enterTsType(t)(that.enterTsType(t)(x))
      override def enterTsMember(t: T)(x: TsMember): TsMember =
        self.enterTsMember(t)(that.enterTsMember(t)(x))
      override def enterTsImported(t: T)(x: TsImported): TsImported =
        self.enterTsImported(t)(that.enterTsImported(t)(x))
      override def enterTsImportee(t: T)(x: TsImportee): TsImportee =
        self.enterTsImportee(t)(that.enterTsImportee(t)(x))
      override def enterTsExportee(t: T)(x: TsExportee): TsExportee =
        self.enterTsExportee(t)(that.enterTsExportee(t)(x))

      override def leaveTsParsedFile(t: T)(x: TsParsedFile): TsParsedFile =
        self.leaveTsParsedFile(t)(that.leaveTsParsedFile(t)(x))
      override def leaveTsDeclModule(t: T)(x: TsDeclModule): TsDeclModule =
        self.leaveTsDeclModule(t)(that.leaveTsDeclModule(t)(x))
      override def leaveTsDeclClass(t: T)(x: TsDeclClass): TsDeclClass =
        self.leaveTsDeclClass(t)(that.leaveTsDeclClass(t)(x))
      override def leaveTsDeclInterface(t: T)(x: TsDeclInterface): TsDeclInterface =
        self.leaveTsDeclInterface(t)(that.leaveTsDeclInterface(t)(x))
      override def leaveTsDeclNamespace(t: T)(x: TsDeclNamespace): TsDeclNamespace =
        self.leaveTsDeclNamespace(t)(that.leaveTsDeclNamespace(t)(x))
      override def leaveTsType(t: T)(x: TsType): TsType =
        self.leaveTsType(t)(that.leaveTsType(t)(x))
      override def leaveTsTypeRef(t: T)(x: TsTypeRef): TsTypeRef =
        self.leaveTsTypeRef(t)(that.leaveTsTypeRef(t)(x))
      override def leaveTsGlobal(t: T)(x: TsGlobal): TsGlobal =
        self.leaveTsGlobal(t)(that.leaveTsGlobal(t)(x))
    }
}
