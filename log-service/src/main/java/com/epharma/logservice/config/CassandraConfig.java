package com.epharma.logservice.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String KEYSPACE;

    @Value("${spring.data.cassandra.contact-points}")
    private String hosts;

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "com.epharma.logservice.model", };
    }

    @Override
    protected boolean getMetricsEnabled() {
        return false;
    }

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
  
      RetryingCassandraClusterFactoryBean bean = new RetryingCassandraClusterFactoryBean();
  
      bean.setAddressTranslator(getAddressTranslator());
      bean.setAuthProvider(getAuthProvider());
      bean.setClusterBuilderConfigurer(getClusterBuilderConfigurer());
      bean.setClusterName(getClusterName());
      bean.setCompressionType(getCompressionType());
      bean.setContactPoints(getContactPoints());
      bean.setLoadBalancingPolicy(getLoadBalancingPolicy());
      bean.setMaxSchemaAgreementWaitSeconds(getMaxSchemaAgreementWaitSeconds());
      bean.setMetricsEnabled(getMetricsEnabled());
      bean.setNettyOptions(getNettyOptions());
      bean.setPoolingOptions(getPoolingOptions());
      bean.setPort(getPort());
      bean.setProtocolVersion(getProtocolVersion());
      bean.setQueryOptions(getQueryOptions());
      bean.setReconnectionPolicy(getReconnectionPolicy());
      bean.setRetryPolicy(getRetryPolicy());
      bean.setSpeculativeExecutionPolicy(getSpeculativeExecutionPolicy());
      bean.setSocketOptions(getSocketOptions());
      bean.setTimestampGenerator(getTimestampGenerator());
  
      bean.setKeyspaceCreations(getKeyspaceCreations());
      bean.setKeyspaceDrops(getKeyspaceDrops());
      bean.setStartupScripts(getStartupScripts());
      bean.setShutdownScripts(getShutdownScripts());
  
      return bean;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
                .createKeyspace(KEYSPACE).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true).withSimpleReplication();
        return Arrays.asList(specification);
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getContactPoints() {
      return hosts;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        
        };
    }
}