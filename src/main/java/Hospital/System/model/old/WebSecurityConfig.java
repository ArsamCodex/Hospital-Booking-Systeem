//package Hospital.System.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
////@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfig  {
//
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select email, password from user where username=?")
//                .authoritiesByUsernameQuery("select username, role from role where username=?")
//        ;
//    }
//}
