package primary.sort_search;

public class Ex1 {   
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int t = nums2[i];
            nums1[m+i] = t;
        }
        
        int temp = 0;
        int size = m+n;
        for(int i = 0 ; i < size-1; i++)
        {
            for(int j = 0 ;j < size-1-i ; j++)
            {
                if(nums1[j] > nums1[j+1]) 
                {
                    temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }
    }
    
    public void merge_better(int[] nums1, int m, int[] nums2, int n) {
        int[] num=new int[m+n];
        int i = 0,j=0,low=0;
        while (i < m && j < n){
            num[low++]= nums1[i]< nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m){
            num[low++]=nums1[i++];
        }

        while (j < n){
            num[low++]=nums2[j++];
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k]=num[k];
        }
    }
    
    public void merge_best(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
