function solution(arr) {
    arr.splice(arr.reduce((acc, curr, idx) => acc[0] > curr ? acc = [curr, idx] : acc, [arr[0], 0])[1],1);
    return arr.length !== 0 ? arr : [-1];
}