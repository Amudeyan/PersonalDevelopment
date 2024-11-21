import java.util.ArrayList;
import java.util.List;

public class ListClass {

    private List<CustomClass> customClasses;

    public ListClass() {
       // customClasses = new ArrayList<>();
        System.out.println("construct");
    }
    {
        customClasses = new ArrayList<>();
        System.out.println("instance ");
    }
    public ListClass(List<CustomClass> customClasses) {
        this.customClasses = customClasses;
    }



    public List<CustomClass> getCustomClasses() {
        return customClasses;
    }

    public void setCustomClasses(List<CustomClass> customClasses) {
        this.customClasses = customClasses;
    }
}
