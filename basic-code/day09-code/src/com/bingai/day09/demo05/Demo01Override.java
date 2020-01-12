package com.bingai.day09.demo05;

/*
方法覆盖重写的注意事项：

1.必须保证父子类之间方法的名称相同，参数列表也相同。
@override：写在方法前面用来检测是不是有效的正确覆盖重写。
这个注解就算不写，只要满足要求，也是正确的方法覆盖重写。

2.子类方法的【返回值】必须【小于等于】父类方法的返回值范围。
java.lang.Object类是所有类的公共最高父类（祖宗类），
java.lang.String类就是Object类的子类

3.子类方法的【权限】必须【大于等于】父类方法的权限修饰符
    public > protected > (default) > private
    备注：(default)不是关键字default，而是什么都不写，留空。

大多数情况下，返回值、权限都是相等关系

 */
public class Demo01Override {



}
