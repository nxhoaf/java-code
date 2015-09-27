package core;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Validator.class })
public class MockPrivateStaticTest {
	@Test
	public void testIsValidInteger_WrongUse() throws Exception {
		// False, because we are mocking the whole class, so the real
		// 'isValidInteger' is not
		// getting called
		PowerMockito.mockStatic(Validator.class);

		String integer = "This is not an url";
		PowerMockito.doReturn(true).when(Validator.class,
				"isValidIntegerPrivateStatic", integer);

		boolean result = Validator.isValidIntegerStatic(integer);
		assertTrue("Should be true", result);
		PowerMockito.verifyPrivate(Validator.class, Mockito.times(1)).invoke(
				"isValidIntegerPrivate", integer);
	}

	@Test
	public void testIsValidInteger_CorrectUse() throws Exception {
		// This is the correct use, we want to mock isValidIntegerPrivate but we
		// still want
		// the real method isValidInteger gets called
		PowerMockito.spy(Validator.class);

		String integer = "This is not an url";
		PowerMockito.doReturn(true).when(Validator.class,
				"isValidIntegerPrivateStatic", integer);

		boolean result = Validator.isValidIntegerStatic(integer);
		Assert.assertTrue("Should be true", result);
		PowerMockito.verifyPrivate(Validator.class, Mockito.times(1)).invoke(
				"isValidIntegerPrivate", integer);
	}
}
