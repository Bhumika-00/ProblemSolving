public class constructor {
    String name;
    int age;
    constructor(String name , int age)
    {
    this.name=name;
    this.age=age;
    }
    constructor(constructor c1)
    {
        this.name=c1.name;
        this.age=c1.age;
    }
    public static void main(String[] args) {
        constructor c1 = new constructor("ram", 19);
        constructor c2 = new constructor(c1);
        System.out.println(c2.name);
    
    }
}
