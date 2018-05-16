package oneapp.incture.workbox.pmc.wsdlconsumers;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.springframework.stereotype.Service;

import com.incture.pmc.poadapter.services.ProcessActionFacade;
import com.incture.pmc.poadapter.services.ProcessActionFacadeBindingStub;
import com.incture.pmc.poadapter.services.ProcessActionFacadeServiceLocator;

import oneapp.incture.workbox.util.PMCConstant;

@Service("ProcessActionConsumer")
public class ProcessActionConsumer {
	
	private ProcessActionFacade getFacadePort() {
		try {
			return new ProcessActionFacadeServiceLocator().getprocessActionFacadePort();
		} catch (ServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	private ProcessActionFacade setStubProperties(ProcessActionFacade port) {
		ProcessActionFacadeBindingStub stub = (ProcessActionFacadeBindingStub) port;
		stub._setProperty(Stub.USERNAME_PROPERTY, PMCConstant.WBuserId);
		stub._setProperty(Stub.PASSWORD_PROPERTY, PMCConstant.WBpassword);
		return port;
	}
	
	public String cancelProcess(String processInstanceId) {
		ProcessActionFacade port = setStubProperties(getFacadePort());
		String response = "";
		try {
			response = port.cancelProcess(processInstanceId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response;
	}
}
