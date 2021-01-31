

public class DynamicArrays {
	
	int[] arr ;
	// defines current capacity of the array
	int capacity;
	// defines the length of the array
	int length;
	
	DynamicArrays(int size){
		this.length = size;
		arr = new int[size];
	}
	
	public int size() {
		return capacity;
	}
	
	public void add(int element) {
		
		if(capacity >= length/2) {
			
			int[] arr1 = new int[length*2];

			for(int i = 0 ; i < capacity; i++ ) {
				arr1[i] = arr[i];
			}
			
			arr1[capacity] = element;
			capacity++;
			arr = arr1;
			length = length*2;
		}else {
			arr[capacity] = element;
			capacity++;
			
		}
		
	}
	
	@SuppressWarnings("null")
	public void clear() {
		for(int i = 0 ; i < length; i++) {
			arr[i] = (Integer) null;
		}
		length=0;
	}
	
	public static void main(String[] args) {
		DynamicArrays d  = new DynamicArrays(2);
		System.out.println("current size "+d.size());
		d.add(11);
		System.out.println("current size "+d.size());
		d.add(12);
		System.out.println("current size "+d.size());
		d.add(13);
		System.out.println("current size "+d.size());
		d.add(41);
		System.out.println("current size "+d.size());
		d.add(51);
		System.out.println("current size "+d.size());
		
	}
}
