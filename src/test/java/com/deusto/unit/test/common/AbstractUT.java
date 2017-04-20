package com.deusto.unit.test.common;

import com.deusto.repositories.BookRepository;
import com.deusto.repositories.RegistrRepository;
import com.deusto.repositories.UserRepository;
import com.deusto.security.AuthenticationService;
import com.deusto.services.BookService;
import com.deusto.services.RegistrService;
import com.deusto.services.UserService;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder.mongoDb;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class AbstractUT {
    @Autowired
    protected Environment env;

    @Rule
    public MongoDbRule remoteMongoDbRule = new MongoDbRule(
            mongoDb().databaseName("bookit_testdb").build()
    );

    /***
     * =================================================
     * Services
     * =================================================
     */
    @Autowired
    protected AuthenticationService authenticationService;

    @Autowired
    protected BookService bookService;

    @Autowired
    protected RegistrService registrService;

    @Autowired
    protected UserService userService;

    /***
     * =================================================
     * Repositories
     * =================================================
     */
    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected RegistrRepository registrRepository;

    @Autowired
    protected UserRepository userRepository;

    /***
     * =================================================
     * Forms validator -> http://stackoverflow.com/a/41671471
     * =================================================
     */

    protected static Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <T> Set<ConstraintViolation<T>> validate(T obj) {
        return validator.validate(obj);
    }

}
