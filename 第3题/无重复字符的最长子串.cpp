#include<iostream>
#include<unordered_map>
#include<unordered_set>
#include<math.h>
#include<algorithm>
using namespace std;
/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
/*
执行用时：788 ms, 在所有 C++ 提交中击败了5.00%的用户
内存消耗：146.6 MB, 在所有 C++ 提交中击败了4.99%的用户
*/ 
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int length = s.length();
        int Max = 0;
        unordered_set<int> set;
        //i/*nt i = j = 0;*/
        int left = 0;
        int right = 1;
        int tempmax = 0;
        for (int i = 0 ; i <length; i++)
        {
            left = i;
            while (set.count(s[left]) <=0 && left <length)//不存在在哈希表中
            {
                set.insert(s[left]);
                //Max++;
                left++;
                //tempmax++;
            }
            Max = max(Max,(int) set.size());
            
            //cout << Max << endl;
            set.clear();
            //tempmax = 0;
        }
        //cout << length;
        return Max;
    }
};
int main() {
    Solution s;
    int max=s.lengthOfLongestSubstring("pwwkew");
    cout << max << endl;
	system("pause");
}
