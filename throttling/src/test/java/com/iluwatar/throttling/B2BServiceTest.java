/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.throttling;

import com.iluwatar.throttling.timer.ThrottleTimerImpl;
import com.iluwatar.throttling.timer.Throttler;
import org.junit.Assert;
import org.junit.Test;

/**
 * B2BServiceTest class to test the B2BService
 */
public class B2BServiceTest {

	@Test
	public void dummyCustomerApiTest() {
		Tenant tenant = new Tenant("testTenant", 2);
		Throttler timer = new ThrottleTimerImpl(100);
		B2BService service = new B2BService(timer);

		for (int i = 0; i < 5; i++) {
			service.dummyCustomerApi(tenant);
		}
		long counter = CallsCount.getCount(tenant.getName());
		Assert.assertTrue("Counter limit must be reached", counter == 2);
	}
}
