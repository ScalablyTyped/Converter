import cx from 'classnames'
import PropTypes from 'prop-types'
import React from 'react'

import {
  childrenUtils,
  customPropTypes,
  getElementType,
  getUnhandledProps,
  SUI,
  useKeyOnly,
  useTextAlignProp,
} from '../../lib'

/**
 * A TestContainer limits content to a maximum width.
 */
function TestContainer(props) {
  const { children, className, content, fluid, text, textAlign } = props
  const classes = cx(
    'ui',
    useKeyOnly(text, 'text'),
    useKeyOnly(fluid, 'fluid'),
    useTextAlignProp(textAlign),
    'testContainer',
    className,
  )
  const rest = getUnhandledProps(TestContainer, props)
  const ElementType = getElementType(TestContainer, props)

  return (
    <ElementType {...rest} className={classes}>
      {childrenUtils.isNil(children) ? content : children}
    </ElementType>
  )
}

TestContainer.propTypes = {
  /** An element type to render as (string or function). */
  as: PropTypes.elementType,

  /** Primary content. */
  children: PropTypes.node,

  /** Additional classes. */
  className: PropTypes.string,

  /** Shorthand for primary content. */
  content: customPropTypes.contentShorthand,

  /** TestContainer has no maximum width. */
  fluid: PropTypes.bool,

  /** Reduce maximum width to more naturally accommodate text. */
  text: PropTypes.bool,

  /** Align TestContainer text. */
  textAlign: PropTypes.oneOf(SUI.TEXT_ALIGNMENTS),


}

export default TestContainer
