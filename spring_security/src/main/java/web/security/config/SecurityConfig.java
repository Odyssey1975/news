package web.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

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
                .usernameParameter("name") //pass bcrypt passwenc
                .defaultSuccessUrl("/user")
                .loginPage("/login")
                .permitAll();
        http.csrf().disable();
    }

}
