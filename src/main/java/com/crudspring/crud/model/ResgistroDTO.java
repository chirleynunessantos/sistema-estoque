package com.crudspring.crud.model;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public record ResgistroDTO(String login, String senha, UsuarioRoles role) {

}
