package com.example.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.version.Version;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.common.ext.WSSecurityException;

public class ServerPasswordCallback implements CallbackHandler {

    private static final Map<String, String> passwords = new HashMap<>();

    static {
        passwords.put("cxfUser", "cxfPassword");  // expected username/password
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callback;

                // PasswordType could be PW_TEXT or PW_DIGEST
                String pass = passwords.get(pc.getIdentifier());
                System.out.println("Received Username: " + pc.getIdentifier());

                if (pass == null) {
                	System.out.println("handle ##################### : NULL#");
                    throw new IOException("Invalid username");
                }

                pc.setPassword(pass);
            } else {
                // Silently ignore non-WSPasswordCallback to avoid crash
                // You can log or handle TokenStoreCallback here if needed
            	System.out.println("handle ##################### : else#");
                throw new UnsupportedCallbackException(callback, "Unrecognized Callback: " + callback.getClass());
            }
        }
    }
}
