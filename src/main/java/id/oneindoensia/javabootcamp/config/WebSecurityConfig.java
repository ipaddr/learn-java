package id.oneindoensia.javabootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests().antMatchers( HttpMethod.GET, "/employees/**", "/api/**")
                .authenticated()
                .and()
                .authorizeRequests().antMatchers( HttpMethod.POST,  "/employees/**", "/api/**")
                .hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers( HttpMethod.PUT,  "/employees/**", "/api/**")
                .hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers( HttpMethod.DELETE,  "/employees/**", "/api/**")
                .hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/sayhello").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("pass")
                        .roles("ADMIN")
                        .build();

        UserDetails employee =
                User.withDefaultPasswordEncoder()
                        .username("employee")
                        .password("pass")
                        .roles("EMPLOYEE")
                        .build();
        return new InMemoryUserDetailsManager(admin, employee);
    }
}
