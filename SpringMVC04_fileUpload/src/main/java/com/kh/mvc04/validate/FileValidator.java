package com.kh.mvc04.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


// 유효성 검사 : 스프링은 객체가 유효한 지의 여부를 검사할때 사용되는 Validator 인터페이스와 유효성 검사 결과를 저장할 Errors인터페이스를 제공함
@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	// Validator가 해당 클래스에 대한 값 검증을 지원하는 지의 여부를 리턴
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {	// target객체에 대한 검증을 실행한다. 
															// 검증 결과 문제가 있을경우 errors 객체에 어떤 문제인지에 대한 정보를 저장한다.
		UploadFile file = (UploadFile) target;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file","errorCode","Pleas select a file");
			// rejectValue : 필드에 대한 에러 코드를 추가한다.
		}
	}

}
