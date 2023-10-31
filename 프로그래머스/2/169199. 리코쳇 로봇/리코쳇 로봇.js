function solution(board) {
    let answer = -1;
    const dxdy = [[-1,0],[1,0],[0,-1],[0,1]];
    const queue = [];
    const visited = Array(board.length);
    let flag = false;
    
    const map = board.map((e,i) =>{
        const line = [...e];
        visited[i] = Array(line.length).fill(false);
        
        if(!flag)
            line.forEach((el,j) =>{
                if(el === 'R'){
                    queue.push([i, j, 0]);
                    visited[i][j] = true;
                    flag = true;
                    return;
                }
            })
        
        return line;
    });
    
    while(queue.length != 0){
        const [x, y, count] = queue.shift();
        
        if(map[x][y] === 'G'){
            answer = count;
            break;
        }

        
        dxdy.forEach((dir)=>{
            let nx = x;
            let ny = y;
            
            while(true){
                if((nx + dir[0] < 0 || ny + dir[1] < 0 || nx + dir[0] >= map.length || ny + dir[1] >= map[0].length)){
                    if(!visited[nx][ny]){
                        queue.push([nx, ny, count+1]);
                        visited[nx][ny] = true;
                    }
                    break;
                }

                if(map[nx + dir[0]][ny + dir[1]] == 'D'){
                    if(!visited[nx][ny]){
                        queue.push([nx,ny, count+1]);
                        visited[nx][ny] = true;
                    }
                    break;
                }
                
                
                nx += dir[0];
                ny += dir[1];
            }
        })
    }

    
    return answer;
}