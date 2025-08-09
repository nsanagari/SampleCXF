package com.example.client;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class UTPasswordCallback implements CallbackHandler {
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            WSPasswordCallback pc = (WSPasswordCallback) cb;
            if ("cxfUser".equals(pc.getIdentifier())) {
                pc.setPassword("cxfPassword");
            }
        }
    }
}
