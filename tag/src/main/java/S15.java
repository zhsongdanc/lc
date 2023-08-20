import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author demussong
 * @describe
 * @date 2023/8/19 17:03
 */
public class S15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >0 && nums[i] == nums[i - 1]){
                continue;
            }


            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(tmp);
                    while (l++ < r && nums[l] == nums[l - 1]);
                    while (l < r-- && nums[r] == nums[r + 1]);

                }else if (sum < 0) {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}
