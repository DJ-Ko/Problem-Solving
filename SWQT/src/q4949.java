import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class q4949 {
	
	static Stack<Character> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			}
			stack = new Stack<>();
			String ans = valanceCheck(str);
			System.out.println(ans);
		}
	}
	
	static String valanceCheck(String str){
		
		char[] arr = str.toCharArray();
		
		for(int i=0; i<arr.length; i++){
			char cur = arr[i];
			if (cur == '(' || cur == '[') {
				stack.add(cur);
			} else if (cur == ')') {
				if(stack.size() == 0){
					return "no";
				}
				char tmp = stack.pop();
				if (tmp != '(') {
					return "no";
				}
			} else if (cur == ']') {
				if(stack.size() ==0 ){
					return "no";
				}
				char tmp = stack.pop();
				if (tmp != '[') {
					return "no";
				}
			}else{
				continue;
			}
		}
		
		if(stack.size()>0){
			return "no";
		}
		
		
		return "yes";
	}

}
