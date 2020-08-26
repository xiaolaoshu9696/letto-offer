# letto-offer
Code and comment of sword finger offer

## 一些需要用到的概念

### 二叉搜索树

​		二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的[二叉树](https://baike.baidu.com/item/二叉树/1602879)： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为[二叉排序树](https://baike.baidu.com/item/二叉排序树/10905079)。
​        其中序遍历结果是从小到大的。
### 深度优先搜索DFS

​	深度优先搜索算法（Depth First Search，简称DFS）：一种用于遍历或搜索树或图的算法。 沿着树的深度遍历树的节点，尽可能深的搜索树的分支。当节点v的所在边都己被探寻过或者在搜寻时结点不满足条件，搜索将回溯到发现节点v的那条边的起始节点。整个进程反复进行直到所有节点都被访问为止。属于盲目搜索,最糟糕的情况算法时间复杂度为O(!n)。

​	

```

int check(参数)
{
    if(满足条件)
        return 1;
    return 0;
}
 
void dfs(int step)
{
        判断边界
        {
            相应操作
        }
        尝试每一种可能
        {
               满足check条件
               标记
               继续下一步dfs(step+1)
               恢复初始状态（回溯的时候要用到）
        }
}   
```



## 堆

​	堆就是用数组实现的二叉树，所有它没有使用父指针或者子指针。堆根据“堆属性”来排序，“堆属性”决定了树中节点的位置。

堆的常用方法：

- 构建优先队列
- 支持堆排序
- 快速找出一个集合中的最小值（或者最大值）



​	堆分为两种：最大堆和最小堆，两者的差别在于节点的排序方式。在最大堆中，父节点的值比每一个子节点的值都要大。在最小堆中，父节点的值比每一个子节点的值都要小。这就是所谓的“堆属性”，并且这个属性对堆中的每一个节点都成立。

​	

堆是使用数组来实现的，那么怎么表示父子节点的关系呢？

如果i是节点的索引那么下面的公式就给出它的父节点和子节点在数组中的位置

parent(i) = floor( ( i-1 ) / 2 )

left(i) = 2i + 1;

right(i) = 2i +2;

因为在堆中，在当前层级所有的节点都已经填满之前不允许开是下一层的填充



### 二进制相关运算

#### 加法

1. (位异或^)如果相同位不同则为1，相同位相同则为0：目的是将相加后不需要进位的取出；
2. (位与&)如果相同位为1，则为1，相同位为0则为零，（<<1）然后左移1位：目的是将相加后需要进位的单独取出；
3. 重复以上2步，直到其中一方全为0，输出结果即可。

```javascript
  public static int add(int x, int y) {
    if (y == 0) return x;
    int sum, carry;
    sum = x ^ y;
    carry = (x & y) << 1;
    return add(sum, carry);
  }
```

#### 减法

由-b=+(-b)，~（b-1）=-b可得a-b=a+（-b）=a+(~(b-1))。把减法转化为加法即可。

```java
public int minus(int a,int b) {
        int B=~(b-1);
        return add(a, B);        
    }	
```



#### 乘法

```java
public int multi(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){//乘数为0则结束
            //处理乘数当前位
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;//i记录当前位是第几位
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }
```

计算b每一位1对最后结果的贡献

#### 除法

```java
public int sub(int a,int b) {
        int res=-1;
        if(a<b){
            return 0;
        }else{
            res=sub(minus(a, b), b)+1;
        }
        return res;
    }
```

除法的意义就在于：求a可以由多少个b组成。那么由此我们可得除法的实现：求a能减去多少个b，做减法的次数就是除法的商。

#### 乘幂

```java
    public double Power(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n>0){
            exponent=n;
        }
        else if (n<0){
            if (base==0)
                throw  new RuntimeException("底数不能为0");
            exponent = -n;
        }
        else return 1; //n=0时
        while (exponent!=0){
            if ((exponent&1)==1) res = res*curr;
            curr = curr*curr;
            exponent>>=1; // 右移一位
        }
        return n>0?res:(1/res);
    }
```

