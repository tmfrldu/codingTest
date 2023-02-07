package practice;

import java.util.Arrays;

public class Java230206 {

	public static void main(String[] args) {
		Solution230206 solution = new Solution230206();
		System.out.println(solution.solution("AB", 1));

	}

}

class Solution230206 {
    public String solution(String s, int n) {
        String answer = "";
       
       
        for (int i = 0; i < s.length(); i++) {
         char a = s.charAt(i); // 스트링 s의 인덱스로 알파벳을 반환해줌
         int cs = a + n;
         if (a >= 65 && a <= 90) { // 반환된 알파벳이 대문자인 경우
             if (cs > 90) { // 연산된 값이 대문자 Z를 초과하면 A로 되돌아가야하므로
                 cs = cs - 26; // 알파벳 개수인 26을 빼줌
             }
         } else if (a >= 97 && a <= 122) { // 반환된 알파벳이 소문자인 경우
             if (cs > 122) { // 연산된 값이 소문자 z를 초과하면 a로 되돌아가야하므로
                 cs = cs - 26; // 위와 같이 26을 빼줌
             }
         } else if (a == 32) { // 공백의 경우는 공백을 유지해야하므로
             cs = 32;    // 공백인 아스키코드 값 32를 계속 유지하도록 한다
         }
         answer += (char) cs; // String answer에 하나씩 담는다
     }

       
        return answer;
    }
}