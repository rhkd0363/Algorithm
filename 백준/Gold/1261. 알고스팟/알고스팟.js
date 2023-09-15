const filePath = process.platform === "linux" ? "/dev/stdin" : "example.txt";
let input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

let readLine, inputLine = 0;
let N, M, map, visited, dxdy, queue, answer;

class Info {
  constructor(x, y, count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}

readLine = input[inputLine++].split(" ");
M = +readLine[0];
N = +readLine[1];

map = Array.from(Array(N), () => input[inputLine++].split(""));
visited = Array.from(Array(N), () => new Array(M).fill(false));

queue = new Array();
queue.push(new Info(0, 0, 0));
visited[0][0] = true;

dxdy = [[-1, 0],[1, 0],[0, -1],[0, 1]];

while (queue.length) {
  let curr = queue.shift();

  if (curr.x === N - 1 && curr.y === M - 1) {
    answer = curr.count;
    break;
  }

  for (let i = 0; i < 4; i++) {
    let nx = curr.x + dxdy[i][0];
    let ny = curr.y + dxdy[i][1];

    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

    visited[nx][ny] = true;
    queue.push(
      new Info(nx, ny, map[nx][ny] == 1 ? curr.count + 1 : curr.count)
    );
    queue.sort((obj1, obj2) => obj1.count - obj2.count);
  }
}

console.log(answer);