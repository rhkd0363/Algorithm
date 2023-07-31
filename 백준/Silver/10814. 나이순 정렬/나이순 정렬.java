import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info>{
        int age;
        String name;
        int index;
        public Info(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
        @Override
        public int compareTo(Info i){
            if(this.age == i.age)
                return this.index - i.index;
            return this.age - i.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Info> list = new ArrayList<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
        Collections.sort(list);
        for(Info i: list)
            sb.append(i.age+" "+i.name).append('\n');
        System.out.println(sb);
    }
}