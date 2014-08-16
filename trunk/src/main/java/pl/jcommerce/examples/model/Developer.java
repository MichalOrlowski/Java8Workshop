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

	private String name;
	private List<Language> programmingLanguages;

	public Developer(String name, List<Language> programmingLanguages) {
		super();
		this.name = name;
		this.programmingLanguages = programmingLanguages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Language> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(List<Language> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, programmingLanguages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Developer) {
			Developer other = (Developer) obj;
			return Objects.equals(name, other.name)
					&& Objects.equals(programmingLanguages,
							other.programmingLanguages);
		}

		return false;
	}

}
