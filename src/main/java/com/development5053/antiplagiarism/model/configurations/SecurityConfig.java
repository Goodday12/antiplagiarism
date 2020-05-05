package com.development5053.antiplagiarism.model.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.development5053.antiplagiarism.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void globalConfigure(AuthenticationManagerBuilder auth, AuthenticationProvider provider) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("STUDENT")
                .and()
                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("STUDENT")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("TEACHER");
        //        inMemoryConfigure()
//                .withUser("Dima")
//                .password("merkloh1488")
//                .roles("TEACHER")
//                .and()
//                .configure(builder);
//        builder.authenticationProvider(provider);
    }

    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigure() {
        return new InMemoryUserDetailsManagerConfigurer<>();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/teacher-page/**").access("hasRole('TEACHER')")
                .antMatchers("/code-checker").access("hasAnyRole('TEACHER','STUDENT')")
                .antMatchers("/load-file").access("hasAnyRole('TEACHER','STUDENT')")
                .antMatchers("/").permitAll().anyRequest().authenticated()
                .and()
                .httpBasic();
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .permitAll()
////                    .loginProcessingUrl("/perform_login")
////                    .defaultSuccessUrl("/")
////                .failureUrl("/login?error=true")
////                .failureHandler(aut)
//                .usernameParameter("usernameLogin")
//                .passwordParameter("passwordLogin")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        httpSecurity.addFilterBefore(encodingFilter, CsrfFilter.class);
    }

}

