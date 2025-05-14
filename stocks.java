public class stocks {
    public static void main(String[] args) {
        int selling_price[]={7,1,5,3,6,4};
        int buying_price=Integer.MAX_VALUE;
        int profit;
       int max_profit=0;
        for(int i=0;i<selling_price.length;i++)
        {
            if(selling_price[i]>buying_price)
            {
                profit=selling_price[i]-buying_price;
                max_profit=Math.max(profit,max_profit);
            }
            else{
                buying_price=selling_price[i];
            }
        }
        System.out.println(max_profit);
    }
}
