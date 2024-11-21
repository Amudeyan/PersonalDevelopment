import java.util.*;

public enum EnumSingleton {
    ORDERED,READY,
    delivery("delivery"),
    ordered("ordered"),
    packed("packed");

private String name;
private EnumSet<EnumSingleton> set;
private EnumMap<EnumSingleton, List<String>> map;

    EnumSingleton() {

    }
    EnumSingleton(String name) {
        this.name = name;
    }
    EnumSingleton(String name,EnumSet<EnumSingleton> set,EnumMap<EnumSingleton, List<String>> map) {
        this.name = name;
        this.set = set;
        this.map = map;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSet<EnumSingleton> getSet() {
        return set;
    }

    public void setSet(EnumSet<EnumSingleton> set) {
        this.set = set;
    }

    public EnumMap<EnumSingleton, List<String>> getMap() {
        return map;
    }
}
