package oneapp.incture.workbox.util;

import com.sap.security.um.service.UserManagementAccessor;
import com.sap.security.um.user.PersistenceException;
import com.sap.security.um.user.User;
import com.sap.security.um.user.UserProvider;

public class UserManagementUtil {

	public static User getLoggedInUser() {
		try {
			UserProvider provider = UserManagementAccessor.getUserProvider();
			User user = provider.getCurrentUser();
			return user;
		} catch(PersistenceException e){
			System.err.println("Exception : "+e.getMessage());
			return null;
		}
	}
}
