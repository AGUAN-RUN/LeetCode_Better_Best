package chapter1.section1_99;


class SearchInRotatedSortedArrayII2 {
    //对于第一次提交的优化，优化对于重复元素不多的元素进行二分处理
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if (nums[start] < nums[mid]) {

                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {

                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;

                }
            }
        }

        return false;

    }
}