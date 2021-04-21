import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q10972 {

	static int[] nums;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int lpart = -1, rpart = -1;
		
		// �����ʺ��� Ž���ؼ� ���������� �Ǵ� �κ��� ã��
		for (int i = n - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				lpart = i - 1;
				rpart = i;
				break;
			}
		}
		
		// ���������� �Ǵ� �κ��� ���ٸ� ��� ������ ���� ���������̶�� ���̹Ƿ� ���� ������ �������� �ʾ� -1 ���
		if (lpart == -1 && rpart == -1) {
			System.out.println(-1);
			return;
		}
		
		solve(lpart,rpart);
		sort(rpart, n);
		
		for(int i=0; i<nums.length; i++){
			bw.write(nums[i]+" ");
		}
		
		bw.newLine();
		bw.flush();
		bw.close();
		
	}

	public static void solve(int lpart, int rpart) {
		//�ڿ������� ���������� �Ǵ� �κ��� �������� ����(������)�� ������ ����(ū������ ���� ��)
		//������ ������ �ں��� ���ʴ�� ���� ��(������)�� ���ϴµ� �� ū���� ã�Ƽ� �ٲ���
		for (int i = n - 1; i >= rpart; i--) {
			if (nums[lpart] < nums[i]) {
				int tmp = nums[lpart];
				nums[lpart] = nums[i];
				nums[i] = tmp;
				break;
			}
		}
	}
	
	public static void sort(int start, int end){
		//������ ������ ���� �������� ������
		for(int i=start; i < end; i++){
			int min = i;
			for(int j = i+1; j<end; j++){
				if(nums[min]>nums[j]){
					min = j;
				}
			}
			int tmp = nums[min];
			nums[min] = nums[i];
			nums[i] = tmp;
		}
	}

}
