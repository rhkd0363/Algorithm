const filePath = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs").readFileSync(filePath).toString().trim().split("\n");
let N = input[0];
let answer = 0;
[...check] = Array.from(Array(101), () => false);
input[1].split(" ").forEach((number) => {
  if (check[number]) answer++;
  else check[number] = true;
});
console.log(answer);