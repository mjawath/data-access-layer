package com.openworld.tech.dal.meta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.Properties;

//@Configuration ignoring orm in the interest of Meta DAL
//@EnableTransactionManagement
//@refeshScope//
public class PersistentLayerConfiguration {

    /**
     * seems this is needed to create entity manager factory
     *
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
//        factory.setDataSource(dataSource());
//        factory.setMappingResources(orm);
//        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        //comment the following line if you want to use default META-INF/persistence.xml
//        factory.setPersistenceXmlLocation("persistence.xml");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.setProperty("javax.persistence.schema-generation.database.action", "create");
//        properties.setProperty("javax.persistence.schema-generation.database.action", "create");
//        factory.setJpaProperties(properties);
//        factory.setPackagesToScan("com.test.meta");
        return factory;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


}
