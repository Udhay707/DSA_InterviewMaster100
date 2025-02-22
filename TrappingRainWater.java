public class TrappingRainWater {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int prevLeftMax = 0;
        int prevRightMax = 0;
        for(int i=0, j=height.length-1; i< height.length && j>=0; i++, j--){
            maxLeft[i]= prevLeftMax;
            maxRight[j] = prevRightMax;
            if(height[i]>prevLeftMax)
                prevLeftMax = height[i];
            if(height[j] > prevRightMax)
                prevRightMax = height[j];
        }
        int volume =0;
        for(int i=0; i<height.length; i++){
            int minHeight= Math.min(maxLeft[i], maxRight[i]);
            volume+= minHeight-height[i] > 0 ? minHeight-height[i] : 0; 
        }
        return volume;
        
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
    }
}
