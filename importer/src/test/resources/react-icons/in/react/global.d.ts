/*
React projects that don't include the DOM library need these interfaces to compile.
React Native applications use React, but there is no DOM available. The JavaScript runtime
is ES6/ES2015 only. These definitions allow such projects to compile with only `--lib ES6`.
*/

interface Event { }
interface Element { }
interface SVGElement extends Element { }