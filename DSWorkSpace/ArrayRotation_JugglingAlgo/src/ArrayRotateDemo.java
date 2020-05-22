
public class ArrayRotateDemo {
	
	static void leftRotate(int[] arr, int d, int n) {		
		d = d%n; // if d >= n
		int i,j,k,temp, gcd;
		
		gcd = GCD(d, n);
		for(i =0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while(true) {
				k = j + d;
				if(k >= n)
					k = k -n;
				if(k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}
	
	static int GCD(int d, int n) {
		if(n == 0)
			return d;
		else
			return GCD(n, d%n);
	}
	
	static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10, 11, 12, 13};
		int d = 9; // rotation club count
		
		int n = arr.length;		
		
		leftRotate(arr, d, n);
		printArr(arr);

	}

}
