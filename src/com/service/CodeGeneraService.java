package com.service;

/**
 * Created by sosoo on 2017/2/27.
 */
public class CodeGeneraService {
    private CodeGeneraServiceProviderInterface serviceProvider;

    public String generateCode(String jsonString) throws Exception {
        if (serviceProvider == null)
            throw new Exception("No CodeGeneraServiceProviderInterface");
        return serviceProvider.generateCode(jsonString);
    }

    public void setServiceProvider(CodeGeneraServiceProviderInterface serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
