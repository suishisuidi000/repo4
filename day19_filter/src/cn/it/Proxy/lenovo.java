package cn.it.Proxy;
//真实类
public class lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"元买了一台电脑...");
        return "电脑";
    }

    @Override
    public void show() {
        System.out.println("玩电脑...");
    }

}
