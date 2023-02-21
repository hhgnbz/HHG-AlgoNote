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
  



## 数学定理

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



## 动态规划

- **原理**

  通过拆分问题，定义问题状态和状态之间的关系，使得问题能够以递推的方式去解决。将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。在求解任一子问题时，列出各种可能的局部解，通过决策保留那些有可能达到最优的局部解，丢弃其他局部解。依次解决各子问题，最后一个子问题就是初始问题的解。

- **要点**
  1. 拆分问题
  2. 定义各个问题状态之间关系(转移方程)

- **例题**
  1. LC1139 最大的以 1 为边界的正方形 - 2023/02/17 每日一题 (/DP/LC1139.java)
  1. LC1326 灌溉花园的最少水龙头数目 - 2023/02/21 每日一题(/Greedy/LC1326.java)
