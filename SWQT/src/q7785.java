import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class q7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		TreeSet<String> log = new TreeSet<>();
		
		int n  = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			if(in[1].equals("enter")){
				log.add(in[0]);
			}else{
				log.remove(in[0]);
			}
		}
		
		Iterator<String> iter = log.descendingIterator();
		
		while(iter.hasNext()){
			bw.write(iter.next());
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public class Trie { 
		// [ ���� ] 
		// ��Ʈ ���
		private TrieNode rootNode;
		
		// [ ������ ]
		Trie() {
			rootNode = new TrieNode();
		}

		// [ �޼��� ] // �ڽ� ��� �߰�
		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}

		// Ư�� �ܾ ����ִ��� Ȯ��
		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if (node == null)
					return false;
				thisNode = node;
			}
			return thisNode.isLastChar();
		}

		// Ư�� �ܾ� �����
		void delete(String word) {
			delete(this.rootNode, word, 0);
			// ���ʷ� delete ������ �κ�
		}

		private void delete(TrieNode thisNode, String word, int index) {
			char character = word.charAt(index);
			// APPLE, PEN�� ���� �ƿ� ���� �ܾ��� ��� ���� ���
			if (!thisNode.getChildNodes().containsKey(character))
				throw new Error("There is no [" + word + "] in this Trie.");
			TrieNode childNode = thisNode.getChildNodes().get(character);
			index++;
			if (index == word.length()) {
				// �������� 2�� �׸� // PO�� ���� ���� ���������� insert�� �ܾ �ƴ� ��� ���� ���
				if (!childNode.isLastChar())
					throw new Error("There is no [" + word + "] in this Trie.");
				childNode.setIsLastChar(false);
				// �������� 1�� �׸� // ���� ��� ����� ���� �����ν� �ڽ� ��尡 ������(�� �ܾ �����ϴ� �� �� �ܾ
				// ������) ���� ����
				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);
			} else {
				delete(childNode, word, index);
				// �ݹ��Լ��κ� // �������� 1,3�� �׸� // ���� ��, �ڽ� ��尡 ���� ���� ���� ������ �ٸ� �ܾ
				// ���� ��� �� ��� ����
				if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(character);
			}
		}
	}

	class TrieNode {
		// [ ���� ]
		// �ڽ� ��� ��
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		// ������ �������� ����
		private boolean isLastChar;

		// [ GETTER / SETTER �޼��� ]
		// �ڽ� ��� �� Getter
		Map<Character, TrieNode> getChildNodes() {
			return this.childNodes;
		}

		// ������ �������� ���� Getter
		boolean isLastChar() {
			return this.isLastChar;
		}

		// ������ �������� ���� Setter
		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;

		}
	}

}
