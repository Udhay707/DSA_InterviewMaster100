function maxSubarraySumCircular(nums: number[]): number {
    
    let max : number = nums[0];
    let curMax : number = 0;

    let min : number = nums[0];
    let curMin : number = 0;

    let total: number = 0;

    for(let num of nums){
        curMax = curMax + num > num ? curMax + num : num;
        max = Math.max(curMax, max);

        curMin = curMin + num < num ?curMin + num : num;

        min = Math.min(curMin, min);

        total += num;
    }

    return max > 0 ? Math.max(max, total - min) : max;
    
};

let nums: number[] = [-3, -2, -3]
console.log(maxSubarraySumCircular(nums))