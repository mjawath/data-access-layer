package com.openworld.tech.dal.meta.custom;

public class Testconfig {
}
//
//@Configuration
//@PropertySource(value = { "classpath:database/jdbc.properties" })
//@EnableTransactionManagement
//public class PersistenceConfig {
//
//    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
//    private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
//    private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
//    private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
//    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
//    private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = {"a.b.c.entities", "a.b.c.converters"};
//
//    @Autowired
//    private Environment env;
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("jdbc.url"));
//        dataSource.setUsername(env.getProperty("jdbc.username"));
//        dataSource.setPassword(env.getProperty("jdbc.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public JpaTransactionManager jpaTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    private HibernateJpaVendorAdapter vendorAdaptor() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(true);
//        return vendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
//        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
//
//        return entityManagerFactoryBean;
//    }
//
//    private Properties jpaHibernateProperties() {
//
//        Properties properties = new Properties();
//
//        properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, env.getProperty(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH));
//        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE));
//        properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, env.getProperty(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE));
//        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//
//        properties.put(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");
//        properties.put(AvailableSettings.USE_CLASS_ENHANCER, "false");
//        return properties;
//    }
//
//}