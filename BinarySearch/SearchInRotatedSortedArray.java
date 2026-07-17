public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int n = nums.length, start = 0, end = n - 1;

        while (start < end) {
            int mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
                if (target < nums[start] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] >= nums[start] && nums[end] < nums[mid]) {
                if (target < nums[start]) {
                    start = mid + 1;
                } else if (target > nums[start] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] >= nums[start] && nums[mid] < nums[end]) {
                if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}