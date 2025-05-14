public class trappingwater {
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        int left_max[]=new int[height.length];
        int right_max[]=new int[height.length];
        int level[]=new int[height.length];
        int trap[]=new int[height.length];
        int trapped=0;
        left_max[0]=height[0];
        right_max[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++)
        {
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        for(int i=height.length-2;i>=0;i--)
        {
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        for(int i=0;i<height.length;i++)
        {
            level[i]=Math.min(left_max[i],right_max[i]);
        }
        for(int i=0;i<height.length;i++)
        {
            trap[i]=level[i]-height[i];
            trapped+=trap[i];

        }
        System.out.println(trapped);

    }
}
