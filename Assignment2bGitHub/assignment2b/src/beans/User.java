package beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean

public class User {

		private String firstName;
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
