package core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MockTest {
	@Test
	public void isValidUrl() {
		Validator validator = Mockito.mock(Validator.class);
		
		String url = "This is an invalidUrl";
		Mockito.when(validator.isValidUrl(url)).thenReturn(true);
		
		boolean isVaid = validator.isValidUrl(url);
		
		Assert.assertTrue("Should be true", isVaid);
		Mockito.verify(validator, Mockito.timeout(1)).isValidUrl(url);
	}
}
