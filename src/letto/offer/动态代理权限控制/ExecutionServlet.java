package letto.offer.动态代理权限控制;

import letto.offer.leetcode.Test;

import java.util.Map;

public class ExecutionServlet {

    public static void main(String[] args) {
        ExecutionServlet s= new ExecutionServlet();
        s.Test();
    }
    public void Test() {
        User user01 = new User();
        user01.setId(1);
        ServiceFactory fac01 = ServiceFactory.getInstance();
        BusinessService bus01 = fac01.createBusinessService(user01);

        User user02 = new User();
        user02.setId(2);
        ServiceFactory fac02 = ServiceFactory.getInstance();
        BusinessService bus02 = fac02.createBusinessService(user02);

        User user03 = new User();
        user03.setId(1);
        ServiceFactory fac03 = ServiceFactory.getInstance();
        BusinessService bus03 = fac03.createBusinessService(user03);


        bus01.method01();//权限正确 测试方法01

        bus02.method01();//您没有该方法的执行权限

        bus03.method02();//没有注解 测试方法02
    }
}
