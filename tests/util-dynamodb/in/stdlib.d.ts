interface Int8Array{}
interface Uint8Array{}
interface Array<T>{}
interface Set<T>{}
interface Map<K, V>{}
interface ArrayBuffer{}
interface Blob{}
interface Buffer{}
interface DataView{}

interface Number{}
type Record<K extends keyof any, T> = {
    [P in K]: T;
};
type InstanceType<T extends abstract new (...args: any) => any> = T extends abstract new (...args: any) => infer R ? R : any;