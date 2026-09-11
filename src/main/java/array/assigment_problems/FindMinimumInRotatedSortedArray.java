package array.assigment_problems;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int min1 = findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min1);

        int min2 = findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min2);

        int min3 = findMin(new int[]{11, 13, 15, 17});
        System.out.println(min3);
    }
}