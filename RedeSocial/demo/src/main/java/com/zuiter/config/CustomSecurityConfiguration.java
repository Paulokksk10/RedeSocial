package com.zuiter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.zuiter.services.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfiguration {

    // Configuração para codificar senhas de usuário
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuração para autenticação usando um provedor de autenticação personalizado
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    // Configuração para carregar informações do usuário
    @Bean
    public UserDetailsService userDetailsService() {
        return new UsuarioDetailsServiceImpl();
    }

    // Configuração de segurança para diferentes URLs da aplicação
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                    (authorize) -> authorize
                            .requestMatchers("/usuarios/cadastro").permitAll() // Permitir acesso sem autenticação a "/usuarios/cadastro"
                            .requestMatchers("/usuarios/salvar").permitAll() // Permitir acesso sem autenticação a "/usuarios/salvar"
                            .anyRequest().authenticated() // Exigir autenticação para outras requisições
                )
                .formLogin(
                    form -> form
                            .loginPage("/login") // Configurar a página de login em "/login"
                            .loginProcessingUrl("/login") // URL para processar o login
                            .defaultSuccessUrl("/home") // Redirecionar para "/atletas" após o login bem-sucedido
                            .permitAll() // Permitir acesso à página de login sem autenticação
                );
        return http.build(); // Construir as configurações de segurança
    }
}