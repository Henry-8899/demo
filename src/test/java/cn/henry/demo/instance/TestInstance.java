package cn.henry.demo.instance;

public class TestInstance {
    interface C{

    }
    static class A {
    }

    static class B extends A implements C{
    }

    public static void main(String[] args) {

        // 详见：https://www.cnblogs.com/greatfish/p/6096038.html
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
