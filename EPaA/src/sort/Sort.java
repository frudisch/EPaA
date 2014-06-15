package sort;

public class Sort {

	public static void main(String[] args) {
		new Sort();
	}
	
	public Sort() {
		String temp[] = {"LRFKQ","YUQFJ","KXYQV","NRTYS","FRZRM","ZLYGF","VEULQ","FPDBH","LQDQR","RCRWD","NXEUO","QQEKL","AITGD","PHCSP","IJTHB","SFYFV","LADZP","BFUDK","KLRWQ","AOZMI","XRPIF","EFFEC","LHBVF","UKBYE","QFQOJ","WTWOS","ILEEZ","TXWJL","KNGBQ","QMBXQ","CQPTK","HHQRQ","DWFCA","YSSYO"};
		temp = sortHeap(temp);
//		for(int i = 0; i<temp.length;i++){
//			System.out.println(i + ": " + temp[i]);
//		}
		//temp = sortRadix(temp);
	}

	private String[] sortRadix(String[] temp) {
		
		return null;
	}

	private String[] sortHeap(String[] temp) {
		for(int i = 0; i<temp.length; i++){
			temp = reheap(temp, temp.length-i);
			temp[temp.length-i-1] = temp[0];
//			System.out.println(temp.length-i-1 + ": " + temp[0]);
//			for(int j = 0; j<temp.length;j++){
//				System.out.println(j + ": " + temp[j]);
//			}
		}
		
		return temp;
	}

	private String[] reheap(String[] temp, int length) {
		int pos = length-1;
		//System.out.println(pos);
		if(length%2 == 0){
			if(temp[pos].compareTo(temp[pos/2]) > 0){
				temp[pos/2] = temp[pos];
			}
			pos--;
		}
		
		while(pos > 0){
			//System.out.println(pos);
			if(temp[pos].compareTo(temp[pos/2]) > 0){
				temp[pos/2] = temp[pos];
			}
			if(temp[pos-1].compareTo(temp[pos/2]) > 0){
				temp[pos/2] = temp[pos-1];
			}
			pos = pos-2;
				
		}
//		//System.out.println(pos);
//		if(temp[2].compareTo(temp[0]) > 0){
//			temp[0] = temp[1];
//		}
//		if(temp[1].compareTo(temp[0]) > 0){
//			temp[0] = temp[1];
//		}
		System.out.println(length);
		return temp;
	}
	
	
	
	
	
	int compare(String s1, String s2){
		int rc = 0;
		if(s1.equals(s2)){
			return 2;
		}else{
			for(int i=0; i<s1.length()||i<s2.length(); i++){
			}
		}
		
		return rc;
	}
	
	
}
