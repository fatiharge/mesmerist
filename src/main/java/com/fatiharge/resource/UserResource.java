package com.fatiharge.resource;


import com.fatiharge.core.filter.GlobalExceptionResponse;
import com.fatiharge.shared.user.dto.user.CreateUserRequest;
import com.fatiharge.shared.user.dto.user.UserResponse;
import com.fatiharge.service.UserService;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    JsonWebToken jwt;

    @APIResponse(responseCode = "4**", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalExceptionResponse.class)))
    @POST
    public UserResponse createUser(@Valid CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }


    @GET
    @Authenticated
    @APIResponse(responseCode = "4**", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalExceptionResponse.class)))
    public UserResponse getUser() {
        return userService.getUserById(Long.parseLong(jwt.getName()));
    }

    @GET
    @Path("/getUser/{id}")
    @RolesAllowed({"admin", "app"})
    @APIResponse(responseCode = "4**", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalExceptionResponse.class)))
    public UserResponse getUserById(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }


    @DELETE
    @Path("/{id}")
    @RolesAllowed({"admin", "app"})
    @APIResponse(responseCode = "4**", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalExceptionResponse.class)))
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}

