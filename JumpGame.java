
public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;
        for(int i= nums.length-1; i>=0; i--){
            if(nums[i] + i >= target)
                target = i;
        }
        return target == 0;  
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean ans = jumpGame.canJump(new int[]{1,0,8,0});
        System.out.println(ans);
    }
}
