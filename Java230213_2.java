package practice;

import java.util.Arrays;

public class Java230213_2 {

	public static void main(String[] args) {
		Solution230215 solution = new Solution230215();
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		solution.solution(today, terms, privacies);
	}

}

class Solution230215 {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	// 한달을 28일로 지정해놨으니 일수로 변환 후 today와 privacies에 terms를 더해서 today보다 작을경우 폐기인 것으로 반환
    	    	
        int[] answer = {};
        
        // today를 일수로 변환
        String[] tod = today.split("\\"+ ".");
        int total = Integer.parseInt(tod[0])*12*28 + Integer.parseInt(tod[1])*28 + Integer.parseInt(tod[2]);
        
        // terms를 일수로 변환 
        String[] termstype = new String[terms.length];
        int[] termsttl = new int[terms.length];
        for (int i = 0; i < terms.length; i++) {
        	String[] termsArr = terms[i].split("\\s");
        	termstype[i] = termsArr[0];
        	termsttl[i] = Integer.parseInt(termsArr[1]) * 28;
//        	System.out.print(Arrays.toString(termsArr));
		}
        
        // privacies를 일수로 변환 및 termstype 추출 
        String[] prtype = new String[privacies.length]; // privacies의 termstype저장하기 위한 배열 선언  
        int[] prttl = new int[privacies.length];
        for (int i = 0; i < privacies.length; i++) {
       		String[] prArr = privacies[i].split("\\s"); // 공백으로 수집일자와 terms type을 분리
       		prtype[i] = prArr[prArr.length-1];  	// terms type
       		String[] prstart = prArr[0].split("\\"+ ".");
       		prttl[i] = Integer.parseInt(prstart[0])*12*28 + Integer.parseInt(prstart[1])*28 + Integer.parseInt(prstart[2]);
       		
//       		System.out.println(Arrays.toString(prArr));
//       		System.out.println(Arrays.toString(prtype));
//       		System.out.print("prstart");
//       		System.out.println(Arrays.toString(prstart));
			
		}
        
        // privacies와 terms의 type별 연산
        // privacies에 terms type에 해당하는 ttl을 더하고 today와 비교연산 후
        // today보다 작을 경우 answer배열에 해당 index+1을 반환해야함
//        System.out.println(total);
//        System.out.println(Arrays.toString(termstype));
//        System.out.println(Arrays.toString(termsttl));
//        System.out.println(Arrays.toString(prtype));
//        System.out.println(Arrays.toString(prttl));
        
        for (int i = 0; i < prtype.length; i++) {
        	for (int j = 0; j < termstype.length; j++) {
        		if(prtype[i].equals(termstype[j])) {
        			if(total >= prttl[i]+termsttl[j]) {
        				answer = Arrays.copyOf(answer, answer.length+1);
        				answer[answer.length-1]= i+1;
        			}
        			
        		}
			}
		}
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}