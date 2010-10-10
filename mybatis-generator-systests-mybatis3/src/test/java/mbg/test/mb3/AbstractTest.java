/*
 *  Copyright 2009 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package mbg.test.mb3;

import static mbg.test.common.util.TestUtilities.createDatabase;

import java.io.Reader;
import java.net.URL;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

/**
 * @author Jeff Butler
 * 
 */
public abstract class AbstractTest {

    protected SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        URL url = AbstractTest.class.getClassLoader().getResource("CreateDB.sql");
        
        createDatabase(url);

        Reader reader = Resources
                    .getResourceAsReader("mbg/test/mb3/MapperConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        reader.close();
    }
}