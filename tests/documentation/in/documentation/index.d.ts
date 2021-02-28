
interface Nullability {
    a: number
    b?: number
    c: number | null
    d: number | null | undefined
}

interface Complex {
    a: ((n: number) => void) | string
}

interface Parent<T> {
    t: T
}
interface Child<T1, T2> extends Parent<T1> {
    t2: T2 | undefined
}

interface Branch<T> {
    type: "Branch"
    left: T
    right: T
}

interface Leaf<T>  {
    type: "Leaf"
    value: T
}

type Tree<T> = Branch<T> | Leaf<T>
