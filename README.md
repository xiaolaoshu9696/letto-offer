# letto-offer
Code and comment of sword finger offer

## 一些需要用到的概念

### 二叉搜索树

​		二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的[二叉树](https://baike.baidu.com/item/二叉树/1602879)： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为[二叉排序树](https://baike.baidu.com/item/二叉排序树/10905079)。
        其中序遍历结果是从小到大的。
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