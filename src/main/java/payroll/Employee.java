package payroll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        String[] newArray = Arrays.copyOfRange(parts, 1, parts.length - 1);
        this.firstName = parts[0];
        this.lastName = String.join(" ", Arrays.asList(newArray));
    }

}
