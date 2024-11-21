package data;

import java.util.List;

public record Student(Long rollNo, String firstName, String lastName, List<Subjects> subjects) {
}
