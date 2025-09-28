# ScalablyTyped Converter - Claude Assistant Documentation

## Project Overview

ScalablyTyped is a TypeScript to Scala.js converter that enables the use of JavaScript libraries with TypeScript type definitions in Scala.js projects. The converter takes TypeScript definition files (`.d.ts`) and generates corresponding Scala.js facades, supporting multiple flavors including vanilla Scala.js, Slinky (React), and Scalajs-react (Japgolly).

### Key Features
- Converts TypeScript type definitions to Scala.js facades
- Supports multiple Scala versions (2.12, 2.13, 3.x)
- Provides different flavors for React integration
- Handles complex TypeScript features like union types, literal types, and type mappings
- Includes SBT plugin for seamless integration

## Architecture

### Core Components

#### 1. TypeScript AST (`core/src/main/scala/org/scalablytyped/converter/internal/ts/`)
- **trees.scala**: Defines the TypeScript AST representation
  - `TsTree`: Base trait for all TypeScript AST nodes
  - `TsParsedFile`: Root of a parsed TypeScript file
  - `TsDeclClass`, `TsDeclInterface`, `TsDeclModule`: TypeScript declarations
  - `TsType`: Type representations (unions, intersections, literals, etc.)
- **TsExpr.scala**: Expression handling for TypeScript
- **parser/TsParser.scala**: Parser combinator-based TypeScript parser using `TsLexer`

#### 2. Scala.js AST (`core/src/main/scala/org/scalablytyped/converter/internal/scalajs/`)
- **tree.scala**: Scala.js AST representation
  - `Tree`: Base trait for all Scala AST nodes
  - `PackageTree`, `ClassTree`, `ModuleTree`: Container structures
  - `FieldTree`, `MethodTree`: Member definitions
  - `TypeRef`: Type references with type parameters
- **Annotation.scala**: Scala.js annotations (`@js.native`, `@JSImport`, etc.)
- **Name.scala**, **QualifiedName.scala**: Naming system for Scala identifiers

#### 3. Conversion Pipeline

The conversion happens in three main phases:

##### Phase 1: Read TypeScript (`Phase1ReadTypescript`)
- Parses TypeScript files using `TsParser`
- Implements TypeScript module system
- Applies TypeScript transformations:
  - Inlines triple-slash directives
  - Resolves module references
  - Expands type mappings when possible
  - Handles augmented modules

##### Phase 2: Convert to Scala.js (`Phase2ToScalaJs`)
- Converts TypeScript AST to Scala.js AST
- Applies Scala.js transformations:
  - `ModulesCombine`: Combines modules
  - `FakeLiterals`: Creates fake literal types for TypeScript string/number literals
  - `UnionToInheritance`: Converts long union types to inheritance hierarchies
  - `CombineOverloads`: Handles method overloading
  - `CompleteClass`: Ensures classes are valid Scala

##### Phase 3: Compile (`Phase3Compile`)
- Compiles generated Scala code
- Validates output
- Publishes artifacts

### Important Concepts

#### Encoding Strategies

1. **Literal Types**: TypeScript literal types are encoded as sealed traits with companion objects providing instances
2. **Union Types**: Short unions use Scala union types (`A | B`), long unions are converted to inheritance
3. **Type Mappings**: Static type mappings are expanded, generic ones are kept as comments
4. **Classes**: TypeScript classes that are also values use `Instantiable` traits
5. **Modules**: TypeScript modules become Scala packages with `^` objects for top-level members

#### Flavours

- **Normal**: Standard Scala.js facades
- **Slinky**: React components for Slinky framework
- **ScalajsReact (Japgolly)**: React components for scalajs-react

## Testing

### Snapshot Tests (`ImporterTest`)
Located in `importer/src/test/scala/org/scalablytyped/converter/internal/importer/ImporterTest.scala`
- Tests conversion of various TypeScript libraries
- Compares output against checked-in snapshots
- Run with: `sbt "importer/testOnly org.scalablytyped.converter.internal.importer.ImporterTest*"`

### Parser Tests
Located in `importer/src/test/scala/org/scalablytyped/converter/internal/ts/parser/`
- Unit tests for TypeScript parser
- Run with: `sbt "importer/testOnly org.scalablytyped.converter.internal.ts.parser.*"`

## Development Workflow

### Running the Converter

#### Development Mode (single library)
```bash
sbt "importer/runMain org.scalablytyped.converter.Main -softWrites -enableParseCache -offline react"
```

#### Demo Set
```bash
sbt "importer/runMain org.scalablytyped.converter.Main -softWrites -enableParseCache -offline -demoSet"
```

#### Full Conversion
```bash
sbt "importer/runMain org.scalablytyped.converter.Main -softWrites -enableParseCache"
```

### Command Line Options
- `-softWrites`: Only write changed files (better for IDEs)
- `-enableParseCache`: Cache parsed TypeScript files
- `-offline`: Skip fetching updates from DefinitelyTyped
- `-demoSet`: Convert only demo libraries
- `-flavourSlinky`: Use Slinky flavor
- `-flavourJapgolly`: Use scalajs-react flavor
- `-scala212`/`-scala213`: Target Scala version
- `-forceCommit`: Create git commit even in debug mode
- `-dontCleanProject`: Don't reset git repo

### IntelliJ Run Configurations
- **Main All**: Full conversion with all libraries
- **CI Demoset**: Demo set for testing
- **ImporterTest**: Run snapshot tests
- **CI Demoset Slinky/Japgolly**: Flavor-specific demo sets

## Key Files and Locations

### Source Structure
```
core/                           # Core data structures and utilities
├── src/main/scala/
│   └── org/scalablytyped/converter/internal/
│       ├── ts/                # TypeScript AST and utilities
│       │   └── trees.scala    # TypeScript AST definitions
│       └── scalajs/           # Scala.js AST and utilities
│           └── tree.scala     # Scala.js AST definitions

importer-portable/              # Platform-independent conversion logic
├── src/main/scala/
│   └── org/scalablytyped/converter/internal/importer/
│       ├── Phase1ReadTypescript.scala
│       ├── Phase2ToScalaJs.scala
│       └── Phase3Compile.scala

importer/                       # JVM-specific runner and tests
├── src/main/scala/
│   └── org/scalablytyped/converter/
│       └── Main.scala         # Main entry point
└── src/test/
    ├── scala/.../ImporterTest.scala
    └── resources/             # Test TypeScript files

ts/                            # TypeScript parser
└── src/main/scala/.../parser/
    ├── TsParser.scala
    └── TsLexer.scala
```

### Output Structure
```
~/.cache/scalablytyped/        # Default cache location
├── parse/                     # Parse cache
├── npmjs.zip/                 # NPM package metadata
└── ScalablyTyped/            # Generated Scala code
```

## Important Notes

### Performance Considerations
- Parse cache significantly speeds up development
- Use `-softWrites` to avoid IDE reindexing
- Parallel processing controlled by thread pool settings

### Known Limitations
- Generic type mappings not fully expanded
- Some TypeScript patterns have imperfect encodings
- Interface augmentation requires manual casting