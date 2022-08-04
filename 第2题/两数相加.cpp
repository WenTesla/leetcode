#include<iostream>
#include<stack>
using namespace std;
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
/*
执行用时：20 ms, 在所有 C++ 提交中击败了88.42%的用户
内存消耗：69.4 MB, 在所有 C++ 提交中击败了56.20%的用户*/
struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};
class Solution {
public:

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head=nullptr;
        ListNode* tail = nullptr;
        int carry = 0;
        while (l1 || l2)
        {
            int a = l1 ? l1->val:0;
            int b = l2 ? l2->val:0;
            int sum = a+b+ carry;
            //head->next=new ListNode(sun)
            if (!head)//第一次节点不用考虑是否进位，只使用一次
            {
                head =tail= new ListNode(sum % 10);
            }
            else
            {
                tail->next = new ListNode(sum % 10);
                tail = tail->next;
            }
            carry = sum / 10;
            if (l1)
            {
                l1 = l1->next;
            }
            if (l2)
            {
                l2 = l2->next;
            }

        }
        if (carry > 0)
            {
                tail->next = new ListNode(carry);
            }
        return head;
       /* stack<int> s1;
        stack<int> s2;*/

       /* while (l1!=NULL)
        {
            s1.push(l1->val);
            l1 = l1->next;
        }
        while (l2!=NULL)
        {
            s2.push(l2->val);
            l2 = l2->next;
        }*/
        /*while (!s1.empty())
        {
           
            cout << s1.top() << endl;
            s1.pop();
        }*/

    }
};
int main() {
    ListNode* p1=nullptr;
    p1 = new ListNode(2);
    p1->next = new ListNode(4);
    p1->next->next = new ListNode(3);
    ListNode* p2=nullptr;
    p2 = new ListNode(5);
    p2->next = new ListNode(6);
    p2->next->next = new ListNode(4);
    Solution s;
    ListNode* p = s.addTwoNumbers(p1, p2);
    while (p)
    {
        cout << (*p).val << " " << endl;
        p = p->next;
    }
   
}
