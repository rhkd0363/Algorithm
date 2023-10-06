const filePath = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(filePath).toString().trim().split("\n");

const K = input[0];
const arr = [...input[1].split(" ")];
const check = new Array(arr.length);
let len = Math.pow(2, K);

for (let i = 0; i < K; i++) {
  len = parseInt(len / 2);
  for (let j = len - 1; j < arr.length; j += len) {
    if (!check[j]) {
      process.stdout.write(arr[j] + " ");
      check[j] = true;
    }
  }
  console.log();
}