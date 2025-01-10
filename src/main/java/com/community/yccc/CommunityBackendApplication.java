package com.community.yccc;

import com.community.yccc.jwt.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.community.yccc.mapper")
public class CommunityBackendApplication {

//    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(CommunityBackendApplication.class);
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        filterRegistrationBean.setFilter(jwtAuthenticationFilter);
        return filterRegistrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityBackendApplication.class, args);
    }

}
