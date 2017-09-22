package com.mdrsolutions.chores; 
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*; 

/**
 * @author mrodgers
 */
@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value(value = "${chores.authentication.password}")
    @Getter 
    private String password;

    @Value(value = "${chores.authentication.username}")
    @Getter 
    private String username; 

    private static final String IN_MEM_ROLE_ADMIN = "ADMIN";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser(username).password(password).roles(IN_MEM_ROLE_ADMIN);
    } 

    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http.csrf().disable();
        http.httpBasic()
                .and()
                .authorizeRequests().anyRequest().hasRole(IN_MEM_ROLE_ADMIN);

    }

    public String hasAuthority() {
        return "hasAuthority('ROLE_" + IN_MEM_ROLE_ADMIN + "')";
    }
     
}
