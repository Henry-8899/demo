package cn.henry.demo.instance;

public class TestInstance {
    interface C{

    }
    static class A {
    }

    static class B extends A implements C{
    }

    /**
     * obj.instanceof(class)
     * 也就是说这个对象是不是这种类型，
     *
     * 1.一个对象是本身类的一个对象
     * 2.一个对象是本身类父类（父类的父类）和接口（接口的接口）的一个对象
     * 3.所有对象都是Object
     * 4.凡是null有关的都是false  null.instanceof(class)
     *
     * class.inInstance(obj)
     * 这个对象能不能被转化为这个类
     *
     * 1.一个对象是本身类的一个对象
     * 2.一个对象能被转化为本身类所继承类（父类的父类等）和实现的接口（接口的父接口）强转
     * 3.所有对象都能被Object的强转
     * 4.凡是null有关的都是false   class.inInstance(null)
     *
     * 类名.class和对象.getClass()几乎没有区别，因为一个类被类加载器加载后，就是唯一的一个类。
     * @param args
     * @see : https://www.cnblogs.com/greatfish/p/6096038.html
     */
    public static void main(String[] args) {

        B b = new B();
        A a = new A();
        A ba = new B();
        System.out.println("1------------");

        /**
         * false
         * true
         * true
         * true
         * true
         * false
         */
        System.out.println(a instanceof C);
        System.out.println(b instanceof C);
        System.out.println(b instanceof B);
        System.out.println(b instanceof A);
        System.out.println(b instanceof Object);
        System.out.println(null instanceof Object);
        System.out.println("2------------");

        /**
         * true
         * false
         */
        System.out.println(b.getClass().isInstance(b));
        System.out.println(b.getClass().isInstance(a));
        System.out.println("3------------");

        /**
         * true
         * true
         * false
         */
        System.out.println(a.getClass().isInstance(ba));
        System.out.println(b.getClass().isInstance(ba));
        System.out.println(b.getClass().isInstance(null));
        System.out.println("4------------");

        /**
         * true
         * true
         * true
         */
        System.out.println(A.class.isInstance(a));
        System.out.println(A.class.isInstance(b));
        System.out.println(A.class.isInstance(ba));
        System.out.println("5------------");

        /**
         * false
         * true
         * true
         */
        System.out.println(B.class.isInstance(a));
        System.out.println(B.class.isInstance(b));
        System.out.println(B.class.isInstance(ba));
        System.out.println("6------------");

        /**
         * true
         * false
         */
        System.out.println(Object.class.isInstance(b));
        System.out.println(Object.class.isInstance(null));

    }
}
