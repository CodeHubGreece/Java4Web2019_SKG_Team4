package regenaration.team4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import regenaration.team4.security.ApiAccessDeniedHandler;
import regenaration.team4.security.ApiAuthenticationEntryPoint;
import regenaration.team4.security.ApiAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebAppConfig extends WebSecurityConfigurerAdapter {

    private ApiAuthenticationEntryPoint authenticationEntryPoint;
    private ApiAuthenticationSuccessHandler apiSuccessHandler;
    private ApiAccessDeniedHandler accessDeniedHandler;
    private UserDetailsService userDetailsService;

    @Autowired
    public void setAuthenticationEntryPoint(ApiAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Autowired
    public void setApiSuccessHandler(ApiAuthenticationSuccessHandler apiSuccessHandler) {
        this.apiSuccessHandler = apiSuccessHandler;
    }

    @Autowired
    public void setAccessDeniedHandler(ApiAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired
    public void setUserDetailsService(@Qualifier("apiUserDetailService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/static/citizen/**").hasRole(Role.CITIZEN.name())
                .antMatchers("/static/doctor/**").hasRole(Role.DOCTOR.name())
                .antMatchers("/static/**").authenticated()
                .and()
                .formLogin()
                .successHandler(apiSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutSuccessUrl("/login.html");
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public enum Role {
        DOCTOR,
        CITIZEN
    }
}



