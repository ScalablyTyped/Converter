import {ElementType, ReactNode, ReactElement} from 'react'

type Not<T> = {
    [key in keyof T]?: never
}

type MutuallyExclusive<T, U> = (T & Not<U>) | (U & Not<T>)

declare namespace ReactMarkdown {
    type LinkTargetResolver = (uri: string, text: string, title?: string) => string

    type Renderer<T> = (props: T) => ElementType<T>
    interface Renderers {
        [key: string]: string | Renderer<any>
    }

    interface ReactMarkdownPropsBase {
        readonly className?: string
        readonly allowNode?: (index: number) => boolean
        readonly linkTarget?: string | LinkTargetResolver
        readonly transformLinkUri?:
            | ((uri: string, children?: ReactNode, title?: string) => string)
            | null
    }

    interface SourceProp {
        /** @deprecated use children */
        readonly source: string
    }

    interface ChildrenProp {
        readonly children: string
    }


    type ReactMarkdownProps = ReactMarkdownPropsBase &
        MutuallyExclusive<ChildrenProp, SourceProp>

    const renderers: Renderers
    function uriTransformer(uri: string): string
}

declare function ReactMarkdown(props: ReactMarkdown.ReactMarkdownProps): ReactElement

export = ReactMarkdown
