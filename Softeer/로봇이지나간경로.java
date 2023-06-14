import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];

        for(int i=0;i<H;i++){  
            String inputLine = br.readLine();
            for(int j=0;j<W;j++){
                map[i][j] = inputLine.charAt(j);
            }
        }

        int[] start = new int[2];

        int[][] drdc = {{-1,0},{0,1},{1,0},{0,-1}};

        point : for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == '#'){
                    int count = 0;
                    for(int k=0;k<4;k++){
                        int nr = i + drdc[k][0];
                        int nc = j + drdc[k][1];

                        if(nr < 0 || nc < 0 || nr >= H || nc >= W)
                            continue;

                        if(map[nr][nc] == '#')
                            count++;
                    }

                    if(count == 1){
                        start = new int[]{i,j};
                        break point;
                    }
                }
            }
        }


        String commandList = "";
        int[] currPos = new int[]{start[0],start[1]};
        char dir = ' ';
        int currDir = 0;

        for(int k=0;k<4;k++){
            int nr = start[0] + drdc[k][0];
            int nc = start[1] + drdc[k][1];

            if(nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == '.')
                continue;

            if(k == 0) dir = '^';
            else if(k == 1) dir='>';   
            else if(k == 2) dir='v';   
            else dir='<';
            currDir = k;   
        }


        loop: while(true){   
            int tr = currPos[0]+drdc[currDir][0]; 
            int tc = currPos[1]+drdc[currDir][1]; 

            if(tr >= 0 && tc >= 0 && tr < H && tc < W && map[tr][tc] == '#'){
                commandList += "A";
                currPos[0] += drdc[currDir][0] *2;
                currPos[1] += drdc[currDir][1] *2;

                continue;
            }

            for(int i=0;i<4;i++){
                int nr = currPos[0]+drdc[i][0]; 
                int nc = currPos[1]+drdc[i][1]; 

                if(nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == '.')
                    continue;

                if((i == 0 && currDir == 2 )|| (i == 1 && currDir == 3 ) || (i == 2 && currDir == 0 )||(i == 3 && currDir == 1 )){
                    continue;
                }

                if(i == currDir){ //전진
                    commandList += "A";
                    currPos[0] += drdc[currDir][0] *2;
                    currPos[1] += drdc[currDir][1] *2;

                    continue loop;
                }else{
                    if(i > currDir){ //오른쪽
                        if(i == 3 && currDir == 0){ //왼쪽
                            commandList += "L";
                            currDir = i;
                            continue loop;
                        }
                        commandList += "R";
                        currDir = i;
                    }else{ //왼쪽
                        if(i == 0 && currDir == 3){ //오른쪽
                            commandList += "R";
                            currDir = i;
                            continue loop;
                        } 
                        commandList += "L";
                        currDir = i;
                    }
                    continue loop;
                }
            }
            break loop;
        }

        System.out.println((start[0]+1)+" "+(start[1]+1));
        System.out.println(dir);
        System.out.println(commandList);
    }
}
