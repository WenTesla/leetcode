#include<vector>
#include<iostream>
using namespace std;
//使用归并排序两个数组
//由于给出两个数组是有序的，所以直接归并这两个数组，不需要拆分
/*
执行用时：28 ms, 在所有 C++ 提交中击败了56.93%的用户
内存消耗：87.6 MB, 在所有 C++ 提交中击败了12.62%的用户
*/
class Solution {
public:
    double findMedianSortedArrays(vector<int>&nums1, vector<int>&nums2) {
        //归并两个有序数组
        int m = nums1.size();
        int n = nums2.size();
        int length = m + n;
        vector<int> v;
        auto frist1 = nums1.begin();
        auto frist2 = nums2.begin();
        while (frist1 <nums1.end() || frist2 < nums2.end())
        {
            if (frist1 == nums1.end())//1到头
            {
                while (frist2<nums2.end())
                {
                    v.push_back(*frist2);
                    frist2++;
                }
                break;

            } 
            if (frist2 == nums2.end())//2到头
            {
                while (frist1 < nums1.end())
                {
                    v.push_back(*frist1);
                    frist1++;
                }
                break;

            }

            if (*frist1 <= *frist2)
            {
                v.push_back(*frist1);
                frist1++;
            }
            else
            {
                v.push_back(*frist2);
                frist2++;
            }
            

        }
       /* for (auto it = v.begin(); it < v.end(); it++)
        {
            cout << *it << " " << endl;
        }*/
        if (length % 2 == 0)//偶数 1 2 3 4 4/2=2
        {
            return (double)(v.at(length / 2 - 1) + v.at((length / 2)))/2;
        }
        else//奇数
        {
            return (double)v.at(length/2);//1 2 3 3/2=1
        }
        
    }

};
int main() {
    Solution s;
    vector<int> a = { 1,2};
    vector<int> b = { 3,4 };
    //s.findMedianSortedArrays(a, b);
    cout << s.findMedianSortedArrays(a,b) << endl;
}
