package com.fatiharge.resource;


import com.fatiharge.core.filter.GlobalExceptionResponse;
import com.fatiharge.shared.user.dto.auth.LoginRequest;
import com.fatiharge.shared.user.dto.auth.TokenResponse;
import com.fatiharge.service.AuthService;
import io.quarkus.security.Authenticated;
import io.quarkus.security.UnauthorizedException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


@Path("/auth")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    AuthService authService;

    @Inject
    JsonWebToken jwt;

    @POST
    @Path("/login")
    @APIResponse(
            responseCode = "4**",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = GlobalExceptionResponse.class
                    )
            )
    )
    public TokenResponse login(LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @GET
    @Path("/refreshToken")
    @APIResponse(
            responseCode = "4**",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = GlobalExceptionResponse.class
                    )
            )
    )
    @Authenticated
    public TokenResponse refreshToken() {
        String userId = jwt.getName();
        String authorizationHeader = jwt.getRawToken();

        boolean isRefreshClaimContains = Boolean.parseBoolean(jwt.getClaim("refresh").toString());//todo

        if (!isRefreshClaimContains) {
            throw new UnauthorizedException();
        }

        return authService.refreshToken(Long.valueOf(userId), authorizationHeader);
    }


}
