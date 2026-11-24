# 🔌 3411. Maximum Subarray With Equal Products (aka *The Charger Problem*)

[LeetCode link](https://leetcode.com/problems/maximum-subarray-with-equal-products/) · Easy · Java · 0 ms ✅

## The problem
Find the longest subarray where **prod(arr) == gcd(arr) × lcm(arr)**.

## The hostel story 🏠
One power strip, everyone lines up. Each charger type is a **prime**:

| Charger | Prime |
|---|---|
| Type-C | 2 |
| Lightning | 3 |
| Micro-USB | 5 |
| Laptop brick | 7 |

Rahul has a phone + laptop → `2 × 7 = 14`. Priya only has an iPhone → `3`.

The condition `prod == gcd × lcm` secretly means:
- ✅ **2 people** → always fine (`a × b = gcd × lcm`, pure math magic ✨)
- ✅ **3+ people** → only if every pair is **coprime**, i.e. nobody shares a charger
- ❌ `[4, 5, 6]` → 4 and 6 both want Type-C. Fight! 🥊
- ✅ `[3, 4, 5]` → peace in the hostel 🕊️

## Algorithm 🧠
1. Fix where the line starts (`i`).
2. Let people join one by one (`j`), tracking `prod`, `gcd`, `lcm`.
3. If `prod == gcd × lcm`, record the length.
4. Stop early once `prod > lcm(all) × max(all)`. It can never match again.

⏱️ O(n²) · 💾 O(1)

## Real life 🌍
Swap chargers for **database tables, files or locks**. The longest coprime window is the biggest batch of consecutive jobs that can run **in parallel** without fighting over a resource, just like transaction schedulers, CI pipelines and merge-conflict checks do.
