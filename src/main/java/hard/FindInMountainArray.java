package hard;

/**
 * @author Yasin Zhang
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int index = binarySearchUp(mountainArr, target, 0, start);
        return index == -1 ? binarySearchDown(mountainArr, target, start, mountainArr.length() - 1) : index;
    }

    private int binarySearchUp(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDown(MountainArray mountainArr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static class MountainArray {
        int[] array;
        int length;

        public MountainArray(int[] array) {
            this.array = array;
            this.length = array.length;
        }

        public int get(int index) {
            return array[index];
        }
        public int length() {
            return length;
        }
    }
}
