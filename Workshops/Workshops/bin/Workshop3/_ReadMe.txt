Workshop3
sample solution:
1. 新定义了Member类,继承Person,加入了新的属性memberNumber
2. 在不同类中override了toString()方法,来取代原来的show()
3. 创建Club类,来存储Member对象(Member[]),完成对于member的add,remove,show方法
注:使用Member[],无论是Arrays.cooyOf还是自定义的ensureArraySize(),都需要对整个数组copy一遍
自制:
使用ArrayList<Member>代替sample中的Member[]
尝试使用HashMap来处理memberNumber与Member之间的索引
