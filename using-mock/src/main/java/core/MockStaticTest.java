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
public class MockStaticTest {
	@Test
	public void testIsValidUrl_First_Solution() {
		PowerMockito.mockStatic(Validator.class);

		String url = "This is not an url";
		PowerMockito.when(Validator.isValidUrlStatic(url)).thenReturn(true);

		boolean result = Validator.isValidUrlStatic(url);
		result = Validator.isValidUrlStatic(url);
		Assert.assertTrue("Should be true", result);

		PowerMockito.verifyStatic(Mockito.times(2));
		Validator.isValidUrlStatic(url);
	}

	@Test
	public void testIsValidUrl_Second_Solution() throws Exception {
		PowerMockito.mockStatic(Validator.class);

		String url = "This is not an url";
		PowerMockito.doReturn(true).when(Validator.class, "isValidUrlStatic",
				url);

		boolean result = Validator.isValidUrlStatic(url);
		Assert.assertTrue("Should be true", result);

		// PowerMockito.verifyStatic(Mockito.times(1));
		PowerMockito.verifyStatic(); // Same as above
		Validator.isValidUrlStatic(url);
	}
}
