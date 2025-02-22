func findPeakElement(nums []int) int {
    start := 0
    end := len(nums) - 1

    for start <= end {
        mid := start + (end - start) / 2

        if mid+1 < len(nums) && nums[mid] < nums[mid+1] {
            start = mid + 1 //possible solution
        } else {
            end = mid - 1
        }
    }
    return start
}