package com.in28minutes.powermock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PowerMockitoTestingPrivateMethodTest {

	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void powerMockito_CallingAPrivateMethod() throws Exception {
		Method method = systemUnderTest.getClass().getDeclaredMethod("privateMethodUnderTest");
		method.setAccessible(true);
		when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
		long value = (Long) method.invoke(systemUnderTest);
		assertEquals(6, value);
	}
}