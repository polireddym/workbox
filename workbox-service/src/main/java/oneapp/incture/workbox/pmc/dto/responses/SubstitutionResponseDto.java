package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import com.incture.pmc.poadapter.services.SubstitutionRuleDto;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class SubstitutionResponseDto {

	List<SubstitutionRuleDto> ruleDto;
	ResponseMessage response;

	public List<SubstitutionRuleDto> getRuleDto() {
		return ruleDto;
	}

	public void setRuleDto(List<SubstitutionRuleDto> ruleDto) {
		this.ruleDto = ruleDto;
	}

	public ResponseMessage getResponse() {
		return response;
	}

	public void setResponse(ResponseMessage response) {
		this.response = response;
	}

}
