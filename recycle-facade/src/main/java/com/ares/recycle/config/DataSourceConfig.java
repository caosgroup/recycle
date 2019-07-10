package com.ares.recycle.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Set;

/**
 * @author wangqiaomu
 * @date 2019-07-04 20:00
 **/
@Slf4j
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {

    private final static String DATASOURCE_TAG = "db";

    /**
     * Db变更的key
     */
    public static final String DATASOURCE_KEY = "datasource";

    private final ApplicationContext context;

    @ApolloConfig
    private Config config;

    @Autowired
    public DataSourceConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean("dataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource source = new DynamicDataSource();
        source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
        return source;
    }

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        Set changedKeys = changeEvent.changedKeys();
        if (changedKeys.contains(DATASOURCE_KEY)) {
            DynamicDataSource source = context.getBean(DynamicDataSource.class);
            source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
            source.afterPropertiesSet();
            log.info("动态切换数据源为：{}", config.getProperty("datasource.url", ""));
        }

    }

    private DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(config.getProperty("datasource.url", ""));
        dataSource.setUsername(config.getProperty("datasource.username", ""));
        dataSource.setPassword(config.getProperty("datasource.password", ""));
        return dataSource;
    }


    class DynamicDataSource extends AbstractRoutingDataSource {
        @Override
        protected Object determineCurrentLookupKey() {
            return DATASOURCE_TAG;
        }

    }
}
