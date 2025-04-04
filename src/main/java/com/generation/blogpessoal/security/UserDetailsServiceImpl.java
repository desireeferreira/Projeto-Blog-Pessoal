package com.generation.blogpessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;

@Service //indica que essa classe é um serviço do Spring
	public class UserDetailsServiceImpl implements UserDetailsService {
		//UserDetailsService- usada para buscar usuários no banco de dados
	
		@Autowired //injeta automaticamente a instância de UsuarioRepository dentro da classe.
		private UsuarioRepository usuarioRepository;

		@Override // validar o usuario se ele existe no banco de dados
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			
//Optional <Usuario> usuario = SELECT 8 FROM tb_usuario where usuario= "ja@e.com
			Optional<Usuario> usuario = usuarioRepository.findByUsuario(userName);

			if (usuario.isPresent())
				return new UserDetailsImpl(usuario.get());
			else
				throw new ResponseStatusException(HttpStatus.FORBIDDEN);
				
		}
	}
	// Lógica do código para entender
//1️- O método procura o usuário no banco pelo nome digitado.
//2️- Se o usuário existe, ele retorna os dados para o Spring Security autenticar.
//3️- Se o usuário não existe, o sistema bloqueia o acesso com um erro 403 - FORBIDDEN.
