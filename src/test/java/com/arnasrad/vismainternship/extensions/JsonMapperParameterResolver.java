package com.arnasrad.vismainternship.extensions;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonMapperParameterResolver implements ParameterResolver {

    @Autowired
    private JsonMapperService jsonMapperService;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        return parameterContext.getParameter().getType().equals(JsonMapperService.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        return jsonMapperService;
    }
}
