# 主要是关于算法方面的一些题目练习
- 数组相关题目：
    - 力扣网：26、27、75、88、215、283：循环不变量，明确变量
    - 力扣网：11、125、167、345：双指针碰撞
    - 力扣网：3、76、209、438：滑动窗口，其中76题为438题的升华版。
        1. 滑动窗口的左指针和右指针在什么情况下滑动，一般判断右指针滑动，else就滑动左指针
        2. 右指针的判断，一般在右指针滑动到最右端的基础情况下，再做其他判断
        3. 要判断滑动终止的条件，一般是判断左指针不再可以移动了。
        4. 一般在滑动过后，要判断本窗口是否符合以满足的条件
        5. 3题判断最长不重复子串，重点是声明一个记录ASCII码的频率数组，通过右指针不断滑动更新频率数组，判断数组元素是否等于0来判断子串的字符是否重复
        6. 438题在3题的基础之上，寻找异位词子串的索引，除了声明了频率数组外，还引入了固定的滑动窗口，但之前需要扩展窗口至固定值，同时还引入了如何通过频率数组判断一个字符串是否重复
        7. 76题在438题的基础之上，寻找包含字符串的最小子串，多了点最小长度的判断
- 集合Set与Map相关操作
    - 力扣网：202、242题、349题、350题
        - 349题和350题分别通过 Set 和 Map 求两个集合的交集
        - 242题:判断两个字符串出现字符频率一样，可使用map，也可使用数组记录频率，需分别遍历两个字符串
        - 使用集合来记录频率的题，一般都是使用一个集合去记录某个输入参数的频率，再去遍历另外一个输入参数判断，将判断对的结果放入新的集合中去
        - 205题和290题：判断两个字符串是否为同构的，两种解法：1、分别判断两个字符串中每个字符第一次出现的频率；2、将每个字符串的每个字符都翻译一遍，判断翻译后的是否相等
        - 1题（求两数之和）、15题（三数之和）、18题（四数之和）、16题（三数之和最接近目标值的）；求两数之和可以利用map记录值和索引，一边遍历一边去map中获取另一半，巧妙的运用了map的查找功能。求三数之和和四数之和本质上是在排序之后利用了双指针碰撞的原理，在一个或两个for循环的前提下进行双指针碰撞。
        - 219题和220题，在一个数组中查找两个符合（索引、两个值之差）特定规定的元素，可以使用Map或者Set来存储元素，同时使用滑动窗口去判断
- 链表相关的题目
    - 力扣网：206题、92题：反转一个列表
        - 思路就是声明三个节点依次移动节点，并充值节点的next指向
        - 92题在206题反转的基础之上加入了范围内的反转，思路如下：![思路图片](./src/imgs/LeetCode92.png)