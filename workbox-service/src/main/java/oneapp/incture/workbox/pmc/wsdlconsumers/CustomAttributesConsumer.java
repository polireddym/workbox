package oneapp.incture.workbox.pmc.wsdlconsumers;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.springframework.stereotype.Service;

import com.incture.pmc.poadapter.services.CustomAttributeDto;
import com.incture.pmc.poadapter.services.CustomAttributesService;
import com.incture.pmc.poadapter.services.CustomAttributesServiceBindingStub;
import com.incture.pmc.poadapter.services.CustomAttributesServiceServiceLocator;

import oneapp.incture.workbox.util.PMCConstant;
@Service("CustomAttributesConsumer")
public class CustomAttributesConsumer {

	private CustomAttributesService getFacadePort() {
		try {
			return new CustomAttributesServiceServiceLocator().getCustomAttributesServicePort();
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	private CustomAttributesService setStubProperties(CustomAttributesService port) {
		CustomAttributesServiceBindingStub stub = (CustomAttributesServiceBindingStub) port;
		stub._setProperty(Stub.USERNAME_PROPERTY, PMCConstant.WBuserId);
		stub._setProperty(Stub.PASSWORD_PROPERTY, PMCConstant.WBpassword);
		return port;
	}

	public CustomAttributeDto getCustomAttributes(String taskId) {
		CustomAttributesService port = setStubProperties(getFacadePort());
		CustomAttributeDto dto = null;
		try {
			dto = port.getCustomAttributes(taskId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
