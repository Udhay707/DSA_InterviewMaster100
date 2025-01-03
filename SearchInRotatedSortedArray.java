public class SearchInRotatedSortedArray {
    public int search(int[] arr, int target) {
    
		int pivot = getPeak(arr);
        if(pivot==-1)
            return binarySearch(arr,target,0,arr.length-1);
		int index = binarySearch(arr, target, 0, pivot);
		if(index==-1)
			index=binarySearch(arr, target, pivot+1, arr.length-1);
		return index;
    }
    public int binarySearch(int arr[], int target, int start, int end) {
		while(start<=end) {
			int mid=start + (end-start)/2;
			if(arr[mid]<target) {
				start=mid+1;
			}
			else if(arr[mid]>target) {
				end=mid-1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	public int getPeak(int []arr){
		int start=0;
		int end = arr.length-1;
		while(start<end) {
			int mid = start + (end-start)/2;
			if(mid<end && arr[mid]>arr[mid+1])
				return mid;
			if(mid>start && arr[mid]<arr[mid-1])
				return mid-1;
			if(arr[mid]<= arr[start]) {
				end=mid-1;
			}
			else if(arr[mid]>= arr[start]) {
				start=mid+1;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
        int []array = {3,1};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int sol = searchInRotatedSortedArray.search(array, 1);
        System.out.println(sol);
    }
}

