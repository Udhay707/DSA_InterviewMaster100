public class Kokobanana {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        double[] pilesDouble = new double[piles.length];
        for(int i=0; i< piles.length; i++){
            pilesDouble[i] = piles[i];
            max = Math.max(piles[i], max);
        }

        int start = 0;
        int end = max;
        while(start <= end){
            int mid = start + (end - start )/2;

            if (isSpeedEnough(pilesDouble, h, mid)){
                end = mid-1;
                max = mid;
            } else{
                start = mid + 1;
            }
        }
        return max;
    }

    private boolean isSpeedEnough(double[] piles, int h, double speed){
        int i =0;
        while(i<piles.length && h > 0){
            int hoursConsumed = (int)Math.ceil(piles[i]/speed);
            h -= hoursConsumed;
            i++;
        }

        if (i == piles.length && h>=0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(new Kokobanana().minEatingSpeed(piles, h));
    }
}
