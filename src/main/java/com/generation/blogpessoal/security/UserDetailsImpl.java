package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	//controle de versão para a classe
	
	private String userName; // recebo o e-mail
	private String password;// recebo a senha
	private List<GrantedAuthority> authorities; //authorities- e uma Lista de permissões  concedidas ao usuário.
	//grandauthority ele trabalha com as autorizações do que ele pode acessar no sistema.
	
	public UserDetailsImpl(Usuario user) {// userdetails implement e um metodo construtor
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}

	public UserDetailsImpl() {	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//Retorna a lista de permissões (ou seja, roles que são autorizações que o usuário possui.
		// O ? significa que  uma variavel generica, pq não tem uma lista especifica de autorizações
		return authorities; //
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return userName;
	}
	//verifica se a conta do usuário ainda é válida ou se está expirada
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
// verifica se o usuario está bloqueado
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
//auxilia validar a credencial de data limite de usuario
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
//verifica o usuario que está ativo
	@Override
	public boolean isEnabled() {
		return true;
	}

}