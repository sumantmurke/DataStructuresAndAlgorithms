

public class MergeSort {

	/*
	 * The strategy behind merge sort is divide and conquer similar to quick sort. 
	 * However quick sort does in place where as merge sort need extra storage. 
	 * Merge sort worst case is nlogn
	 */
	
	public void mergeSort(int[] arr, int low , int high) {
		
		if(low < high) {
			
			int mid = low+ (high-low)/2;
			mergeSort(arr, low , mid);
			mergeSort(arr, mid+1, high);
			
			merge(arr, low , mid , high);
		}
		
	}
	
	public void merge(int[] arr, int low, int mid, int high) {
		
		int sizeOfTempArray1 = mid- low+1;
		int sizeOfTempArray2 = high - mid;
		
		int[] temp1 = new int[sizeOfTempArray1];
		int[] temp2 = new int[sizeOfTempArray2];
		
		/*
		 * Filling up the temp array
		 */
		for(int i = 0 ; i< sizeOfTempArray1; i++) {
			temp1[i] = arr[low+i];
		}
		
		for(int i = 0 ; i< sizeOfTempArray2; i++) {
			temp2[i] = arr[mid+1 + i];
		}
		
		int i  = 0, j = 0;
		int k = low;
		while(i < sizeOfTempArray1 && j < sizeOfTempArray2) {
			
			if(temp1[i] <= temp2[j]) {
				arr[k] = temp1[i];
				i++;
			}else {
				arr[k] = temp2[j];
				j++;
			}
			
			k++;
			
		}
		
		while(i < sizeOfTempArray1) {
			arr[k] = temp1[i];
			i++;
			k++;
		}
		
		while(j < sizeOfTempArray2) {
			arr[k] = temp2[j];
			j++;
			k++;
		}
		
	}
	
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] nums = {10,16,8,12,15,6,3,9,5};
		m.mergeSort(nums, 0, nums.length-1);
		
		for(int n : nums) {
			System.out.print(n+" ");
		}
	}
}
