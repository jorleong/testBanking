//package com.jorleong.onlinebanking.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import domain.com.jorleong.onlinebanking.ExceptionResponse;
//
//@ControllerAdvice//handles exception throughout the whole application
//public class ExceptionController {
//	
////	@ExceptionHandler//works at method level
////	public ResponseEntity<String> handlesException(Exception e){
////		return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
////	}
//	
//	@ExceptionHandler//works at method level
//	public ResponseEntity<ExceptionResponse> handlesException(Exception e){
//		ExceptionResponse exceptionResponse = new ExceptionResponse();
//		exceptionResponse.setErrorCode(e.getClass().getSimpleName());
//		exceptionResponse.setErrorMessage(e.getMessage());
//		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.CONFLICT);
//	}
//	
//}
