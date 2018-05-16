package oneapp.incture.workbox.poadapter.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;
import oneapp.incture.workbox.util.ServicesUtil;


/**
 * @author VINU
 */
@XmlRootElement
public abstract class BaseDto {
	protected boolean isNullable = true;

	public abstract Boolean getValidForUsage();
	
	public abstract void validate(EnOperation enOperation)
			throws InvalidInputFault;

	protected void enforceMandatory(String field, Object value)
			throws InvalidInputFault {
		// TODO: Handle empty String case?? [ROHIT]
		if (ServicesUtil.isEmpty(value)) {
			String message = "Field=" + field + " can't be empty";
			throw new InvalidInputFault(message, null);
		}
	}

	/**
	 * STEP:
	 * <ol>
	 * <li>Trim the string</li>
	 * <li>Check if size is exceeding</li>
	 * </ol>
	 */
	protected String checkStringSize(String field, String value, int allowedSize)
			throws InvalidInputFault {
		if (!ServicesUtil.isEmpty(value)) {// check size
			value = value.trim();
			int sizeOfInput = value.length();
			if (sizeOfInput > allowedSize) {
				String message = "Exceeding size for[" + field
						+ "] allowed size is[" + allowedSize
						+ "], input value[" + value + "] is of size[ "
						+ sizeOfInput + "]";
				throw new InvalidInputFault(message, null);
			}
			return value;
		}
		return null;
	}

	/**
	 * STEP:
	 * <ol>
	 * <li>Check if size is exceeding</li>
	 * <li>Return corrected field</li>
	 * </ol>
	 */
	protected BigDecimal checkBigDecimalSize(String field, BigDecimal value,
			int allowedPrecision, int allowedScale) throws InvalidInputFault {
		if (value != null) {
			// STEP 1
			// TODO: TEST BELOW, LOOK FOR BETTER OPTION
			StringBuffer sb = new StringBuffer("1");
			while (allowedPrecision-- > 0) {
				sb.append("0");
			}
			if (value.compareTo(new BigDecimal(sb.toString())) > -1) {
				String message = "Exceeding size for field[" + field
						+ "] of allowed size[" + allowedPrecision
						+ "] and allowed decimal points[" + allowedScale
						+ "], input value[" + value + "]";
				throw new InvalidInputFault(message, null);
			}
		}
		// STEP 2: No correction for now
		return value;
	}

}
