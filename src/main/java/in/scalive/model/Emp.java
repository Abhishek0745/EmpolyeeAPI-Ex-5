package in.scalive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer empId;
	@NotBlank(message="Emp name is required")
 private String ename;
	@NotNull(message="Salary is required")
	@Min(value=10000,message="Salary must be atleast 10000")
 private Double sal;
 
}
