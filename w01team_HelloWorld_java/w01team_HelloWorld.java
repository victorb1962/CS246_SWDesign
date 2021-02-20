package helloworld;

public class HelloWorld {

    public void sayHello() {
        // The end line character happens automatically when we use
        // the println() function.
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        // Create an instance of the class, and call the function.
        HelloWorld hello = new HelloWorld();
        hello.sayHello();

        // An alternate style that doesn't store the class instance:
        // new HelloWorld().sayHello();
    }
}
