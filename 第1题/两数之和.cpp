#include<iostream>
#include<vector>
using namespace std;
//int
/*
执行用时：412 ms, 在所有 C++ 提交中击败了8.19%的用户
内存消耗：9.9 MB, 在所有 C++ 提交中击败了78.39%的用户
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        //vector v;
        vector<int> v;
        int len = nums.size();
        for (int i = 0; i < len; i++)
        {
            for (int j = i+1; j < len; j++)
            {
                if (nums[i]+nums[j] == target)
                {
                    v.push_back(i);
                    v.push_back(j);
                    break;
                }
            }
        }
        return v;
    }
};
// int main() {
//     /*ector<int> s;
//     s.push_back(2);
//     s.push_back()
//     Solution s;
//     vector<int> v = s.twoSum(a,9);*/

// }
