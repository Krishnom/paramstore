package com.krishnom.paramstore.services;

import com.krishnom.paramstore.entities.Parameter;

import java.util.List;

public interface ParameterService {
    List<Parameter> getParameters();

    Parameter getParameter(String name);

    Parameter addParameter(Parameter parameter) throws Exception;

    Parameter updateParameter(Parameter parameter) throws Exception;
}
