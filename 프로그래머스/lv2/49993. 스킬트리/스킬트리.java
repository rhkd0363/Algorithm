import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            String[] temp = skill_tree.split("");
            for(int i=0;i<temp.length;i++){
                if(!skill.contains(temp[i])){
                    skill_tree = skill_tree.replace(temp[i],"");
                }
            }
            
            if(skill.indexOf(skill_tree) == 0)
                answer++;
        }
        
        return answer;
    }
}