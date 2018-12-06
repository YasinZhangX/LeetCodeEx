package primary.sort_search;

import static tools.Print.*;

import org.junit.jupiter.api.*;

class TestEx {
    // Ex1
    int nums1[] = {1, 2, 3, 0, 0, 0};
    int nums2[] = {2, 5, 6};
    int m = 3, n = 3;
    
//    int nums1[] = {2, 0};
//    int nums2[] = {1};
//    int m = 1, n = 1;
    
    Ex1 ex1 = null;
    Ex2 ex2 = null;
    
    int badVer = 100;
    
    //@BeforeEach
    void beforeEx1() {       
        ex1 = new Ex1();
        print("Before");
        printnb("nums1: ");
        printInt(nums1);
        printnb("nums2: ");
        printInt(nums2);
    }
    
    @BeforeEach
    void beforeEx2() {
        ex2 = new Ex2(badVer);
    }
    
    //@AfterEach
    void afterEx1() {
        print("After merge");
        printnb("nums1: ");
        printInt(nums1);
    }
    
    //@Test
    void testEx1() {
        ex1.merge_best(nums1, m, nums2, n);
    }
    
    @Test
    void testEx2() {
        int ver = ex2.firstBadVersion(10000000);
        print("First bad verison is " + ver);
    }
}
