class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tmp = new HashMap<>();
        Map<Character,Integer> smp = new HashMap<>();
        int n=t.length(),m=s.length();
        for(int i=0;i<n;i++)
        {
            tmp.put(t.charAt(i),tmp.getOrDefault(t.charAt(i),0)+1);

        }
        int reqChars = tmp.size();
        int i=0,j=0,curChars = 0;
        int resLength = Integer.MAX_VALUE,start=0,end=-1;
        while(j<m)
        {
            smp.put(s.charAt(j),smp.getOrDefault(s.charAt(j),0)+1);
            if(tmp.containsKey(s.charAt(j)))
            {
                int x=smp.get(s.charAt(j)),y=tmp.get(s.charAt(j));
                if( x==y)
                    curChars++;
            }
          
            while(reqChars == curChars)
            {
                if(j-i+1<resLength)
                {
                    resLength=j-i+1;
                    start=i;
                    end=j;
                }
                smp.put(s.charAt(i),smp.get(s.charAt(i))-1);
                if(tmp.containsKey(s.charAt(i))  &&  smp.get(s.charAt(i)) < tmp.get(s.charAt(i)) )
                {
                        curChars--;
                }
                i++;
            }
            j++;
        }

        return s.substring(start,end+1);
    }
}