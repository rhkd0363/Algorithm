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
    
    public int solution(String[] maps) {
        
        boolean[][] visited_B = new boolean[maps.length][maps[0].length()];
        boolean[][] visited_A = new boolean[maps.length][maps[0].length()];
        
        Queue<Info> queue_B = new LinkedList<>();
        Queue<Info> queue_A = new LinkedList<>();
        
        loop : for(int i=0;i<maps.length;i++)
            for(int j=0;j<maps[i].length();j++)
                if(maps[i].charAt(j) == 'S'){
                    queue_B.add(new Info(i, j, 0));
                    break loop;
                }
        
        boolean flag = false;
        
        int[][] dxdy = {{-1,0},{0,-1},{0,1},{1,0}};

        int answer = 0;
        
        while(!queue_B.isEmpty()){
            Info curr = queue_B.poll();
            
            if(maps[curr.x].charAt(curr.y) == 'L'){
                queue_A.add(new Info(curr.x, curr.y, curr.count));
                break;
            }
            
            if(visited_B[curr.x][curr.y])
                continue;
            
            visited_B[curr.x][curr.y] = true;
            
            for(int i=0;i<4;i++){
                int nx = curr.x + dxdy[i][0];
                int ny = curr.y + dxdy[i][1];
                
                if(nx < 0 || ny < 0 || nx >= visited_B.length || ny >= visited_B[0].length || maps[nx].charAt(ny) == 'X')
                    continue;
                
                queue_B.add(new Info(nx, ny, curr.count+1));
            }
        }
        
        while(!queue_A.isEmpty()){
            Info curr = queue_A.poll();
            
            if(maps[curr.x].charAt(curr.y) == 'E'){
                flag = true;
                answer = curr.count;
                break;
            }
            
            if(visited_A[curr.x][curr.y])
                continue;
            
            visited_A[curr.x][curr.y] = true;
            
            for(int i=0;i<4;i++){
                int nx = curr.x + dxdy[i][0];
                int ny = curr.y + dxdy[i][1];
                
                if(nx < 0 || ny < 0 || nx >= visited_A.length || ny >= visited_A[0].length || maps[nx].charAt(ny) == 'X')
                    continue;
                
                queue_A.add(new Info(nx, ny, curr.count+1));
            }
        }
        
        return flag ? answer : -1;
    }
}