public class pen {
      String color;
      int tip;
      public void Setcolor(String color){
       this.color=color;
      }
      public void Settip(int tip){
        this.tip=tip;
      }
      public void getColor()
      {
        System.out.println(color);
      }
      public static void main(String[] args) {
        pen p1= new pen();
        p1.Setcolor("red");
        p1.getColor();
      }
}
