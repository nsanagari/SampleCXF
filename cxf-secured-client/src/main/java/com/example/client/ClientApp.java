package com.example.client;

//import com.example.service.HelloService;
//import com.example.service.HelloServiceImplService;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
//
//import java.util.HashMap;
//import java.util.Map;
//
////public class ClientApp {
////    public static void main(String[] args) {
////    	HelloServiceImplService service = new HelloServiceImplService();
////    	HelloService port = service.getHelloServiceImplPort();
////
////    	System.out.println("Callback class: " + com.example.security.ClientPasswordCallback.class.getName());
////
////    	
////    	Client client = ClientProxy.getClient(port);
////
////    	Map<String, Object> props = new HashMap<>();
////    	props.put("action", "UsernameToken Timestamp");
////    	props.put("user", "cxfUser");
////    	props.put("passwordCallbackClass", "com.example.security.ClientPasswordCallback");
////    	props.put("passwordCallbackRef", new com.example.security.ClientPasswordCallback());
////    	props.put("passwordCallbackClass", "com.example.security.ClientPasswordCallback");
////    	props.put("passwordType", "PasswordDigest"); // or PasswordText
////
////    	client.getRequestContext().put(
////    		    "ws-security.callback-handler", new ClientPasswordCallback()
////    		);
////    	client.getOutInterceptors().add(new WSS4JOutInterceptor(props));
////
////        // Call the service
////        String response = port.sayHello("Niranjan");
////        System.out.println("Response: " + response);
////    }
////}




import com.example.service.HelloService;
import com.example.service.HelloServiceImplService;

import jakarta.xml.ws.BindingProvider;
import java.util.Map;

public class ClientApp {
    public static void main(String[] args) {
        HelloServiceImplService service = new HelloServiceImplService();
        HelloService port = service.getHelloServiceImplPort();

        Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, "admin");
        // Callback handler as String class name (fully qualified)
        reqContext.put("ws-security.callback-handler", "com.example.security.ClientPasswordCallback");
        reqContext.put("ws-security.username", "cxfUser");
        reqContext.put("ws-security.password", "cxfPassword");

        System.out.println("Response: " + port.toString());
        String response = port.sayHello("Niranjan");
        System.out.println("Response: " + response);
    }
}
