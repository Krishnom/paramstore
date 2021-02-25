package com.krishnom.paramstore.services;


import com.krishnom.paramstore.entities.Parameter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterServiceImpl implements com.krishnom.paramstore.services.ParameterService {
    List<Parameter> parameters;

    public ParameterServiceImpl() {
        this.parameters = new ArrayList<>();
        this.parameters.add(new Parameter("author", "omprakash.paliwal68@gmail.com",
                "omprakash.paliwal68@gmail.com", "Service created and managed by."));
        this.parameters.add(new Parameter("team", "krishnom", "Team managing the service"));
    }

    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public Parameter getParameter(String name) {
        Parameter parameter = null;
        for (Parameter p : parameters) {
            if (p.getName().equals(name)) {
                parameter = p;
            }
        }

        return parameter;
    }

    @Override
    public Parameter addParameter(Parameter parameter) throws Exception {
        if (parameters.contains(parameter)) {
            throw new UnsupportedOperationException("Parameter already present. If update is needed, Please use PUT request");
        }
        this.parameters.add(parameter);
        return parameter;
    }

    @Override
    public Parameter updateParameter(Parameter parameter) throws Exception {
        Parameter p = null;
        for (Parameter param : parameters) {
            if (param.equals(parameter)) {
                p = param;
                param.setValue(parameter.getValue());
            }
        }

        if (p == null) {
            throw new NoSuchFieldException("Parameter " + parameter.getName() + " not found in store.");
        }

        return p;
    }
}
