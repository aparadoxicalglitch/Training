package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import herokuapp.HerokuApp;

public class JunitTest {

	@Test
	public void test() {
		HerokuApp ha = new HerokuApp();
//		ha.scroll();
		ha.scrollToBottom();
	}

}
