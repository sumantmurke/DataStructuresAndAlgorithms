package DataStructure;

import java.util.Random;

public class QuickSort {

	/*
	 * Quick sort is about finding the Pivot and make that pivot valid by making left smaller than pivot and right greater than pivot
	 */
	
	public void quicksort(int[] nums, int low , int high) {
		
		if(low < high) {
			
			int partitionId = partition(nums, low, high);
			
			quicksort(nums, low, partitionId-1);
			quicksort(nums, partitionId+1, high);
		}
		
		
	}
		
	public int partition(int[] nums, int low, int high) {
		
		Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low) + low ;
        int pivot = nums[pivotIndex];    
        int i = low-1;
        for(int j = low ; j < high ; j++){
            
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
            
        }
        swap(nums, i+1, pivotIndex);
        
        return i+1;
		
	}
	
	public void swap (int[] nums, int index1, int index2) {
		
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;		
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] nums = {10,16,8,12,15,6,3,9,5};
		q.quicksort(nums, 0, nums.length-1);
		
		for(int i = 0 ; i < nums.length ; i++) {
			System.out.println(nums[i]);
		}
	}
}
