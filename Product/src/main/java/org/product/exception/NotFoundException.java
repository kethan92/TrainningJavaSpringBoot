package org.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3845455461178772826L;

    public NotFoundException(String mes) {
        // TODO Auto-generated constructor stub
        super(mes);
    	//mes="loi";
    }
}
