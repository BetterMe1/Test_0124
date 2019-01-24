package xust;

/* 
1.两数之和 II - 输入有序数组 
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:
返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

示例:
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */

/*
 * 算法思想：
 * 由于数组是有序数组（默认由小到大），因此可以用双指针法，用i和j分别标记数组左端和右端，i=0,j=numbers.length-1,循环满足要求i<j，
 * 创建数组ret_inde用于存放返回值，默认{-1，-1}（-1默认找不到），
 * 当i、j标记内容之和的小于目标值时，说明i标记的值过小，应该增大，i++;
 * 当i、j标记内容之和的大于目标值时，说明j标记的值过大，应该减小，j--;
 * 等于时，将i+1，j+1存入数组ret_index中，跳出循环，返回数组ret_index
 */
//public class Test_0124 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] numbers = {2, 7, 11, 15};
//		int target = 9;
//		int[] ret_index = So.twoSum(numbers, target);
//		System.out.println(ret_index[0]+" "+ret_index[1]);	
//	}
//}
//class Solution {
//    public int[] twoSum(int[] numbers, int target) {
//    	int[] ret_index = {-1,-1};
//    	int i=0,j=numbers.length-1;
//        while(i<j){
//        	if(numbers[i] + numbers[j] < target ){
//        		i++;
//    		}
//        	else if(numbers[i] + numbers[j] > target){
//    			j--;
//    		}
//    		else{
//    			ret_index[0] = i+1;
//    			ret_index[1] = j+1;
//    			break;
//    		}
//        }
//        return ret_index;
//    }
//}
/*
2.Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，
    1 -> A   
    2 -> B
    3 -> C
    ...
    26 -> Z  
    27 -> AA  
    28 -> AB 
    ...
    
示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"
 */

//public class Test_0124 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		System.out.println(So.convertToTitle(701));
//	}
//}
//class Solution {
//    public String convertToTitle(int n) {
//    	String ret = "";
//    	while(n!=0){
//    		n--;//每次进入循环先减一，0-25 A-Z
//    		int temp = n%26;
//    		ret = String.valueOf((char)('A'+temp)) + ret;
//    		n /= 26;
//    	}
//    	return ret;
//    }
//}
/*
3.求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
 */
/*
 * 算法思想：
 * 先用第一个数来做比较，计数器count=1，遇到相同的数加1，遇到不同的数减1，如果count为0，则将遍历到的下一个数重新作为比较的数重新计数，直到找到最多的为止。
 */
public class Test_0124 {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {6,5,5};
		System.out.println(So.majorityElement(nums));
	}
}
class Solution {
    public int majorityElement(int[] nums) {
    	int i = 0;
    	int count = 1;
    	for(int j=1; j<nums.length-1; j++){
    		if(nums[i] == nums[j]){
    			count++;
    		}
    		else{
    			count--;
    			if(count == 0){
    				i = j+1;
    			}
    		}
    	}
        return nums[i];
    }
}