package com.catcher.currencywidget;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().url("jdbc:postgresql://google/currencywidgetdb?cloudSqlInstance=currencywidgetserver:europe-central2:currencydatabase&socketFactory=com.google.cloud.sql.postgres.SocketFactory")
                .driverClassName("org.postgresql.Driver")
                .username("postgres")
                .password("MB|~S(bDqEPMV(H-")
                .build();
    }
}
