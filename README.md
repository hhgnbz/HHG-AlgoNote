# HHG-AlgoNote

## 常用数据结构

### 大/小根堆

- 出队顺序从大/小到小/大
- java中可用*PriorityQueue*实现，默认为小根堆
- 优先队列是利用堆实现的一种特殊队列，堆是按照完全二叉树顺序存储的，有n 个节点的完全二叉树的高度为log2n +1。
- 出入队时空复杂度均为O(logn)
- 例题：
  1. LC23 合并K个升序链表 - (/Sort/LC23.java)
  1. LC1792 最大平均通过率 - 2023/02/19 每日一题 - (/Greedy/LC1792.java)

```java
// 大根堆
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
// 小根堆(可不写lambda表达式，默认为小根堆)
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
```



## 常用算法模板

### 数字各位数和

```java
int getDigiSum(int x) {
    int res = 0;
    while (x > 0) {
        res += x % 10;
        x /= 10;
    }
    return res;
}
```

### GCD

```java
int gcd(int a,int b) {
    return b == 0 ? a : gcd(b,a % b);
}
```

### LCM

- 前提条件为求出a，b的GCD

```java
int lcm(int a,int b) {
    return a * b / gcd(a,b);
}
```

### 二分(左闭右开)

- 答案具有二分性(eg.数组递增/减，查找其中某个值)

```java
int binarySearch(int n, int target) {
    int l = 0;
    int r = n;
    while (l < r) {
        int m = l + (r - l) / 2;
        if (m > target) {
            r = m;
        } else if (m < target) {
            l = m + 1;
        } else {
            return m;
        }
    }
    return -1;
}
```

### 快速排序

```java
void sort(int[] arr,int left,int right) {
    if (left >= right) {
        return;
    }
    int l = left;
    int r = right;
	int pivot = arr[left];
	int temp = 0;
	while(l < r) {
		while(pivot <= arr[r] && l < r) {
			r--;
		}
		while(pivot >= arr[l] && l < r) {
			l++;
		}
		if(l <= r) {
			swap(arr,l,r);
		}
	}
    arr[left] = arr[l];
	arr[l] = pivot;
	sort(arr, left, l - 1);
	sort(arr, l + 1, right);
}
void swap(int[] arr,int l,int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
}
```

### DFS

- DFS参数包含：
  1. 起始位置
  2. 回溯标记(eg.boolean数组)
  3. 被搜索参数
  4. 用于判断跳出的条件

```java
boolean dfs() {
		if () { // 边界条件
			return false;
		}
		if () { // 搜索完成跳出
			return true;
		}
		used[x][y] = true; // 标记已访问过节点
		dfs(); // 继续向深处dfs
		used[x][y] = false; // 标记节点并未访问
		return ;
}
```

### BFS

```java
int[] bfs(int[] need) {
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{sr,sc}); // 初始节点
    while(!q.isEmpty()) { 
        int[] cur = q.poll(); // 当前节点
        if () { // 边界&判断正确条件
            need[x][y] = ;// 修改返回值
            q.add(new int[]{x,y}); // 条件符合加入队列继续判断
        }
    }
    return need;
}
```



### 格雷码

```java
int gray(x) {
    return x ^ (x >> 1);
}
```

### 快速幂

- 初始化res = 1
- 在幂次数为奇数时，res *= x
- 幂次数不为0前，x *= x，幂次数取一半向下取整

```java
double myPow(double x, int n) {
    if(x == 0) return 0;
    long b = n;
    double res = 1.0;
    if(b < 0) {
        x = 1 / x;
        b = -b;
    }
    while(b > 0) {
        if((b & 1) == 1) {
            res *= x;
        }
        x *= x;
        b >>= 1;
    }
    return res;
}
```



## 常用算法Tips

### 前缀和

- **定义**

  对于数组nums，定义其前缀和：

$$
s[0] = 0\\
s[i+1] = \sum_{j=0}^inums[j]
$$

- **eg.**
  $$
  nums = [1,2,-1,2]\\
  s=[0,1,3,2,4]
  $$
  



## 定理

### 裴蜀定理(GCD)

- **定理**

  多元一次不定方程：
  $$
  A_1X_1+A_2X_2+...+A_nX_n=C
  $$
  (A1,A2,...An,C均为正整数)存在整数解的充要条件是：
  $$
  (A_1,A_2...A_n)|C
  $$
  即C能够被A1,A2...An的最大公约数整除；

- **简化思维**

  整数m,n最大公因数是d，总能找到两个整数s,t，使得
  $$
  ms+nt=d
  $$
  这道题就是使得
  $$
  d=1
  $$
  数组中有任何几个数最大公因数为1，整个数组的最大公因数也为1；

- **例题**
  1. LC1250 检查「好数组」 - 2023/2/15 每日一题 (/Math/LC1250.java)

### 格雷码

- **定理**

  在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为**格雷码**（Gray Code），另外由于最大数与最小数之间也仅一位数不同，即“首尾相连”，因此又称**循环码**或**反射码**。

  假设某个二进制数表示为：
  $$
  B_{n-1}B_{n-2}...B_2B_1B_0
  $$
  其格雷码表示为：
  $$
  G_{n-1}G_{n-2}...G_2G_1G_0
  $$
  最高位保留：
  $$
  G_{n-1} = B_{n-1}
  $$
  而其他各位：
  $$
  G_i=B_{i+1}\bigoplus B_i
  $$
  其中：
  $$
  i=0,1,2...n-2
  $$

- **例题**
  
  1. LC1238 循环码排列 - 2023/02/23 每日一题(/Math/LC1238.java)

### 约瑟夫环

- **原型**

  0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

- **公式**
  $$
  f(n,m) = (f(n - 1,m)+m) \% n
  $$



## 排序

### 快速排序

- **原理**

  对向双指针(哨兵)，指向排序部分两头，通过往中间夹击将数组分为大小两部分。递归进行排序，各自交换为有序数组。

- **例题**
  
  1. 剑指offer21 调整数组顺序使奇数位于偶数前面 - (/Sort/Offer21.java) - 快排基础



## 搜索

### 深度优先搜索(DFS)

- **原理**

  优先向当前访问节点下的接邻节点进行搜索，尽可能深的搜索当前分支，当到达边缘条件后进行回溯，重复进行直到所有节点被访问。

- **例题**

  1. 剑指offer12/LC79 矩阵中的路径 - (/Search/DFS/Offer12-LC79.java)
  1. 剑指offer68/LC236 二叉树的最近公共祖先 - (/Search/DFS/Offer68-LC236.java)
  1. 剑指offer07 重建二叉树 - (/Search/DFS/Offer07.java)

### 广度优先搜索(BFS)

- **原理**

  由初始节点作为第一层，不断向外扩张，直到找不到符合条件的节点。

- **例题**

  1. LC733 图像渲染 - (/Search/BFS/LC733.java)
  2. LC695 岛屿的最大面积- (/Search/BFS/LC695.java)
  3. LC542 01 矩阵 - (/Search/BFS/LC542.java)
  4. LC994 腐烂的橘子 - (/Search/BFS/LC994.java)



## 动态规划

- **原理**

  通过拆分问题，定义问题状态和状态之间的关系，使得问题能够以递推的方式去解决。将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。在求解任一子问题时，列出各种可能的局部解，通过决策保留那些有可能达到最优的局部解，丢弃其他局部解。依次解决各子问题，最后一个子问题就是初始问题的解。

- **要点**
  1. 拆分问题
  2. 定义各个问题状态之间关系(转移方程)

- **例题**
  1. LC1139 最大的以 1 为边界的正方形 - 2023/02/17 每日一题 (/DP/LC1139.java)
  1. LC1326 灌溉花园的最少水龙头数目 - 2023/02/21 每日一题(/Greedy/LC1326.java)
