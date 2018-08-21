package com.olvind.tso
package scalajs
package transforms

import com.olvind.{logging, tso}
import org.scalatest.{FunSuite, Matchers}

class SymbolTransformerTest extends FunSuite with Matchers {
  val original: Symbol =
    PackageSymbol(
      Nil,
      Name("arne"),
      Seq(
        ClassSymbol(
          Nil,
          Name("Class"),
          Seq(TypeParamSymbol(Name("T"), None, NoComments)),
          Seq(TypeRef(QualifiedName(Name("parent") :: Nil), Nil, NoComments)),
          Nil,
          Seq(
            FieldSymbol(
              Nil,
              Name("field"),
              TypeRef(QualifiedName(Name("String") :: Nil), Nil, NoComments),
              fieldType  = FieldTypeNative,
              isOverride = false,
              isReadOnly = false,
              comments   = NoComments
            ),
            FieldSymbol(
              Nil,
              Name("field"),
              TypeRef(QualifiedName(Name("Int") :: Nil), Nil, NoComments),
              fieldType  = FieldTypeNative,
              isOverride = false,
              isReadOnly = false,
              comments   = NoComments
            )
          ),
          ClassType.Class,
          isSealed = false,
          comments = NoComments
        )
      ),
      NoComments
    )

  object deDuplicateMembers extends SymbolVisitor {
    override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
      s.copy(
        members = s.members
          .groupBy(_.name)
          .collect {
            case (_, sameNames) => sameNames.head
          }
          .to[Seq]
      )
  }

  object upperCaseFieldMembers extends SymbolVisitor {
    override def enterFieldSymbol(scope: SymbolScope)(s: FieldSymbol): FieldSymbol =
      scope.stack match {
        case (_: ClassSymbol) :: _ => s.copy(name = Name(s.name.value.toUpperCase))
        case _ => s
      }
  }

  val scope = new tso.scalajs.SymbolScope.Root[Nothing](Name.dummy, Set(), logging.stdout)
  val transformed: Symbol = (deDuplicateMembers >> upperCaseFieldMembers).visitSymbol(scope)(original)

  val expected: Symbol =
    PackageSymbol(
      Nil,
      Name("arne"),
      List(
        ClassSymbol(
          Nil,
          Name("Class"),
          List(TypeParamSymbol(Name("T"), None, NoComments)),
          List(TypeRef(QualifiedName(Name("parent") :: Nil), Nil, NoComments)),
          Nil,
          List(
            FieldSymbol(
              Nil,
              Name("FIELD"),
              TypeRef(QualifiedName(Name("String") :: Nil), Nil, NoComments),
              fieldType  = FieldTypeNative,
              isOverride = false,
              isReadOnly = false,
              comments   = NoComments
            )
          ),
          ClassType.Class,
          isSealed = false,
          NoComments
        )
      ),
      NoComments
    )

  test("should work") {
    transformed should equal(expected)
  }
}
