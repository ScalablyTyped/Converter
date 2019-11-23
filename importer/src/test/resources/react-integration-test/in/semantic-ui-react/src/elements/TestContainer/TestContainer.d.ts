import * as React from 'react'
import { SemanticShorthandContent, SemanticTEXTALIGNMENTS } from '../../generic'

export interface TestContainerProps extends StrictTestContainerProps {
  [key: string]: any
}

export interface StrictTestContainerProps {
  /** An element type to render as (string or function). */
  as?: any

  /** Primary content. */
  children?: React.ReactNode

  /** Additional classes. */
  className?: string

  /** Shorthand for primary content. */
  content?: SemanticShorthandContent

  /** TestContainer has no maximum width. */
  fluid?: boolean

  /** Reduce maximum width to more naturally accommodate text. */
  text?: boolean

  /** Describes how the text inside this component should be aligned. */
  textAlign?: SemanticTEXTALIGNMENTS

  /**Should be Callback*/
  requiredFn0Void: () => void

  /**Should be CallbackTo[Number]*/
  requiredFn0Number: () => number

  /**Should be (x:Number) => Callback*/
  requiredFn1Void: (x: number) => void

  /**Should be (x:Number) => CallbackTo[Number]*/
  requiredFn1Number: (x: number) => number

  /**Should be Callback*/
  optFn0Void?: () => void

  /**Should be CallbackTo[Number]*/
  optFn0Number?: () => number

  /**Should be (x:Number) => Callback*/
  optFn1Void?: (x: number) => void

  /**Should be (x:Number) => CallbackTo[Number]*/
  optFn1Number?: (x: number) => number
}

declare const TestContainer: React.StatelessComponent<TestContainerProps>

export default TestContainer
