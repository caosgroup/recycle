package com.ares.recyce.commcon.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private Integer code;

    private String msg;

}
