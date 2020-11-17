/*
 * Copyright 2020. Nector Cortés Rojas, nector.cortes@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.ncortes.news.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import cl.ucn.disc.dsm.ncortes.news.model.News;

public class TestContractsImplFaker {

    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(TestContractsImplFaker.class);

    /**
     * The Test of Retrieve news.
     */
    @Test
    public void testRetrieveNews() {

        log.debug("Testing ...");

        // The concrete implementation
        Contracts contracts = new ContractsImplFaker();

        // Call the method ..
        List<News> news = contracts.retrieveNews(5);

        // .. the list can't be null ..
        Assertions.assertNotNull(news, "List was null o_0");

        // .. the list can't be empty ..
        Assertions.assertFalse(news.isEmpty(), "Empty list? o_0");

        // .. the size(list) == 5 ..
        Assertions.assertEquals(5, news.size(), "List size != 5 o_0");

        //debug to log
        for(News n: news) {
            log.debug("News: {}", n);
        }

        //size = 0
        Assertions.assertEquals(0, contracts.retrieveNews(0).size(), "List != 0");

        //size = 3
        Assertions.assertEquals(3, contracts.retrieveNews(3).size(), "List != 3");

        //size = 10
        Assertions.assertTrue(contracts.retrieveNews(10).size() <= 10, "List !=  10");

        log.debug("Done.");
    }

    /**
     * The Test of Save News.
     */
    @Test
    public void testSaveNews() {

        log.debug("Testing ..");

        // The concrete implementation
        Contracts contracts = new ContractsImplFaker();

    }

}
