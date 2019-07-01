package br.com.kaykemendes.learningjpapostgres.Utils;

import org.springframework.http.HttpStatus;

public class GenericResponse {

    private HttpStatus status;
    private Object response;

    public GenericResponse(HttpStatus status, Object response) {
        this.status = status;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
