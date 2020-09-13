package primary.sort_search;

import static utils.Print.print;

public class Ex2 {
    int badVer;
    
    public Ex2(int badVer) {
        this.badVer = badVer;
        print("BadVer is " + this.badVer);
    }
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) 
                right = mid;
            else 
                left = mid + 1;
        }
        return left;
    }

    public boolean isBadVersion(int v) {
        if (v >= badVer) 
            return true;
        else 
            return false;
    }
}
