package imported

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object scala {
  
  object scalajs {
    
    object js {
      
      @js.native
      class Array[A] ()
        extends js.Object
           with js.Iterable[A] {
        def this(arrayLength: Int) = this()
        
        def apply(index: Int): A = js.native
        
        def concat[B](items: js.Array[_]): js.Array[B] = js.native
        
        def join(seperator: String): String = js.native
        
        def jsIterator(): js.Iterator[A] = js.native
        
        def jsSlice(start: Int, end: Int): js.Array[A] = js.native
        
        def length(): Int = js.native
        def length_=(v: Int): Unit = js.native
        
        def pop(): A = js.native
        
        def push(items: A): Int = js.native
        
        def reverseInPlace(): js.Array[A] = js.native
        
        def shift(): A = js.native
        
        def sort(compareFn: js.Function2[A, A, Int]): js.Array[A] = js.native
        
        def splice(index: Int, deleteCount: Int, items: A): js.Array[A] = js.native
        
        def unshift(items: A): Int = js.native
        
        def update(index: Int, value: A): Unit = js.native
      }
      object Array {
        
        @js.native
        object NativeArray
          extends js.Object {
          
          def from[A](iterable: js.Iterable[A]): js.Array[A] = js.native
          
          def isArray(arg: Any): Boolean = js.native
        }
      }
      
      @js.native
      class BigInt protected ()
        extends js.Object {
        
        def ^(other: js.BigInt): js.BigInt = js.native
        
        def `%`(other: js.BigInt): js.BigInt = js.native
        
        def `&`(other: js.BigInt): js.BigInt = js.native
        
        def `*`(other: js.BigInt): js.BigInt = js.native
        
        def `+`(other: js.BigInt): js.BigInt = js.native
        
        def `-`(other: js.BigInt): js.BigInt = js.native
        
        def `<`(x: js.BigInt): Boolean = js.native
        
        def `<<`(other: js.BigInt): js.BigInt = js.native
        
        def `<=`(x: js.BigInt): Boolean = js.native
        
        def `>`(x: js.BigInt): Boolean = js.native
        
        def `>=`(x: js.BigInt): Boolean = js.native
        
        def `>>`(other: js.BigInt): js.BigInt = js.native
        
        def toLocaleString(locale: String, options: js.BigInt.ToLocaleStringOptions): String = js.native
        
        override def toString(): String = js.native
        
        def `unary_-`(): js.BigInt = js.native
        
        def `unary_~`(): js.BigInt = js.native
        
        def `|`(other: js.BigInt): js.BigInt = js.native
      }
      @js.native
      object BigInt
        extends js.Object {
        
        @js.native
        trait ToLocaleStringOptions
          extends js.Object {
          
          var currency: js.UndefOr[String] = js.native
          
          var currencyDisplay: js.UndefOr[String] = js.native
          
          var localeMatcher: js.UndefOr[String] = js.native
          
          var maximumFractionDigits: js.UndefOr[Int] = js.native
          
          var maximumSignificantDigits: js.UndefOr[Int] = js.native
          
          var minimumFractionDigits: js.UndefOr[Int] = js.native
          
          var minimumIntegerDigits: js.UndefOr[Int] = js.native
          
          var minimumSignificantDigits: js.UndefOr[Int] = js.native
          
          var style: js.UndefOr[String] = js.native
          
          var useGrouping: js.UndefOr[Boolean] = js.native
        }
        
        def apply(value: String): js.BigInt = js.native
        def apply(value: Double): js.BigInt = js.native
        def apply(value: Int): js.BigInt = js.native
        
        def asIntN(width: Int, bigint: js.BigInt): js.BigInt = js.native
        
        def asUintN(width: Int, bigint: js.BigInt): js.BigInt = js.native
      }
      
      @js.native
      class Date ()
        extends js.Object {
        def this(value: String) = this()
        def this(value: Double) = this()
        def this(year: Int, month: Int, date: Int, hours: Int, minutes: Int, seconds: Int, ms: Int) = this()
        
        def getDate(): Double = js.native
        
        def getDay(): Double = js.native
        
        def getFullYear(): Double = js.native
        
        def getHours(): Double = js.native
        
        def getMilliseconds(): Double = js.native
        
        def getMinutes(): Double = js.native
        
        def getMonth(): Double = js.native
        
        def getSeconds(): Double = js.native
        
        def getTime(): Double = js.native
        
        def getTimezoneOffset(): Double = js.native
        
        def getUTCDate(): Double = js.native
        
        def getUTCDay(): Double = js.native
        
        def getUTCFullYear(): Double = js.native
        
        def getUTCHours(): Double = js.native
        
        def getUTCMilliseconds(): Double = js.native
        
        def getUTCMinutes(): Double = js.native
        
        def getUTCMonth(): Double = js.native
        
        def getUTCSeconds(): Double = js.native
        
        def setDate(date: Double): Unit = js.native
        
        def setFullYear(year: Double, month: Double, date: Double): Unit = js.native
        
        def setHours(hours: Double, min: Double, sec: Double, ms: Double): Unit = js.native
        
        def setMilliseconds(ms: Double): Unit = js.native
        
        def setMinutes(min: Double, sec: Double, ms: Double): Unit = js.native
        
        def setMonth(month: Double, date: Double): Unit = js.native
        
        def setSeconds(sec: Double, ms: Double): Unit = js.native
        
        def setTime(time: Double): Unit = js.native
        
        def setUTCDate(date: Double): Unit = js.native
        
        def setUTCFullYear(year: Double, month: Double, date: Double): Unit = js.native
        
        def setUTCHours(hours: Double, min: Double, sec: Double, ms: Double): Unit = js.native
        
        def setUTCMilliseconds(ms: Double): Unit = js.native
        
        def setUTCMinutes(min: Double, sec: Double, ms: Double): Unit = js.native
        
        def setUTCMonth(month: Double, date: Double): Unit = js.native
        
        def setUTCSeconds(sec: Double, ms: Double): Unit = js.native
        
        def toDateString(): String = js.native
        
        def toISOString(): String = js.native
        
        def toJSON(): String = js.native
        def toJSON(key: js.Any): String = js.native
        
        def toLocaleDateString(): String = js.native
        
        def toLocaleTimeString(): String = js.native
        
        def toTimeString(): String = js.native
        
        def toUTCString(): String = js.native
        
        override def valueOf(): Double = js.native
      }
      @js.native
      object Date
        extends js.Object {
        
        def UTC(year: Int, month: Int, date: Int, hours: Int, minutes: Int, seconds: Int, ms: Int): Double = js.native
        
        def apply(): String = js.native
        
        def now(): Double = js.native
        
        def parse(s: String): Double = js.native
      }
      
      @js.native
      sealed trait Dictionary[A]
        extends js.Any
      
      @js.native
      sealed trait Dynamic
        extends js.Any
           with scala.Dynamic {
        
        def ^(that: js.Dynamic): js.Dynamic = js.native
        
        def `%`(that: js.Dynamic): js.Dynamic = js.native
        
        def `&`(that: js.Dynamic): js.Dynamic = js.native
        
        def `&&`(that: js.Dynamic): js.Dynamic = js.native
        
        def `*`(that: js.Dynamic): js.Dynamic = js.native
        
        def `+`(that: js.Dynamic): js.Dynamic = js.native
        
        def `-`(that: js.Dynamic): js.Dynamic = js.native
        
        def `/`(that: js.Dynamic): js.Dynamic = js.native
        
        def `<`(that: js.Dynamic): js.Dynamic = js.native
        
        def `<<`(that: js.Dynamic): js.Dynamic = js.native
        
        def `<=`(that: js.Dynamic): js.Dynamic = js.native
        
        def `>`(that: js.Dynamic): js.Dynamic = js.native
        
        def `>=`(that: js.Dynamic): js.Dynamic = js.native
        
        def `>>`(that: js.Dynamic): js.Dynamic = js.native
        
        def `>>>`(that: js.Dynamic): js.Dynamic = js.native
        
        def apply(args: js.Any): js.Dynamic = js.native
        
        def applyDynamic(name: String): js.Function1[js.Any, js.Dynamic] = js.native
        
        def selectDynamic(name: String): js.Dynamic = js.native
        
        def `unary_!`(): js.Dynamic = js.native
        
        def `unary_+`(): js.Dynamic = js.native
        
        def `unary_-`(): js.Dynamic = js.native
        
        def `unary_~`(): js.Dynamic = js.native
        
        def updateDynamic(name: String): js.Function1[js.Any, Unit] = js.native
        
        def `|`(that: js.Dynamic): js.Dynamic = js.native
        
        def `||`(that: js.Dynamic): js.Dynamic = js.native
      }
      object Dynamic {
        
        @js.native
        object global
          extends js.Any
             with scala.Dynamic {
          
          def apply(args: js.Any): js.Dynamic = js.native
          
          def applyDynamic(name: String): js.Function1[js.Any, js.Dynamic] = js.native
          
          def selectDynamic(name: String): js.Dynamic = js.native
          
          def updateDynamic(name: String): js.Function1[js.Any, Unit] = js.native
        }
      }
      
      @js.native
      class Error protected ()
        extends js.Object {
        def this(message0: String) = this()
        
        val message: String = js.native
        
        val message0: String = js.native
        
        val name: String = js.native
      }
      @js.native
      object Error
        extends js.Object {
        
        def apply(message: String): js.Error = js.native
      }
      
      @js.native
      class EvalError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object EvalError
        extends js.Object {
        
        def apply(message: String): js.EvalError = js.native
      }
      
      @js.native
      class Function protected ()
        extends js.Object {
        def this(args: String) = this()
        
        val args: String = js.native
        
        def bind(thisArg: js.Any, argArray: js.Any): js.Dynamic = js.native
        
        def call(thisArg: js.Any, argArray: js.Any): js.Dynamic = js.native
        
        val length: Int = js.native
      }
      @js.native
      object Function
        extends js.Object {
        
        def apply(args: String): js.Function = js.native
      }
      
      @js.native
      trait Function0[R]
        extends js.Function {
        
        def apply(): R = js.native
      }
      
      @js.native
      trait Function1[T1, R]
        extends js.Function {
        
        def apply(arg1: T1): R = js.native
      }
      
      @js.native
      trait Function10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10
        ): R = js.native
      }
      
      @js.native
      trait Function11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11
        ): R = js.native
      }
      
      @js.native
      trait Function12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12
        ): R = js.native
      }
      
      @js.native
      trait Function13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13
        ): R = js.native
      }
      
      @js.native
      trait Function14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14
        ): R = js.native
      }
      
      @js.native
      trait Function15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15
        ): R = js.native
      }
      
      @js.native
      trait Function16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16
        ): R = js.native
      }
      
      @js.native
      trait Function17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17
        ): R = js.native
      }
      
      @js.native
      trait Function18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18
        ): R = js.native
      }
      
      @js.native
      trait Function19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19
        ): R = js.native
      }
      
      @js.native
      trait Function2[T1, T2, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2): R = js.native
      }
      
      @js.native
      trait Function20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19,
          arg20: T20
        ): R = js.native
      }
      
      @js.native
      trait Function21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19,
          arg20: T20,
          arg21: T21
        ): R = js.native
      }
      
      @js.native
      trait Function22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R]
        extends js.Function {
        
        def apply(
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19,
          arg20: T20,
          arg21: T21,
          arg22: T22
        ): R = js.native
      }
      
      @js.native
      trait Function3[T1, T2, T3, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3): R = js.native
      }
      
      @js.native
      trait Function4[T1, T2, T3, T4, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4): R = js.native
      }
      
      @js.native
      trait Function5[T1, T2, T3, T4, T5, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5): R = js.native
      }
      
      @js.native
      trait Function6[T1, T2, T3, T4, T5, T6, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6): R = js.native
      }
      
      @js.native
      trait Function7[T1, T2, T3, T4, T5, T6, T7, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, arg7: T7): R = js.native
      }
      
      @js.native
      trait Function8[T1, T2, T3, T4, T5, T6, T7, T8, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, arg7: T7, arg8: T8): R = js.native
      }
      
      @js.native
      trait Function9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]
        extends js.Function {
        
        def apply(arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, arg7: T7, arg8: T8, arg9: T9): R = js.native
      }
      
      @js.native
      trait Iterable[A]
        extends js.Object {
        
        def jsIterator(): js.Iterator[A] = js.native
      }
      
      @js.native
      trait Iterator[A]
        extends js.Object {
        
        def next(): js.Iterator.Entry[A] = js.native
      }
      object Iterator {
        
        @js.native
        trait Entry[A]
          extends js.Object {
          
          def done(): Boolean = js.native
          
          def value(): A = js.native
        }
      }
      
      object JSConverters {
        
        @js.native
        class IterableAdapter[T] protected ()
          extends js.Object
             with js.Iterable[T] {
          def this(col: scala.collection.Iterable[T]) = this()
          
          val col: scala.collection.Iterable[T] = js.native
          
          def jsIterator(): js.Iterator[T] = js.native
        }
        
        @js.native
        class IteratorAdapter[T] protected ()
          extends js.Object
             with js.Iterator[T] {
          def this(it: scala.collection.Iterator[T]) = this()
          
          val it: scala.collection.Iterator[T] = js.native
          
          def next(): js.Iterator.Entry[T] = js.native
        }
      }
      
      @js.native
      trait JSNumberOps
        extends js.Any {
        
        def toExponential(): String = js.native
        def toExponential(fractionDigits: Int): String = js.native
        
        def toFixed(): String = js.native
        def toFixed(fractionDigits: Int): String = js.native
        
        def toPrecision(): String = js.native
        def toPrecision(precision: Int): String = js.native
        
        def toString(radix: Int): String = js.native
      }
      
      @js.native
      object JSON
        extends js.Object {
        
        def parse(text: String, reviver: js.Function2[js.Any, js.Any, js.Any]): js.Dynamic = js.native
        
        def stringify(value: js.Any, replacer: js.Array[js.Any]): String = js.native
        def stringify(value: js.Any, replacer: js.Array[js.Any], space: Int | String): String = js.native
        def stringify(value: js.Any, replacer: js.Function2[String, js.Any, js.Any], space: Int | String): String = js.native
      }
      
      @js.native
      trait JSStringOps
        extends js.Any {
        
        def jsIndexOf(searchString: String): Int = js.native
        def jsIndexOf(searchString: String, position: Int): Int = js.native
        
        def jsLastIndexOf(searchString: String): Int = js.native
        def jsLastIndexOf(searchString: String, position: Int): Int = js.native
        
        def jsReplace(searchValue: String, replaceValue: String): String = js.native
        def jsReplace(searchValue: String, replaceValue: js.Any): String = js.native
        def jsReplace(searchValue: js.RegExp, replaceValue: String): String = js.native
        def jsReplace(searchValue: js.RegExp, replaceValue: js.Any): String = js.native
        
        def jsSlice(start: Int): String = js.native
        def jsSlice(start: Int, end: Int): String = js.native
        
        def jsSplit(separator: String): js.Array[String] = js.native
        def jsSplit(separator: String, limit: Int): js.Array[String] = js.native
        def jsSplit(separator: js.RegExp): js.Array[String] = js.native
        def jsSplit(separator: js.RegExp, limit: Int): js.Array[String] = js.native
        
        def jsSubstring(start: Int): String = js.native
        def jsSubstring(start: Int, end: Int): String = js.native
        
        def localeCompare(that: String): Int = js.native
        
        def `match`(regexp: String): js.Array[String] = js.native
        def `match`(regexp: js.RegExp): js.Array[String] = js.native
        
        def normalize(): String = js.native
        def normalize(form: js.UnicodeNormalizationForm): String = js.native
        
        def search(regexp: String): Int = js.native
        def search(regexp: js.RegExp): Int = js.native
        
        def toLocaleLowerCase(): String = js.native
        
        def toLocaleUpperCase(): String = js.native
      }
      
      @js.native
      class Map[K, V] ()
        extends js.Object
           with js.Iterable[js.Tuple2[K, V]] {
        def this(array: js.Iterable[js.Tuple2[K, V]]) = this()
        
        def clear(): Unit = js.native
        
        def delete(key: K): Boolean = js.native
        
        override def jsIterator(): js.Iterator[js.Tuple2[K, V]] = js.native
        
        def size(): Int = js.native
      }
      object Map {
        
        @js.native
        trait Raw[K, V]
          extends js.Object {
          
          def get(key: K): V = js.native
          
          def has(key: K): Boolean = js.native
          
          def keys(): js.Iterator[K] = js.native
          
          def set(key: K, value: V): js.Map[K, V] = js.native
        }
      }
      
      @js.native
      object Math
        extends js.Object {
        
        val E: Double = js.native
        
        val LN10: Double = js.native
        
        val LN2: Double = js.native
        
        val LOG10E: Double = js.native
        
        val LOG2E: Double = js.native
        
        val PI: Double = js.native
        
        val SQRT1_2: Double = js.native
        
        val SQRT2: Double = js.native
        
        def abs(x: Double): Double = js.native
        def abs(x: Int): Int = js.native
        
        def acos(x: Double): Double = js.native
        
        def asin(x: Double): Double = js.native
        
        def atan(x: Double): Double = js.native
        
        def atan2(y: Double, x: Double): Double = js.native
        
        def cbrt(x: Double): Double = js.native
        
        def ceil(x: Double): Double = js.native
        
        def cos(x: Double): Double = js.native
        
        def cosh(x: Double): Double = js.native
        
        def exp(x: Double): Double = js.native
        
        def expm1(x: Double): Double = js.native
        
        def floor(x: Double): Double = js.native
        
        def hypot(x: Double): Double = js.native
        
        def log(x: Double): Double = js.native
        
        def log10(x: Double): Double = js.native
        
        def log1p(x: Double): Double = js.native
        
        def max(value1: Int, values: Int): Int = js.native
        def max(values: Double): Double = js.native
        
        def min(value1: Int, values: Int): Int = js.native
        def min(values: Double): Double = js.native
        
        def pow(x: Double, y: Double): Double = js.native
        
        def random(): Double = js.native
        
        def round(x: Double): Double = js.native
        
        def sin(x: Double): Double = js.native
        
        def sinh(x: Double): Double = js.native
        
        def sqrt(x: Double): Double = js.native
        
        def tan(x: Double): Double = js.native
        
        def tanh(x: Double): Double = js.native
      }
      
      @js.native
      class Object ()
        extends js.Any {
        def this(value: Any) = this()
        
        def hasOwnProperty(v: String): Boolean = js.native
        
        def isPrototypeOf(v: js.Object): Boolean = js.native
        
        def propertyIsEnumerable(v: String): Boolean = js.native
        
        def toLocaleString(): String = js.native
        
        def valueOf(): Any = js.native
      }
      
      @js.native
      class Promise[A] protected ()
        extends js.Object
           with js.Thenable[A] {
        def this(executor: js.Function2[js.Function1[A | js.Thenable[A], _], js.Function1[Any, _], _]) = this()
        
        def `catch`[B](onRejected: js.UndefOr[js.Function1[Any, B | js.Thenable[B]]]): js.Promise[B] = js.native
        
        val executor: js.Function2[js.Function1[A | js.Thenable[A], _], js.Function1[Any, _], _] = js.native
        
        def `then`[B](
          onFulfilled: js.Function1[A, B | js.Thenable[B]],
          onRejected: js.UndefOr[js.Function1[Any, B | js.Thenable[B]]]
        ): js.Promise[B] = js.native
        def `then`[B](onFulfilled: Unit, onRejected: js.UndefOr[js.Function1[Any, B | js.Thenable[B]]]): js.Promise[B] = js.native
      }
      @js.native
      object Promise
        extends js.Object {
        
        def all[A](promises: js.Iterable[js.Promise[A]]): js.Promise[js.Array[A]] = js.native
        
        def race[A](promises: js.Iterable[js.Promise[A]]): js.Promise[A] = js.native
        
        def reject(reason: Any): js.Promise[scala.Nothing] = js.native
        
        def resolve[A](value: A | js.Thenable[A]): js.Promise[A] = js.native
      }
      
      @js.native
      trait PropertyDescriptor
        extends js.Object {
        
        var configurable: js.UndefOr[Boolean] = js.native
        
        var enumerable: js.UndefOr[Boolean] = js.native
        
        var get: js.UndefOr[js.Function0[Any]] = js.native
        
        var set: js.UndefOr[js.Function1[Any, Any]] = js.native
        
        var value: js.UndefOr[Any] = js.native
        
        var writable: js.UndefOr[Boolean] = js.native
      }
      
      @js.native
      class RangeError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object RangeError
        extends js.Object {
        
        def apply(message: String): js.RangeError = js.native
      }
      
      @js.native
      class ReferenceError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object ReferenceError
        extends js.Object {
        
        def apply(message: String): js.ReferenceError = js.native
      }
      
      @js.native
      class RegExp protected ()
        extends js.Object {
        def this(pattern: js.RegExp) = this()
        def this(pattern: String, flags: String) = this()
        
        def exec(string: String): js.RegExp.ExecResult = js.native
        
        val flags: String = js.native
        
        val global: Boolean = js.native
        
        val ignoreCase: Boolean = js.native
        
        var lastIndex: Int = js.native
        
        val multiline: Boolean = js.native
        
        val pattern: String = js.native
        
        val source: String = js.native
        
        def test(string: String): Boolean = js.native
      }
      @js.native
      object RegExp
        extends js.Object {
        
        @js.native
        trait ExecResult
          extends js.Array[js.UndefOr[String]] {
          
          var groups: js.UndefOr[js.Dictionary[js.UndefOr[String]]] = js.native
          
          var index: Int = js.native
          
          var input: String = js.native
        }
        
        def apply(pattern: String, flags: String): js.RegExp = js.native
      }
      
      @js.native
      class Set[T] ()
        extends js.Object
           with js.Iterable[T] {
        def this(array: js.Iterable[T]) = this()
        
        def clear(): Unit = js.native
        
        override def jsIterator(): js.Iterator[T] = js.native
        
        def size(): Int = js.native
      }
      object Set {
        
        @js.native
        trait Raw[T]
          extends js.Object {
          
          def add(value: T): this.type = js.native
          
          def delete(value: T): Boolean = js.native
          
          def has(value: T): Boolean = js.native
        }
      }
      
      @js.native
      sealed trait Symbol
        extends js.Any
      @js.native
      object Symbol
        extends js.Object {
        
        def apply(): js.Symbol = js.native
        def apply(description: String): js.Symbol = js.native
        
        def forKey(key: String): js.Symbol = js.native
        
        val hasInstance: js.Symbol = js.native
        
        val isConcatSpreadable: js.Symbol = js.native
        
        val iterator: js.Symbol = js.native
        
        def keyFor(sym: js.Symbol): js.UndefOr[String] = js.native
        
        val `match`: js.Symbol = js.native
        
        val replace: js.Symbol = js.native
        
        val search: js.Symbol = js.native
        
        val species: js.Symbol = js.native
        
        val split: js.Symbol = js.native
        
        val toPrimitive: js.Symbol = js.native
        
        val toStringTag: js.Symbol = js.native
        
        val unscopables: js.Symbol = js.native
      }
      
      @js.native
      class SyntaxError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object SyntaxError
        extends js.Object {
        
        def apply(message: String): js.SyntaxError = js.native
      }
      
      @js.native
      trait Thenable[A]
        extends js.Object {
        
        def `then`[B](
          onFulfilled: js.Function1[A, B | js.Thenable[B]],
          onRejected: js.UndefOr[js.Function1[Any, B | js.Thenable[B]]]
        ): js.Thenable[B] = js.native
        def `then`[B](onFulfilled: Unit, onRejected: js.UndefOr[js.Function1[Any, B | js.Thenable[B]]]): js.Thenable[B] = js.native
      }
      
      @js.native
      trait ThisFunction
        extends js.Function
      
      @js.native
      trait ThisFunction0[T0, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0): R = js.native
      }
      
      @js.native
      trait ThisFunction1[T0, T1, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1): R = js.native
      }
      
      @js.native
      trait ThisFunction10[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction11[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction12[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction13[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction14[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction15[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction16[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction17[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction18[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction19[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction2[T0, T1, T2, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2): R = js.native
      }
      
      @js.native
      trait ThisFunction20[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19,
          arg20: T20
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction21[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9,
          arg10: T10,
          arg11: T11,
          arg12: T12,
          arg13: T13,
          arg14: T14,
          arg15: T15,
          arg16: T16,
          arg17: T17,
          arg18: T18,
          arg19: T19,
          arg20: T20,
          arg21: T21
        ): R = js.native
      }
      
      @js.native
      trait ThisFunction3[T0, T1, T2, T3, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3): R = js.native
      }
      
      @js.native
      trait ThisFunction4[T0, T1, T2, T3, T4, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3, arg4: T4): R = js.native
      }
      
      @js.native
      trait ThisFunction5[T0, T1, T2, T3, T4, T5, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5): R = js.native
      }
      
      @js.native
      trait ThisFunction6[T0, T1, T2, T3, T4, T5, T6, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6): R = js.native
      }
      
      @js.native
      trait ThisFunction7[T0, T1, T2, T3, T4, T5, T6, T7, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, arg7: T7): R = js.native
      }
      
      @js.native
      trait ThisFunction8[T0, T1, T2, T3, T4, T5, T6, T7, T8, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(thisArg: T0, arg1: T1, arg2: T2, arg3: T3, arg4: T4, arg5: T5, arg6: T6, arg7: T7, arg8: T8): R = js.native
      }
      
      @js.native
      trait ThisFunction9[T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R]
        extends js.Function
           with js.ThisFunction {
        
        def apply(
          thisArg: T0,
          arg1: T1,
          arg2: T2,
          arg3: T3,
          arg4: T4,
          arg5: T5,
          arg6: T6,
          arg7: T7,
          arg8: T8,
          arg9: T9
        ): R = js.native
      }
      
      @js.native
      sealed trait Tuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _18: T18 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _18: T18 = js.native
        
        val _19: T19 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple2[T1, T2]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
      }
      
      @js.native
      sealed trait Tuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _18: T18 = js.native
        
        val _19: T19 = js.native
        
        val _2: T2 = js.native
        
        val _20: T20 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _18: T18 = js.native
        
        val _19: T19 = js.native
        
        val _2: T2 = js.native
        
        val _20: T20 = js.native
        
        val _21: T21 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _10: T10 = js.native
        
        val _11: T11 = js.native
        
        val _12: T12 = js.native
        
        val _13: T13 = js.native
        
        val _14: T14 = js.native
        
        val _15: T15 = js.native
        
        val _16: T16 = js.native
        
        val _17: T17 = js.native
        
        val _18: T18 = js.native
        
        val _19: T19 = js.native
        
        val _2: T2 = js.native
        
        val _20: T20 = js.native
        
        val _21: T21 = js.native
        
        val _22: T22 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      sealed trait Tuple3[T1, T2, T3]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
      }
      
      @js.native
      sealed trait Tuple4[T1, T2, T3, T4]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
      }
      
      @js.native
      sealed trait Tuple5[T1, T2, T3, T4, T5]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
      }
      
      @js.native
      sealed trait Tuple6[T1, T2, T3, T4, T5, T6]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
      }
      
      @js.native
      sealed trait Tuple7[T1, T2, T3, T4, T5, T6, T7]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
      }
      
      @js.native
      sealed trait Tuple8[T1, T2, T3, T4, T5, T6, T7, T8]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
      }
      
      @js.native
      sealed trait Tuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9]
        extends js.Object {
        
        val _1: T1 = js.native
        
        val _2: T2 = js.native
        
        val _3: T3 = js.native
        
        val _4: T4 = js.native
        
        val _5: T5 = js.native
        
        val _6: T6 = js.native
        
        val _7: T7 = js.native
        
        val _8: T8 = js.native
        
        val _9: T9 = js.native
      }
      
      @js.native
      class TypeError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object TypeError
        extends js.Object {
        
        def apply(message: String): js.TypeError = js.native
      }
      
      @js.native
      class URIError protected ()
        extends js.Error {
        def this(message: String) = this()
        
        val message: String = js.native
      }
      @js.native
      object URIError
        extends js.Object {
        
        def apply(message: String): js.URIError = js.native
      }
      
      @js.native
      object URIUtils
        extends js.Object {
        
        def decodeURI(encodedURI: String): String = js.native
        
        def decodeURIComponent(encodedURIComponent: String): String = js.native
        
        def encodeURI(uri: String): String = js.native
        
        def encodeURIComponent(uriComponent: String): String = js.native
      }
      
      @js.native
      sealed trait UnicodeNormalizationForm
        extends js.Any
      
      object WrappedDictionary {
        
        @js.native
        trait DictionaryRawApply[A]
          extends js.Object {
          
          def rawApply(key: String): A = js.native
          
          def rawUpdate(key: String, value: A): Unit = js.native
        }
      }
      
      object special {
        
        @js.native
        trait FullyDynamicProps
          extends js.Object {
          
          def update(prop: Any, value: Any): Unit = js.native
        }
      }
      
      object timers {
        
        @js.native
        object RawTimers
          extends js.Object {
          
          def clearInterval(handle: js.timers.SetIntervalHandle): Unit = js.native
          
          def clearTimeout(handle: js.timers.SetTimeoutHandle): Unit = js.native
          
          def setInterval(handler: js.Function0[Any], interval: Double): js.timers.SetIntervalHandle = js.native
          
          def setTimeout(handler: js.Function0[Any], interval: Double): js.timers.SetTimeoutHandle = js.native
        }
        
        @js.native
        sealed trait SetIntervalHandle
          extends js.Any
        
        @js.native
        sealed trait SetTimeoutHandle
          extends js.Any
      }
      
      object typedarray {
        
        @js.native
        class ArrayBuffer protected ()
          extends js.Object {
          def this(length: Int) = this()
          
          val byteLength: Int = js.native
          
          val length: Int = js.native
          
          def slice(begin: Int, end: Int): js.typedarray.ArrayBuffer = js.native
        }
        
        @js.native
        trait ArrayBufferView
          extends js.Object {
          
          val buffer: js.typedarray.ArrayBuffer = js.native
          
          val byteLength: Int = js.native
          
          val byteOffset: Int = js.native
        }
        
        @js.native
        class BigInt64Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[js.BigInt, js.typedarray.BigInt64Array] {
          def this(array: js.Iterable[js.BigInt]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.BigInt64Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class BigUint64Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[js.BigInt, js.typedarray.BigUint64Array] {
          def this(array: js.Iterable[js.BigInt]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.BigUint64Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class DataView protected ()
          extends js.Object
             with js.typedarray.ArrayBufferView {
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, byteLength: Int) = this()
          
          val buffer: js.typedarray.ArrayBuffer = js.native
          
          val byteLength: Int = js.native
          
          val byteOffset: Int = js.native
          
          def getFloat32(byteOffset: Int, littleEndian: Boolean): Float = js.native
          
          def getFloat64(byteOffset: Int, littleEndian: Boolean): Double = js.native
          
          def getInt16(byteOffset: Int, littleEndian: Boolean): Short = js.native
          
          def getInt32(byteOffset: Int, littleEndian: Boolean): Int = js.native
          
          def getInt8(byteOffset: Int): Byte = js.native
          
          def getUint16(byteOffset: Int, littleEndian: Boolean): Int = js.native
          
          def getUint32(byteOffset: Int, littleEndian: Boolean): Double = js.native
          
          def getUint8(byteOffset: Int): Short = js.native
          
          def setFloat32(byteOffset: Int, value: Float, littleEndian: Boolean): Unit = js.native
          
          def setFloat64(byteOffset: Int, value: Double, littleEndian: Boolean): Unit = js.native
          
          def setInt16(byteOffset: Int, value: Short, littleEndian: Boolean): Unit = js.native
          
          def setInt32(byteOffset: Int, value: Int, littleEndian: Boolean): Unit = js.native
          
          def setInt8(byteOffset: Int, value: Byte): Unit = js.native
          
          def setUint16(byteOffset: Int, value: Int, littleEndian: Boolean): Unit = js.native
          
          def setUint32(byteOffset: Int, value: Double, littleEndian: Boolean): Unit = js.native
          
          def setUint8(byteOffset: Int, value: Short): Unit = js.native
        }
        
        @js.native
        class Float32Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Float, js.typedarray.Float32Array] {
          def this(array: js.Iterable[Float]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Float32Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Float64Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Double, js.typedarray.Float64Array] {
          def this(array: js.Iterable[Double]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Float64Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Int16Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Short, js.typedarray.Int16Array] {
          def this(array: js.Iterable[Short]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Int16Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Int32Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Int, js.typedarray.Int32Array] {
          def this(array: js.Iterable[Int]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Int32Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Int8Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Byte, js.typedarray.Int8Array] {
          def this(array: js.Iterable[Byte]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Int8Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        trait TypedArray[T, Repr]
          extends js.Object
             with js.typedarray.ArrayBufferView
             with js.Iterable[T] {
          
          def apply(index: Int): T = js.native
          
          def fill(value: T): Unit = js.native
          def fill(value: T, start: Int): Unit = js.native
          def fill(value: T, start: Int, end: Int): Unit = js.native
          
          def get(index: Int): T = js.native
          
          def jsIterator(): js.Iterator[T] = js.native
          
          val length: Int = js.native
          
          def set(array: js.Array[_]): Unit = js.native
          def set(array: js.Array[_], offset: Int): Unit = js.native
          def set(index: Int, value: T): Unit = js.native
          def set(typedArray: Repr): Unit = js.native
          def set(typedArray: Repr, offset: Int): Unit = js.native
          
          def subarray(begin: Int, end: Int): Repr = js.native
          
          def update(index: Int, value: T): Unit = js.native
        }
        
        @js.native
        trait TypedArrayStatic[T, Repr]
          extends js.Object {
          
          val BYTES_PER_ELEMENT: Int = js.native
          
          def from(iterable: js.Iterable[T]): Repr = js.native
          def from[E](iterable: js.Iterable[E], mapFn: js.Function1[E, T]): Repr = js.native
          def from[D, E](iterable: js.Iterable[E], mapFn: js.ThisFunction1[D, E, T], thisArg: D): Repr = js.native
          
          def of(items: T): Repr = js.native
        }
        
        @js.native
        class Uint16Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Int, js.typedarray.Uint16Array] {
          def this(array: js.Iterable[Int]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Uint16Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Uint32Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Double, js.typedarray.Uint32Array] {
          def this(array: js.Iterable[Double]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Uint32Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Uint8Array protected ()
          extends js.Object
             with js.typedarray.TypedArray[Short, js.typedarray.Uint8Array] {
          def this(array: js.Iterable[Short]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Uint8Array) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
        
        @js.native
        class Uint8ClampedArray protected ()
          extends js.Object
             with js.typedarray.TypedArray[Int, js.typedarray.Uint8ClampedArray] {
          def this(array: js.Iterable[Int]) = this()
          def this(length: Int) = this()
          def this(typedArray: js.typedarray.Uint8ClampedArray) = this()
          def this(buffer: js.typedarray.ArrayBuffer, byteOffset: Int, length: Int) = this()
        }
      }
    }
    
    object runtime {
      
      @js.native
      sealed trait LinkingInfo
        extends js.Object {
        
        val assumingES6: Boolean = js.native
        
        val fileLevelThis: Any = js.native
        
        val linkerVersion: String = js.native
        
        val productionMode: Boolean = js.native
      }
    }
  }
}
