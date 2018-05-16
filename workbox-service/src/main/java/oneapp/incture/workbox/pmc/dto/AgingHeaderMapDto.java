package oneapp.incture.workbox.pmc.dto;

import java.math.BigDecimal;

public class AgingHeaderMapDto {
	private String key;
	private BigDecimal value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AgingDataMapDto [key=" + key + ", value=" + value + "]";
	}
}
