package com.deusto.unit.test.common;

import com.deusto.repositories.BookRepository;
import com.deusto.repositories.RegistrRepository;
import com.deusto.repositories.UserRepository;
import com.deusto.security.AuthenticationService;
import com.deusto.services.BookService;
import com.deusto.services.RegistrService;
import com.deusto.services.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class AbstractUT {
    @Autowired
    protected Environment env;

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
     * Forms validator -> http://stackoverflow.com/questions/29069956/how-to-test-validation-annotations-of-a-class-using-junit/29070276#29070276
     * =================================================
     */

    protected static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

}
