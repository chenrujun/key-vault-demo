/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */

package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties
public class SampleApplication implements CommandLineRunner {

    @Value("${yourSecretPropertyName}")
    private String yourSecretPropertyName;

    @Autowired
    KeyVaultTestProperties keyVaultTestProperties;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    public void run(String[] args) {
        log.info("property yourSecretPropertyName in Azure Key Vault: {}", yourSecretPropertyName);
        log.info("keyVaultTestProperties.getTestProperty(): {}", keyVaultTestProperties.getTestProperty());

    }

}
