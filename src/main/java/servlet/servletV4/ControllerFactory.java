package servlet.servletV4;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ControllerFactory {
    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c){
        //TODO: beanMap에 key = method + servletPath, value = Controller instance를 저장합니다.
        c.
        beanMap.put(c.)
    }

    public Object getBean(String method, String path){
        //TODO: beanMap 에서 method+servletPath을 key로 이용하여 Controller instance를 구합니다.
        Object object = beanMap.get(method+path);
        return null;
    }
}
