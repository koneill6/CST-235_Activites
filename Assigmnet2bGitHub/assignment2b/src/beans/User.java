package beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ManagedBean

public class User {

		@NotNull(message="First name cannot be null")
		@NotEmpty(message="First name cannot be empty")
		@Size(min=1, max=15, message="First name must be between 5-15 characters")
		private String firstName;
		
		@NotNull(message="Last name cannot be null")
		@NotEmpty(message="Last name cannot be empty")
		@Size(min=1, max=15, message="Last name must be between 5-15 characters")
		private String lastName;
		
		public User() {
			firstName = "Kody";
			lastName = "O'Neill";
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		
}
