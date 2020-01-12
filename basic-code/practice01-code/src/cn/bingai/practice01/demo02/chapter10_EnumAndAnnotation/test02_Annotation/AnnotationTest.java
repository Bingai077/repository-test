package cn.bingai.practice01.demo02.chapter10_EnumAndAnnotation.test02_Annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的使用：
 * <p>
 * 1.理解Annotation
 * 1.1jdk5.0 新增的功能
 * <p>
 * 1.2 Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * <p>
 * 1.3 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面， 代替JavaEE旧版中所遗留的繁冗代码和XML配置等
 * <p>
 * 2.Annocation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二： 在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * <p>
 * 示例三： 跟踪代码依赖性，实现替代配置文件功能
 *
 * 3. 如何自定义注解：参照@SuppressWarnings定义
 *    3.1 注解声明为@interface
 *    3.2 内部定义成员，通常使用value表示
 *    3.3 可以指定成员的默认值，使用default定义
 *    3.4 如果自定义注解没有成员，表明是一个标识作用。
 *
 *    如果注解有成员，在使用注解时，需要指明成员的成员。
 *    自定义注解必须配上注解的信息处理流程才有意义。
 *    自定义注解一般都会指明两个元注解：Retention、Target
 * 
 * 4. jdk 提供的4种元注解
 *    元注解：对现有注解进行解释说明的注解
 *       Retention：用于指定该 Annotation 的生命周期：
 *                      SOURCE\CLASS(默认行为)\RUNTIME,只有声明为RUNTIME，才能通过反射获取

         Target：用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。
            
        ******出现频率低******
         Documented：用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。
         Inherited：被它修饰的 Annotation 将具有继承性。如果某个类使用了被@Inherited 修饰的 Annotation, 则其子类将自动具有该注解。
 *
 * 5. 通过反射获取注解信息 ---到反射再系统讲解
 *
 * 6. jdk 8 中注解的新特性：可重复注解、类型注解
 * 6.1 可重复注解: 1. 在MyAnnotation上声明@Repeatable,成员值为MyAnnotation.class
 *                2. MyAnnontation的target和Retention等元注解和MyAnnontations相同
 *
 * 6.2 类型注解：
 *           ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如： 泛型声明） 。
             ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 * @author bingai
 * @create 2019-11-04 15:25
 */
@SuppressWarnings("all")
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;
//        System.out.println(num);

        ArrayList objects = new ArrayList();
    }


    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation ann : annotations) {
            System.out.println(ann);
        }
    }

}



//jdk 8之前的写法
@MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "abc")})
//@MyAnnotation(value = "hi")
//@MyAnnotation(value = "abc")
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}


class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }


    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}
