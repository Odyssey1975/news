package web.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello/**").permitAll()
                .antMatchers("/changeUser/**").hasAuthority("ADMIN")
                .antMatchers("/addUser/**").permitAll()
                .antMatchers("/admin/**", "/crud/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").authenticated()
                .and()
                .formLogin()
                .usernameParameter("name")
                .defaultSuccessUrl("/user")
                .loginPage("/login")
                .permitAll();
        http.csrf().disable();
    }

}
