import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    	int[] answer = new int[id_list.length];
    	
        boolean[][] reportCheck = new boolean[id_list.length][id_list.length];
        int[] count = new int[id_list.length];
        
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            
            String reporting = st.nextToken();
            String reported = st.nextToken();

            int reportingCnt = -1;
            int reportedCnt = -1;
            
            boolean reportingChk = false;
            boolean reportedChk = false;
            
            for(int j=0;j<id_list.length;j++) {
            	if(!reportingChk && id_list[j].equals(reporting)) {
            		reportingChk = true;
            		reportingCnt = j;
            	}
            	if(!reportedChk && id_list[j].equals(reported)) {
            		reportedChk = true;
            		reportedCnt = j;
            	}
            	if(reportedChk && reportingChk)
            		break;
            }
            
            if(!reportCheck[reportingCnt][reportedCnt]) { //신고 기록이 없으면
	            reportCheck[reportingCnt][reportedCnt] = true;
	            count[reportedCnt]++;
            }
        }
        
        for(int i=0;i<count.length;i++) {
        	if(count[i] >= k) { // 신고누적이면
        		for(int j=0;j<id_list.length;j++) {
        			if(reportCheck[j][i]) {
        				answer[j]++;
        			}
        		}
        	}
        }
        
        return answer;
    }
}