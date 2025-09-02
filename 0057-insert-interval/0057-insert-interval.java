class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = -1;
        int end = -1;

        int ns = newInterval[0];
        int ne = newInterval[1];

        List<int[]> l = new ArrayList<>();
        for (int[] interval : intervals) {
            if (start >= 0 && end >= 0) {
                l.add(interval);
            }
            int s = interval[0];
            int e = interval[1];
   
            if (start < 0) {
                if (ns > e) {
                    l.add(interval);
                    continue;
                } else if ( ns < s) {
                    start = ns;
                } else if ( ns >= s && ns <= e) {
                    start = s;
                }
            }
            if (start >= 0 && end < 0 ) {
                if ( s > ne ) {
                    end = ne;
                    l.add(new int[]{start,end});
                    l.add(interval);
                } else if ( e >= ne){
                    end = e;
                    l.add(new int[]{start,end});
                }
            }
        }
        if (start < 0) {
            l.add(new int[]{ns,ne});
        } else if ( end < 0) {
            l.add(new int[]{start,ne});
        }
       return l.toArray(new int[0][]);
    }
}