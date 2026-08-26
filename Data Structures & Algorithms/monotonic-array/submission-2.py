class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        n = len(nums)
        increase = True
        for i in range(1, n):
            if nums[i] < nums[i - 1]:
                increase = False
                break

        if increase:
            return True

        decrease = True
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                decrease = False
                break
        return decrease