class Solution {
    public int compareVersion(String a, String b) {
        int ans = 0;
		
		ArrayList<Integer> ar = fun(a);
		ArrayList<Integer> br = fun(b);
		
		int x = ar.size();
		int y = br.size();
		
	
		if(x>y) {
			for(int i = 0;i<Math.abs(x-y);i++) {
				br.add(0);
			}
		}else if(y>x){
			for(int i = 0;i<Math.abs(x-y);i++) {
				ar.add(0);
			}
		}

		int n = br.size();
		for(int i = 0;i<n;i++) {
			if(ar.get(i)<br.get(i)) {
				ans = -1;
				break;
			}else if(ar.get(i)>br.get(i)) {
				ans = 1;
				break;
			}
		}
        return ans;
    }

    public  ArrayList<Integer> fun(String a){
		String[] arr = a.split("\\.");
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(String x:arr) {
			list.add(Integer.parseInt(x));
		}
		return list;
	}
}