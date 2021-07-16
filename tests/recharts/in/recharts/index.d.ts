interface Coordinate {
    x: number,
    y: number
}

export declare const rectWithPoints: ({ x: x1, y: y1 }: Coordinate, { x: x2, y: y2 }: Coordinate) => {
    x: number;
    y: number;
    width: number;
    height: number;
};
