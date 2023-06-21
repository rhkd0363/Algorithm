import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String pattern = "[^"+skill+"]";
        
        for(String skill_tree : skill_trees){
            skill_tree = skill_tree.replaceAll(pattern,"");
            
            answer += skill.indexOf(skill_tree) == 0 ? 1 : 0;
        }
        
        return answer;
    }
}