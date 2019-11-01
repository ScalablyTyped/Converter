beforeEach(() => {
  jest.resetModules()
})

describe('isIeOrEdge', () => {
  let utils
  beforeEach(async done => {
    utils = await import('./index')
    done()
  })

  it('should return true for IE10', () => {
    const userAgent =
      'Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0; .NET4.0E; .NET4.0C; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)'

    expect(utils.isIeOrEdge(userAgent)).toBe(true)
  })

  it('should return true for IE11', () => {
    const userAgent =
      'Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; rv:11.0) like Gecko'
    expect(utils.isIeOrEdge(userAgent)).toBe(true)
  })

  it('should return true for Edge', () => {
    const userAgent =
      'Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16258'

    expect(utils.isIeOrEdge(userAgent)).toBe(true)
  })

  it('should return false for Chrome', () => {
    const userAgent =
      'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36'

    expect(utils.isIeOrEdge(userAgent)).toBe(false)
  })
})

describe('isKindFile()', () => {
  it('should return true for DataTransferItem of kind "file"', async () => {
    const utils = await import('./index')
    expect(utils.isKindFile({ kind: 'file' })).toBe(true)
    expect(utils.isKindFile({ kind: 'text/html' })).toBe(false)
    expect(utils.isKindFile({})).toBe(false)
    expect(utils.isKindFile(null)).toBe(false)
  })
})

describe('isPropagationStopped()', () => {
  const trueFn = jest.fn(() => true)

  let utils
  beforeEach(async done => {
    utils = await import('./index')
    done()
  })

  it('should return result of isPropagationStopped() if isPropagationStopped exists', () => {
    expect(utils.isPropagationStopped({ isPropagationStopped: trueFn })).toBe(true)
  })

  it('should return value of cancelBubble if isPropagationStopped doesnt exist and cancelBubble exists', () => {
    expect(utils.isPropagationStopped({ cancelBubble: true })).toBe(true)
  })

  it('should return false if isPropagationStopped and cancelBubble are missing', () => {
    expect(utils.isPropagationStopped({})).toBe(false)
  })
})

describe('isEvtWithFiles()', () => {
  let utils
  beforeEach(async done => {
    utils = await import('./index')
    done()
  })

  it('should return true if some dragged types are files', () => {
    expect(utils.isEvtWithFiles({ dataTransfer: { types: ['Files'] } })).toBe(true)
    expect(utils.isEvtWithFiles({ dataTransfer: { types: ['application/x-moz-file'] } })).toBe(true)
    expect(
      utils.isEvtWithFiles({
        dataTransfer: { types: ['Files', 'application/x-moz-file'] }
      })
    ).toBe(true)
    expect(utils.isEvtWithFiles({ dataTransfer: { types: ['text/plain'] } })).toBe(false)
    expect(utils.isEvtWithFiles({ dataTransfer: { types: ['text/html'] } })).toBe(false)
    expect(utils.isEvtWithFiles({ dataTransfer: { types: ['Files', 'application/test'] } })).toBe(
      true
    )
    expect(
      utils.isEvtWithFiles({
        dataTransfer: { types: ['application/x-moz-file', 'application/test'] }
      })
    ).toBe(true)
  })

  it('should return true if the event has a target with files', () => {
    expect(utils.isEvtWithFiles({ target: { files: [] } })).toBe(true)
  })

  it('should return false otherwise', () => {
    expect(utils.isEvtWithFiles({})).toBe(false)
  })
})

describe('composeEventHandlers', () => {
  let utils
  beforeEach(async done => {
    utils = await import('./index')
    done()
  })

  it('returns a fn', () => {
    const fn = utils.composeEventHandlers(() => {})
    expect(typeof fn).toBe('function')
  })

  it('runs every passed fn in order', () => {
    const fn1 = jest.fn()
    const fn2 = jest.fn()
    const fn = utils.composeEventHandlers(fn1, fn2)
    const event = { type: 'click' }
    const data = { ping: true }
    fn(event, data)
    expect(fn1).toHaveBeenCalledWith(event, data)
    expect(fn2).toHaveBeenCalledWith(event, data)
  })

  it('stops after first fn that calls stopPropagation()', () => {
    const fn1 = jest.fn().mockImplementation(event => {
      Object.defineProperty(event, 'cancelBubble', { value: true })
      return event
    })
    const fn2 = jest.fn()
    const fn = utils.composeEventHandlers(fn1, fn2)
    const event = new MouseEvent('click')
    fn(event)
    expect(fn1).toHaveBeenCalledWith(event)
    expect(fn2).not.toHaveBeenCalled()
  })

  it('stops before first fn if bubble is already canceled', () => {
    const fn1 = jest.fn()
    const fn2 = jest.fn()
    const fn = utils.composeEventHandlers(fn1, fn2)
    const event = new MouseEvent('click')
    Object.defineProperty(event, 'cancelBubble', { value: true })
    fn(event)
    expect(fn1).not.toHaveBeenCalled()
    expect(fn2).not.toHaveBeenCalled()
  })
})
