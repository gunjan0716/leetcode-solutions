// 3411. Maximum Subarray With Equal Products
// 🔌 The Charger Problem: find the longest line of people where nobody fights over the same charger.
// Every prime = a charger type (2 = Type-C, 3 = Lightning, 5 = Micro-USB, 7 = Laptop brick).

class Solution {
    public int maxLength(int[] nums) {
        int mx = 0, ml = 1;
        for (int x : nums) {
            mx = Math.max(mx, x);
            ml = lcm(ml, x);
        }
        long cap = (long) ml * mx;              // gcd × lcm can never be bigger than this

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {           // 🚪 the line starts here
            long p = 1;
            int g = 0, l = 1;
            for (int j = i; j < nums.length; j++) {       // 🙋 next person joins the line
                p *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);
                if (p == (long) g * l) {                  // 🕊️ no charger fight
                    ans = Math.max(ans, j - i + 1);
                }
                if (p > cap) break;                       // 🥊 someone wants the same charger → stop
            }
        }
        return ans;
    }

    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    private int lcm(int a, int b) { return a / gcd(a, b) * b; }
}

// ⏱️ Time: O(n² · log 10)   💾 Space: O(1)   🚀 0 ms on LeetCode
