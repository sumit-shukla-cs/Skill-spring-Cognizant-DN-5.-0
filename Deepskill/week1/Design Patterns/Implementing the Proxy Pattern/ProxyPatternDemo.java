public class ProxyPatternDemo{
    public static void main(String[] args){
        System.out.println();
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");
        image1.display();
        image1.display();
        image2.display();
        image2.display();
    }
}