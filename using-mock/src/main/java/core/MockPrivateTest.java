package core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Validator.class })
public class MockPrivateTest {
	@Test
	public void isValidUrl_WrongUse() throws Exception {
		// False, because we are mocking the whole class, so the real
		// 'isValidInteger' is not
		// getting called
		Validator validator = Mockito.mock(Validator.class);

		String integer = "This is an invali Integer";
		PowerMockito.doReturn(true).when(validator, "isValidIntegerPrivate",
				integer);

		boolean isVaid = validator.isValidInteger(integer);

		Assert.assertTrue("Should be true", isVaid);
		Mockito.verify(validator, Mockito.timeout(1)).isValidUrl(integer);
		PowerMockito.verifyPrivate(validator, Mockito.times(1)).invoke(
				"isValidIntegerPrivate", integer);
	}

	@Test
	public void isValidUrl_CorrectUse() throws Exception {
		// False, because we are mocking the whole class, so the real
		// 'isValidInteger' is not
		// getting called
		// to mock private, PowerMockito must be used. Mockito will not working
		// Validator validator = Mockito.spy(new Validator()); // Not working

		Validator validator = PowerMockito.spy(new Validator());

		String integer = "This is an invali Integer";
		PowerMockito.doReturn(true).when(validator, "isValidIntegerPrivate",
				integer);

		boolean isVaid = validator.isValidInteger(integer);

		Assert.assertTrue("Should be true", isVaid);
		PowerMockito.verifyPrivate(validator, Mockito.times(1)).invoke(
				"isValidIntegerPrivate", integer);
	}
}