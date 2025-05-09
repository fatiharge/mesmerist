package com.fatiharge.core.common;//package com.fatiharge.core.common;
//
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.client.ClientRequestContext;
//import jakarta.ws.rs.client.ClientRequestFilter;
//import jakarta.ws.rs.ext.Provider;
//import org.eclipse.microprofile.jwt.JsonWebToken;
//
//
//@Provider
//public class AuthTokenRequestFilter implements ClientRequestFilter {
//
//
//    @Inject
//    JsonWebToken jwt;
//
//    @Override
//    public void filter(ClientRequestContext requestContext)  {
//        String token = jwt.getRawToken();
//        requestContext.getHeaders().add("Authorization", "Bearer " + token);
//    }
//}