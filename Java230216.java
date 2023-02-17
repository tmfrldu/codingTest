package practice;

import java.util.HashMap;
import java.util.Map;

public class Java230216 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		solution.solution(survey, choices);
		// "TCMA"

	}

}

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
//        Map<String, Integer> typept = new HashMap<String, Integer>();
        Map<String, Integer> typept = new HashMap<>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);            
        }};
        
        // 검사와 점수 들어오면 타입에 관한 점수를 맵으로 반환
        for (int i = 0; i < choices.length; i++) {
        	if(choices[i] <= 3) {
        		// survey에 있는 스트링의 0번째를 key 값으로
        		// value에 point를 넣을수 있도록
        		switch(choices[i]) {
        			case 1:
        				typept.put(String.valueOf(survey[i].charAt(0)),       				           
        				        	typept.get(String.valueOf(survey[i].charAt(0))) + 3);
        			break;
        			case 2:
        				typept.put(String.valueOf(survey[i].charAt(0)),
     				        		typept.get(String.valueOf(survey[i].charAt(0))) + 2);
            		break;
        			case 3:
        				typept.put(String.valueOf(survey[i].charAt(0)),
    				        		typept.get(String.valueOf(survey[i].charAt(0))) + 1);
            		break;        		
        		}
        	}
        	else if(choices[i] >= 5) {
        		switch(choices[i]) {
    			case 5:
    				typept.put(String.valueOf(survey[i].charAt(1)),
 				        		typept.get(String.valueOf(survey[i].charAt(1))) + 1);
    			break;
    			case 6:
    				typept.put(String.valueOf(survey[i].charAt(1)),
  				        		typept.get(String.valueOf(survey[i].charAt(1))) + 2);
        		break;
    			case 7:
    				typept.put(String.valueOf(survey[i].charAt(1)),
  				        		typept.get(String.valueOf(survey[i].charAt(1))) + 3);
        		break;        		
        		}
        	}
		}
        
        // RT, CF, JM, AN 별로 value가 큰 key를 반환하도록

        
        if(typept.get("R")>=typept.get("T")) {
        	answer += "R";        	
        }else if(typept.get("R")<typept.get("T")) {
        	answer += "T";        	
        }
        if(typept.get("C")>=typept.get("F")) {
        	answer += "C";        	
        }else if(typept.get("C")<typept.get("F")) {
        	answer += "F";        	
        }
        if(typept.get("J")>=typept.get("M")) {
        	answer += "J";        	
        }else if(typept.get("J")<typept.get("M")) {
        	answer += "M";        	
        }
        if(typept.get("A")>=typept.get("N")) {
        	answer += "A";        	
        }else if(typept.get("A")<typept.get("N")) {
        	answer += "N";        	
        }
        
        
        
        
        
        System.out.println(typept);
        System.out.println(answer);
        
        return answer;
    }


}