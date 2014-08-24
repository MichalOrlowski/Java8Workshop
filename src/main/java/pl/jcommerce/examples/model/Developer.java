package pl.jcommerce.examples.model;

import java.util.List;
import java.util.Objects;

/**
 * Developer POJO representation
 * 
 * @author Michal Orlowski
 *
 */
public class Developer {

	private String firstName;
	private String lastName;
	private String email;
	private Integer age;
	private List<Language> programmingLanguages;

	public Developer(String firstName, String lastName, String email,
			List<Language> programmingLanguages) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.programmingLanguages = programmingLanguages;
	}
	
	public Developer(String firstName, String lastName,
			Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Language> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(List<Language> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, age,
				programmingLanguages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Developer) {
			Developer other = (Developer) obj;
			return Objects.equals(firstName, other.firstName)
					&& Objects.equals(lastName, other.lastName)
					&& Objects.equals(email, other.email)
					&& Objects.equals(age,  other.age)
					&& Objects.equals(programmingLanguages, other.programmingLanguages);
		}

		return false;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + email + ")";
	}

}
