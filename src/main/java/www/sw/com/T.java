package www.sw.com;

public class T {

    public int sum(int a,int b) {
        return a+b;
    }
    public static void main(String[] args) {
        T t=new T();
        int c=t.sum(10, 1);
        System.out.println(c);
    }
}
