interface Person {
    age?: number | null;
    name: string;
}

type PartialPerson = Partial<Person>;
type RequiredPerson = Required<Person>
type ReadonlyPerson = Readonly<Person>
type NamePerson = Pick<Person, "name">
type PersonRecord = Record<"name" | "age", string>
type NonNullablePerson = NonNullable<Person>

declare const foo: () => Person;
type ReturnedPerson = ReturnType<typeof foo>;

declare const newPerson: new() => Person;
type NewedPerson = InstanceType<typeof newPerson>

type Proxify<T> = {
    [P in keyof T]: { get(): T[P]; set(v: T[P]): void }
}
type ProxiedPerson = Proxify<Person>

declare const proxy: ProxiedPerson;

declare interface IPersonRecord extends PersonRecord {}
declare interface IProxiedPerson extends Proxify<Person> {}

type T = Pick<{name: string} | {age: number}, "name" & "age">
type U = Pick<{name: string} & {age: number}, "name" | "age">
type V = Pick<{name: string} & {age: number}, "age">


declare interface CSSProperties {
    color: string;
    fontSize: string;
    fontFamily: string;
    fontWeight: string;
    letterSpacing: string,
    lineHeight: string,
    textTransform: string;
}

type TypographyStyle = (Required<Pick<CSSProperties, "fontFamily" | "fontSize" | "fontWeight" | "color">>) & (Partial<Pick<CSSProperties, "letterSpacing" | "lineHeight" | "textTransform">>)
type TypographyStyleOptions = Partial<TypographyStyle>


type Omit<T, K extends keyof any> = T extends any ? Pick<T, Exclude<keyof T, K>> : never;

type Excluded = Omit<CSSProperties, 'color'>

interface TextMark{
    type: 'text';
}
interface TrailMark {
    type: 'trail';
}

type Mark =
    | TextMark
    | TrailMark;

type Marking = Record<Mark['type'], string>
