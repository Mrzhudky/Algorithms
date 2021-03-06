/**
链接：https://www.nowcoder.com/acm/contest/131/E
来源：牛客网

题目描述 
A 集合有 N 个元素，分别为 A1, A2, A3, ... ..., AN。
B 集合有 M 个元素，分别为 B1, B2, B3, ... ..., BM。
两个集合中的元素均为 01 字符串（字符串中只包含两种字符，0 和 1 ）。
每次操作，你可以在以下两种方式中选择一种：

删除：将某个集合中的某个元素删除。（每个元素只能被删除一次，删除一次之后就没了）
修改：将某个集合中的某个元素的一段区间倒置。（例如元素 10010，将区间 [1,3] 倒置后得到 00110 ）

删除 A 集合中第 i 个元素的花费为 dai。
删除 B 集合中第 i 个元素的花费为 dbi。
修改一次 A 集合中第 i 个元素的花费为 mai。
修改一次 B 集合中第 i 个元素的花费为 mbi。

请问，让 A 集合和 B 集合相等的最小花费是多少？
输入描述:
第一行输入一个整数 N，表示 A 集合有 N 个元素。
第二行输入 N 个互不相同的 01 字符串，表示 A1, A2, A3, ... ..., AN。 
第三行输入一个整数 M，表示 B 集合有 M 个元素。 
第四行输入 M 个互不相同的 01 字符串，表示 B1, B2, B3, ... ..., BM。
第五行输入 N 个整数，表示 da1, da2, da3, ... ..., daN。 
第六行输入 M 个整数，表示 db1, db2, db3, ... ..., dbM。 
第七行输入 N 个整数，表示 ma1, ma2, ma3, ... ..., maN。 
第八行输入 M 个整数，表示 mb1, mb2, mb3, ... ..., mbM。 
0 ≤ N,M ≤ 50.
1 ≤ |Ai|,|Bi| ≤ 16.
1 ≤ dai, dbi, mai, mbi ≤ 1000.
输出描述:
输出一个整数，表示最小花费。
示例1
输入
复制
5
000111 101010 000001 100 0
6
110110 011010 001101 010 1 001
1 1 1 1 1
1 1 1 1 1 1
4 5 1 6 2
6 3 2 1 4 5
输出
复制
10
示例2
输入
复制
5
000111 101010 000001 100 0
6
110110 011010 001101 010 1 001
4 5 1 6 2
6 3 2 1 4 5
1 1 1 1 1
1 1 1 1 1 1
输出
复制
17
说明
集合具有无序性，例如 { 10100,11,101} = { 101,10100,11}。
*/