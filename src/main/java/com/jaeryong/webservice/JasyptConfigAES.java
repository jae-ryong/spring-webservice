package com.jaeryong.webservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class JasyptConfigAES {

    @Value("${jasypt.encryptor.password}")
    private String encryptKey;
    @Bean("jasyptEncryptorAES")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(encryptKey); // 암호화키
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setPoolSize("1"); // 인스턴스 pool
        encryptor.setConfig(config);
        return encryptor;
    }
}
