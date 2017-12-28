package example.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable() // CSRF対策を無効化
      .authorizeRequests()
      .antMatchers("/", "/api/**").permitAll()
      .anyRequest().authenticated()
      .and().logout().logoutSuccessUrl("/").permitAll();


  }
}
