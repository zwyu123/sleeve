package com.lin.sleeve.advice;

import com.lin.sleeve.constant.Result;
import com.lin.sleeve.exception.http.HttpException;
import com.lin.sleeve.vo.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(HttpServletRequest req, Exception e) {
        Response response = new Response(Result.ERROR, "服务器异常");
        return response;
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<Response> handleHttpException(HttpServletRequest req, HttpException e) {
        Response response = new Response(Result.ERROR, e.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());

        ResponseEntity<Response> responseEntity = new ResponseEntity<>(response, headers, httpStatus);
        return responseEntity;
    }
}
