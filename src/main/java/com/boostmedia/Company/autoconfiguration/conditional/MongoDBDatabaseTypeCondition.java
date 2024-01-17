package com.boostmedia.Company.autoconfiguration.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDBDatabaseTypeCondition implements Condition
{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata)
    {
        String enabledDBType = System.getProperty("dbType");
       // return (enabledDBType != null && enabledDBType.equalsIgnoreCase("MONGODB"));
        String dbType = conditionContext.getEnvironment().getProperty("app.dbType");
        return "MONGO".equalsIgnoreCase(dbType);

    }
}
