package com.deusto.integration.test.common;

import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder.mongoDb;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractIT {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected Environment env;

    @Rule
    public MongoDbRule remoteMongoDbRule;

    @Before
    public void setup() {
        remoteMongoDbRule = new MongoDbRule(
                mongoDb().databaseName(env.getProperty("spring.data.mongodb.database")).build()
        );
    }

}
