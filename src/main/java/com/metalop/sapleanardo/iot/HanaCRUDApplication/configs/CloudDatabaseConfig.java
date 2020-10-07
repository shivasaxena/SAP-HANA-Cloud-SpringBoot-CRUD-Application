package com.metalop.sapleanardo.iot.HanaCRUDApplication.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sap.db.jdbcext.HanaDataSource;
import com.sap.hana.cloud.hcp.service.common.HANAServiceInfo;
import com.zaxxer.hikari.HikariDataSource;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.UriInfo;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;

@Configuration
@Profile("cloud")
public class CloudDatabaseConfig extends AbstractCloudConfig {

	CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
	DataSourceProperties properties = new DataSourceProperties();
	CfCredentials hanaCredentials = cfJdbcEnv.findCredentialsByTag("hana");

	@Bean
	public DataSource dataSource() {

		String username = hanaCredentials.getUsername();
		String password = hanaCredentials.getPassword();

		String url = hanaCredentials.getUriInfo().toString();

		return DataSourceBuilder.create().type(HikariDataSource.class)
				.driverClassName(com.sap.db.jdbc.Driver.class.getName())
				.url(url).username(username)
				.password(password)
				.build();

	}

}