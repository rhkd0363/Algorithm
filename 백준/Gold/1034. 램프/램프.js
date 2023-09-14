let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let inputLine = 0;
let readLine = input[inputLine++].split(" ");

let N = Number(readLine[0]);
let M = Number(readLine[1]);

let rows = new Array(N);

for (let i = 0; i < N; i++) {
  rows[i] = input[inputLine++];
}

let K = Number(input[inputLine++]);
let answer = 0;
let flag = false;
for (let i = 0; i < N; i++) {
  let count = 0;
  for (let j = 0; j < rows[i].length; j++) count += rows[i][j] == 0 ? 1 : 0;

  if (count % 2 != K % 2) continue;

  let result = 1;
  for (let j = i + 1; j < N; j++) {
    result += rows[i] == rows[j] ? 1 : 0;
  }

  if (count <= K) {
    answer = Math.max(answer, result);
    flag = true;
  }
}

console.log(answer);