
#### 首先， 设置两个变量 sold 和 hold
##### sold : 表示当前没有股票的利润
##### hold : 表示当前有股票的利润

##### 用for loop 遍历每一个price, 每一次更新 sold and hold
##### hold = Math.max(hold, sold - prices[i]); // 
                       <1>         <2>
##### sold = Math.max(sold, hold+prices[i]-fee); 
                        <3>           <4>
##### <1> hold : 继承昨天的hold, 今天什么也没做， 保持原先的hold 不变
##### <2> sold - prices[i] ： 昨天sold, 今天重新买入当前股票
##### <3> sold ： 继承昨天的 sold, 今天什么也没做， 保持原先的 sold 不变
##### <4>hold+prices[i]-fee : 昨天hold 一张股票， 今天把它卖掉

#### notice :
##### 1. the initial value :  sold = 0, 表示刚开始没有股票， 所以利润维0
###### 2. hold = Math.MIN_VALUE, 初始状态下， 没有任何股票， 为了在之后更新hold 时， 保证当前的最小值不会被考虑
###### 类似的题目还有：376.Wiggle-Subsequence，487.Max-Consecutive-Ones-II