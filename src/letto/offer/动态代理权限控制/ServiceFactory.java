package letto.offer.动态代理权限控制;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceFactory {
    private ServiceFactory() {}
    private static ServiceFactory instance = new ServiceFactory();
    public static ServiceFactory getInstance() {
        return instance;
    }

    public BusinessService createBusinessService(User user) {
        BusinessService service = new BusinessServiceImp();

        //产生代理对象并且返回
        return (BusinessService) Proxy.newProxyInstance(ServiceFactory.class.getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //得到要调用的方法的注解
                Permission per = method.getAnnotation(Permission.class);
                //如果没有注解
                if(per == null) {
                    System.out.println("没有注解");
                    return method.invoke(service, args);
                }
                //在这里如果user的id与注解相同，就是拥有该权限
                if(user.getId()==per.value()) {
                    System.out.println("权限正确");
                    return method.invoke(service, args);
                }
                //id与注解不同
                System.out.println("您没有该方法的执行权限");
                return null;
            }
        });
    }
}

interface BusinessService {
    @Permission(1)
    public void method01();

    public void method02();
}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Permission {

    int value();

}
class BusinessServiceImp implements BusinessService {
    @Permission(1)
    @Override
    public void method01() {
        System.out.println("测试方法01");
    }

    @Override
    public void method02() {
        System.out.println("测试方法02");
    }
}

class User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}