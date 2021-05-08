import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1620 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashMap<String, Integer> nameToNum = new HashMap<>();
		HashMap<Integer,String> numToName = new HashMap<>();
		
		st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++){
			String pokemon = br.readLine();
			nameToNum.put(pokemon, i);
			numToName.put(i, pokemon);
		}
		
		while(q-->0){
			String tmp = br.readLine();
			if(nameToNum.containsKey(tmp)){
				bw.write(String.valueOf(nameToNum.get(tmp)));
			}else{
				bw.write(numToName.get(Integer.parseInt(tmp)));
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
