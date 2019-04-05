import java.util.Arrays;
import java.util.Random;

public class Main {
	
	static long start,end;
	static int[] Random = new int[100000];
	static int[] Reverse = new int[100000];
	static int size=0;
	
	
	
	
	public static void main(String[] args) {
		System.out.println("		Random1000	Reverse1000	Random1000	Reverse10000	Random100000	Reverse100000");
		System.out.println("Bubble"+"		"+bubblesort(Random_array(1000))+"	"+bubblesort(Reverse_array(1000))+"	"+bubblesort(Random_array(10000))+"	"+bubblesort(Reverse_array(10000))+"	"+bubblesort(Random_array(100000))+"	"+bubblesort(Reverse_array(100000)));
		System.out.println("Selection"+"	"+selectionsort(Random_array(1000))+"	"+selectionsort(Reverse_array(1000))+"	"+selectionsort(Random_array(10000))+"	"+selectionsort(Reverse_array(10000))+"	"+selectionsort(Random_array(100000))+"	"+selectionsort(Reverse_array(100000)));
		System.out.println("Insertion"+"	"+insertionsort(Random_array(1000))+"	"+insertionsort(Reverse_array(1000))+"	"+insertionsort(Random_array(10000))+"	"+insertionsort(Reverse_array(10000))+"	"+insertionsort(Random_array(100000))+"	"+insertionsort(Reverse_array(100000)));
		System.out.println("Merge"+"		"+mergesort(Random_array(1000),0,999)+"	"+mergesort(Reverse_array(1000),0,999)+"	"+mergesort(Random_array(10000),0,9999)+"	"+mergesort(Reverse_array(10000),0,9999)+"	"+mergesort(Random_array(100000),0,99999)+"	"+mergesort(Reverse_array(100000),0,99999));
//		System.out.println("Quick1"+"		"+Quicksort1(0,999,Random_array(1000))+"	"+Quicksort1(0,999,Reverse_array(1000))+"	"+Quicksort1(0,9999,Random_array(10000))+"	"+Quicksort1(0,9999,Reverse_array(10000))+"	"+Quicksort1(0,99999,Random_array(100000))+"   "+Quicksort1(0,99999,Reverse_array(100000)));		
		System.out.println("Quick2"+"		"+Quicksort2(Random_array(1000),0,999)+"	"+Quicksort2(Reverse_array(1000),0,999)+"	"+Quicksort2(Random_array(10000),0,9999)+"	"+Quicksort2(Reverse_array(10000),0,9999)+"	"+Quicksort2(Random_array(100000),0,99999)+"   "+Quicksort2(Reverse_array(100000),0,99999));
		System.out.println("Quick3"+"		"+Quicksort3(Random_array(1000),0,999)+"	"+Quicksort3(Reverse_array(1000),0,999)+"	"+Quicksort3(Random_array(10000),0,9999)+"	"+Quicksort3(Reverse_array(10000),0,9999)+"	"+Quicksort3(Random_array(100000),0,99999)+"   "+Quicksort3(Reverse_array(100000),0,99999));
		System.out.println("heap"+"		"+Heapsort(Random_array(1000))+"	"+Heapsort(Reverse_array(1000))+"	"+Heapsort(Random_array(10000))+"	"+Heapsort(Reverse_array(10000))+"	"+Heapsort(Random_array(100000))+"   "+Heapsort(Reverse_array(100000)));
		System.out.println("lib"+"		"+api(Random_array(1000))+"	"+api(Reverse_array(1000))+"	"+api(Random_array(10000))+"	"+api(Reverse_array(10000))+"	"+api(Random_array(100000))+"   "+api(Reverse_array(100000)));
	}	
	
	public static int[] Random_array(int data) {
		Random=new int[data];
		for(int i=0;i<Random.length;i++) {
			Random[i]=(int)(Math.random()*data+1);
		}
		return Random;
	}
	
	public static int[] Reverse_array(int data) {
		int index = data;
		Reverse=new int[data];
		for(int i=0;i<data;i++) {
			Reverse[i]=index--;
		}
		return Reverse;
	}
	
	public static double bubblesort(int[] array) {
		start = System.currentTimeMillis();
		for(int i = 0 ; i < array.length ; i ++) {
			for(int j = 0 ; j < array.length -i -1 ; j ++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		 end = System.currentTimeMillis();
		 
		return ((double)end-start)/1000;
	}
	public static double selectionsort(int[] array) {
		start = System.currentTimeMillis();
		for(int i = 0 ; i <  array.length -1 ; i ++) {
			for(int j = i+1 ; j < array.length ; j ++) {
				if(array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		 end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	public static double insertionsort(int[] array) {
		start = System.currentTimeMillis();
		 for (int end = 1; end < array.length; end++) {
	            int toInsert = array[end];
	            int i = end;
	            while (i > 0 && array[i-1] > toInsert) {
	            	array[i] = array[i-1];
	                i--;
	            }
	            array[i] = toInsert;
	       }
		 end = System.currentTimeMillis();
		 
		return ((double)end-start)/1000;
	}
	public static double mergesort(int[] array,int p,int r) {
		start = System.currentTimeMillis();
		int q=0;
		if(p<r) {
			q = (p+r)/2;
			mergesort(array,p,q);
			mergesort(array,q+1,r);
			merge(array,p,q,r);
		}
		 end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	public static void merge(int[] array,int p,int q,int r) {
		int i=p,j=q+1,k=p;
		int temp[] = new int[array.length];
		while(i<=q && j<=r) {
			if(array[i]<=array[j])
				temp[k++]=array[i++];
			else
				temp[k++]=array[j++];
		}
		while(i<=q)
				temp[k++]=array[i++];
		while(j<=r)
				temp[k++]=array[j++];
		for(int a=p;a<k;a++)
				array[a] = temp[a];
	}
	
	public static double Quicksort1(int p,int r,int array[]) {
		start = System.currentTimeMillis();
			if(p<r) {
				int q = lastpivot(p,r,array); //pivot위치
				Quicksort1(p,q-1,array);
				Quicksort1(q+1,r,array);	
			}
		 end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	
	public static int lastpivot(int p,int r,int array[]) {
		int x = array[r];
		int i = p-1;
		for(int j=p;j<r;j++) { 
			if(array[j]<=x) {
				i++;
				swap(array,i,j);
			}
		}
		swap(array,i+1,r);
		return i+1;
	}
	
	public static double Quicksort2(int[] array,int p,int r) {
		start = System.currentTimeMillis();//가운데값
		if(p<r) {
			int q = middlepivot(array,p,r); //pivot위치
			Quicksort2(array,p,q-1);
			Quicksort2(array,q+1,r);
		}
		 end = System.currentTimeMillis();
		 
		return ((double)end-start)/1000;
	}
	public static int middlepivot(int[] array,int p,int r) {
		int mid = (p+r)/2;
		int pv = array[mid];
		swap(array, mid, r-1);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(array[j] <= pv) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, r);
		return i+1;
	}
	public static double Quicksort3(int[] array,int p,int r) {
		start = System.currentTimeMillis();//랜덤
		if(p<r) {
			int q = randomizedPartition(array,p,r); //pivot위치
			Quicksort3(array,p,q-1);
			Quicksort3(array,q+1,r);
		}
		 end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	public static int randomizedPartition(int[] array, int p, int r) {
        int randomr = randomNumberBetween(p,r);
        swap(array,r,randomr);
        return partition(array,p,r);
    }

    public static int randomNumberBetween(int startNumber, int endNumber) {
        return (int)Math.floor(Math.random() * (endNumber - startNumber + 1) + startNumber);
    }

    public static int partition(int[] array,int p,int r) {
        int pivotValue = array[r];
        int pivotIndex = p;

        for (int j = p; j < r; j++) {
            if (array[j] <= pivotValue) {
                swap(array,pivotIndex,j);
                pivotIndex = pivotIndex + 1;
            }
        }
        swap(array,pivotIndex,r);
        return pivotIndex;
    }

    public static void swap(int[] array,int p,int r) {
        int temp = array[p];
        array[p] = array[r];
        array[r] = temp;
    }
public static void MAX_HEAPIFY(int k, int array[]) {
		
		while(k*2+1<=size) 
		{
			int j=k*2+1;
			if(k*2+2<=size)
			{
				if(array[k*2+1]<array[k*2+2])
					j=k*2+2;
			}
			if(array[k]<array[j])
				swap(array,k,j);
			else
				return ;
			k = j;
		}
	}
	public static void Heap(int array[]) {
		int i=(array.length-1)/2;
		while(i>=0) {
			MAX_HEAPIFY(i,array);
			i--;
		}
	}
	public static double Heapsort(int array[])
	{
		start = System.currentTimeMillis();
		size=array.length-1;
		Heap(array);
		for(int i=size;i>=1;i--) {
			swap(array,i,0);
			size--;
			MAX_HEAPIFY(0,array);
		}
		end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	public static double api(int array[]) {
		start = System.currentTimeMillis();
		Arrays.sort(array);
		end = System.currentTimeMillis();
		
		return ((double)end-start)/1000;
	}
	
}

