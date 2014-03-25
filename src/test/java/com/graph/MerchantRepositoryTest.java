package com.graph;

import com.ApplicationConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by paul.gribelyuk on 3/24/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:**/application-context.xml"})
@Transactional
public class MerchantRepositoryTest {

}
