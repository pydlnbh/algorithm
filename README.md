1. 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？
   即使绳子边缘处盖住点也算盖住

> 1. 方法一: 写一个有序数组中找到 >= num 最左的位置的方法, 然后遍历求最接近的位置, 返回最大值, 时间复杂度 O(N * logN)
> 2. 方法二: 定义两个临时变量 left, right, 两层循环判断 left ~ right 区间是否小于等于 K, 返回最大值
> 3. 方法三: 从 0 开始遍历 arr 数组的长度, 遍历下标为 i, 定义一个临时遍历 pre = i - 1, 循环判断 pre 大于等于 0 并且 arr[pre] <= K, pre--, 求 max 和 i -
     > pre 的最大值, 这个方式主要就是从后往前算

2. 给定一个文件目录的路径，写一个函数统计这个目录下所有的文件数量并返回，隐藏文件也算，但是文件夹不算
> 1. 这道题使用栈或者队列就可以解决, 使用栈就是深度优先遍历, 使用队列就是宽度优先变量

3. 给定一个非负整数 num, 如何不用循环语句, 返回 >= num, 并且离 num 最近的 2 的某次方
> 1. 这道题用到位运算, 使用 | 和 >>> 把每个数低位都填 1, 然后再加 1 就是最近的 2 的某次方, 有一个注意的点就是需要先减 1, 防止 num 就是 2 的某次方, 这种情况不减的话就求不了等于的情况

4. 一个数组中只有两种字符'G'和'B'，可以让所有的G都放在左侧，所有的B都放在右侧，或者可以让所有的G都放在右侧，所有的B都放在左侧，但是只能在相邻字符之间进行交换操作，返回至少需要交换几次
> 1. 因为是让所有 G 或者 B 放在左边或右边, 不用计较 G 排左边第几个或者右边第几个, 所以定义一个变量记住当前遍历到的字符的位置, 用遍历下标减去临时变量, 最求出两种方法的最小值

5. 给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与，再给定一个数target，请问最后算出target的方法数
> 1. 暴力递归和记忆搜索不说了, 解决方法三用到了五个优化: 
> 2. 优化一(因为每个数字可能放 + 或者 -, 所以把 arr 数组的里数全转为正数, 最后的结果是不变的)
> 3. 优化二(如果 arr 数组都是非负数, 那么数组累加 sum 比给定的数 target 小的话说明这个方法数也不成立)
> 4. 优化三(因为只有加减, 所以最后的结果和数组正数累加和奇偶性不同的话说明这个方法数不成立)
> 5. 优化四(最关键的优化, 如果把数组里的正数集合定义为 P, 负数集合定义为 N, 肯定有一种方案是 sum(P) - sum(N) = target, 如果等式两边再加上 sum(P) + sum(N), 那么可以从 sum(P) - sum(N) + sum(P) + sum
     > (N) = target + sum(P) + sum(N) 转化为 2 * sum(P) = target + sum, 那么 sum(P) = (target + sum) / 2, 如果 target 和 sum 都给值了, 那么根据上面的等式求除 P 就是方法数)
> 6. 优化五(只求非负数组有几种情况累加和到达 P 的情况, 可以使用二维动态规划的压缩技巧)

6. 给定一个二维数组matrix，你可以从任何位置出发，走向上、下、左、右四个方向，返回能走出来的最长的递增链长度. 测试链接: https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
> 1. 正常的判断边界递归调用再加个缓存(记忆化搜索)

7. 给定两个非负数组x和hp，长度都是N，再给定一个正数range
   x有序，x[i]表示i号怪兽在x轴上的位置
   hp[i]表示i号怪兽的血量
   再给定一个正数range，表示如果法师释放技能的范围长度
   被打到的每只怪兽损失1点血量。返回要把所有怪兽血量清空，至少需要释放多少次AOE技能？
> 1. 最优解就是线段树