package com.example.security;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class ClientPasswordCallback implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    	System.out.println("############## : handle");
        for (Callback cb : callbacks) {
            if (cb instanceof WSPasswordCallback) {
            	System.out.println("############## : instanceof");
                WSPasswordCallback pc = (WSPasswordCallback) cb;
                if ("cxfUser".equals(pc.getIdentifier())) {
                    pc.setPassword("cxfPassword");
                }
            }
        }
    }
}
