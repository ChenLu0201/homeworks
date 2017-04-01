package com.tw.lane.bcc.Exception;

import java.lang.*;

/**
 * Created by luchen on 13/10/2016.
 */
public class InputLoadingException extends java.lang.Exception {
    public InputLoadingException(String message) {
        super(message);
    }

    public InputLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
