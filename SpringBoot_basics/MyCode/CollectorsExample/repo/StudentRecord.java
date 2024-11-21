package repo;

public record StudentRecord(String name,int Age) {
    public StudentRecord(int Age){
        this("",Age);
    }
}
