package com.iso.plogues.request.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestDto {
	private Long joinRequestNo;
	private Long joinNo;
	private String userId;
	@NotBlank(max=200 ,message="포부를 작성해주세요.")
	private String aspiration;
	private String status;
}
