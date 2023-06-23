import java.util.*;

class Solution {
    static class Info{
        int x;
        int y;
        int count;
        
        public Info(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static String[] map;
    static boolean flag;
    static Info pos;
    
    public int solution(String[] maps) {        
        map = maps;
        flag = false;
        
        loop : for(int i=0;i<maps.length;i++)
            for(int j=0;j<maps[i].length();j++)
                if(maps[i].charAt(j) == 'S'){
                    pos = BFS(new Info(i, j, 0),maps.length, maps[0].length(), 'L');
                    break loop;
                }
        
        if(flag == false)
            return -1;
        
        flag = false;
        
        int answer = 0;
        
        pos = BFS(pos, maps.length, maps[0].length(), 'E');
        
        answer = pos.count;
        
        return flag ? answer : -1;
    }
    
    static Info BFS(Info info, int rowLen, int colLen, char target){
        Queue<Info> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLen][colLen];
        int[][] dxdy = {{-1,0},{0,-1},{0,1},{1,0}};
        
        queue.add(info);
        
        while(!queue.isEmpty()){
            Info curr = queue.poll();
            
            if(map[curr.x].charAt(curr.y) == target){
                flag = true;
            
                return curr;
            }
            
            if(visited[curr.x][curr.y])
                continue;
            
            visited[curr.x][curr.y] = true;
            
            for(int i=0;i<4;i++){
                int nx = curr.x + dxdy[i][0];
                int ny = curr.y + dxdy[i][1];
                
                if(nx < 0 || ny < 0 || nx >= rowLen || ny >= colLen || map[nx].charAt(ny) == 'X')
                    continue;
                
                queue.add(new Info(nx, ny, curr.count+1));
            }
        }  
        return new Info(0,0,-1);
    }
    
}