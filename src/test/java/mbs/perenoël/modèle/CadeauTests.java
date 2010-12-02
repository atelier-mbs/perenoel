package mbs.perenoël.modèle;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CadeauTests {

	@Test
	public void peutGénéreUnId() {
		assertThat(new Cadeau("Un VoyAge à Macao").getId(), is("un-voyage-a-macao"));
	}
}
