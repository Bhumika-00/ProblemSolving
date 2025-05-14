abstract class abstraction {
    void eats()
    {
        System.out.println("i eat");
    }
    abstract void walk();
}
class aabb extends abstraction{
    void walk(){
        System.out.println("walks");
    }
    public static void main(String[] args) {
        aabb a1 = new aabb();
        a1.eats();
        a1.walk();
    }
}
