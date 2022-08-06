/*
执行用时：32 ms, 在所有 C++ 提交中击败了25.28%的用户
内存消耗：10.7 MB, 在所有 C++ 提交中击败了16.63%的用户
通过测试用例：
987 / 987
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int length = s.length();
        int Max = 0;
        unordered_set<int> set;
        int left = -1;
        //int right = 0;
        for (int i = 0; i < length; i++) {
            if (i!=0)//防止i<0导致越界错误
            {
                set.erase(s[i - 1]);//移除已经判断过的子串的最左边元素
            }
            while (left+1 < length && !set.count(s[left+1]))//两边的left+1（索引）应该相同防止越界,左边判断越界必须放在左边先判断，否则报错
            {
                set.insert(s[left+1]);
                left++;
            }
            Max = max(left-i+1, Max);
        }
        return Max;
    }
};
