declare namespace std {
    class Queue<T> {
        private container_;
        constructor();
        constructor(container: Queue<T>);
        empty(): boolean;
    }
}
declare namespace std {
    type queue<T> = Queue<T>;
    var queue: typeof Queue;
}