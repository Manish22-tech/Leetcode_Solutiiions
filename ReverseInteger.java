class Solution {
    public int reverse(int x) {
        int sum=0;
        while(x!=0){
            int temp=x%10;
            x=x/10;
            if(sum>0 && sum>(Integer.MAX_VALUE-temp)/10|| sum<0 && sum <(Integer.MIN_VALUE)/10) return 0;
            sum=sum*10+temp;
        }
        return sum;
    }
}
